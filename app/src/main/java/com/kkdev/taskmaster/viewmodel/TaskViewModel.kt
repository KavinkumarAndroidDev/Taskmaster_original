package com.kkdev.taskmaster.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.kkdev.taskmaster.TaskApp
import com.kkdev.taskmaster.data.models.Task
import com.kkdev.taskmaster.repository.TaskRepository
import kotlinx.coroutines.launch


class TaskViewModel (private val taskRepository: TaskRepository): ViewModel() {

    fun addTask(task: Task) = viewModelScope.launch{
        taskRepository.insertTask(task)
    }

    companion object{
        fun provideFactory(application: TaskApp): ViewModelProvider.Factory = object :
            ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val repository = TaskRepository(application.taskDao)
                return TaskViewModel(repository) as T
            }
        }
    }
}

