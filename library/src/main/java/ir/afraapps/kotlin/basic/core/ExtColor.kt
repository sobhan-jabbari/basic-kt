package ir.afraapps.kotlin.basic.core

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ColorStateListInflaterCompat
import androidx.fragment.app.Fragment
import ir.afraapps.kotlin.basic.view.AnkoUI
import org.jetbrains.anko.colorAttr

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 10/16/19.
 */

@ColorInt
fun Context.color(@ColorRes colorRes: Int): Int = colorOr(colorRes, 0)

@ColorInt
fun Context.colorOr(@ColorRes colorRes: Int, @ColorInt defaultColor: Int): Int = colorOrNull(colorRes) ?: defaultColor

@ColorInt
fun Context.colorOrNull(@ColorRes colorRes: Int): Int? {
    return runCatching { ContextCompat.getColor(this, colorRes) }.getOrNull()
}

@ColorInt
fun View.color(@ColorRes colorRes: Int): Int = context.color(colorRes)

@ColorInt
fun View.colorOr(@ColorRes colorRes: Int, @ColorInt defaultColor: Int): Int = context.colorOr(colorRes, defaultColor)

@ColorInt
fun View.colorOrNull(@ColorRes colorRes: Int): Int? = context.colorOrNull(colorRes)

@ColorInt
fun Fragment.color(@ColorRes colorRes: Int): Int = requireContext().color(colorRes)

@ColorInt
fun Fragment.colorOr(@ColorRes colorRes: Int, @ColorInt defaultColor: Int): Int = requireContext().colorOr(colorRes, defaultColor)

@ColorInt
fun Fragment.colorOrNull(@ColorRes colorRes: Int): Int? = requireContext().colorOrNull(colorRes)


@ColorInt
fun AnkoUI.color(@ColorRes colorRes: Int): Int = context.color(colorRes)

@ColorInt
fun AnkoUI.colorOr(@ColorRes colorRes: Int, @ColorInt defaultColor: Int): Int = context.colorOr(colorRes, defaultColor)

@ColorInt
fun AnkoUI.colorOrNull(@ColorRes colorRes: Int): Int? = context.colorOrNull(colorRes)


@ColorInt
fun Context.color(colorString: String): Int = colorOr(colorString, 0)

@ColorInt
fun Context.colorOr(colorString: String, @ColorInt defaultColor: Int): Int = colorOrNull(colorString) ?: defaultColor

@ColorInt
fun Context.colorOrNull(colorString: String): Int? {
    return runCatching { Color.parseColor(colorString) }.getOrNull()
}

@ColorInt
fun View.color(colorString: String): Int = context.color(colorString)

@ColorInt
fun View.colorOr(colorString: String, @ColorInt defaultColor: Int): Int = context.colorOr(colorString, defaultColor)

@ColorInt
fun View.colorOrNull(colorString: String): Int? = context.colorOrNull(colorString)

@ColorInt
fun Fragment.color(colorString: String): Int = requireContext().color(colorString)

@ColorInt
fun Fragment.colorOr(colorString: String, @ColorInt defaultColor: Int): Int = requireContext().colorOr(colorString, defaultColor)

@ColorInt
fun Fragment.colorOrNull(colorString: String): Int? = requireContext().colorOrNull(colorString)

@ColorInt
fun AnkoUI.color(colorString: String): Int = context.color(colorString)

@ColorInt
fun AnkoUI.colorOr(colorString: String, @ColorInt defaultColor: Int): Int = context.colorOr(colorString, defaultColor)

@ColorInt
fun AnkoUI.colorOrNull(colorString: String): Int? = context.colorOrNull(colorString)


@SuppressLint("RestrictedApi", "ResourceType")
fun Context.getColorStateListCompat(@ColorRes resId: Int): ColorStateList? {
    return ColorStateListInflaterCompat.inflate(
        resources,
        resId,
        null
    )
}

@ColorInt
fun Context.getColorPrimary(): Int = colorAttr(androidx.appcompat.R.attr.colorPrimary)

