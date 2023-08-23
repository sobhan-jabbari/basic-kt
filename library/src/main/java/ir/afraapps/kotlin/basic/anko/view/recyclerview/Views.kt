@file:JvmName("RecyclerviewV7ViewsKt")

package org.jetbrains.anko.recyclerview.v7

import android.app.Activity
import android.content.Context
import android.view.ViewManager
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.AnkoViewDslMarker
import org.jetbrains.anko.custom.ankoView

@PublishedApi
internal object `$$Anko$Factories$RecyclerviewV7ViewGroup` {
    val RECYCLER_VIEW = { ctx: Context -> _RecyclerView(ctx) }
}

fun ViewManager.recyclerView(): RecyclerView = recyclerView() {}
inline fun ViewManager.recyclerView(init: (@AnkoViewDslMarker _RecyclerView).() -> Unit): RecyclerView {
    return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW, theme = 0) { init() }
}

fun ViewManager.themedRecyclerView(theme: Int = 0): RecyclerView = themedRecyclerView(theme) {}
inline fun ViewManager.themedRecyclerView(
    theme: Int = 0,
    init: (@AnkoViewDslMarker _RecyclerView).() -> Unit
): RecyclerView {
    return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW, theme) { init() }
}

fun Context.recyclerView(): RecyclerView = recyclerView() {}
inline fun Context.recyclerView(init: (@AnkoViewDslMarker _RecyclerView).() -> Unit): RecyclerView {
    return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW, theme = 0) { init() }
}

fun Context.themedRecyclerView(theme: Int = 0): RecyclerView = themedRecyclerView(theme) {}
inline fun Context.themedRecyclerView(theme: Int = 0, init: (@AnkoViewDslMarker _RecyclerView).() -> Unit): RecyclerView {
    return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW, theme) { init() }
}

fun Activity.recyclerView(): RecyclerView = recyclerView() {}
inline fun Activity.recyclerView(init: (@AnkoViewDslMarker _RecyclerView).() -> Unit): RecyclerView {
    return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW, theme = 0) { init() }
}

fun Activity.themedRecyclerView(theme: Int = 0): RecyclerView = themedRecyclerView(theme) {}
inline fun Activity.themedRecyclerView(theme: Int = 0, init: (@AnkoViewDslMarker _RecyclerView).() -> Unit): RecyclerView {
    return ankoView(`$$Anko$Factories$RecyclerviewV7ViewGroup`.RECYCLER_VIEW, theme) { init() }
}

