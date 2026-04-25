package com.movies.examenmovies.data

data class CoworkingSpace(
    val id: Int,
    val name: String,
    val description: String,
    val location: String,
    val capacity: Int,
    val pricePerHour: Double,
    val isAvailable: Boolean
)