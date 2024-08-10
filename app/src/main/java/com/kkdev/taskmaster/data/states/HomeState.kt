package com.kkdev.taskmaster.data.states

import com.kkdev.taskmaster.data.models.Task
import kotlinx.coroutines.flow.Flow

data class HomeState(
    val AllTask: List<Task>? = emptyList(),
    val pinnedTask: List<Task>? = emptyList(),
    val sortType: SortType = SortType.NEWEST_FIRST,
    val notesAvail: Boolean = AllTask != null,
    val pinnedTaskAvail: Boolean = pinnedTask != null
)
