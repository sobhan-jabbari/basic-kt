package ir.afraapps.kotlin.basic.view

import android.app.Activity
import android.content.Context
import android.view.View
import ir.afraapps.kotlin.basic.R
import ir.afraapps.kotlin.basic.core.getColorAttr

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 10/16/19.
 */

abstract class AnkoUI(val context: Context) {

    abstract val root: View

    val colorPrimary: Int by lazy { context.getColorAttr(R.attr.colorPrimary) }
    val colorPrimaryDark: Int by lazy { context.getColorAttr(R.attr.colorPrimaryDark) }


    companion object {

        fun <T : AnkoUI> setContentView(activity: Activity, clazz: Class<T>): T {
            val ui = clazz.getConstructor(Context::class.java).newInstance(activity)
            activity.setContentView(ui.root)
            return ui
        }
    }


}