package ir.afraapps.kotlin.basic.core

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.AppBarLayout
import ir.afraapps.kotlin.basic.view.AnkoUI
import org.jetbrains.anko.matchParent
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
    setOnClickListener(object : View.OnClickListener {
        override fun onClick(v: View) {
            isClickable = false
            action(v)
            postDelayed({ isClickable = true }, 700)
        }
    })
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

fun <T : AnkoUI> CoordinatorLayout.includeUI(ui: T, params: CoordinatorLayout.LayoutParams.() -> Unit = {}): T {
    val lp = ui.root.layoutParams.let { p ->
        when (p) {
            is ViewGroup.MarginLayoutParams -> CoordinatorLayout.LayoutParams(p)
            is ViewGroup.LayoutParams -> CoordinatorLayout.LayoutParams(p)
            else -> CoordinatorLayout.LayoutParams(wrapContent, wrapContent)
        }
    }
    addView(ui.root, lp.apply(params))
    return ui
}

fun <T : AnkoUI> AppBarLayout.includeUI(ui: T, width: Int, params: AppBarLayout.LayoutParams.() -> Unit = {}): T {
    val lp = ui.root.layoutParams.let { p ->
        when (p) {
            is LinearLayout.LayoutParams -> AppBarLayout.LayoutParams(p)
            is ViewGroup.MarginLayoutParams -> AppBarLayout.LayoutParams(p)
            is ViewGroup.LayoutParams -> AppBarLayout.LayoutParams(p)
            else -> AppBarLayout.LayoutParams(width, wrapContent)
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



