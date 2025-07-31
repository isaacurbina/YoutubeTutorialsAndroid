package com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iucoding.youtubetutorialsandroid.R
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MvvmVsMviScreen(
	onIntent: (MvvmVsMviIntent) -> Unit,
	modifier: Modifier = Modifier,
	viewModel: MvvmVsMviViewModel = koinViewModel()
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
				text = stringResource(R.string.homescreen_mvvm_vs_mvi),
				textAlign = TextAlign.Center,
				fontSize = 32.sp,
				fontWeight = FontWeight.Bold
			)
		}
		item {
			Button(
				onClick = { onIntent(MvvmVsMviIntent.MvvmButtonClicked) }) {
				Text(text = stringResource(R.string.homescreen_mvvm_vs_mvi_mvvm))
			}
		}
		item {
			Button(
				onClick = { onIntent(MvvmVsMviIntent.MviButtonClicked) }) {
				Text(text = stringResource(R.string.homescreen_mvvm_vs_mvi_mvi))
			}
		}
	}
}
