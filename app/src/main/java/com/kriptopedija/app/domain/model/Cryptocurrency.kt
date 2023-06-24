package com.kriptopedija.app.domain.model

data class Cryptocurrency (
    val id: Int,
    val name: String,
    val price:String,
    val hourDifference: String,
    val dayDifference: String,
    val weekDifference: String,
    val photo: String
)