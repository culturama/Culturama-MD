package com.example.culturama.ui.screen.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.culturama.R
import com.example.culturama.ui.screen.detail.HistoricalFigure
import com.example.culturama.ui.screen.detail.History
import com.example.culturama.ui.screen.detail.LocalCulinary
import com.example.culturama.ui.screen.detail.LocalTradition
import com.example.culturama.ui.screen.detail.Mythology
import com.example.culturama.ui.screen.detail.Story
import com.example.culturama.ui.screen.detail.TouristDestination
import com.example.culturama.ui.screen.detail.TraditionalArt
import com.example.culturama.ui.screen.detail.TraditionalBuilding

data class Category(val name: String, val icon: Painter, val destinationCount: Int)

@ExperimentalMaterial3Api
@Composable
fun CategoriesScreen(navController: NavHostController) {
    val categories = listOf(
        Category("Tujuan Wisata", painterResource(R.drawable.ic_tourist_destination), 475),
        Category("Kuliner Lokal", painterResource(R.drawable.ic_local_culinary), 261),
        Category("Bangunan Tradisional", painterResource(R.drawable.ic_traditional_building), 359),
        Category("Tradisi Lokal", painterResource(R.drawable.ic_local_tradition), 478),
        Category("Seni Tradisional", painterResource(R.drawable.ic_traditional_art), 261),
        Category("Mitologi", painterResource(R.drawable.ic_myth), 359),
        Category("Sejarah", painterResource(R.drawable.ic_history), 359),
        Category("Tokoh Sejarah", painterResource(R.drawable.ic_historical_figure), 359),
        Category("Cerita", painterResource(R.drawable.ic_story), 359)
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Kategori",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(categories.size) { index ->
                val category = categories[index]

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            // Navigasi ke layar detail kategori
                            navController.navigate("detail/${category.name}")
                        }
                ) {
                    Icon(
                        painter = category.icon,
                        contentDescription = null,
                        modifier = Modifier.size(48.dp).padding(end = 16.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = category.name,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "${category.destinationCount} Destinasi",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_forward),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Divider()
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun CategoryNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "categories") {
        composable("categories") {
            CategoriesScreen(navController)
        }
        composable("detail/{categoryName}") { backStackEntry ->
            val categoryName = backStackEntry.arguments?.getString("categoryName")
            when (categoryName) {
                "Tujuan Wisata" -> {
                    navController.navigate("TouristDestination")
                }
                "Kuliner Lokal" -> {
                    navController.navigate("LocalCulinary")
                }
                "Bangunan Tradisional" -> {
                    navController.navigate("TraditionalBuilding")
                }
                "Tradisi Lokal" -> {
                    navController.navigate("LocalTradition")
                }
                "Seni Tradisional" -> {
                    navController.navigate("TraditionalArt")
                }
                "Mitologi" -> {
                    navController.navigate("Mythology")
                }
                "Sejarah" -> {
                    navController.navigate("History")
                }
                "Tokoh Sejarah" -> {
                    navController.navigate("HistoricalFigure")
                }
                "Cerita" -> {
                    navController.navigate("Story")
                }
                else -> {
                    // Handle kategori lainnya jika diperlukan
                }
            }
        }
    }
}