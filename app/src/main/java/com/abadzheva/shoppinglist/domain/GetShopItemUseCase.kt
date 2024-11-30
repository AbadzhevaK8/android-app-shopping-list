package com.abadzheva.shoppinglist.domain

import javax.inject.Inject

class GetShopItemUseCase
    @Inject
    constructor(
        private val shopListRepository: ShopListRepository,
    ) {
        suspend fun getShopItem(shopItemId: Int): ShopItem = shopListRepository.getShopItem(shopItemId)
    }
