package ir.afraapps.kotlin.basic.view

import android.content.Context
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseLoadingStateAdapter<V : BasicItemLoadingUI> :
    LoadStateAdapter<BaseLoadingStateAdapter.ViewHolder<V>>() {

    override fun onBindViewHolder(holder: ViewHolder<V>, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ViewHolder<V> {
        return onCreateViewHolder(parent.context)
    }

    protected abstract fun onCreateViewHolder(context: Context): ViewHolder<V>

    class ViewHolder<V : BasicItemLoadingUI>(private val ui: V, private val onRetry: () -> Unit) : RecyclerView.ViewHolder(ui.root) {

        init {
            ui.onClickError { onRetry.invoke() }
        }

        fun bind(loadState: LoadState) {
            ui.isLoading(loadState is LoadState.Loading)
            ui.isFailed(loadState is LoadState.Error, (loadState as? LoadState.Error)?.error?.message)
        }
    }


}