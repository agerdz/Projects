package com.example.ContactProject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Contact::class)], version = 1)
abstract class ProductRoomDatabase: RoomDatabase() {
    abstract fun productDao(): ContactDao
    companion object {
        private var INSTANCE: ProductRoomDatabase? = null
        internal fun getDatabase(context: Context): ProductRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(ProductRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE =
                            Room.databaseBuilder<ProductRoomDatabase>(
                                context.applicationContext,
                                ProductRoomDatabase::class.java,
                                "product_database").build()
                    }
                }
            }
            return INSTANCE
        }
    }
}