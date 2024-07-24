package com.example.todoappp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ToDoDao {
    @Query("Select * from ToDo")
    fun getAllTodo():LiveData<List<ToDo>>

    @Insert
    fun addToDo(todo:ToDo)

    @Query("Delete from ToDo where id=:id")
    fun deleteTodo(id:Int)
}