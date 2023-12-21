package com.example.culturama.ui.screen.categories

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.culturama.R
import com.example.culturama.ui.theme.CulturamaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesScreen() {
    // Membuat data sumber untuk kategori
    val categories = listOf(
        Category(R.drawable.ic_tourist_destination, R.string.tourist_destination),
        Category(R.drawable.ic_local_culinary, R.string.local_culinary),
        Category(R.drawable.ic_traditional_building, R.string.traditional_building)
    )
    // Membuat scaffold dengan app bar dan konten
    // Membuat scaffold dengan app bar dan konten
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.categories_screen)) },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { innerPadding ->
        // Menggunakan lazy column untuk menampilkan daftar kategori
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(categories) { category ->
                // Membuat komponen untuk setiap kategori
//                    Category()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoriesScreenPreview() {
    CulturamaTheme {
        CategoriesScreen()
    }
}