package ir.afraapps.kotlin.basic.core

import android.app.Dialog
import android.content.res.ColorStateList
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.*
import androidx.core.text.layoutDirection
import ir.afraapps.kotlin.basic.R
import org.jetbrains.anko.colorAttr
import java.util.*

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
fun Dialog.getColorPrimary(): Int = getColorAttr(R.attr.colorPrimary)
fun Dialog.getFont(@FontRes fontRes: Int): Typeface? = context.getFont(fontRes)

fun Dialog.getDrawableCompat(@DrawableRes id: Int): Drawable? = context.getDrawableCompat(id)

fun Dialog.showToast(@StringRes restId: Int) = context.showToast(restId)
fun Dialog.showToast(message: String) = context.showToast(message)


fun Dialog.isLocaleRTL(): Boolean = Locale.getDefault().layoutDirection == View.LAYOUT_DIRECTION_RTL