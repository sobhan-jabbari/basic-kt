package ir.afraapps.kotlin.basic.util.permission

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.net.Uri.fromParts
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import org.jetbrains.anko.storageManager

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 10/4/20.
 */

class PermissionCheckerFragment : Fragment() {

    private var permissionsRequest: PermissionsRequest? = null

    private var needToStorage2Request = false

    private lateinit var permissionsLuncher: ActivityResultLauncher<Array<out String>>

    @RequiresApi(Build.VERSION_CODES.R)
    private var storageRLauncher: ActivityResultLauncher<Any?>? = null

    @RequiresApi(Build.VERSION_CODES.R)
    private var storageR2Launcher: ActivityResultLauncher<Any?>? = null

    private val settingsLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it?.resultCode == Activity.RESULT_OK) {
            val permissions = permissionsRequest?.permissions.orEmpty()
            if (permissions.isNotEmpty()) permissionsLuncher.launch(permissions)
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        permissionsLuncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            handlePermissionResult(it)
        }
        if (SDK_INT >= Build.VERSION_CODES.R) {
            storageRLauncher = registerForActivityResult(StorageRContract()) {
                handleStoragePermissionResult(it)
            }
            storageR2Launcher = registerForActivityResult(StorageR2Contract()) {
                handleStoragePermissionResult(it)
            }
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    interface PermissionsCallback {
        fun onPermissionsGranted(permissionsRequest: PermissionsRequest?, uri: Uri? = null)
        fun onPermissionsDenied(permissionsRequest: PermissionsRequest?)
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
                            storageRLauncher?.launch(null)
                        } catch (e: Exception) {
                            needToStorage2Request = true
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


    @RequiresApi(Build.VERSION_CODES.R)
    private fun handleStoragePermissionResult(uri: Uri?) {
        if (needToStorage2Request) {
            needToStorage2Request = false
            storageR2Launcher?.launch(null)
            return
        }
        if (uri != null) {
            mListener?.onPermissionsGranted(permissionsRequest, uri)

        } else {
            if (permissionsRequest?.handleRationale == true) {
                permissionsRequest!!.rationaleMethod?.invoke(permissionsRequest!!)
            }
            mListener?.onPermissionsDenied(permissionsRequest)
            clean()
        }
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun handleStoragePermissionResult(granted: Boolean) {
        if (needToStorage2Request) {
            needToStorage2Request = false
            storageR2Launcher?.launch(null)
            return
        }
        if (granted) {
            mListener?.onPermissionsGranted(permissionsRequest)

        } else {
            if (permissionsRequest?.handleRationale == true) {
                permissionsRequest!!.rationaleMethod?.invoke(permissionsRequest!!)
            }
            mListener?.onPermissionsDenied(permissionsRequest)
            clean()
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
            mListener?.onPermissionsDenied(permissionsRequest)

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
    private class StorageRContract : ActivityResultContract<Any?, Uri?>() {
        override fun createIntent(context: Context, input: Any?): Intent {
            return context.storageManager.primaryStorageVolume.createOpenDocumentTreeIntent().apply {
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION)
            }
        }

        override fun parseResult(resultCode: Int, intent: Intent?): Uri? {
            return intent?.data
        }

    }

    @RequiresApi(Build.VERSION_CODES.R)
    private class StorageR2Contract : ActivityResultContract<Any?, Boolean>() {
        override fun createIntent(context: Context, input: Any?): Intent {
            return Intent().setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
        }

        override fun parseResult(resultCode: Int, intent: Intent?): Boolean {
            return Environment.isExternalStorageManager()
        }
    }

}