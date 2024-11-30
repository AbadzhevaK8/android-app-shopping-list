package com.abadzheva.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abadzheva.shoppinglist.domain.DeleteShopItemUseCase
import com.abadzheva.shoppinglist.domain.EditShopItemUseCase
import com.abadzheva.shoppinglist.domain.GetShopListUseCase
import com.abadzheva.shoppinglist.domain.ShopItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel
    @Inject
    constructor(
        private val getShopListUseCase: GetShopListUseCase,
        private val deleteShopListUseCase: DeleteShopItemUseCase,
        private val editShopItemUseCase: EditShopItemUseCase,
    ) : ViewModel() {
        val shopList = getShopListUseCase.getShopList()

        fun deleteShopItem(shopItem: ShopItem) {
            viewModelScope.launch {
                deleteShopListUseCase.deleteShopItem(shopItem)
            }
        }

        fun changeEnableState(shopItem: ShopItem) {
            viewModelScope.launch {
                val newItem = shopItem.copy(enabled = !shopItem.enabled)
                editShopItemUseCase.editShopItem(newItem)
            }
        }
    }
