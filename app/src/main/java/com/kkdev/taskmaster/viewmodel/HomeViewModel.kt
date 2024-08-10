package com.kkdev.taskmaster.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kkdev.taskmaster.data.states.SortType
import com.kkdev.taskmaster.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(
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