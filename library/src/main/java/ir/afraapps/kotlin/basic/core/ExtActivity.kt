package ir.afraapps.kotlin.basic.core

import android.app.Activity
import android.view.inputmethod.InputMethodManager
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
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