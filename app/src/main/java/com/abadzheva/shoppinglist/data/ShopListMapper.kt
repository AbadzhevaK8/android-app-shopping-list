package com.abadzheva.shoppinglist.data

import com.abadzheva.shoppinglist.domain.ShopItem
import javax.inject.Inject

class ShopListMapper
    @Inject
    constructor() {
        fun mapEntityToDbModel(shopItem: ShopItem): ShopItemDbModel =
            ShopItemDbModel(
                id = shopItem.id,
                name = shopItem.name,
                count = shopItem.count,
                enabled = shopItem.enabled,
            )

        fun mapDbModelToEntity(shopItemDbModel: ShopItemDbModel) =
            ShopItem(
                id = shopItemDbModel.id,
                name = shopItemDbModel.name,
                count = shopItemDbModel.count,
                enabled = shopItemDbModel.enabled,
            )

        fun mapListDbModelToListEntity(list: List<ShopItemDbModel>) =
            list.map {
                mapDbModelToEntity(it)
            }
    }
