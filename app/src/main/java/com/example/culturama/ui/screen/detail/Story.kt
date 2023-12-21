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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.culturama.R
import com.example.culturama.ui.theme.CulturamaTheme

data class StoryData(
    val name: String,
    val image: Int,
    val description: String,
    val origin: String,
    val category: String
)
@Composable
@ExperimentalMaterial3Api
fun Story() {
    val searchText = remember { mutableStateOf("") }
    val selectedItem = remember { mutableStateOf(-1) }
    val storyList = remember {
        mutableListOf(
            StoryData("Rorojonggrang", R.drawable.rorojongrang, "Cerita", "Cerita Daerah", "Story"),
            StoryData("Rorojonggrang", R.drawable.rorojongrang, "Cerita", "Cerita Daerah", "Story"),
            StoryData("Rorojonggrang", R.drawable.rorojongrang, "Cerita", "Cerita Daerah", "Story"),
            StoryData("Rorojonggrang", R.drawable.rorojongrang, "Cerita", "Cerita Daerah", "Story"),
            StoryData("Rorojonggrang", R.drawable.rorojongrang, "Cerita", "Cerita Daerah", "Story"),
            StoryData("Rorojonggrang", R.drawable.rorojongrang, "Cerita", "Cerita Daerah", "Story"),
            StoryData("Rorojonggrang", R.drawable.rorojongrang, "Cerita", "Cerita Daerah", "Story"),
            StoryData("Rorojonggrang", R.drawable.rorojongrang, "Cerita", "Cerita Daerah", "Story"),
            StoryData("Rorojonggrang", R.drawable.rorojongrang, "Cerita", "Cerita Daerah", "Story"),
            StoryData("Rorojonggrang", R.drawable.rorojongrang, "Cerita", "Cerita Daerah", "Story"),
            StoryData("Rorojonggrang", R.drawable.rorojongrang, "Cerita", "Cerita Daerah", "Story"),
            StoryData("Rorojonggrang", R.drawable.rorojongrang, "Cerita", "Cerita Daerah", "Story"),
            StoryData("Rorojonggrang", R.drawable.rorojongrang, "Cerita", "Cerita Daerah", "Story"),
            StoryData("Rorojonggrang", R.drawable.rorojongrang, "Cerita", "Cerita Daerah", "Story"),
            StoryData("Rorojonggrang", R.drawable.rorojongrang, "Cerita", "Cerita Daerah", "Story"),
            StoryData("Rorojonggrang", R.drawable.rorojongrang, "Cerita", "Cerita Daerah", "Story"),

        )
    }

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
            items(storyList.size) { index ->
                val data = storyList[index]
                storyItem(
                    index = index,
                    data = data,
                    selected = selectedItem.value,
                    onSelect = { selectedItem.value = it }
                ) { StoryData ->
                    if (storyList.contains(StoryData)) {
                        storyList.remove(StoryData)
                    } else {
                        storyList.add(StoryData)
                    }
                }
            }
        }
    }
}
@Composable
@ExperimentalMaterial3Api
fun storyItem(
    index: Int,
    data: StoryData, // Change the type to StoryData
    selected: Int,
    onSelect: (Int) -> Unit,
    onAddToFavorites: (StoryData) -> Unit
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
                onSelect(index)
            },
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surface
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
                    .clip(RoundedCornerShape(8.dp))
            )
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

@Composable
@ExperimentalMaterial3Api
@Preview
fun StoryPreview() {
    CulturamaTheme {
        Story()
    }
}
