package com.example.Mouth7Work1.domain.model

data class ShopItem(
    val name: String,
    val count: Int,
    var enabled: Boolean,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}
