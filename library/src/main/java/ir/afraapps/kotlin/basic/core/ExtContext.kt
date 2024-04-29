package ir.afraapps.kotlin.basic.core

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.view.WindowInsets
import androidx.annotation.AnyRes
import androidx.annotation.AttrRes
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.annotation.StyleRes
import androidx.core.app.ActivityCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.FragmentActivity
import org.jetbrains.anko.dip
import org.jetbrains.anko.storageManager
import org.jetbrains.anko.windowManager

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 10/16/19.
 */

@AnyRes
fun Context.resourceId(@StyleRes styleRes: Int, @AttrRes attrRes: Int): Int {
    val ta = obtainStyledAttributes(styleRes, intArrayOf(attrRes))
    val resId = ta.getResourceId(0, 0)
    ta.recycle()
    return resId
}

fun Context.font(@StyleRes styleRes: Int): Typeface? {
    val resId = resourceId(styleRes, androidx.appcompat.R.attr.fontFamily)
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
    for (permission in permissions) {
        if (ActivityCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            return false
        }
    }
    return true
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

fun Context.statusBarSize(): Int {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        windowManager.currentWindowMetrics.windowInsets.getInsets(WindowInsets.Type.statusBars()).top
    } else {
        dip(24)
    }
}

fun Context.finishAsActivity() = (this as? Activity)?.finish()

fun Context.startActivity(target: Class<*>, build: Intent.() -> Unit = {}) {
    val intent = Intent(this, target)
    intent.build()
    startActivity(intent)
}

fun Context.onBackPressed() {
    (this as? FragmentActivity)?.onBackPressedDispatcher?.onBackPressed()
}

fun Context.sendBroadcast(target: Class<*>, build: Intent.() -> Unit = {}) {
    val intent = Intent(this, target)
    intent.build()
    sendBroadcast(intent)
}
