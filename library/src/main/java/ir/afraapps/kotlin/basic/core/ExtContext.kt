package ir.afraapps.kotlin.basic.core

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.util.TypedValue
import android.view.View
import android.widget.Toast
import androidx.annotation.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.res.ColorStateListInflaterCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.text.layoutDirection
import ir.afraapps.kotlin.basic.R
import ir.afraapps.kotlin.basic.util.permission.PermissionsUtil
import org.jetbrains.anko.storageManager
import java.util.*

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 10/16/19.
 */


fun Context.dipf(value: Int): Float = (value * resources.displayMetrics.density)
fun Context.dipf(value: Float): Float = (value * resources.displayMetrics.density)

fun Context.spf(value: Int): Float = (value * resources.displayMetrics.scaledDensity)
fun Context.spf(value: Float): Float = (value * resources.displayMetrics.scaledDensity)


fun View.dipf(value: Int): Float = context.dipf(value)
fun View.dipf(value: Float): Float = context.dipf(value)

fun View.spf(value: Int): Float = context.spf(value)
fun View.spf(value: Float): Float = context.spf(value)


@AnyRes
fun Context.resourceId(@StyleRes styleRes: Int, @AttrRes attrRes: Int): Int {
    val ta = obtainStyledAttributes(styleRes, intArrayOf(attrRes))
    val resId = ta.getResourceId(0, 0)
    ta.recycle()
    return resId
}

fun Context.font(@StyleRes styleRes: Int): Typeface? {
    val resId = resourceId(styleRes, R.attr.fontFamily)
    if (resId > 0) return getFont(resId)
    return null
}

fun Context.getFont(@FontRes fontRes: Int): Typeface? {
    return ResourcesCompat.getFont(this, fontRes)
}


fun Context.getDrawableCompat(@DrawableRes id: Int): Drawable? {
    return ResourcesCompat.getDrawable(resources, id, theme)
}

fun Context.getDrawableWrap(@DrawableRes id: Int): Drawable? {
    return getDrawableCompat(id)?.let { DrawableCompat.wrap(it) }
}

fun Context.getDrawableResId(name: String): Int {
    return resources.getIdentifier(name, "drawable", packageName)
}


fun Context.isGrantedPermission(vararg permissions: String): Boolean {
    return PermissionsUtil.hasSelfPermission(this, arrayOf(*permissions))
}

fun Context.isGrantedStoragePermission(): Boolean {
    return PermissionsUtil.hasSelfPermission(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE))
}


fun Context.showToast(@StringRes restId: Int) {
    Toast.makeText(this, restId, Toast.LENGTH_SHORT).show()
}


fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}


fun Context.createOpenDocumentInitUri(dir: String): Uri? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val intent = storageManager.primaryStorageVolume.createOpenDocumentTreeIntent()
        (intent.getParcelableExtra("android.provider.extra.INITIAL_URI") as? Uri)?.let { uri ->
            var path = uri.toString().replace("/root/", "/document/")
            path += "%3A$dir"
            Uri.parse(path)
        }
    } else {
        null
    }
}
