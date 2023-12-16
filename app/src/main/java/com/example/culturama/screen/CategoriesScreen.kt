package com.example.culturama.screen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.culturama.R

@Composable
fun CategoriesScreen() {
    // Membuat data sumber untuk kategori
    val categories = listOf(
        Category(R.drawable.ic_tourist_destination, R.string.tourist_destination, 478),
        Category(R.drawable.ic_local_culinary, R.string.local_culinary, 261),
        Category(R.drawable.ic_traditional_building, R.string.traditional_building, 359)
    )

    // Membuat scaffold dengan app bar dan konten
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.categories_screen)) },
                backgroundColor = MaterialTheme.colors.primary
            )
        },
        content = {
            // Menggunakan lazy column untuk menampilkan daftar kategori
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(categories) { category ->
                    // Membuat komponen untuk setiap kategori
                    CategoryItem(category = category)
                }
            }
        }
    )
}

// Data class untuk menyimpan informasi kategori
data class Category(
    @DrawableRes val icon: Int,
    @StringRes val name: Int,
    val count: Int
)

// Komponen untuk menampilkan item kategori
@Composable
fun CategoryItem(category: Category) {
    // Membuat surface dengan bentuk persegi panjang berpinggir bulat
    Surface(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(vertical = 8.dp)
            .clickable { /* TODO: tambahkan aksi klik */ }
    ) {
        // Membuat row untuk menampilkan ikon, nama, dan jumlah kategori
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            // Membuat ikon kategori
            Icon(
                painter = painterResource(category.icon),
                contentDescription = stringResource(category.name),
                tint = MaterialTheme.colors.secondary,
                modifier = Modifier.size(48.dp)
            )
            // Membuat spasi horizontal
            Spacer(modifier = Modifier.width(16.dp))
            // Membuat teks nama kategori
            Text(
                text = stringResource(category.name),
                style = MaterialTheme.typography,
                maxLines = 1
            )
            // Membuat spasi fleksibel
            Spacer(modifier = Modifier.weight(1f))
            // Membuat teks jumlah kategori
            Text(
                text = "${category.count} ${stringResource(R.string.destinations)}",
                style = MaterialTheme.typography,
                maxLines = 1
            )
            // Membuat spasi horizontal
            Spacer(modifier = Modifier.width(8.dp))
            // Membuat ikon panah kanan
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium)
            )
        }
    }
}
