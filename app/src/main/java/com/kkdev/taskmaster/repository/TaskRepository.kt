package com.kkdev.taskmaster.repository

import com.kkdev.taskmaster.data.daos.TaskDao
import com.kkdev.taskmaster.data.models.Task

class TaskRepository  (private val taskDao: TaskDao) {

    suspend fun insertTask(task: Task){
        taskDao.insert(task)
    }


}