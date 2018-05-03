package com.carlos.carlos.csgoitems.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.carlos.carlos.csgoitems.R
import com.carlos.carlos.csgoitems.models.CSGOObject
import com.carlos.carlos.csgoitems.ui.activities.MainActivity
import kotlinx.android.synthetic.main.item_row.view.*

class ItemsAdapter(private val comicList: MutableList<CSGOObject>) : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsAdapter.ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_row, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(comicList[position])
    }

    override fun getItemCount(): Int {
        return comicList.size
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: CSGOObject) = with(itemView) {
            item__label__name.text = item.market_name
            item_label_type.text = item.name_color

            itemView.setOnClickListener {
                /*val intent = MainActivity.newIntent(this.context, item.id, section)
                rootView.context.startActivity(intent)*/
            }
        }
    }

}