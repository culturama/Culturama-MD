package com.example.culturama.ui.screen.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.culturama.R
import com.example.culturama.ui.screen.categories.Category
import com.example.culturama.ui.screen.categories.dummyCategory
import com.example.culturama.ui.theme.CulturamaTheme
import com.example.culturama.ui.theme.Teal100

@Composable
fun CategoriesItemSmall (
    modifier: Modifier = Modifier,
    category: Category
) {
    Column (
        modifier = Modifier
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(16.dp)
            )
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .size(80.dp)
            .clickable {  }
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Teal100)
                .size(50.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(category.categoriesIcon),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
            )
        }
        Text(
            text = stringResource(category.categoriesName),
            fontSize = 8.sp,

        )
    }
}

@Composable
fun CategoryRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        itemsIndexed(dummyCategory) { index, category ->
            CategoriesItemSmall(category = category)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CategoryRowPreview() {
    CulturamaTheme {
        CategoryRow()
    }
}

@Preview(showBackground = true)
@Composable
fun CategoriesItemSmallPreview() {
    CulturamaTheme {
        CategoriesItemSmall(
            category = Category(
                R.drawable.ic_local_culinary,
                R.string.local_culinary
            )
        )
    }
}