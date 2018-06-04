package com.divya.rememberyourpasswords.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * Created by divya on 5/14/2018.
 */

@Database(entities = arrayOf(UserAccount::class), version = 1)
abstract class UserAccountDatabase : RoomDatabase() {

    abstract fun userAccountDao(): UserAccountDao

    companion object {
       private var INSTANCE: UserAccountDatabase? = null

        fun getAppDatabase(context: Context): UserAccountDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, UserAccountDatabase::class.java, "user-database").allowMainThreadQueries().build()

            }

            return INSTANCE!!

        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

}
