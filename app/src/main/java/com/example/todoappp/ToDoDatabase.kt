package com.example.todoappp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities=[ToDo::class], version = 1)
@TypeConverters(DateConverter::class)
 abstract class ToDoDatabase:RoomDatabase() {

     abstract fun getToDoDao():ToDoDao

}