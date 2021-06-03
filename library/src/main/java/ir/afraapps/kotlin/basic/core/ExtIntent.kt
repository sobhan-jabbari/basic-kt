package ir.afraapps.kotlin.basic.core

import android.content.Context
import android.content.Intent

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 11/2/20.
 */

fun Intent.sendBroadcast(context: Context) {
    context.sendBroadcast(this)
}