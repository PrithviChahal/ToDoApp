package com.example.todoappp

import android.app.Application
import androidx.room.Room

class MainApplication: Application() {

    companion object {
        lateinit var todoDatabase: ToDoDatabase
    }


    override fun onCreate() {
      super.onCreate()
       todoDatabase= Room.databaseBuilder(applicationContext,ToDoDatabase::class.java,"ToDoDB").build()
    }
}