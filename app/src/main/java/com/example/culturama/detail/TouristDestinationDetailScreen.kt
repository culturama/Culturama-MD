package com.example.culturama.detail

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.culturama.R

@Composable
fun TouristDestinationDetailScreen() {
    // Membuat scaffold dengan app bar dan konten
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.tourist_destination)) },
                navigationIcon = {
                    IconButton(onClick = { /* TODO: tambahkan aksi kembali */ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        },
        content = {
            // Menggunakan state untuk menyimpan query pencarian
            val query = remember { mutableStateOf("") }
            // Menggunakan state untuk menyimpan daftar daerah berdasarkan query
            val areas = remember { mutableStateListOf<String>() }
            // Menggunakan column untuk menampilkan elemen-elemen tampilan
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                // Membuat text field untuk memasukkan query pencarian
                OutlinedTextField(
                    value = query.value,
                    onValueChange = { query.value = it },
                    label = { Text(text = stringResource(R.string.search_area)) },
                    trailingIcon = {
                        IconButton(onClick = { /* TODO: tambahkan aksi hapus query */ }) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = null
                            )
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                // Membuat spasi vertikal
                Spacer(modifier = Modifier.height(16.dp))
                // Membuat button untuk memicu pencarian
                Button(
                    onClick = {
                        // TODO: tambahkan logika pencarian daerah berdasarkan query dan perbarui daftar daerah
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = stringResource(R.string.search))
                }
                // Membuat spasi vertikal
                Spacer(modifier = Modifier.height(16.dp))
                // Membuat text untuk menampilkan jumlah hasil pencarian
                Text(
                    text = stringResource(R.string.search_results, areas.size),
                    style = MaterialTheme.typography
                )
                // Membuat spasi vertikal
                Spacer(modifier = Modifier.height(8.dp))
                // Membuat lazy column untuk menampilkan daftar daerah
                LazyColumn {
                    items(areas) { area ->
                        // Membuat komponen untuk setiap daerah
                        AreaItem(area = area)
                    }
                }
            }
        }
    )
}

// Data class untuk menyimpan informasi daerah
data class Area(
    val name: String,
    val description: String,
    val image: Int
)

// Komponen untuk menampilkan item daerah
@Composable
fun AreaItem(area: Area) {
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
        // Membuat row untuk menampilkan gambar, nama, dan deskripsi daerah
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            // Membuat gambar daerah
            Image(
                painter = painterResource(area.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
            // Membuat spasi horizontal
            Spacer(modifier = Modifier.width(16.dp))
            // Membuat column untuk menampilkan nama dan deskripsi daerah
            Column {
                // Membuat teks nama daerah
                Text(
                    text = area.name,
                    style = MaterialTheme.typography,
                    maxLines = 1
                )
                // Membuat teks deskripsi daerah
                Text(
                    text = area.description,
                    style = MaterialTheme.typography,
                    maxLines = 1
                )
            }
        }
    }
}
