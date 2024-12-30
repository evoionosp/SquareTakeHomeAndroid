package com.example.squaretakehome.data

import com.example.squaretakehome.domain.EmployeeRepository
import com.example.squaretakehome.model.EmployeeResponse
import com.example.squaretakehome.model.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class EmployeeRepositoryImpl @Inject constructor(private val api: EmployeeApi): EmployeeRepository {

    override suspend fun getEmployeeList(): Flow<Response<EmployeeResponse>> {
        val response = Response<EmployeeResponse>()

        return flow {
            emit(response.copy(isLoading = true))
            try {
                emit(response.copy(data = api.getEmployees(), isLoading = false))
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                emit(response.copy(data = null, isLoading = false, error = "IO Exception occurred: ${ioException.message}"))
            } catch (exception: Exception) {
                exception.printStackTrace()
                emit(response.copy(data = null, isLoading = false, error = "Unknown Exception occurred: ${exception.message}"))
            }
        }
    }
}