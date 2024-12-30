package com.example.squaretakehome.ui.employee_list

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.squaretakehome.data.EmployeeApi
import com.example.squaretakehome.domain.EmployeeRepository
import com.example.squaretakehome.model.Employee
import com.example.squaretakehome.model.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployeeListViewModel @Inject constructor(
    private val repository: EmployeeRepository
): ViewModel() {

    var state by mutableStateOf(Response<List<Employee>>())

    init {
        getEmployees()
    }

    internal fun getEmployees() {
        viewModelScope.launch {
            repository.getEmployeeList().collect { result ->
                result.data?.let {
                    Log.d("EmployeeListViewModel", "getEmployees: ${it.employees.size}")
                    state = state.copy(data = it.employees)
                }

                state = state.copy(isLoading = result.isLoading)
                state = state.copy(error = result.error)
            }
        }
    }

}
