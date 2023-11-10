package com.example.practicebuildagrid

import android.graphics.Paint.Style
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicebuildagrid.data.DataSource
import com.example.practicebuildagrid.model.Topic
import com.example.practicebuildagrid.ui.theme.PracticeBuildAGridTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeBuildAGridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ColumnOfContent(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))
                }
            }
        }
    }
}

@Composable
fun ColumnOfContent(modifier: Modifier = Modifier) {
    Column {
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
            modifier = modifier
        ) {
            items(DataSource.topics) { topic ->
                CardList(topic)
            }
        }
    }

}


@Composable
fun CardList(topic: Topic, modifier: Modifier = Modifier) {
    Card() {
        Row {
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription = "1",
                Modifier
                    .size(68.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
            Column() {
                Text(
                    text = stringResource(topic.stringResourceId),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(
                        dimensionResource(id = R.dimen.padding_medium),
                        dimensionResource(id = R.dimen.padding_medium),
                        dimensionResource(id = R.dimen.padding_medium),
                        dimensionResource(id = R.dimen.padding_small)
                    )
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = dimensionResource(id = R.dimen.padding_medium))
                    )
                    Text(
                        text = topic.availableCourses.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier
                            .padding(start = dimensionResource(id = R.dimen.padding_small))
                    )
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticeBuildAGridTheme {
        ColumnOfContent()
    }
}