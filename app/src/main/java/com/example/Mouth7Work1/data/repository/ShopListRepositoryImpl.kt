package com.example.Mouth7Work1.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.Mouth7Work1.App
import com.example.Mouth7Work1.domain.model.ShopItem
import com.example.Mouth7Work1.domain.repository.ShopListRepository
import com.example.Mouth7Work1.utils.ShopListMapper

class ShopListRepositoryImpl : ShopListRepository {

    private val shopList =
        sortedSetOf<ShopItem>({ element1, element2 -> element1.id.compareTo(element2.id) })
    private val mapper = ShopListMapper()

    override suspend fun addShopItem(shopItem: ShopItem) {
        App.db.shopItemDao().addShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override suspend fun deleteShopItem(shopItem: ShopItem) {
        App.db.shopItemDao().deleteShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override suspend fun editShopItem(shopItem: ShopItem) {
        App.db.shopItemDao().editShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override suspend fun getShopItem(shopItemId: Int): ShopItem { //= shopList[shopItemId]
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Element with ID $shopItemId not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> = Transformations.map(
        App.db.shopItemDao().getAll()
    ) {
        mapper.mapListDBModelToListEntity(it)
    }
}