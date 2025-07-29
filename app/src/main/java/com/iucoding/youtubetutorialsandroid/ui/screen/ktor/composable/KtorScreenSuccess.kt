package com.iucoding.youtubetutorialsandroid.ui.screen.ktor.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.iucoding.youtubetutorialsandroid.ui.screen.ktor.model.CarDetails

@Composable
internal fun KtorScreenSuccess(
	carDetailsList: List<CarDetails>,
	modifier: Modifier = Modifier
) {
	LazyColumn(
		modifier = modifier.padding(16.dp),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.spacedBy(16.dp)
	) {
		items(carDetailsList) {
			CarDetails(
				modifier = Modifier.fillMaxWidth(),
				details = it
			)
		}
	}
}

@Composable
private fun CarDetails(
	details: CarDetails,
	modifier: Modifier = Modifier
)  {
	Text(
		modifier = modifier,
		text = "${details.make} ${details.model} ${details.year}"
	)
}
