package com.abadzheva.shoppinglist.domain

import androidx.lifecycle.LiveData

class GetShopListUseCase(
    private val shopListRepository: ShopListRepository,
) {
    fun getShopList(): LiveData<List<ShopItem>> = shopListRepository.getShopList()
}
