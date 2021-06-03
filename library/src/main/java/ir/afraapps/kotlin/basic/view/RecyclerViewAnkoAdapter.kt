package ir.afraapps.kotlin.basic.view

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


abstract class RecyclerViewAnkoAdapter<V : AnkoUI, I>(private val items: List<I>) :
    RecyclerView.Adapter<RecyclerViewAnkoAdapter.ViewHolder<V>>() {


    override fun onBindViewHolder(viewHolder: ViewHolder<V>, position: Int) {
        onBindItem(viewHolder.ui, getItem(position), position)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<V> {
        return ViewHolder(getUI(parent.context, viewType))
    }


    abstract fun onBindItem(ui: V, item: I?, position: Int)
    abstract fun getUI(context: Context, viewType: Int): V


    override fun onViewDetachedFromWindow(holder: ViewHolder<V>) {
        if (holder.itemView.animation != null) {
            holder.itemView.animation.cancel()
        }
        super.onViewDetachedFromWindow(holder)
    }


    override fun getItemId(position: Int): Long {
        return getItemId(getItem(position))
    }

    fun getItem(position: Int): I? = items.getOrNull(position)


    protected abstract fun getItemId(item: I?): Long


    override fun getItemCount(): Int = items.size


    class ViewHolder<V : AnkoUI>(var ui: V) : RecyclerView.ViewHolder(ui.root)


}
