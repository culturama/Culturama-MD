package com.example.culturama.ui.screen.survei

import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.culturama.R
import com.example.culturama.ui.theme.CulturamaTheme

@ExperimentalMaterial3Api
class SurveiActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CulturamaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SurveiScreen()
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun SurveiScreen() {
    var monasRating by remember { mutableStateOf(0) }
    var tamanFantasiRating by remember { mutableStateOf(0) }
    var ragunanZooRating by remember { mutableStateOf(0) }
    var ancolBeachRating by remember { mutableStateOf(0) }
    var grandIndoRating by remember { mutableStateOf(0) }
    var istiqlalRating by remember { mutableStateOf(0) }

    // Use SnackbarHostState instead of ScaffoldState
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        // Remove the scaffoldState parameter
        topBar = {
            TopAppBar(
                title = { Text(text = "Survei Wisata") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle navigation icon click */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = { /* Handle send action */ }) {
                        Icon(Icons.Default.Send, contentDescription = null)
                    }
                }
            )
        },
        // Add the snackbarHost parameter
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding) // apply the padding here
            ) {
                SurveiItem(
                    question = "How interested are you in cultural tourism?",
                    rating = monasRating,
                    onRatingChanged = { monasRating = it }
                )
                Spacer(modifier = Modifier.height(16.dp))
                SurveiItem(
                    question = "How excited are you about amusement parks and fantasy worlds?",
                    rating = tamanFantasiRating,
                    onRatingChanged = { tamanFantasiRating = it }
                )
                Spacer(modifier = Modifier.height(16.dp))
                SurveiItem(
                    question = "How interested are you in visiting zoos and wildlife parks?",
                    rating = ragunanZooRating,
                    onRatingChanged = { ragunanZooRating = it }
                )
                Spacer(modifier = Modifier.height(16.dp))
                SurveiItem(
                    question = "How interested are you in beach and maritime activities?",
                    rating = ancolBeachRating,
                    onRatingChanged = { ancolBeachRating = it }
                )
                Spacer(modifier = Modifier.height(16.dp))
                SurveiItem(
                    question = "How likely are you to visit shopping centers during your travels?",
                    rating = grandIndoRating,
                    onRatingChanged = { grandIndoRating = it }
                )
                Spacer(modifier = Modifier.height(16.dp))
                SurveiItem(
                    question = "How interested are you in visiting religious and historic sites?",
                    rating = istiqlalRating,
                    onRatingChanged = { istiqlalRating = it }
                )
            }
        }
    )
}
@Composable
fun SurveiItem(
    question: String,
    rating: Int,
    onRatingChanged: (Int) -> Unit
) {
    Column {
        Text(text = question, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            for (i in 1..5) {
                Image(
                    painterResource(id = if (i <= rating) R.drawable.ic_star_filled else R.drawable.ic_star_empty),
                    contentDescription = null,
                    modifier = Modifier
                        .size(36.dp)
                        .clickable { onRatingChanged(i) }
                )
            }
        }
    }
}
@Preview(showBackground = true)
@ExperimentalMaterial3Api
@Composable
fun SurveiScreenPreview() {
    SurveiScreen()
}
