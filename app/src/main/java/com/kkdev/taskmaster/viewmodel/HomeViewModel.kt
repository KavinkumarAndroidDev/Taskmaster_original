package com.kkdev.taskmaster.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kkdev.taskmaster.data.states.SortType
import com.kkdev.taskmaster.repository.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel (
    private val homeRepository: HomeRepository
): ViewModel() {

    private val _sortType = MutableStateFlow(SortType.NEWEST_FIRST)

    fun addTask(tid: Int) = viewModelScope.launch {
        homeRepository.getTaskById(tId = tid)
    }

    fun getAllTasks() = viewModelScope.launch {
        homeRepository.getAllTasks()
    }

}