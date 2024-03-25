package com.example.androidlab.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidlab.R
import com.example.androidlab.ui.Package.MyTextStyle
import com.example.androidlab.ui.Package.colorBackground
import com.example.androidlab.ui.Package.colorChip
import com.example.androidlab.ui.Package.colorDarkGray
import com.example.androidlab.ui.Package.colorStartVideo


@Composable
fun Chip(text: String) {
    Box(
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .background(
                Color(android.graphics.Color.parseColor(colorChip)),
                shape = RoundedCornerShape(45.dp)
            )
            .padding(8.dp)
    ) {
        Text(
            text = text,
            style = MyTextStyle.ChipStyle
        )
    }
}
@Composable
fun Commentaries(image: Int, name: String, date: String, text: String) {
    Column(modifier = Modifier.padding(start = 24.dp)) {
        Row {
            Image(
                painter = painterResource(id = image),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(36.dp)
                    .width(36.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = name,
                    style = MyTextStyle.CommentNameStyle
                )
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = date,
                    style = MyTextStyle.CommentDateStyle
                )
            }
        }
        Text(
            text = text,
            style = MyTextStyle.CommentTextStyle,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Line() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 38.dp)
            .padding(vertical = 24.dp)
    ) {
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )
    }
}



@Preview(showBackground = true)
@Composable
fun List() {
    Column {
        Commentaries(
            image = R.drawable.people1,
            name = stringResource(id = R.string.comment_name1),
            date = stringResource(id = R.string.comment_date),
            text = stringResource(id = R.string.comment_text)
        )
        Line()
        Commentaries(
            image = R.drawable.people2,
            name = stringResource(id = R.string.comment_name2),
            date = stringResource(id = R.string.comment_date),
            text = stringResource(id = R.string.comment_text)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(310.dp)
        )
        Box(
            modifier = Modifier
                .padding(top = 290.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp))
                .background(Color(android.graphics.Color.parseColor(colorBackground)))
        ) {
            Column(
                modifier = Modifier.padding(start = 124.dp, bottom = 10.dp, top = 14.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.logo_text),
                    style = MyTextStyle.HeaderTextStyle
                )
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.stars5),
                        contentDescription = "image",
                        modifier = Modifier
                            .align(Alignment.Bottom)
                            .height(12.dp)
                            .width(76.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.count_reviewers),
                        modifier = Modifier
                            .align(Alignment.Bottom)
                            .padding(start = 10.dp),
                        style = MyTextStyle.HeaderCounterStyle
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .padding(top = 270.dp, start = 24.dp)
                .border(
                    width = 1.dp,
                    color = Color(android.graphics.Color.parseColor(colorDarkGray)),
                    shape = RoundedCornerShape(20.dp)
                )
                .background(
                    color = Color.Black,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(17.dp)
        )
        {
            Image(
                painter = painterResource(id = R.drawable.dotaico),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(54.dp)
                    .width(54.dp)
            )
        }
    }
}

@Composable
fun Button(text: String, modifier: Modifier = Modifier) {
    TextButton(
        onClick = { },
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFAC00))
    ) {
        Text(
            text = text,
            style = MyTextStyle.ButtonStyle
        )
    }
}

@Composable
fun RateStars(rating: String, reviewsCount: String, modifier: Modifier) {
    Row(modifier = modifier) {
        Spacer(modifier = Modifier.width(24.dp))
        Text(
            text = rating,
            style = MyTextStyle.RatingRatingStyle
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.align(Alignment.CenterVertically)) {
            Image(
                painter = painterResource(id = R.drawable.stars5),
                contentDescription = "image",
                modifier = Modifier
                    .height(12.dp)
                    .width(76.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = reviewsCount,
                style = MyTextStyle.RatingCounterStyle
            )
        }
    }
}

@Composable
fun Scroll(items: List<String>, modifier: Modifier, contentPadding: PaddingValues) {
    LazyRow(
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        items(items) { item ->
            Chip(text = item)
        }
    }
}

@Composable
fun ContentPreview(previewResList: List<Int>, contentPadding: PaddingValues) {
    LazyRow(contentPadding = contentPadding) {
        items(previewResList) { previewResId ->
            Box(modifier = Modifier.padding(end = 15.dp)){
                Image(
                    painter = painterResource(id = previewResId),
                    contentDescription = "image",
                    modifier = Modifier
                        .height(135.dp)
                        .width(240.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
                Box(modifier = Modifier
                    .clip(RoundedCornerShape(50.dp))
                    .size(48.dp)
                    .background(Color(android.graphics.Color.parseColor(colorStartVideo)))
                    .align(
                        Alignment.Center

                    )){
                    Image(
                        painter = painterResource(id = R.drawable.start),
                        contentDescription = "image",
                        modifier = Modifier
                            .size(15.dp)
                            .align(Alignment.Center)
                    )
                }
            }

        }
    }
}