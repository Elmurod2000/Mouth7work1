package com.example.Mouth7Work1.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.Mouth7Work1.data.model.ShopItemDBModel
import com.example.helper.data.local.ShopItemDao

@Database(entities = [ShopItemDBModel::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun shopItemDao(): ShopItemDao
}