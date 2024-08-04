package com.abadzheva.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abadzheva.shoppinglist.R
import com.abadzheva.shoppinglist.domain.ShopItem

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {
    val list = listOf<ShopItem>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ShopItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shop_disabled, parent, false)
        return ShopItemViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(
        viewHolder: ShopItemViewHolder,
        position: Int,
    ) {
        val shopItem = list[position]
        viewHolder.tvName.text = shopItem.name
        viewHolder.tvCount.text = String.format("%d", shopItem.count)
        viewHolder.view.setOnLongClickListener {
            true
        }
    }

    class ShopItemViewHolder(
        val view: View,
    ) : RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)
    }
}
