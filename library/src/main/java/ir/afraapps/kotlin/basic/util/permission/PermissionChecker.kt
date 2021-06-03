package ir.afraapps.kotlin.basic.util.permission

import android.Manifest
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ir.afraapps.kotlin.basic.model.PermissionsOptions
import ir.afraapps.kotlin.basic.model.PermissionsRequest

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
        callback()
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
            callback()
            return true
        }
    }
    return false
}


fun Context.runWithPermissions(
    vararg permissions: String,
    options: PermissionsOptions = PermissionsOptions(),
    callback: () -> Unit
) {
    runWithPermissionsHandler(this, permissions, callback, options)
}

fun Context.runWithStoragePermissions(
    options: PermissionsOptions = PermissionsOptions(),
    callback: () -> Unit
) {
    runWithPermissionsHandler(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE), callback, options)
}


fun Fragment.runWithPermissions(
    vararg permissions: String,
    options: PermissionsOptions = PermissionsOptions(),
    callback: () -> Unit
) {
    runWithPermissionsHandler(this, permissions, callback, options)
}

fun Fragment.runWithStoragePermissions(
    options: PermissionsOptions = PermissionsOptions(),
    callback: () -> Unit
) {
    runWithPermissionsHandler(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE), callback, options)
}


private fun runWithPermissionsHandler(target: Any?, permissions: Array<out String>, callback: () -> Unit, options: PermissionsOptions) {

    if (target is AppCompatActivity || target is Fragment) {

        val context = when (target) {
            is Context -> target
            is Fragment -> target.context
            else -> null
        }

        if (PermissionsUtil.hasSelfPermission(context, arrayOf(*permissions))) {
            callback()

        } else {
            var permissionCheckerFragment = when (context) {
                is AppCompatActivity -> context.supportFragmentManager.findFragmentByTag(PermissionCheckerFragment::class.java.canonicalName) as PermissionCheckerFragment?
                is Fragment -> context.childFragmentManager.findFragmentByTag(PermissionCheckerFragment::class.java.canonicalName) as PermissionCheckerFragment?
                else -> null
            }

            if (permissionCheckerFragment == null) {
                permissionCheckerFragment = PermissionCheckerFragment.newInstance()
                when (context) {
                    is AppCompatActivity -> {
                        context.supportFragmentManager.beginTransaction().apply {
                            add(permissionCheckerFragment, PermissionCheckerFragment::class.java.canonicalName)
                            commit()
                        }
                        context.supportFragmentManager.executePendingTransactions()
                    }
                    is Fragment -> {
                        context.childFragmentManager.beginTransaction().apply {
                            add(permissionCheckerFragment, PermissionCheckerFragment::class.java.canonicalName)
                            commit()
                        }
                        context.childFragmentManager.executePendingTransactions()
                    }
                }
            }

            permissionCheckerFragment.setListener(object : PermissionCheckerFragment.PermissionsCallback {
                override fun onPermissionsGranted(permissionsRequest: PermissionsRequest?) {
                    try {
                        callback()
                    } catch (throwable: Throwable) {
                        throwable.printStackTrace()
                    }
                }
            })

            val permissionRequest = PermissionsRequest(permissionCheckerFragment, arrayOf(*permissions))
            permissionRequest.handleRationale = options.handleRationale
            permissionRequest.handlePermanentlyDenied = options.handlePermanentlyDenied
            permissionRequest.rationaleMessage = if (options.rationaleMessage.isBlank())
                "These permissions are required to perform this feature. Please allow us to use this feature. "
            else
                options.rationaleMessage
            permissionRequest.permanentlyDeniedMessage = if (options.permanentlyDeniedMessage.isBlank())
                "Some permissions are permanently denied which are required to perform this operation. Please open app settings to grant these permissions."
            else
                options.permanentlyDeniedMessage
            permissionRequest.rationaleMethod = options.rationaleMethod
            permissionRequest.permanentDeniedMethod = options.permanentDeniedMethod
            permissionRequest.permissionsDeniedMethod = options.permissionsDeniedMethod

            permissionCheckerFragment.setRequestPermissionsRequest(permissionRequest)

            permissionCheckerFragment.requestPermissionsFromUser()
        }
    } else {
        throw IllegalStateException("Found " + target!!::class.java.canonicalName + " : No support from any classes other than AppCompatActivity/Fragment")
    }
}