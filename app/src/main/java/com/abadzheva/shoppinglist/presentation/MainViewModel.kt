package com.abadzheva.shoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abadzheva.shoppinglist.data.ShopListRepositoryImpl
import com.abadzheva.shoppinglist.domain.DeleteShopItemUseCase
import com.abadzheva.shoppinglist.domain.EditShopItemUseCase
import com.abadzheva.shoppinglist.domain.GetShopListUseCase
import com.abadzheva.shoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {
    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopListUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList() {
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopListUseCase.deleteShopItem(shopItem.id)
        getShopList()
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
        getShopList()
    }
}
