package ir.afraapps.kotlin.basic.util.permission

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 10/4/20.
 */

fun Context.runIfPermissions(
    vararg permissions: String,
    callback: () -> Unit
): Boolean {
    if (PermissionsUtil.hasSelfPermission(this, arrayOf(*permissions))) {
        callback.invoke()
        return true
    }
    return false
}


fun Fragment.runIfPermissions(
    vararg permissions: String,
    callback: () -> Unit
): Boolean {
    context?.let {
        if (PermissionsUtil.hasSelfPermission(it, arrayOf(*permissions))) {
            callback.invoke()
            return true
        }
    }
    return false
}


fun Context.runWithPermissions(
    vararg permissions: String,
    options: PermissionsOptions = PermissionsOptions(),
    deniedCallback: () -> Unit = {},
    grantedCallback: (Uri?) -> Unit
): Boolean {
    return runWithPermissionsHandler(this, permissions, grantedCallback, deniedCallback, options)
}

fun Context.runWithStoragePermissions(
    options: PermissionsOptions = PermissionsOptions(),
    deniedCallback: () -> Unit = {},
    grantedCallback: (Uri?) -> Unit
): Boolean {
    return runWithPermissionsHandler(
        this,
        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE),
        grantedCallback,
        deniedCallback,
        options
    )
}


fun Fragment.runWithPermissions(
    vararg permissions: String,
    options: PermissionsOptions = PermissionsOptions(),
    deniedCallback: () -> Unit = {},
    grantedCallback: (Uri?) -> Unit
): Boolean {
    return runWithPermissionsHandler(this, permissions, grantedCallback, deniedCallback, options)
}

fun Fragment.runWithStoragePermissions(
    options: PermissionsOptions = PermissionsOptions(),
    deniedCallback: () -> Unit = {},
    grantedCallback: (Uri?) -> Unit
): Boolean {
    return runWithPermissionsHandler(
        this,
        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE),
        grantedCallback,
        deniedCallback,
        options
    )
}


fun Context.checkSelfPermissions(vararg permissions: String): Boolean {
    for (permission in permissions) {
        if (ActivityCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            return false
        }
    }
    return true
}

fun Fragment.checkSelfPermissions(vararg permissions: String): Boolean {
    for (permission in permissions) {
        if (ActivityCompat.checkSelfPermission(requireContext(), permission) != PackageManager.PERMISSION_GRANTED) {
            return false
        }
    }
    return true
}


private fun runWithPermissionsHandler(
    target: Any?,
    permissions: Array<out String>,
    grantedCallback: (Uri?) -> Unit,
    deniedCallback: () -> Unit,
    options: PermissionsOptions
): Boolean {

    if (target !is AppCompatActivity && target !is Fragment) {
        throw IllegalStateException("Found " + target?.javaClass?.canonicalName + " : No support from any classes other than AppCompatActivity/Fragment")
    }

    val context: Context = (if (target is Fragment) target.requireContext() else target as Context)

    if (context.checkSelfPermissions(*permissions)) {
        grantedCallback.invoke(null)
        return true

    } else {
        var permissionCheckerFragment = when (target) {
            is AppCompatActivity -> target.supportFragmentManager.findFragmentByTag(PermissionCheckerFragment::class.java.canonicalName) as PermissionCheckerFragment?
            is Fragment -> target.childFragmentManager.findFragmentByTag(PermissionCheckerFragment::class.java.canonicalName) as PermissionCheckerFragment?
            else -> null
        }

        if (permissionCheckerFragment == null) {
            permissionCheckerFragment = PermissionCheckerFragment.newInstance()
            when (target) {
                is AppCompatActivity -> {
                    target.supportFragmentManager.beginTransaction().apply {
                        add(permissionCheckerFragment, PermissionCheckerFragment::class.java.canonicalName)
                        commit()
                    }
                    target.supportFragmentManager.executePendingTransactions()
                }
                is Fragment -> {
                    target.childFragmentManager.beginTransaction().apply {
                        add(permissionCheckerFragment, PermissionCheckerFragment::class.java.canonicalName)
                        commit()
                    }
                    target.childFragmentManager.executePendingTransactions()
                }
            }
        }

        permissionCheckerFragment.setListener(object : PermissionCheckerFragment.PermissionsCallback {
            override fun onPermissionsGranted(permissionsRequest: PermissionsRequest?, uri: Uri?) {
                kotlin.runCatching { grantedCallback.invoke(uri) }
            }

            override fun onPermissionsDenied(permissionsRequest: PermissionsRequest?) {
                kotlin.runCatching { deniedCallback.invoke() }
            }
        })

        val permissionRequest = PermissionsRequest(permissionCheckerFragment, arrayOf(*permissions))
        permissionRequest.handleRationale = options.handleRationale
        permissionRequest.handlePermanentlyDenied = options.handlePermanentlyDenied
        permissionRequest.rationaleMessage = if (options.rationaleMessage.isBlank())
            "These permissions are required to perform this feature. Please allow us to use this feature. "
        else
            options.rationaleMessage
        permissionRequest.permanentlyDeniedMessage = if (options.permanentlyDeniedMessage.isEmpty())
            "Some permissions are permanently denied which are required to perform this operation. Please open app settings to grant these permissions."
        else
            options.permanentlyDeniedMessage
        permissionRequest.rationaleMethod = options.rationaleMethod
        permissionRequest.permanentDeniedMethod = options.permanentDeniedMethod
        permissionRequest.permissionsDeniedMethod = options.permissionsDeniedMethod

        permissionCheckerFragment.setRequestPermissionsRequest(permissionRequest)

        permissionCheckerFragment.requestPermissionsFromUser()

        return false
    }

}