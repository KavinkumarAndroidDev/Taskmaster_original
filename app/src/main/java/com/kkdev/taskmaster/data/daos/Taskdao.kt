package com.kkdev.taskmaster.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kkdev.taskmaster.data.models.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task)

    @Update(onConflict = OnConflictStrategy.ABORT)
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("SELECT * FROM task")
    fun getAllTasks(): Flow<List<Task>>

    @Query("SELECT * FROM task WHERE isCompleted = 1")
    fun getCompletedTasks(): Flow<List<Task>>

    @Query("SELECT * FROM task WHERE isPinned = 1")
    fun getPinnedTasks(): Flow<List<Task>>

    @Query("SELECT * FROM task ORDER BY tTitle ASC")
    fun getTasksOrderedByTitle(): Flow<List<Task>>

    @Query("SELECT * FROM task ORDER BY tId DESC")
    fun getNewTasks(): Flow<List<Task>>

    @Query("SELECT * FROM task ORDER BY tId ASC")
    fun getOldTasks(): Flow<List<Task>>

    @Query("SELECT * FROM task WHERE tId = :taskId")
    fun getTaskById(taskId: Int): Flow<Task>
}

