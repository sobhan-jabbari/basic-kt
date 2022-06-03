package ir.afraapps.kotlin.basic.view

import android.content.Context
import android.view.View

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 10/17/19.
 */

abstract class BasicItemLoadingUI(context: Context) : AnkoUI(context) {
    abstract fun isLoading(loading: Boolean)
    abstract fun isFailed(failed: Boolean, message: String?)
    abstract fun onClickError(onClick: View.OnClickListener?)
}