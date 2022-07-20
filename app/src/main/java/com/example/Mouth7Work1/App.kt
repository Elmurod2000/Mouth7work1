package com.example.Mouth7Work1

import android.app.Application
import androidx.room.Room
import com.example.Mouth7Work1.data.local.AppDataBase

class App : Application(){

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext, AppDataBase::class.java, "dataBase").fallbackToDestructiveMigration().build()
    }

    companion object {
        lateinit var db: AppDataBase
    }
}