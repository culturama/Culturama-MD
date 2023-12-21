package com.example.culturama.data.remote.dto

import com.example.culturama.domain.model.CultureItem

data class CultureResponse (
    val cultures: List<CultureItem>
)