package com.example.Mouth7Work1.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.Mouth7Work1.domain.model.ShopItem
import com.example.Mouth7Work1.domain.repository.ShopListRepository

class ShopListRepositoryImpl : ShopListRepository {

    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private val shopList = mutableListOf<ShopItem>()

    private var autoIncrementId = 0

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
    }

    override fun editShopItem(shopItem: ShopItem) {
        shopItem.enabled = !shopItem.enabled
    }

    override fun getShopItem(shopItemId: Int): ShopItem = shopList[shopItemId]

    override fun getShopList(): LiveData<List<ShopItem>> = shopListLD

    private fun updateList() {
        shopListLD.value = shopList.toList()
    }
}