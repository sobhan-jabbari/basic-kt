package ir.afraapps.kotlin.basic.core

import android.view.View

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 4/28/20.
 */

interface ItemCallback<T> {
    fun onClickItem(view: View, item: T, position: Int)
}