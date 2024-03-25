package com.example.androidlab.Component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidlab.R
import com.example.androidlab.components.*
import com.example.androidlab.ui.Package.MyTextStyle
import com.example.androidlab.ui.Package.colorBackground

@Preview(showBackground = true)
@Composable
fun Screen() {
    val lazyListState = rememberLazyListState()
    LazyColumn(
        state = lazyListState,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(android.graphics.Color.parseColor(colorBackground)))
    ) {
        item {
            HeaderBox()
        }
        item {
            Scroll(
                items = listOf(
                    stringResource(id = R.string.chip1),
                    stringResource(id = R.string.chip2),
                    stringResource(id = R.string.chip3)
                ),
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                contentPadding = PaddingValues(start = 24.dp, end = 24.dp)
            )
            Text(
                text = stringResource(id = R.string.description),
                modifier = Modifier.padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 14.dp,
                    bottom = 14.dp,
                ),
                style = MyTextStyle.DescriptionStyle
            )
        }
        item {
            ContentPreview(
                previewResList = listOf(
                    R.drawable.video1,
                    R.drawable.video1
                ),
                contentPadding = PaddingValues(start = 24.dp, end = 24.dp)
            )
        }
        item {
            Text(
                text = "Review & Ratings",
                modifier = Modifier.padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 20.dp,
                    bottom = 12.dp,
                ),
                style = MyTextStyle.RewiewAndRatingsTextStyle
            )
            RateStars(
                rating = "4.9",
                reviewsCount = stringResource(id = R.string.count_reviewers),
                modifier = Modifier.padding(
                    start = 24.dp,
                    end = 24.dp,
                    bottom = 30.dp,
                )
            )
        }
        item {
            List()
        }
        item {
            Button(
                text = stringResource(id = R.string.button_text),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 24.dp,
                        end = 24.dp,
                        top = 40.dp,
                        bottom = 50.dp,
                    )
                    .height(height = 64.dp)
            )
        }
    }
}