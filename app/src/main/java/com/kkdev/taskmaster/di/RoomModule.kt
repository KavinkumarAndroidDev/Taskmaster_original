package com.kkdev.taskmaster.di

import android.content.Context
import androidx.room.Room
import com.kkdev.taskmaster.data.TaskDatabase
import com.kkdev.taskmaster.data.daos.TaskDao

// Removed Hilt annotations
object RoomModule {
    // Removed @Provides annotation
    fun providesTaskDatabase(context: Context): TaskDatabase {
        return Room.databaseBuilder(context, TaskDatabase::class.java, "task.db").build()
    }

    // Removed @Provides annotation
    fun providesTaskDao(taskDatabase: TaskDatabase): TaskDao {
        return taskDatabase.taskDao()
    }
}