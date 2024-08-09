package com.abadzheva.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.abadzheva.shoppinglist.data.ShopListRepositoryImpl
import com.abadzheva.shoppinglist.domain.AddShopItemUseCase
import com.abadzheva.shoppinglist.domain.EditShopItemUseCase
import com.abadzheva.shoppinglist.domain.GetShopItemUseCase
import com.abadzheva.shoppinglist.domain.ShopItem

class ShopItemViewModel : ViewModel() {
    private val repository = ShopListRepositoryImpl
    private val getShopItemUseCase = GetShopItemUseCase(repository)
    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    fun getShopItem(shopItemId: Int) = getShopItemUseCase.getShopItem(shopItemId)

    fun addShopItem(
        inputName: String?,
        inputCount: String?,
    ) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldsValid = validateInput(name, count)
        if (!fieldsValid) return
        val shopItem = ShopItem(name, count, true)
        addShopItemUseCase.addShopItem(shopItem)
    }

    fun editShopItem(
        inputName: String?,
        inputCount: String?,
    ) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldsValid = validateInput(name, count)
        if (!fieldsValid) return
        val shopItem = ShopItem(name, count, true)
        editShopItemUseCase.editShopItem(shopItem)
    }

    private fun parseName(inputName: String?): String = inputName?.trim() ?: ""

    private fun parseCount(inputCount: String?) = inputCount?.trim()?.toIntOrNull() ?: 0

    private fun validateInput(
        name: String,
        count: Int,
    ): Boolean {
        var result = true
        if (name.isBlank()) {
            // todo: show error input name
            result = false
        }
        if (count <= 0) {
            // todo: show error input count
            result = false
        }
        return result
    }
}
