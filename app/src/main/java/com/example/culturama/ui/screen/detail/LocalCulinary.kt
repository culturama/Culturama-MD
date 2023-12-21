package com.example.culturama.ui.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.culturama.R

data class LocalCulinary(
    val name: String,
    val image: Int,
    val description: String
)

@ExperimentalMaterial3Api
@Composable
fun LocalCulinary(navController: NavHostController, culinary: LocalCulinary) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = {
                Text(
                    text = culinary.name,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(16.dp)
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = {
                        // Navigate back to the category screen
                        navController.navigateUp()
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = "Back"
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
        )
        Image(
            painter = painterResource(culinary.image),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(200.dp)
        )
        Text(
            text = "Ini detail kuliner lokal ${culinary.name}",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = culinary.description,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(16.dp)
        )
    }
}
