package ir.afraapps.kotlin.basic.util.permission

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.net.Uri.fromParts
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Environment
import android.provider.Settings
import android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import ir.afraapps.kotlin.basic.model.PermissionsRequest

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 10/4/20.
 */

class PermissionCheckerFragment : Fragment() {

    private var permissionsRequest: PermissionsRequest? = null
    private var allowHandle = true

    private var permissionsLuncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
        handlePermissionResult(it)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private var storageRLauncher = registerForActivityResult(StorageRContract()) {
        handleStoragePermissionResult(it)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private var storageR2Launcher = registerForActivityResult(StorageR2Contract()) {
        handleStoragePermissionResult(it)
    }

    private val settingsLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it?.resultCode == Activity.RESULT_OK) {
            val permissions = permissionsRequest?.permissions.orEmpty()
            if (permissions.isNotEmpty()) permissionsLuncher.launch(permissions)
        }
    }

    interface PermissionsCallback {
        fun onPermissionsGranted(permissionsRequest: PermissionsRequest?)
    }

    companion object {
        fun newInstance(): PermissionCheckerFragment = PermissionCheckerFragment()
    }

    private var mListener: PermissionsCallback? = null

    fun setListener(listener: PermissionsCallback) {
        mListener = listener
    }

    private fun removeListener() {
        mListener = null
    }


    fun setRequestPermissionsRequest(permissionsRequest: PermissionsRequest?) {
        this.permissionsRequest = permissionsRequest
    }

    private fun removeRequestPermissionsRequest() {
        permissionsRequest = null
    }

    fun clean() {
        permissionsRequest?.let { request ->
            if (request.deniedPermissions.isNotEmpty()) {
                request.permissionsDeniedMethod?.invoke(request)
            }
            removeRequestPermissionsRequest()
            removeListener()
        }
    }

    fun requestPermissionsFromUser() {
        permissionsRequest?.let { request ->
            val permissions = request.permissions
            if (permissions.isNotEmpty()) {
                if (SDK_INT >= Build.VERSION_CODES.R) {
                    val hasStoragePermissions = permissions.any {
                        it == Manifest.permission.WRITE_EXTERNAL_STORAGE || it == Manifest.permission.READ_EXTERNAL_STORAGE
                    }

                    if (hasStoragePermissions) {
                        try {
                            allowHandle = false
                            storageRLauncher.launch(null)
                            allowHandle = true
                        } catch (e: Exception) {
                            storageR2Launcher.launch(null)
                        }

                    } else {
                        permissionsLuncher.launch(permissions)
                    }

                } else {
                    permissionsLuncher.launch(permissions)
                }
            }
        }
    }


    private fun handleStoragePermissionResult(granted: Boolean) {
        if (allowHandle.not()) return
        if (granted) {
            mListener?.onPermissionsGranted(permissionsRequest)

        } else {
            if (permissionsRequest?.handleRationale == true) {
                permissionsRequest!!.rationaleMethod?.invoke(permissionsRequest!!)
            } else {
                clean()
            }
        }
    }

    private fun handlePermissionResult(permissions: Map<String, Boolean>) {

        if (permissions.isEmpty()) {
            return
        }

        val deniedMap = permissions.filterValues { it.not() }

        if (deniedMap.isEmpty()) {
            permissionsRequest?.deniedPermissions = emptyArray()
            mListener?.onPermissionsGranted(permissionsRequest)
            clean()

        } else {
            val deniedPermissions = deniedMap.keys.toTypedArray()
            permissionsRequest?.deniedPermissions = deniedPermissions

            var shouldShowRationale = true
            var isPermanentlyDenied = false
            for (deniedPermission in deniedPermissions) {
                val rationale = shouldShowRequestPermissionRationale(deniedPermission)
                if (!rationale) {
                    shouldShowRationale = false
                    isPermanentlyDenied = true
                    break
                }
            }

            if (permissionsRequest?.handlePermanentlyDenied == true && isPermanentlyDenied) {
                permissionsRequest?.permanentDeniedMethod?.invoke(permissionsRequest!!)
                return
            }

            // if should show rationale dialog
            if (permissionsRequest?.handleRationale == true && shouldShowRationale) {
                permissionsRequest?.rationaleMethod?.invoke(permissionsRequest!!)
                return
            }

            clean()
        }
    }

    fun openAppSettings() {
        if (permissionsRequest != null) {
            settingsLauncher.launch(
                Intent(
                    ACTION_APPLICATION_DETAILS_SETTINGS,
                    fromParts("package", activity?.packageName, null)
                )
            )
        }
    }


    @RequiresApi(Build.VERSION_CODES.R)
    private open class StorageRContract : ActivityResultContract<Any?, Boolean>() {
        override fun createIntent(context: Context, input: Any?): Intent {
            return Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
                .addCategory("android.intent.category.DEFAULT")
                .setData(Uri.parse("package:${context.applicationContext.packageName}"))
        }

        override fun parseResult(resultCode: Int, intent: Intent?): Boolean {
            return Environment.isExternalStorageManager()
        }

    }

    @RequiresApi(Build.VERSION_CODES.R)
    private class StorageR2Contract : StorageRContract() {
        override fun createIntent(context: Context, input: Any?): Intent {
            return Intent().setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
        }
    }

}