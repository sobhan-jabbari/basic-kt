package ir.afraapps.kotlin.basic.view

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


abstract class BaseAdapterPagedListSimple<V : AnkoUI, I>(diffCallback: DiffUtil.ItemCallback<I>) :
    PagedListAdapter<I, BaseAdapterPagedListSimple.ViewHolder<V>>(diffCallback) {

    private var lastPosition: Int = 0

    val isEmpty: Boolean
        get() = super.getItemCount() == 0


    override fun onBindViewHolder(holder: ViewHolder<V>, position: Int) {
        onBindItem(holder.ui, getItem(position), position)
        animateItem(holder.itemView, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<V> {
        return ViewHolder(onCreateUI(parent.context, viewType))
    }


    override fun getItemId(position: Int): Long {
        return getItemId(getItem(position))
    }

    abstract fun onBindItem(ui: V, item: I?, position: Int)

    protected abstract fun onCreateUI(context: Context, viewType: Int): V

    protected abstract fun getItemId(item: I?): Long
    protected open fun getAnimationResId(): Int = 0

    fun getItem(id: Long): I? {
        return getItemPosition(id).takeIf { it != -1 }?.let { getItem(it) }
    }

    fun getItemPosition(id: Long): Int {
        val items = currentList
        var position = 0
        for (item in items!!) {
            if (getItemId(item) == id) return position
            position++
        }
        return -1
    }


    override fun onViewDetachedFromWindow(holder: ViewHolder<V>) {
        holder.itemView.animation?.cancel()
        super.onViewDetachedFromWindow(holder)
    }


    private fun animateItem(view: View, position: Int) {
        if (position > lastPosition && getAnimationResId() != 0) {
            val animation = view.animation ?: AnimationUtils.loadAnimation(view.context, getAnimationResId())
            view.startAnimation(animation)
            lastPosition = position
        }
    }


    class ViewHolder<V : AnkoUI>(val ui: V) : RecyclerView.ViewHolder(ui.root)

}
