package com.kkdev.taskmaster.repository

import com.kkdev.taskmaster.data.daos.TaskDao
import com.kkdev.taskmaster.data.models.Task
import javax.inject.Inject

class TaskRepository @Inject constructor(private val taskDao: TaskDao) {

    suspend fun insertTask(task: Task){
        taskDao.insert(task)
    }


}