package ir.afraapps.kotlin.basic.core

import android.view.View
import androidx.core.text.layoutDirection
import java.util.*

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 10/7/20.
 */

fun Boolean.takeIfTrue(action: () -> Unit): Boolean {
    if (this) {
        action.invoke()
        return true
    }
    return false
}

fun Boolean.takeIfFalse(action: () -> Unit): Boolean {
    if (!this) {
        action.invoke()
        return true
    }
    return false
}


fun <T> List<T>.takeIfNotEmpty(): List<T>? {
    return if (isNotEmpty()) this else null
}


fun <T : Any> T.getPrivateProperty(variableName: String): Any? {
    return javaClass.getDeclaredField(variableName).let { field ->
        field.isAccessible = true
        return@let field.get(this)
    }
}

fun isLocaleRTL(): Boolean = Locale.getDefault().layoutDirection == View.LAYOUT_DIRECTION_RTL
