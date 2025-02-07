package com.example.todoappp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class ToDoViewmodel:ViewModel() {

    val todoDao =MainApplication.todoDatabase.getToDoDao()
    val todoList:LiveData<List<ToDo>> = todoDao.getAllTodo()




    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title:String) {
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.addToDo(ToDo(title = title, createAt = Date.from(Instant.now())))
        }
    }

    fun deleteTodo(id:Int) {
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.deleteTodo(id)
        }
    }
}