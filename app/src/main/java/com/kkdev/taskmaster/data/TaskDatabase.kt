package com.kkdev.taskmaster.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kkdev.taskmaster.data.converters.RoomConverters
import com.kkdev.taskmaster.data.daos.TaskDao
import com.kkdev.taskmaster.data.models.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
@TypeConverters(RoomConverters::class)
abstract class TaskDatabase : RoomDatabase(){

    abstract fun taskDao() : TaskDao

}