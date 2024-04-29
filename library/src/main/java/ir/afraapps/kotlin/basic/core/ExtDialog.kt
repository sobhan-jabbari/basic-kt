package ir.afraapps.kotlin.basic.core

import android.app.Dialog
import android.content.res.ColorStateList
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.annotation.StringRes
import androidx.core.text.layoutDirection
import org.jetbrains.anko.colorAttr
import org.jetbrains.anko.toast
import java.util.Locale

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 4/24/20.
 */


@ColorInt
fun Dialog.color(@ColorRes colorRes: Int): Int = context.color(colorRes)

@ColorInt
fun Dialog.getColorAttr(@AttrRes colorAttrRes: Int): Int = context.colorAttr(colorAttrRes)
fun Dialog.getColorStateListCompat(@ColorRes resId: Int): ColorStateList? = context.getColorStateListCompat(resId)

@ColorInt
fun Dialog.getColorPrimary(): Int = getColorAttr(androidx.appcompat.R.attr.colorPrimary)
fun Dialog.getFont(@FontRes fontRes: Int): Typeface? = context.getFont(fontRes)

fun Dialog.getDrawableCompat(@DrawableRes id: Int): Drawable? = context.getDrawableCompat(id)

fun Dialog.toast(@StringRes restId: Int) = context.toast(restId)
fun Dialog.toast(message: String) = context.toast(message)


fun Dialog.isLocaleRTL(): Boolean = Locale.getDefault().layoutDirection == View.LAYOUT_DIRECTION_RTL