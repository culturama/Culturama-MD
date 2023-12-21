package com.example.culturama.ui.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.example.culturama.R
import com.example.culturama.ui.theme.CulturamaTheme

data class HistoricalData(
    val name: String,
    val image: Int, // Change to Int if it's a resource ID
    val description: String,
    val origin: String,
    val category: String
)

@ExperimentalMaterial3Api
@Composable
fun HistoricalFigure() {
    MaterialTheme {
        val searchText = remember { mutableStateOf("") }
        val selectedItem = remember { mutableStateOf(-1) }
        val historicalFigure = remember { mutableStateOf(mutableListOf<HistoricalData>()) }

        val historicalFigureList = listOf(
            HistoricalData("Gajah Mada", R.drawable.gajah_mada, "tokoh sejarah", "Tokoh Sejarah", "History FIgure"),
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
                items(historicalFigureList.size) { index ->
                    val data = historicalFigureList[index]
                    HistoricalFigureItem(index, data, selectedItem.value, onSelect = { selectedItem.value = it }) { historicalData ->
                        if (historicalFigure.value.contains(historicalData)) {
                            historicalFigure.value.remove(historicalData)
                        } else {
                            historicalFigure.value.add(historicalData)
                        }
                    }
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun SearchBar(text: String, onTextChange: (String) -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(28.dp),
        color = MaterialTheme.colorScheme.surface
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Ikona Pencarian",
                tint = MaterialTheme.colorScheme.onSurface
            )
            TextField(
                value = text,
                onValueChange = onTextChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp),
                singleLine = true,
                maxLines = 1,
                textStyle = MaterialTheme.typography.bodyLarge,
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = MaterialTheme.colorScheme.onSurface,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                placeholder = {
                    Text(
                        text = "Cari...",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                        )
                    )
                }
            )
        }
    }
}

@Composable
fun HistoricalFigureItem(
    index: Int,
    data: HistoricalData,
    selected: Int,
    onSelect: (Int) -> Unit,
    onAddToFavorites: (HistoricalData) -> Unit
) {
    // Gunakan Surface untuk membuat item favorit dengan garis tepi jika dipilih
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
                            // Tambahkan atau hapus dari favorit saat ikon hati diklik
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
fun HistoricalFigurePreview() {
    CulturamaTheme {
        HistoricalFigure()
    }
}