package com.example.culturama.ui.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.culturama.R
import com.example.culturama.ui.theme.CulturamaTheme

data class TraditionalBuildingData(
    val name: String,
    val image: Int,
    val description: String,
    val origin: String,
    val category: String
)
@Composable
@ExperimentalMaterial3Api
fun TraditionalBuilding() {
    var searchText by remember { mutableStateOf("") }
    var selectedItem by remember { mutableStateOf(-1) }
    val traditionalBuildingList by remember {
        mutableStateOf(
            mutableListOf(
                TraditionalBuildingData("Candi Penatara", R.drawable.candi_penatara, "Candi Penatara bangunan tradisional", "Bangunan Asal Madura", "Traditional Building"),
                TraditionalBuildingData("Candi Penatara", R.drawable.candi_penatara, "Candi Penatara bangunan tradisional", "Bangunan Asal Madura", "Traditional Building"),
                TraditionalBuildingData("Candi Penatara", R.drawable.candi_penatara, "Candi Penatara bangunan tradisional", "Bangunan Asal Madura", "Traditional Building"),
                TraditionalBuildingData("Candi Penatara", R.drawable.candi_penatara, "Candi Penatara bangunan tradisional", "Bangunan Asal Madura", "Traditional Building"),
                TraditionalBuildingData("Candi Penatara", R.drawable.candi_penatara, "Candi Penatara bangunan tradisional", "Bangunan Asal Madura", "Traditional Building"),
                TraditionalBuildingData("Candi Penatara", R.drawable.candi_penatara, "Candi Penatara bangunan tradisional", "Bangunan Asal Madura", "Traditional Building"),
                TraditionalBuildingData("Candi Penatara", R.drawable.candi_penatara, "Candi Penatara bangunan tradisional", "Bangunan Asal Madura", "Traditional Building"),
                TraditionalBuildingData("Candi Penatara", R.drawable.candi_penatara, "Candi Penatara bangunan tradisional", "Bangunan Asal Madura", "Traditional Building"),
                TraditionalBuildingData("Candi Penatara", R.drawable.candi_penatara, "Candi Penatara bangunan tradisional", "Bangunan Asal Madura", "Traditional Building"),
                TraditionalBuildingData("Candi Penatara", R.drawable.candi_penatara, "Candi Penatara bangunan tradisional", "Bangunan Asal Madura", "Traditional Building"),
                TraditionalBuildingData("Candi Penatara", R.drawable.candi_penatara, "Candi Penatara bangunan tradisional", "Bangunan Asal Madura", "Traditional Building"),
                TraditionalBuildingData("Candi Penatara", R.drawable.candi_penatara, "Candi Penatara bangunan tradisional", "Bangunan Asal Madura", "Traditional Building"),
                TraditionalBuildingData("Candi Penatara", R.drawable.candi_penatara, "Candi Penatara bangunan tradisional", "Bangunan Asal Madura", "Traditional Building"),
                TraditionalBuildingData("Candi Penatara", R.drawable.candi_penatara, "Candi Penatara bangunan tradisional", "Bangunan Asal Madura", "Traditional Building"),
                )
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        SearchBar(searchText) {
            searchText = it
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(traditionalBuildingList) { data ->
                TraditionalBuildingItem(
                    data = data,
                    selected = selectedItem,
                    onSelect = { selectedItem = it }
                ) { traditionalBuildingData ->
                    if (traditionalBuildingList.contains(traditionalBuildingData)) {
                        traditionalBuildingList.remove(traditionalBuildingData)
                    } else {
                        traditionalBuildingList.add(traditionalBuildingData)
                    }
                }
            }
        }
    }
}
@Composable
@ExperimentalMaterial3Api
fun TraditionalBuildingItem(
    data: TraditionalBuildingData,
    selected: Int,
    onSelect: (Int) -> Unit,
    onAddToFavorites: (TraditionalBuildingData) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable { onSelect(data.image) },
        shape = RoundedCornerShape(8.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = data.image),
                    contentDescription = data.name,
                    modifier = Modifier
                        .size(104.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                ) {
                    Text(
                        text = data.name,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = if (data.image == selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = data.category,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                        )
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = if (data.image == selected) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite icon",
                            tint = if (data.image == selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(
                                alpha = 0.5f
                            ),
                            modifier = Modifier
                                .size(20.dp)
                                .clickable {
                                    onAddToFavorites(data)
                                }
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.Default.Place,
                            contentDescription = "Place icon",
                            tint = MaterialTheme.colorScheme.onSurface.copy(
                                alpha = 0.5f
                            ),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}
@Composable
@ExperimentalMaterial3Api
@Preview
fun TraditionalBuildingPreview() {
    CulturamaTheme {
        TraditionalBuilding()
    }
}
