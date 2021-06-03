package ir.afraapps.kotlin.basic.view

import android.view.ViewManager
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
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



