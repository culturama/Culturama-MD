package com.example.culturama.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.culturama.di.Injection
import com.example.culturama.domain.model.FavCulture
import com.example.culturama.ui.ViewModelFactory
import com.example.culturama.ui.screen.common.UiState
import com.example.culturama.ui.screen.home.components.CategoryRow
import com.example.culturama.ui.screen.home.components.HomeContent
import com.example.culturama.ui.screen.home.components.RecommendationItem
import com.example.culturama.ui.screen.home.components.Search
import com.example.culturama.ui.theme.CulturamaTheme
import com.example.culturama.ui.theme.Montserrat

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
                Column {
                    Column (
                        modifier = Modifier
                            .padding(48.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                        Text(
                            text = "Explore the Culture Now",
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = Montserrat
                            ),
                            modifier = modifier
                                .fillMaxWidth()
                        )
                    }
                    Search()
                    CategoryRow()
                    HomeContent(
                        favCulture = uiState.data,
                        modifier = modifier,
//                      navigateToDetail = navigateToDetail,
                    )
                }
            }
            is UiState.Error -> {}
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