package ir.afraapps.kotlin.basic.view

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.core.view.isVisible
import ir.afraapps.kotlin.basic.R
import org.jetbrains.anko.colorAttr

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 10/16/19.
 */

abstract class AnkoUI(
    val context: Context,
    val colorPrimary: Int = context.colorAttr(R.attr.colorPrimary),
    val colorPrimaryDark: Int = context.colorAttr(R.attr.colorPrimaryDark)
) {

    abstract val root: View


    @Suppress("UNCHECKED_CAST")
    fun <T : AnkoUI> bind(activity: Activity): T {
        activity.setContentView(root)
        return this as T
    }

    fun postDelayed(delayInMillis: Long, action: () -> Unit): Runnable {
        val runnable = Runnable { action() }
        root.postDelayed(runnable, delayInMillis)
        return runnable
    }

    var visibility: Int
        get() = root.visibility
        set(value) = let { root.visibility = value }

    var isVisible: Boolean
        get() = root.isVisible
        set(value) = let { root.isVisible = value }

    open fun hide() = let { isVisible = false }

}

fun <T : AnkoUI> Activity.setContentView(ui: T): T {
    setContentView(ui.root)
    return ui
}