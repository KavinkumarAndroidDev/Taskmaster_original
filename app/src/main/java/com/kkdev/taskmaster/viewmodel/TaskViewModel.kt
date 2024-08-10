package com.kkdev.taskmaster.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kkdev.taskmaster.data.models.Task
import com.kkdev.taskmaster.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(private val taskRepository: TaskRepository): ViewModel() {

    fun addTask(task: Task) = viewModelScope.launch{
        taskRepository.insertTask(task)
    }
}

