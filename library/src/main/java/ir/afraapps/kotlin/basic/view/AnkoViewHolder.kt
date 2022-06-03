package ir.afraapps.kotlin.basic.view

import androidx.recyclerview.widget.RecyclerView

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 3/18/2022.
 */
open class AnkoViewHolder<V : AnkoUI>(val ui: V) : RecyclerView.ViewHolder(ui.root)
