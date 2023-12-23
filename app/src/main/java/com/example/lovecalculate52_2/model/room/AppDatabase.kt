package com.example.lovecalculate52_2.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lovecalculate52_2.model.LoveModel

@Database(version = 1, entities = [LoveModel::class])
abstract class AppDatabase:RoomDatabase() {

    abstract fun getLoveDao():LoveDao
}