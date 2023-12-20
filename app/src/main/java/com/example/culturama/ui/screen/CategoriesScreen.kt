package com.example.culturama.ui.screen

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
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.culturama.R

data class Category(val name: String, val icon: Painter, val destinationCount: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesScreen() {
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
            style = MaterialTheme.typography,
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(Category) { category ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable { /* Navigasi ke layar detail kategori */ }
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
                            style = MaterialTheme.typography
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "${category.destinationCount} Destinasi",
                            style = MaterialTheme.typography
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
