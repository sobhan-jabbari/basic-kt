package ir.afraapps.kotlin.basic.core

import android.content.res.ColorStateList
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.annotation.*
import androidx.core.text.layoutDirection
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import ir.afraapps.kotlin.basic.R
import org.jetbrains.anko.inputMethodManager
import java.util.*

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 4/24/20.
 */


fun Fragment.closeSoftKeyboard() {
    requireActivity().let { a ->
        a.currentFocus?.let {
            a.inputMethodManager.hideSoftInputFromWindow(
                it.windowToken,
                InputMethodManager.RESULT_UNCHANGED_SHOWN
            )
        }
    }
}


fun <I, O> Fragment.registerForActivityResult(
    callback: ActivityResultCallback<O>,
    contract: ActivityResultContract<I, O>
): ActivityResultLauncher<I> {
    return registerForActivityResult(contract, callback)
}


@ColorInt
fun Fragment.getColorRes(@ColorRes colorRes: Int): Int = requireContext().getColorRes(colorRes)

@ColorInt
fun Fragment.getColorAttr(@AttrRes colorAttrRes: Int): Int = requireContext().getColorAttr(colorAttrRes)
fun Fragment.getColorStateListCompat(@ColorRes resId: Int): ColorStateList? = requireContext().getColorStateListCompat(resId)

@ColorInt
fun Fragment.getColorPrimary(): Int = getColorAttr(R.attr.colorPrimary)
fun Fragment.getFont(@FontRes fontRes: Int): Typeface? = requireContext().getFont(fontRes)

fun Fragment.getDrawableCompat(@DrawableRes id: Int): Drawable? = requireContext().getDrawableCompat(id)

fun Fragment.showToast(@StringRes restId: Int) = requireContext().showToast(restId)
fun Fragment.showToast(message: String) = requireContext().showToast(message)


fun Fragment.isLocaleRTL(): Boolean = Locale.getDefault().layoutDirection == View.LAYOUT_DIRECTION_RTL