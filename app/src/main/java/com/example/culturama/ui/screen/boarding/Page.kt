package com.example.culturama.ui.screen.boarding

import androidx.annotation.DrawableRes
import com.example.culturama.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Embark on a Cultural Odyssey",
        description = "Embark on a journey to discover the rich traditions and heritage that define Indonesian culture",
        image = R.drawable.onboarding_1
    ),
    Page(
        title = "Immerse Yourself in Rich Traditions",
        description = "Immerse yourself in the heart of Indonesian customs and daily life, exploring the vibrant traditions that make the nation unique",
        image = R.drawable.onboarding_2
    ),
    Page(
        title = "Explore it All with Culturama",
        description = "Embark on your Culturama journey now to uncover the treasures of Indonesia's rich heritage and explore the diverse facets of its culturally rich nation",
        image = R.drawable.onboarding_3
    )
)
