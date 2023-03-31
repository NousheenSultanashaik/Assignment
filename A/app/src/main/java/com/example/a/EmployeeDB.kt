package com.example.a

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [EmployeEntity::class], version = 1)
abstract class EmployeeDB : RoomDatabase() {


    abstract fun employeedao(): EmployeDAO

    companion object {

        @Volatile
        private var INSTANCE: EmployeeDB? = null
        //Instance will be created only Once


        fun getInstance(context: Context): EmployeeDB {

            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        EmployeeDB::class.java,
                        "employee_db"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }

        }
    }
}
