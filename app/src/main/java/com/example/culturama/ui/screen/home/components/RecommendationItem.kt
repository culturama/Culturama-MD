package com.example.culturama.ui.screen.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.culturama.R
import com.example.culturama.ui.theme.CulturamaTheme
import com.example.culturama.ui.theme.Montserrat

@Composable
fun RecommendationItem (
    image: Int,
    title: String,
    categories: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(36.dp)
            )
            .clip(RoundedCornerShape(36.dp))
            .background(Color.White)
            .padding(16.dp),
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .padding(8.dp)
        ) {
            Column {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(width = 360.dp, height = 150.dp)
                        .clip(RoundedCornerShape(24.dp))
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    fontFamily = Montserrat
                )
                Text(
                    text = categories,
                    style = MaterialTheme.typography.titleSmall,
                    fontFamily = Montserrat
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameItemPreview() {
    CulturamaTheme {
        RecommendationItem(
            image = R.drawable.onboarding_1,
            title = "Candi Borobudur",
            categories = stringResource(R.string.tourist_destination)
        )
    }
}