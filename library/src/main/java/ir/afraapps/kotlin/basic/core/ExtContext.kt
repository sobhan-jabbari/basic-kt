package ir.afraapps.kotlin.basic.core

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.graphics.Typeface
import android.graphics.drawable.Drawable
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
import java.util.*

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 10/16/19.
 */

val Context.resolver: ContentResolver
    get() = applicationContext.contentResolver

fun Context.dipf(value: Int): Float = (value * resources.displayMetrics.density)
fun Context.dipf(value: Float): Float = (value * resources.displayMetrics.density)

fun Context.spf(value: Int): Float = (value * resources.displayMetrics.scaledDensity)
fun Context.spf(value: Float): Float = (value * resources.displayMetrics.scaledDensity)


@ColorInt
fun Context.getColorRes(@ColorRes colorRes: Int): Int {
    return runCatching { ContextCompat.getColor(this, colorRes) }.getOrElse { 0 }
}

@ColorInt
fun Context.getColorAttr(@AttrRes colorAttrRes: Int): Int {
    val a = obtainStyledAttributes(TypedValue().data, intArrayOf(colorAttrRes))
    val color = a.getColor(0, 0)
    a.recycle()
    return color
}


@SuppressLint("RestrictedApi", "ResourceType")
fun Context.getColorStateListCompat(@ColorRes resId: Int): ColorStateList? {
    return ColorStateListInflaterCompat.inflate(
        resources,
        resId,
        null
    )
}

@ColorInt
fun Context.getColorPrimary(): Int = getColorAttr(R.attr.colorPrimary)


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


fun Context.isLocaleRTL(): Boolean = Locale.getDefault().layoutDirection == View.LAYOUT_DIRECTION_RTL



