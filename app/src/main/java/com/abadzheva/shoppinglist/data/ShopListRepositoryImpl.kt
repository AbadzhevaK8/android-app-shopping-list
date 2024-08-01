package com.abadzheva.shoppinglist.data

import com.abadzheva.shoppinglist.domain.ShopItem
import com.abadzheva.shoppinglist.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {
    private val shopList = mutableListOf<ShopItem>()

    private var autoIncrementId = 0

    init {
        for (i in 0 until 10) {
            val item = ShopItem("Name $i", i, true)
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItemId: Int) {
        shopList.removeAt(shopItemId)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem =
        shopList.find { it.id == shopItemId }
            ?: throw RuntimeException("Element with id $shopItemId not found")

    override fun getShopList(): List<ShopItem> = shopList.toList()
}
