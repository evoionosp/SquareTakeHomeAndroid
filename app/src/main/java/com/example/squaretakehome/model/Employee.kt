package com.example.squaretakehome.model

import com.google.gson.annotations.SerializedName

data class Employee(
    @SerializedName("uuid") val uuid: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("phone_number") val phoneNumber: String,
    @SerializedName("email_address") val emailAddress: String,
    @SerializedName("biography") val biography: String,
    @SerializedName("photo_url_small") val photoUrl: String,
    @SerializedName("photo_url_large") val photoUrlLarge: String,
    @SerializedName("team") val team: String,
    @SerializedName("employee_type") val employeeType: EmployeeType
)


data class EmployeeResponse(
    @SerializedName("employees") val employees: List<Employee>
)