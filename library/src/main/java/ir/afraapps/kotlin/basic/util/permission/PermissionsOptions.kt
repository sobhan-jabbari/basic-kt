package ir.afraapps.kotlin.basic.util.permission

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 10/4/20.
 */

data class PermissionsOptions(
    var handleRationale: Boolean = false,
    var rationaleMessage: String = "",
    var handlePermanentlyDenied: Boolean = false,
    var permanentlyDeniedMessage: String = "",
    var rationaleMethod: ((PermissionsRequest) -> Unit)? = null,
    var permanentDeniedMethod: ((PermissionsRequest) -> Unit)? = null,
    var permissionsDeniedMethod: ((PermissionsRequest) -> Unit)? = null
)
