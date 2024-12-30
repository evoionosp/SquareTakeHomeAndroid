package com.example.squaretakehome.model

data class Response<T> (
    val data: T? = null,
    val error: String? = null,
    val isLoading: Boolean = false
) {
}