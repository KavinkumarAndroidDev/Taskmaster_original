package com.kkdev.taskmaster.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true) val tId: Long = 0,
    val tTitle: String,
    val tDesc: String,
    val tCategory : String,
    val tTime: Long,
    val isCompleted: Boolean = false,
    val isPinned: Boolean = false
)