package ir.afraapps.kotlin.basic.view

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import ir.afraapps.kotlin.basic.data.BaseDataSource


abstract class BaseAdapterPagedListEndlessSimple<V : AnkoUI, I>(diffCallback: DiffUtil.ItemCallback<I>) :
    BaseAdapterPagedListSimple<V, I>(diffCallback) {

    companion object {
        val TYPE_LOADING = -1
    }

    var isRefreshLoading: Boolean = false
        private set
    var isLoadingFailed: Boolean = false
        private set


    override fun onBindViewHolder(holder: ViewHolder<V>, position: Int) {
        val viewType = getItemViewType(position)
        if (viewType == TYPE_LOADING) {
            if (holder.ui is BasicItemLoadingUI) {
                holder.ui.apply {
                    isRefreshing(isRefreshLoading)
                    isFailed(isLoadingFailed)
                    onClickError({ retry() })
                }
            }

        } else {
            super.onBindViewHolder(holder, position)
        }
    }


    protected abstract fun <L : BasicItemLoadingUI> getLoadingUI(context: Context): L


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<V> {
        return if (viewType == TYPE_LOADING) ViewHolder(getLoadingUI(parent.context))
        else super.onCreateViewHolder(parent, viewType)
    }


    fun setIsRefreshing(value: Boolean) {
        //if (value == refreshLoading) return;
        this.isLoadingFailed = false
        this.isRefreshLoading = value
        if (value) {
            notifyItemInserted(itemCount)

        } else {
            notifyItemRemoved(itemCount)
        }
    }


    fun setLoadingFailed() {
        this.isRefreshLoading = false
        this.isLoadingFailed = true
        notifyItemChanged(itemCount - 1)
    }


    fun hasLoadingItem(): Boolean {
        return isRefreshLoading || isLoadingFailed
    }


    private fun retry() {
        this.isRefreshLoading = true
        setIsRefreshing(false)
        currentList?.dataSource?.let {
            when (it) {
                is BaseDataSource -> it.retry()
            }
        }
    }


    override fun getItemId(position: Int): Long {
        return if (isLoadingItem(position)) -1L else super.getItemId(position)
    }


    override fun getItemViewType(position: Int): Int {
        return if (isLoadingItem(position)) TYPE_LOADING else super.getItemViewType(position)
    }


    override fun getItemCount(): Int {
        return if (hasLoadingItem()) super.getItemCount() + 1 else super.getItemCount()
    }


    protected fun isLoadingItem(position: Int): Boolean {
        return hasLoadingItem() && position == itemCount - 1
    }


}
