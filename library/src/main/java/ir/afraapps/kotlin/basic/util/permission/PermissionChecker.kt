package ir.afraapps.kotlin.basic.util.permission

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.Settings
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import ir.afraapps.kotlin.basic.core.isGrantedPermission

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 10/4/20.
 */

fun Context.runIfPermissions(
    vararg permissions: String,
    callback: () -> Unit
): Boolean {
    if (isGrantedPermission(*permissions)) {
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
        if (it.isGrantedPermission(*permissions)) {
            callback.invoke()
            return true
        }
    }
    return false
}


fun FragmentActivity.runWithPermissions(
    vararg permissions: String,
    options: PermissionsOptions = PermissionsOptions(),
    deniedCallback: () -> Unit = {},
    grantedCallback: () -> Unit
): Boolean {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
        return true
    } else {
        val rationale: (String) -> Boolean = { shouldShowRequestPermissionRationale(it) }
        return launchPermissionRequest(
            this,
            activityResultRegistry,
            arrayOf(*permissions),
            rationale,
            grantedCallback, deniedCallback, options
        )
    }
}

fun Fragment.runWithPermissions(
    vararg permissions: String,
    options: PermissionsOptions = PermissionsOptions(),
    deniedCallback: () -> Unit = {},
    grantedCallback: () -> Unit
): Boolean {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
        return true
    } else {
        val rationale: (String) -> Boolean = { shouldShowRequestPermissionRationale(it) }
        return launchPermissionRequest(
            requireContext(),
            requireActivity().activityResultRegistry,
            arrayOf(*permissions),
            rationale, grantedCallback, deniedCallback, options
        )
    }
}

@RequiresApi(Build.VERSION_CODES.R)
fun FragmentActivity.runWithStorageManagePermission(action: () -> Unit) {
    if (Environment.isExternalStorageManager()) {
        action.invoke()
    } else {
        launchStorageManagePermessionRequest(activityResultRegistry, { if (it) action.invoke() })
    }
}

@RequiresApi(Build.VERSION_CODES.R)
fun Fragment.runWithStorageManagePermission(action: () -> Unit) {
    if (Environment.isExternalStorageManager()) {
        action.invoke()
    } else {
        launchStorageManagePermessionRequest(requireActivity().activityResultRegistry, { if (it) action.invoke() })
    }
}


fun AppCompatActivity.getDocumentTreeUri(callback: (Uri?) -> Unit) {
    launchDocumentTreeUri(activityResultRegistry, callback)
}

fun Fragment.getDocumentTreeUri(callback: (Uri?) -> Unit) {
    launchDocumentTreeUri(requireActivity().activityResultRegistry, callback)
}


private fun launchPermissionRequest(
    context: Context,
    registry: ActivityResultRegistry,
    permissions: Array<String>,
    rationale: (String) -> Boolean,
    grantedCallback: () -> Unit,
    deniedCallback: () -> Unit,
    options: PermissionsOptions
): Boolean {

    if (context.isGrantedPermission(*permissions)) {
        grantedCallback.invoke()
        return true

    } else {
        val permissionRequest = PermissionsRequest(
            arrayOf(*permissions)
        ).apply {
            handleRationale = options.handleRationale
            handlePermanentlyDenied = options.handlePermanentlyDenied
            rationaleMessage = if (options.rationaleMessage.isBlank())
                "These permissions are required to perform this feature. Please allow us to use this feature. "
            else
                options.rationaleMessage
            permanentlyDeniedMessage = if (options.permanentlyDeniedMessage.isEmpty())
                "Some permissions are permanently denied which are required to perform this operation. Please open app settings to grant these permissions."
            else
                options.permanentlyDeniedMessage
            rationaleMethod = options.rationaleMethod
            permanentDeniedMethod = options.permanentDeniedMethod
            permissionsDeniedMethod = options.permissionsDeniedMethod
        }

        val permissionLauncher = getPermissionRequestLauncher(registry) { permissionResult ->
            handlePermissionResult(permissionResult, permissionRequest, rationale) {
                if (it) grantedCallback.invoke() else deniedCallback.invoke()
            }
        }

        val appSettingsLauncher = getAppSettingsLauncher(registry) {
            if (it?.resultCode == Activity.RESULT_OK) {
                permissionLauncher.launch(permissions)
            }
        }

        permissionRequest.permissionLauncher = permissionLauncher
        permissionRequest.appSettingLauncher = appSettingsLauncher

        permissionLauncher.launch(permissions)

        return false
    }

}

private fun getAppSettingsLauncher(
    registry: ActivityResultRegistry,
    onActivityResult: (ActivityResult?) -> Unit
): ActivityResultLauncher<Intent> {
    return registry.register(
        APP_SETTINGS_KEY,
        ActivityResultContracts.StartActivityForResult(),
        onActivityResult
    )
}

private fun getPermissionRequestLauncher(
    registry: ActivityResultRegistry,
    onActivityResult: (Map<String, Boolean>) -> Unit
): ActivityResultLauncher<Array<String>> {
    return registry.register(
        PERMISSION_KEY,
        ActivityResultContracts.RequestMultiplePermissions(),
        onActivityResult
    )
}

private fun handlePermissionResult(
    permissionResult: Map<String, Boolean>,
    permissionsRequest: PermissionsRequest,
    rationale: (String) -> Boolean,
    result: (isGranted: Boolean) -> Unit
) {

    if (permissionResult.isEmpty()) {
        return
    }

    val deniedMap = permissionResult.filterValues { it.not() }

    if (deniedMap.isEmpty()) {
        permissionsRequest.deniedPermissions = emptyArray()
        result.invoke(true)

    } else {
        result.invoke(false)

        val deniedPermissions = deniedMap.keys.toTypedArray()
        permissionsRequest.deniedPermissions = deniedPermissions

        var shouldShowRationale = true
        var isPermanentlyDenied = false
        for (deniedPermission in deniedPermissions) {
            if (!rationale(deniedPermission)) {
                shouldShowRationale = false
                isPermanentlyDenied = true
                break
            }
        }

        if (permissionsRequest.handlePermanentlyDenied == true && isPermanentlyDenied) {
            permissionsRequest.permanentDeniedMethod?.invoke(permissionsRequest)
            return
        }

        // if should show rationale dialog
        if (permissionsRequest.handleRationale == true && shouldShowRationale) {
            permissionsRequest.rationaleMethod?.invoke(permissionsRequest)
            return
        }
    }
}


private fun launchDocumentTreeUri(registry: ActivityResultRegistry, callback: (Uri?) -> Unit) {
    registry.register(DOCUMENT_TREE_KEY, ActivityResultContracts.OpenDocument(), callback)
}

@RequiresApi(Build.VERSION_CODES.R)
private fun launchStorageManagePermessionRequest(
    registry: ActivityResultRegistry,
    callback: (Boolean) -> Unit
) {
    registry.register(STORAGE_MANAGE_KEY, StorageManageContract(), callback)
}

@RequiresApi(Build.VERSION_CODES.R)
private class StorageManageContract : ActivityResultContract<Any?, Boolean>() {
    override fun createIntent(context: Context, input: Any?): Intent {
        return Intent().setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Boolean {
        return Environment.isExternalStorageManager()
    }
}


private const val APP_SETTINGS_KEY = ".APP_SETTINGS_KEY"
private const val PERMISSION_KEY = ".PERMISSION_KEY"
private const val DOCUMENT_TREE_KEY = ".DOCUMENT_TREE_KEY"
private const val STORAGE_MANAGE_KEY = ".STORAGE_MANAGE_KEY"