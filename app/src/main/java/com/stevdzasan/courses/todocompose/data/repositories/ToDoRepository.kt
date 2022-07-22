package com.stevdzasan.courses.todocompose.data.repositories

import com.stevdzasan.courses.todocompose.data.ToDoDao
import com.stevdzasan.courses.todocompose.data.models.ToDoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class ToDoRepository @Inject constructor(private val toDoDao: ToDoDao) {

    fun getAllTasks(): Flow<List<ToDoTask>> {
        return toDoDao.getAllTasks()
    }

    fun sortByLowPriority(): Flow<List<ToDoTask>> {
        return toDoDao.sortByLowPriority()
    }

    fun sortByHighPriority(): Flow<List<ToDoTask>> {
        return toDoDao.sortByHighPriority()
    }

    fun getSelectedTask(taskId: Int): Flow<ToDoTask> {
        return toDoDao.getSelectedTask(taskId)
    }

    fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>> {
        return toDoDao.searchDatabase(searchQuery)
    }

    suspend fun addTask(toDoTask: ToDoTask) {
        toDoDao.addTask(toDoTask)
    }

    suspend fun updateTask(toDoTask: ToDoTask) {
        toDoDao.updateTask(toDoTask)
    }

    suspend fun deleteTask(toDoTask: ToDoTask) {
        toDoDao.deleteTask(toDoTask)
    }

    suspend fun deleteAllTasks() {
        toDoDao.deleteAllTasks()
    }
}