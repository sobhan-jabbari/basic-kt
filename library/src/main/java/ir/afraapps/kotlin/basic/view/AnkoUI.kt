package ir.afraapps.kotlin.basic.view

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.core.view.isVisible
import ir.afraapps.kotlin.basic.util.property.IntProperty
import org.jetbrains.anko.colorAttr

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 10/16/19.
 */

abstract class AnkoUI(
    val context: Context,
    primaryColor: Int = context.colorAttr(androidx.appcompat.R.attr.colorPrimary),
    primaryColorDark: Int = context.colorAttr(androidx.appcompat.R.attr.colorPrimaryDark)
) {

    val colorPrimaryProperty = IntProperty(primaryColor)
    val colorPrimaryDarkProperty = IntProperty(primaryColorDark)
    val colorPrimaryLightProperty = IntProperty(primaryColorDark)

    var colorPrimary: Int by colorPrimaryProperty
    var colorPrimaryDark: Int by colorPrimaryDarkProperty
    var colorPrimaryLight: Int by colorPrimaryLightProperty

    abstract val root: View


    @Suppress("UNCHECKED_CAST")
    fun <T : AnkoUI> bind(): T {
        (context as? Activity)?.setContentView(root)
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