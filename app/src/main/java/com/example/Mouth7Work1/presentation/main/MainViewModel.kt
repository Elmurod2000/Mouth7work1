package com.example.Mouth7Work1.presentation.main

import androidx.lifecycle.ViewModel
import com.example.Mouth7Work1.data.repository.ShopListRepositoryImpl
import com.example.Mouth7Work1.domain.model.ShopItem
import com.example.Mouth7Work1.domain.useCase.*

class MainViewModel : ViewModel() {

    private val repositoryImpl = ShopListRepositoryImpl()
    private val addShopItemUseCase = AddShopItemUseCase(repositoryImpl)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repositoryImpl)
    private val getShopListUseCase = GetShopListUseCase(repositoryImpl)
    private val editShopItemUseCase = EditShopItemUseCase(repositoryImpl)
    private val getShopItemUseCase = GetShopItemUseCase(repositoryImpl)
    val shopListLD = getShopListUseCase.getShopList()

    init {
        addShopItem(ShopItem("Яблоко", 25, true))
        addShopItem(ShopItem("Апельсин", 13, true))
        addShopItem(ShopItem("Черещня", 42, true))
        addShopItem(ShopItem("Калинка", 33, true))
        addShopItem(ShopItem("Фосфор", 23, true))
        addShopItem(ShopItem("Река", 21, true))
        addShopItem(ShopItem("Шоколод", 56, true))
        addShopItem(ShopItem("Грузин", 54, true))
        addShopItem(ShopItem("Вишня", 34, true))
        addShopItem(ShopItem("Йогурт", 87, true))
        addShopItem(ShopItem("Яблокочко", 25, true))
        addShopItem(ShopItem("Рыба", 43, true))
        addShopItem(ShopItem("Просоня", 54, true))
        addShopItem(ShopItem("Ягода", 74, true))
        addShopItem(ShopItem("Оранж", 63, true))
        addShopItem(ShopItem("Яблоко", 15, true))
        addShopItem(ShopItem("Ягода", 52, true))
        addShopItem(ShopItem("Яблоко", 53, true))
        addShopItem(ShopItem("Ягода", 54, true))
        addShopItem(ShopItem("Яблоко", 54, true))
        addShopItem(ShopItem("Ягода", 43, true))
        addShopItem(ShopItem("Слабоа", 34, true))
        addShopItem(ShopItem("Нобоа", 32, true))
        addShopItem(ShopItem("Роналду", 34, true))
        addShopItem(ShopItem("Криштиану", 53, true))
        addShopItem(ShopItem("Месси", 34, true))
        addShopItem(ShopItem("Лионель", 32, true))
        addShopItem(ShopItem("Харри", 24, true))
        addShopItem(ShopItem("Магуаер", 32, true))
        addShopItem(ShopItem("Редкостяк", 83, true))
        addShopItem(ShopItem("Контроллер", 64, true))
        addShopItem(ShopItem("Сталкер", 65, true))
        addShopItem(ShopItem("Радикс", 67, true))
        addShopItem(ShopItem("Исин", 56, true))
        addShopItem(ShopItem("Ясен", 42, true))
        addShopItem(ShopItem("Гну", 43, true))
        addShopItem(ShopItem("Личинка", 45, true))
        addShopItem(ShopItem("Сколопендра", 53, true))
        addShopItem(ShopItem("Черепаха", 14, true))
        addShopItem(ShopItem("Жираф", 11, true))
        addShopItem(ShopItem("Морской", 1, true))
        addShopItem(ShopItem("Лев", 2, true))
    }

    fun addShopItem(shopItem: ShopItem) {
        addShopItemUseCase.addShopItem(shopItem)
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)

    }

    fun editShopItem(shopItem: ShopItem) {
        val newItem = with(shopItem) { copy(enabled = !enabled) }
        editShopItemUseCase.editShopItem(newItem)

    }

    fun getShopItem(shopItem: Int): ShopItem {
        return getShopItemUseCase.getShopItem(shopItem)
    }
}