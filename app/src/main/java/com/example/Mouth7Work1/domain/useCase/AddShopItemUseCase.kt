package com.example.Mouth7Work1.domain.useCase

import com.example.Mouth7Work1.domain.model.ShopItem
import com.example.Mouth7Work1.domain.repository.ShopListRepository

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun addShopItem(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem)
    }
}