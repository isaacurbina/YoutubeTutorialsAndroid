package com.iucoding.youtubetutorialsandroid.ui.screen.livedatavsflow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

/*
 Ref: https://www.youtube.com/watch?v=6Jc6-INantQ

 StateFlow vs. Flow vs. SharedFlow vs. LiveData... When to Use What?! - Android Studio Tutorial
 */

@Composable
fun LiveDataVsFlowScreen(
	modifier: Modifier = Modifier, viewModel: LiveDataVsFlowViewModel = koinViewModel()
) {
	val liveDataValue = viewModel.liveData.observeAsState()
	val stateFlowValue = viewModel.stateFlow.collectAsState()
	val sharedFlowValue = viewModel.sharedFlow.collectAsState(initial = "Hello World!")
	val flowValue = viewModel.triggerFlow().collectAsState(initial = "Hello World!")

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
			Text(text = liveDataValue.value.orEmpty())
		}
		item {
			Button(onClick = viewModel::triggerLiveData) {
				Text(text = stringResource(R.string.livedatavsflowscreen_livedata))
			}
		}
		item {
			Text(text = stateFlowValue.value)
		}
		item {
			Button(onClick = viewModel::triggerStateFlow) {
				Text(text = stringResource(R.string.livedatavsflowscreen_stateflow))
			}
		}
		item {
			Text(text = flowValue.value)
		}
		item {
			Button(onClick = viewModel::triggerFlow) {
				Text(text = stringResource(R.string.livedatavsflowscreen_flow))
			}
		}
		item {
			Text(text = sharedFlowValue.value)
		}
		item {
			Button(onClick = viewModel::triggerSharedFlow) {
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
