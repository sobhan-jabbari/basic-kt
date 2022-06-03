package ir.afraapps.kotlin.basic.core

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.drawerlayout.widget.DrawerLayout
import ir.afraapps.kotlin.basic.view.AnkoUI
import ir.afraapps.kotlin.basic.view.OnSingleClickListener
import org.jetbrains.anko.wrapContent

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 4/24/20.
 */


fun View.onClick(action: ((v: View) -> Unit)?) {
    setOnClickListener(action)
}

fun View.onSingleClick(action: (v: View) -> Unit) {
    setOnClickListener(OnSingleClickListener(action))
}

fun View.onLongClick(action: (v: View) -> Boolean) {
    setOnLongClickListener(action)
}

fun <T : AnkoUI> FrameLayout.includeUI(ui: T, params: FrameLayout.LayoutParams.() -> Unit = {}): T {
    val lp = ui.root.layoutParams.let { p ->
        when (p) {
            is ViewGroup.MarginLayoutParams -> FrameLayout.LayoutParams(p)
            is ViewGroup.LayoutParams -> FrameLayout.LayoutParams(p)
            else -> FrameLayout.LayoutParams(wrapContent, wrapContent)
        }
    }
    addView(ui.root, lp.apply(params))
    return ui
}

fun <T : AnkoUI> LinearLayout.includeUI(ui: T, params: LinearLayout.LayoutParams.() -> Unit = {}): T {
    val lp = ui.root.layoutParams.let { p ->
        when (p) {
            is ViewGroup.MarginLayoutParams -> LinearLayout.LayoutParams(p)
            is ViewGroup.LayoutParams -> LinearLayout.LayoutParams(p)
            else -> LinearLayout.LayoutParams(wrapContent, wrapContent)
        }
    }
    addView(ui.root, lp.apply(params))
    return ui
}

fun <T : AnkoUI> RelativeLayout.includeUI(ui: T, params: RelativeLayout.LayoutParams.() -> Unit = {}): T {
    val lp = ui.root.layoutParams.let { p ->
        when (p) {
            is ViewGroup.MarginLayoutParams -> RelativeLayout.LayoutParams(p)
            is ViewGroup.LayoutParams -> RelativeLayout.LayoutParams(p)
            else -> RelativeLayout.LayoutParams(wrapContent, wrapContent)
        }
    }
    addView(ui.root, lp.apply(params))
    return ui
}

fun <T : AnkoUI> ConstraintLayout.includeUI(ui: T, params: ConstraintLayout.LayoutParams.() -> Unit = {}): T {
    val lp = ui.root.layoutParams.let { p ->
        when (p) {
            is ViewGroup.MarginLayoutParams -> ConstraintLayout.LayoutParams(p)
            is ViewGroup.LayoutParams -> ConstraintLayout.LayoutParams(p)
            else -> ConstraintLayout.LayoutParams(wrapContent, wrapContent)
        }
    }
    addView(ui.root, lp.apply(params))
    return ui
}

fun <T : AnkoUI> DrawerLayout.includeUI(ui: T, params: DrawerLayout.LayoutParams.() -> Unit = {}): T {
    val lp = ui.root.layoutParams.let { p ->
        when (p) {
            is ViewGroup.MarginLayoutParams -> DrawerLayout.LayoutParams(p)
            is ViewGroup.LayoutParams -> DrawerLayout.LayoutParams(p)
            else -> DrawerLayout.LayoutParams(wrapContent, wrapContent)
        }
    }
    addView(ui.root, lp.apply(params))
    return ui
}



