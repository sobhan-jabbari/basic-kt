package ir.afraapps.kotlin.basic.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.*
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ColorStateListInflaterCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.text.TextUtilsCompat
import androidx.core.text.layoutDirection
import androidx.core.view.forEach
import com.google.android.material.textfield.TextInputLayout
import ir.afraapps.kotlin.basic.core.color
import ir.afraapps.kotlin.basic.core.color
import org.jetbrains.anko.inputMethodManager
import org.jetbrains.anko.internals.AnkoInternals
import java.util.*

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 4/24/20.
 */


fun View.closeSoftKeyboard() {
    context.inputMethodManager.hideSoftInputFromWindow(
        windowToken,
        InputMethodManager.RESULT_UNCHANGED_SHOWN
    )
}

fun EditText.showSoftKeyboard() {
    requestFocus()
    context.inputMethodManager.showSoftInput(
        this,
        InputMethodManager.SHOW_FORCED
    )
}


fun View.dispatchEnabled(enabled: Boolean) {
    isEnabled = enabled
    if (this is ViewGroup) {
        forEach { it.dispatchEnabled(enabled) }
    }
}

inline var AppCompatImageView.tintColor: Int
    @SuppressLint("RestrictedApi")
    get() = supportImageTintList?.defaultColor ?: 0
    @SuppressLint("RestrictedApi")
    set(@ColorInt value) {
        supportImageTintList = ColorStateList.valueOf(value)

    }


inline var AppCompatImageView.tintColorRes: Int
    @SuppressLint("RestrictedApi")
    get() = supportImageTintList?.defaultColor ?: 0
    @SuppressLint("RestrictedApi")
    set(@ColorRes value) {
        supportImageTintList = ColorStateList.valueOf(ContextCompat.getColor(context, value))

    }


inline var AppCompatImageView.backgroundTintColor: Int
    @SuppressLint("RestrictedApi")
    get() = supportBackgroundTintList?.defaultColor ?: 0
    @SuppressLint("RestrictedApi")
    set(@ColorInt value) {
        supportBackgroundTintList = ColorStateList.valueOf(value)
    }


inline var AppCompatImageView.backgroundTintColorRes: Int
    @SuppressLint("RestrictedApi")
    get() = supportBackgroundTintList?.defaultColor ?: 0
    @SuppressLint("RestrictedApi")
    set(@ColorRes value) {
        supportBackgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, value))

    }


inline var AppCompatImageView.tintStateColorRes: Int
    @Deprecated(
        AnkoInternals.NO_GETTER,
        level = DeprecationLevel.ERROR
    ) get() = AnkoInternals.noGetter()
    @SuppressLint("RestrictedApi", "ResourceType")
    set(@ColorRes resId) = setSupportImageTintList(
        ColorStateListInflaterCompat.inflate(
            resources,
            resId,
            null
        )
    )

inline var AppCompatImageView.tintStateColor: ColorStateList?
    @Deprecated(
        AnkoInternals.NO_GETTER,
        level = DeprecationLevel.ERROR
    ) get() = AnkoInternals.noGetter()
    @SuppressLint("RestrictedApi", "ResourceType")
    set(stateListColor) = setSupportImageTintList(stateListColor)


inline var AppCompatImageView.backgroundTintStateColorRes: Int
    @Deprecated(
        AnkoInternals.NO_GETTER,
        level = DeprecationLevel.ERROR
    ) get() = AnkoInternals.noGetter()
    @SuppressLint("RestrictedApi", "ResourceType")
    set(@ColorRes resId) = setSupportBackgroundTintList(
        ColorStateListInflaterCompat.inflate(
            resources,
            resId,
            null
        )
    )

inline var AppCompatTextView.compoundDrawableTintColor: Int
    @SuppressLint("RestrictedApi")
    get() = supportCompoundDrawablesTintList?.defaultColor ?: 0
    @SuppressLint("RestrictedApi")
    set(@ColorInt value) {
        supportCompoundDrawablesTintList = ColorStateList.valueOf(value)

    }

inline var AppCompatTextView.compoundDrawableTintColorRes: Int
    @SuppressLint("RestrictedApi")
    get() = supportCompoundDrawablesTintList?.defaultColor ?: 0
    @SuppressLint("RestrictedApi")
    set(@ColorRes value) {
        supportCompoundDrawablesTintList = ColorStateList.valueOf(context.color(value))

    }

inline var View.backgroundResourceAttr: Int
    @Deprecated(
        AnkoInternals.NO_GETTER,
        level = DeprecationLevel.ERROR
    ) get() = AnkoInternals.noGetter()
    set(@AttrRes v) {
        val a: TypedArray = context.obtainStyledAttributes(intArrayOf(v))
        val resId = a.getResourceId(0, 0)
        a.recycle()
        setBackgroundResource(resId)
    }

inline var TextView.textColorAttr: Int
    @Deprecated(
        AnkoInternals.NO_GETTER,
        level = DeprecationLevel.ERROR
    ) get() = AnkoInternals.noGetter()
    set(@AttrRes v) {
        val a: TypedArray = context.obtainStyledAttributes(intArrayOf(v))
        val color = a.getColor(0, 0)
        a.recycle()
        setTextColor(color)
    }


var TextView.textColorStateResource: Int
    @Deprecated(
        AnkoInternals.NO_GETTER,
        level = DeprecationLevel.ERROR
    ) get() = AnkoInternals.noGetter()
    @SuppressLint("RestrictedApi", "ResourceType")
    set(@ColorRes resId) = setTextColor(
        ColorStateListInflaterCompat.inflate(
            resources,
            resId,
            null
        )
    )


inline var TextView.fontRes: Int
    @Deprecated(
        AnkoInternals.NO_GETTER,
        level = DeprecationLevel.ERROR
    ) get() = AnkoInternals.noGetter()
    set(@FontRes v) {
        typeface = ResourcesCompat.getFont(context, v)
    }


var TextInputLayout.StrokeColorStateResource: Int
    @Deprecated(
        AnkoInternals.NO_GETTER,
        level = DeprecationLevel.ERROR
    ) get() = AnkoInternals.noGetter()
    @SuppressLint("RestrictedApi", "ResourceType")
    set(@ColorRes resId) {
        val colorState = ColorStateListInflaterCompat.inflate(
            resources,
            resId,
            null
        )
        colorState?.let { setBoxStrokeColorStateList(it) }
    }

var TextInputLayout.hintResource: Int
    @Deprecated(
        AnkoInternals.NO_GETTER,
        level = DeprecationLevel.ERROR
    ) get() = AnkoInternals.noGetter()
    set(@StringRes resId) {
        hint = context.getString(resId)
    }


fun View.addOnGlobalLayoutListener(command: () -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            viewTreeObserver.removeOnGlobalLayoutListener(this)
            command.invoke()
        }
    })
}


fun View.isRTL(): Boolean = layoutDirection == View.LAYOUT_DIRECTION_RTL


