package com.example.Mouth7Work1.domain.useCase

import com.example.Mouth7Work1.domain.model.ShopItem
import com.example.Mouth7Work1.domain.repository.ShopListRepository

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {
    suspend fun deleteShopItem(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }
}