package com.kkdev.taskmaster.di

import android.content.Context
import androidx.room.Room
import com.kkdev.taskmaster.data.TaskDatabase
import com.kkdev.taskmaster.data.daos.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    fun providesTaskDatabase(@ApplicationContext context: Context):TaskDatabase{
        return Room.databaseBuilder(context,TaskDatabase::class.java, "task.db").build()
    }

    @Provides
    fun providesTaskDao(taskDatabase: TaskDatabase):TaskDao{
        return taskDatabase.taskDao()
    }
}