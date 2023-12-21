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

data class LocalTradition(
    val name: String,
    val image: Int,
    val description: String
)

@ExperimentalMaterial3Api
@Composable
fun LocalTradition(navController: NavHostController, tradition: LocalTradition) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = {
                Text(
                    text = tradition.name,
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
            painter = painterResource(tradition.image),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(200.dp)
        )
        Text(
            text = "Ini detail tradisi lokal ${tradition.name}",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = tradition.description,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(16.dp)
        )
    }
}
