package ir.afraapps.kotlin.basic.util.permission


/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 10/4/20.
 */

data class PermissionsRequest(
    private var target: PermissionCheckerFragment,
    var permissions: Array<String> = emptyArray(),
    var handleRationale: Boolean = true,
    var rationaleMessage: String = "",
    var handlePermanentlyDenied: Boolean = true,
    var permanentlyDeniedMessage: String = "",
    internal var rationaleMethod: ((PermissionsRequest) -> Unit)? = null,
    internal var permanentDeniedMethod: ((PermissionsRequest) -> Unit)? = null,
    internal var permissionsDeniedMethod: ((PermissionsRequest) -> Unit)? = null,
    var deniedPermissions: Array<String> = emptyArray(),
    var permanentlyDeniedPermissions: Array<String> = emptyArray()
) {


    fun proceed() = target.requestPermissionsFromUser()


    fun cancel() = target.clean()

    fun openAppSettings() = target.openAppSettings()

}