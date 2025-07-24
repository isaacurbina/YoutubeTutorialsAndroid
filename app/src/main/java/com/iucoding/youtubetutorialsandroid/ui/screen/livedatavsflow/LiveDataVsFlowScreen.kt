package com.iucoding.youtubetutorialsandroid.ui.screen.livedatavsflow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iucoding.youtubetutorialsandroid.R
import com.iucoding.youtubetutorialsandroid.ui.theme.YoutubeTutorialsAndroidTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun LiveDataVsFlowScreen(
    modifier: Modifier = Modifier,
    viewModel: LiveDataVsFlowViewModel = koinViewModel()
) {
    LazyColumn(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                text = stringResource(R.string.livedatavsflowscreen_observable_comparison),
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }
        item {
            Text(text = stringResource(R.string.livedatavsflowscreen_hello_world))
        }
        item {
            Button(
                onClick = {
                    // TODO
                }) {
                Text(text = stringResource(R.string.livedatavsflowscreen_livedata))
            }
        }
        item {
            Text(text = stringResource(R.string.livedatavsflowscreen_hello_world))
        }
        item {
            Button(
                onClick = {
                    // TODO
                }) {
                Text(text = stringResource(R.string.livedatavsflowscreen_stateflow))
            }
        }
        item {
            Text(text = stringResource(R.string.livedatavsflowscreen_hello_world))
        }
        item {
            Button(
                onClick = {
                    // TODO
                }) {
                Text(text = stringResource(R.string.livedatavsflowscreen_flow))
            }
        }
        item {
            Text(text = stringResource(R.string.livedatavsflowscreen_hello_world))
        }
        item {
            Button(
                onClick = {
                    // TODO
                }) {
                Text(text = stringResource(R.string.livedatavsflowscreen_sharedflow))
            }
        }
    }
}

@Preview
@Composable
private fun LiveDataVsFlowScreenPreview() {
    YoutubeTutorialsAndroidTheme {
        LiveDataVsFlowScreen(modifier = Modifier.fillMaxSize())
    }
}
