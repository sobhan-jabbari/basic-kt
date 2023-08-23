package ir.afraapps.kotlin.basic.view

import android.content.Context
import android.view.ViewManager
import android.widget.Switch
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.tabs.TabLayout
import org.jetbrains.anko.AnkoViewDslMarker
import org.jetbrains.anko.`$$Anko$Factories$Sdk25View`
import org.jetbrains.anko.custom.ankoView

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 10/15/19.
 */

inline fun ViewManager.imageViewCompat(init: AppCompatImageView.() -> Unit = {}): AppCompatImageView =
    imageViewCompat(0, init)

inline fun ViewManager.imageViewCompat(
    theme: Int,
    init: AppCompatImageView.() -> Unit = {}
): AppCompatImageView {
    return ankoView({ AppCompatImageView(it, null, theme) }, theme = theme, init = init)
}

inline fun ViewManager.textViewCompat(init: AppCompatTextView.() -> Unit = {}): AppCompatTextView {
    return ankoView({ AppCompatTextView(it) }, theme = 0, init = init)
}

inline fun ViewManager.swipeRefreshLayout(init: SwipeRefreshLayout.() -> Unit = {}): SwipeRefreshLayout {
    return ankoView({ SwipeRefreshLayout(it) }, theme = 0, init = init)
}

inline fun ViewManager.recyclerView(init: RecyclerView.() -> Unit = {}): RecyclerView {
    return ankoView({ RecyclerView(it) }, theme = 0, init = init)
}

inline fun ViewManager.tabLayout(theme: Int = 0, init: TabLayout.() -> Unit = {}): TabLayout {
    return ankoView({ TabLayout(it) }, theme = theme, init = init)
}

fun ViewManager.switchCompat(theme: Int = 0): SwitchCompat = switchCompat(theme) {}
inline fun ViewManager.switchCompat(theme: Int = 0, init: (@AnkoViewDslMarker SwitchCompat).() -> Unit): SwitchCompat {
    return ankoView({ ctx -> SwitchCompat(ctx) }, theme) { init() }
}


fun Context.switchCompat(theme: Int = 0): SwitchCompat = switchCompat(theme) {}
inline fun Context.switchCompat(theme: Int = 0, init: (@AnkoViewDslMarker SwitchCompat).() -> Unit): SwitchCompat {
    return ankoView({ ctx -> SwitchCompat(ctx) }, theme) { init() }
}



