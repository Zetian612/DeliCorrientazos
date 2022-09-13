package com.example.delicorrientazos.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.delicorrientazos.data.db.entities.CartDelicias

@Database(entities = [CartDelicias::class], version = 1)
abstract class CartDeliDatabase: RoomDatabase() {
    abstract fun cartDeliciasDao(): CartDeliciasDao

    companion object {

        @Volatile
        private var INSTANCE: CartDeliDatabase? = null

        fun getDatabase(context: Context): CartDeliDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CartDeliDatabase::class.java,
                    "database_mc_app_v"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }

}