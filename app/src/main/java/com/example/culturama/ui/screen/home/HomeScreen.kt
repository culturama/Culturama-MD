package com.example.culturama.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.culturama.di.Injection
import com.example.culturama.model.FavCulture
import com.example.culturama.ui.ViewModelFactory
import com.example.culturama.ui.screen.common.UiState
import com.example.culturama.ui.screen.home.components.RecommendationItem
import com.example.culturama.ui.screen.home.components.Search
import com.example.culturama.ui.theme.CulturamaTheme

@Composable
fun HomeScreen (
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
//    navigateToDetail: (Long) -> Unit
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAllCulture()
            }
            is UiState.Success -> {
                Search()
                HomeContent(
                    favCulture = uiState.data,
                    modifier = modifier,
//                    navigateToDetail = navigateToDetail,
                )
            }
            is UiState.Error -> {}
        }
    }
}

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

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun HomeScreenPreview() {
    CulturamaTheme {
        HomeScreen()
    }
}