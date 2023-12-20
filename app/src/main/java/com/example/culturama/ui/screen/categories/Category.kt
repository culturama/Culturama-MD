package com.example.culturama.ui.screen.categories

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.culturama.R

data class Category(
    @DrawableRes val categoriesIcon: Int,
    @StringRes val categoriesName: Int,
//    val count: Int
)

val dummyCategory = listOf(
    R.drawable.ic_tourist_destination to R.string.tourist_destination,
    R.drawable.ic_tradition to R.string.local_tradition,
    R.drawable.ic_art to R.string.traditional_art,
    R.drawable.ic_traditional_building to R.string.traditional_building,
    R.drawable.ic_local_culinary to R.string.local_culinary,
    R.drawable.ic_myth to R.string.myth,
    R.drawable.ic_book to R.string.local_story,
    R.drawable.ic_history to R.string.history,
    R.drawable.ic_figure to R.string.historycal_figure,

).map {
    Category(it.first, it.second)
}