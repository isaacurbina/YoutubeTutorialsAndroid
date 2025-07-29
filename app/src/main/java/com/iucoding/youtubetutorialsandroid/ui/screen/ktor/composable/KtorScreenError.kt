package com.iucoding.youtubetutorialsandroid.ui.screen.ktor.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
internal fun KtorScreenError(
	message: String,
	modifier : Modifier = Modifier
) {
	Box(modifier = modifier) {
		Text(
			modifier = Modifier.align (Alignment.Center),
			text = message,
			fontWeight = FontWeight.Bold
		)
	}
}
