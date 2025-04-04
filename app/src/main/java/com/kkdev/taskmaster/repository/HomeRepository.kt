package com.kkdev.taskmaster.repository

import com.kkdev.taskmaster.data.daos.TaskDao
import com.kkdev.taskmaster.data.models.Task

class HomeRepository (private val taskDao: TaskDao) {

    suspend fun getAllTasks(){
        taskDao.getAllTasks()
    }
    suspend fun getPinnedTask(){
        taskDao.getPinnedTasks()
    }
    suspend fun getCompletedTasks(){
        taskDao.getCompletedTasks()
    }
    suspend fun getTaskById(tId : Int){
        taskDao.getTaskById(tId)
    }
    suspend fun getNewTasks(){
        taskDao.getNewTasks()
    }
    suspend fun getOldTasks(){
        taskDao.getOldTasks()
    }
    suspend fun getTasksByTitle(){
        taskDao.getTasksOrderedByTitle()
    }
}