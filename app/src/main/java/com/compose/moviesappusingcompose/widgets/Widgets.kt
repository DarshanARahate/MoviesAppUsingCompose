package com.compose.moviesappusingcompose.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.compose.moviesappusingcompose.model.Movie
import com.compose.moviesappusingcompose.model.getMovies


@Composable
fun MovieRow(
    movie: Movie = getMovies()[0],
    onItemClick: (String) -> Unit = {}
) {

    var expanded by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable {
                onItemClick(movie.id)
            },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape
            ) {
                Image(
                    painter = rememberImagePainter(data = movie.images[0],
                        builder = {
                            crossfade(true)
                            transformations(CircleCropTransformation())
                        }),
                    contentDescription = "Movie Poster"
                )
            }
            Column(modifier = Modifier.padding(4.dp)) {
                Text(text = movie.title, style = MaterialTheme.typography.titleSmall)
                Text(
                    text = "Director : ${movie.title}",
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    text = "Release : ${movie.year}",
                    style = MaterialTheme.typography.titleSmall
                )

                AnimatedVisibility(visible = expanded) {
                    Column {
                        Text(
                            buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.DarkGray,
                                        fontSize = 13.sp
                                    )
                                ) {
                                    append("Plot: ")
                                }

                                withStyle(
                                    style = SpanStyle(
                                        color = Color.DarkGray,
                                        fontSize = 13.sp, fontWeight = FontWeight.Light
                                    )
                                ) {
                                    append(movie.plot)
                                }
                            })

                        Divider(modifier = Modifier.padding(3.dp))
                        Text(
                            text = "Director: ${movie.director}",
                            style = MaterialTheme.typography.titleSmall
                        )
                        Text(
                            text = "Director: ${movie.actors}",
                            style = MaterialTheme.typography.titleSmall
                        )
                        Text(
                            text = "Director: ${movie.rating}",
                            style = MaterialTheme.typography.titleSmall
                        )

                    }
                }

                Icon(
                    imageVector = if (expanded) Icons.Filled.KeyboardArrowDown else
                        Icons.Filled.KeyboardArrowUp,
                    contentDescription = "Down Arrow",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            expanded = !expanded
                        },
                    tint = Color.DarkGray
                )
            }
        }
    }
}
















