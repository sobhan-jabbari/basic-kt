package ir.afraapps.kotlin.basic.util.permission

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Environment
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment

object PermissionsUtil {

    fun getDeniedPermissions(permissions: Array<String>, grantResults: IntArray): Array<String> =
        permissions.filterIndexed { index, _ ->
            grantResults[index] == PackageManager.PERMISSION_DENIED
        }.toTypedArray()

    fun getPermanentlyDeniedPermissions(fragment: Fragment, permissions: Array<String>, grantResults: IntArray): Array<String> =
        permissions.filterIndexed { index, s ->
            grantResults[index] == PackageManager.PERMISSION_DENIED && !fragment.shouldShowRequestPermissionRationale(s)
        }.toTypedArray()

    fun getPermanentlyDeniedPermissions(fragment: Fragment, permissions: Map<String, Boolean>): Array<String> =
        permissions.filter {
            it.value.not() && !fragment.shouldShowRequestPermissionRationale(it.key)
        }.keys.toTypedArray()


    fun hasSelfPermission(context: Context?, permissions: Array<String>): Boolean {
        context?.let {
            for (permission in permissions) {
                if ((permission == Manifest.permission.READ_EXTERNAL_STORAGE || permission == Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    && SDK_INT >= Build.VERSION_CODES.R
                ) {
                    return Environment.isExternalStorageManager()
                }
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false
                }
            }
        }
        return true
    }

}