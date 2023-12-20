package com.example.culturama.model

data class Culture (
    val id: Long,
    val titleDest: String,
    val categories: String,
    val rating: Int,
    val image: Int,
    val price: Int,
    val content: String,
)