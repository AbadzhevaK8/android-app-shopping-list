package com.abadzheva.shoppinglist.domain

class GetShopItemUseCase(
    private val shopListRepository: ShopListRepository,
) {
    suspend fun getShopItem(shopItemId: Int): ShopItem = shopListRepository.getShopItem(shopItemId)
}
