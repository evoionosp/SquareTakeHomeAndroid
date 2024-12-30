package com.example.squaretakehome.data

import com.example.squaretakehome.model.EmployeeResponse
import retrofit2.http.GET

interface EmployeeApi {

    @GET("employees.json")
    suspend fun getEmployees() : EmployeeResponse

    @GET("employees_empty.json")
    suspend fun getEmployeesEmpty() : EmployeeResponse

    @GET("employees_malformed.json")
    suspend fun getEmployeesMalformed() : EmployeeResponse


    companion object {
        const val BASE_URL = "https://s3.amazonaws.com/sq-mobile-interview/"
    }

}