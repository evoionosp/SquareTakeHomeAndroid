package com.example.squaretakehome.domain

import com.example.squaretakehome.model.Employee
import com.example.squaretakehome.model.EmployeeResponse
import com.example.squaretakehome.model.Response
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {

    suspend fun getEmployeeList() : Flow<Response<EmployeeResponse>>
}