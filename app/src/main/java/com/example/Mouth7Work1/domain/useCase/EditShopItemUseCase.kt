package com.example.Mouth7Work1.domain.useCase

import com.example.Mouth7Work1.domain.model.ShopItem
import com.example.Mouth7Work1.domain.repository.ShopListRepository

class EditShopItemUseCase(private val shopEditRepository: ShopListRepository) {
    suspend fun editShopItem(shopItem: ShopItem) {
        shopEditRepository.editShopItem(shopItem)
    }
}