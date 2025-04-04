package com.kkdev.taskmaster

import android.app.Application
import androidx.room.Room
import com.kkdev.taskmaster.data.TaskDatabase
import com.kkdev.taskmaster.data.daos.TaskDao

class TaskApp : Application() {
    lateinit var database: TaskDatabase
    lateinit var taskDao: TaskDao

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            TaskDatabase::class.java,
            "task.db"
        ).build()
        taskDao = database.taskDao()
    }
}