package ir.afraapps.kotlin.basic.util.permission

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.activity.result.ActivityResultLauncher


/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 10/4/20.
 */

class PermissionsRequest(
    var permissions: Array<String> = emptyArray(),
) {

    var handleRationale: Boolean = true
    var rationaleMessage: String = ""
    var handlePermanentlyDenied: Boolean = true
    var permanentlyDeniedMessage: String = ""
    internal var rationaleMethod: ((PermissionsRequest) -> Unit)? = null
    internal var permanentDeniedMethod: ((PermissionsRequest) -> Unit)? = null
    internal var permissionsDeniedMethod: ((PermissionsRequest) -> Unit)? = null
    var deniedPermissions: Array<String> = emptyArray()
    var permanentlyDeniedPermissions: Array<String> = emptyArray()
    internal var permissionLauncher: ActivityResultLauncher<Array<String>>? = null
    internal var appSettingLauncher: ActivityResultLauncher<Intent>? = null

    fun proceed() {
        permissionLauncher?.launch(permissions)
    }

    fun openAppSettings(context: Context) {
        appSettingLauncher?.launch(
            Intent(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.fromParts("package", context.packageName, null)
            )
        )
    }
}


