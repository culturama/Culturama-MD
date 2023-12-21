package com.example.culturama.ui.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.culturama.R
import com.example.culturama.ui.theme.CulturamaTheme

data class HistoryData(
    val name: String,
    val image: Int, // Change to Int if it's a resource ID
    val description: String,
    val origin: String,
    val category: String
)

@ExperimentalMaterial3Api
@Composable
fun History() {
    MaterialTheme {
        val searchText = remember { mutableStateOf("") }
        val selectedItem = remember { mutableStateOf(-1) }
        val history = remember { mutableStateOf(mutableListOf<HistoryData>()) }

        val historyList = listOf(
            HistoryData("Cerita Surabaya", R.drawable.surabaya, "Sejarah Surabaya", "Sejarah", "History"),
            HistoryData("Cerita Surabaya", R.drawable.surabaya, "Sejarah Surabaya", "Sejarah", "History"),
            HistoryData("Cerita Surabaya", R.drawable.surabaya, "Sejarah Surabaya", "Sejarah", "History"),
            HistoryData("Cerita Surabaya", R.drawable.surabaya, "Sejarah Surabaya", "Sejarah", "History"),
            HistoryData("Cerita Surabaya", R.drawable.surabaya, "Sejarah Surabaya", "Sejarah", "History"),
            HistoryData("Cerita Surabaya", R.drawable.surabaya, "Sejarah Surabaya", "Sejarah", "History"),
            HistoryData("Cerita Surabaya", R.drawable.surabaya, "Sejarah Surabaya", "Sejarah", "History"),
            HistoryData("Cerita Surabaya", R.drawable.surabaya, "Sejarah Surabaya", "Sejarah", "History"),
            HistoryData("Cerita Surabaya", R.drawable.surabaya, "Sejarah Surabaya", "Sejarah", "History"),
            HistoryData("Cerita Surabaya", R.drawable.surabaya, "Sejarah Surabaya", "Sejarah", "History"),
            HistoryData("Cerita Surabaya", R.drawable.surabaya, "Sejarah Surabaya", "Sejarah", "History"),
            HistoryData("Cerita Surabaya", R.drawable.surabaya, "Sejarah Surabaya", "Sejarah", "History"),
            HistoryData("Cerita Surabaya", R.drawable.surabaya, "Sejarah Surabaya", "Sejarah", "History"),
            HistoryData("Cerita Surabaya", R.drawable.surabaya, "Sejarah Surabaya", "Sejarah", "History"),
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            SearchBar(searchText.value) {
                searchText.value = it
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(historyList.size) { index ->
                    val data = historyList[index]
                    HistoryItem(index, data, selectedItem.value, onSelect = { selectedItem.value = it }) { HistoryData ->
                        if (history.value.contains(HistoryData)) {
                            history.value.remove(HistoryData)
                        } else {
                            history.value.add(HistoryData)
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun HistoryItem(
    index: Int,
    data: HistoryData,
    selected: Int,
    onSelect: (Int) -> Unit,
    onAddToFavorites: (HistoryData) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .border(
                width = if (index == selected) 4.dp else 0.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable {
                // Panggil fungsi onSelect saat item diklik
                onSelect(index)
            },
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surface
    ) {
        // Gunakan Row untuk menata elemen UI secara horizontal
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
                    .clip(RoundedCornerShape(8.dp))
            )
            // Gunakan Column untuk menata elemen UI secara vertikal
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(start = 8.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = data.name,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = if (index == selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                        fontWeight = FontWeight.Bold
                    )
                )
                // Tampilkan kategori item dengan teks abu-abu
                Text(
                    text = data.category,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Tampilkan label item favorit dengan teks ungu jika dipilih
                    Text(
                        text = if (index == selected) "item medium" else "",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = MaterialTheme.colorScheme.primary
                        )
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                contentAlignment = Alignment.TopEnd
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = "Heart icon",
                    tint = if (index == selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(
                        alpha = 0.5f
                    ),
                    modifier = Modifier
                        .clickable {
                            onAddToFavorites(data)
                        }
                )
            }
        }
    }
}
@Preview
@ExperimentalMaterial3Api
@Composable
fun HistoryPreview() {
    CulturamaTheme {
        History()
    }
}