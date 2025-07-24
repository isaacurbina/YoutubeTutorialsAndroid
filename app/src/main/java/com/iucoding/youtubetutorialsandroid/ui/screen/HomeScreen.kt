package com.iucoding.youtubetutorialsandroid.ui.screen

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

@Composable
fun HomeScreen(
	onIntent: (HomeScreenIntent) -> Unit,
	modifier: Modifier = Modifier
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
				text = stringResource(R.string.app_name),
				textAlign = TextAlign.Center,
				fontSize = 32.sp,
				fontWeight = FontWeight.Bold
			)
		}
		item {
			Button(
				onClick = {
					onIntent(HomeScreenIntent.LiveDataVsFlowsButtonClicked)
				}) {
				Text(text = stringResource(R.string.homescreen_livedata_vs_flows))
			}
		}
	}
}
