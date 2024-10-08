package com.abadzheva.shoppinglist.presentation

import androidx.recyclerview.widget.DiffUtil
import com.abadzheva.shoppinglist.domain.ShopItem

class ShopItemDiffCallback : DiffUtil.ItemCallback<ShopItem>() {
    override fun areItemsTheSame(
        oldItem: ShopItem,
        newItem: ShopItem,
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: ShopItem,
        newItem: ShopItem,
    ): Boolean = oldItem == newItem
}
