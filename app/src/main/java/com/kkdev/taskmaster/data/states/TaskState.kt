package com.kkdev.taskmaster.data.states

import com.kkdev.taskmaster.data.models.Task

data class TaskState (
    val task: List<Task> = emptyList(),
    val taskTitle: String = "",
    val taskDescription: String = "",
    val reminderTime: String = "",
    val isCompleted: Boolean = false,
    val isPinned: Boolean = false,
    val category: String = "",
    val sortType: SortType = SortType.NEWEST_FIRST,
)