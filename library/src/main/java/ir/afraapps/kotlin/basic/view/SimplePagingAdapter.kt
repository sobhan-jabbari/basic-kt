package ir.afraapps.kotlin.basic.view

import androidx.recyclerview.widget.DiffUtil


abstract class SimplePagingAdapter<I : Any>(diffCallback: DiffUtil.ItemCallback<I>) :
    BasePagingAdapter<AnkoUI, SimplePagingAdapter.ViewHolder<AnkoUI>, I>(diffCallback) {

    class ViewHolder<V : AnkoUI>(ui: V) : AnkoViewHolder<V>(ui)

}
