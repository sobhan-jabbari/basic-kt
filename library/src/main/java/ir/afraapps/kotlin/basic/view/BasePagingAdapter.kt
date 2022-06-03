package ir.afraapps.kotlin.basic.view

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil


abstract class BasePagingAdapter<V : AnkoUI, VH : AnkoViewHolder<V>, I : Any>(diffCallback: DiffUtil.ItemCallback<I>) :
    PagingDataAdapter<I, VH>(diffCallback) {

    private var lastPosition: Int = 0

    val isEmpty: Boolean
        get() = itemCount == 0


    override fun onBindViewHolder(holder: VH, position: Int) {
        onBindItem(holder, getItem(position), position)
        animateItem(holder.itemView, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return onCreateViewHolder(parent.context, viewType)
    }

    abstract fun getItemId(item: I): Long
    abstract fun onBindItem(holder: VH, item: I?, position: Int)

    protected abstract fun onCreateViewHolder(context: Context, viewType: Int): VH

    fun getItemPositionById(id: Long): Int {
        snapshot().items.forEachIndexed { index, i ->
            if (getItemId(i) == id) return index
        }
        return -1
    }

    fun getItemWithId(id: Long): I? {
        snapshot().forEach { it?.let { item -> if (getItemId(item) == id) return item } }
        return null
    }

    protected open fun getAnimationResId(): Int = 0

    override fun onViewDetachedFromWindow(holder: VH) {
        holder.itemView.animation?.cancel()
        super.onViewDetachedFromWindow(holder)
    }


    private fun animateItem(view: View, position: Int) {
        if (getAnimationResId() != 0 && position > lastPosition) {
            val animation = view.animation ?: AnimationUtils.loadAnimation(view.context, getAnimationResId())
            view.startAnimation(animation)
            lastPosition = position
        }
    }

}
