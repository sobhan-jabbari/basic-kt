package ir.afraapps.kotlin.basic.core

import android.app.Activity
import android.os.Build
import android.view.inputmethod.InputMethodManager
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentActivity
import org.jetbrains.anko.inputMethodManager

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 4/24/20.
 */


fun Activity.closeSoftKeyboard() {
    currentFocus?.let {
        inputMethodManager.hideSoftInputFromWindow(
            it.windowToken,
            InputMethodManager.RESULT_UNCHANGED_SHOWN
        )
    }
}


fun <I, O> FragmentActivity.registerForActivityResult(
    callback: ActivityResultCallback<O>,
    contract: ActivityResultContract<I, O>
): ActivityResultLauncher<I> {
    return registerForActivityResult(contract, callback)
}

var Activity.statusBarColor: Int
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @ColorInt
    get() = window.statusBarColor
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    set(@ColorInt value) {
        window.statusBarColor = value
    }

var Activity.navigationBarColor: Int
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @ColorInt
    get() = window.navigationBarColor
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    set(@ColorInt value) {
        window.navigationBarColor = value
    }