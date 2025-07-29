package com.iucoding.youtubetutorialsandroid.ui.screen.ktor.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
internal fun KtorScreenLoading(modifier : Modifier = Modifier) {
	Box(modifier = modifier) {
		CircularProgressIndicator(modifier = Modifier.align (Alignment.Center))
	}
}
