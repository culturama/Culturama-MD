package com.example.culturama.ui.screen.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.culturama.R
import com.example.culturama.domain.model.Culture
import com.example.culturama.domain.model.FavCulture
import com.example.culturama.ui.screen.home.HomeScreen
import com.example.culturama.ui.theme.CulturamaTheme

@Composable
fun HomeContent (
    favCulture: List<FavCulture>,
    modifier: Modifier = Modifier,
//    navigateToDetail: (Long) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(favCulture) { data ->
            RecommendationItem(
                image = data.culture.image,
                title = data.culture.titleDest,
                categories = data.culture.categories,
//                modifier = Modifier.clickable {
//                    navigateToDetail(data.culture.id)
//                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeContentPreview() {
    CulturamaTheme {
        val fakeData = listOf(
            FavCulture(
                culture = Culture(1, "tes", "tes", 5, R.drawable.monas, 20000, "dvdvd")
            ),
        )
        HomeContent(favCulture = fakeData)
    }
}