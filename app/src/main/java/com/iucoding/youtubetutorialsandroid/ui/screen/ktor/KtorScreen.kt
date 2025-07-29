package com.iucoding.youtubetutorialsandroid.ui.screen.ktor

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.iucoding.youtubetutorialsandroid.ui.screen.ktor.composable.KtorScreenError
import com.iucoding.youtubetutorialsandroid.ui.screen.ktor.composable.KtorScreenLoading
import com.iucoding.youtubetutorialsandroid.ui.screen.ktor.composable.KtorScreenSuccess
import org.koin.androidx.compose.koinViewModel

/*
 Ref: https://proandroiddev.com/using-ktor-in-jetpack-compose-e00b1b32eef0?gi=3ad1c9ef3111

 Using Ktor In Jetpack Compose
 */

@Composable
fun KtorScreen(
	modifier: Modifier = Modifier,
	viewModel: KtorViewModel = koinViewModel()
) {
	val state = viewModel.carDetailsList.collectAsState().value
	when (state) {
		is KtorScreenState.Loading -> KtorScreenLoading(modifier = modifier)
		is KtorScreenState.Success -> KtorScreenSuccess(modifier = modifier, carDetailsList = state.carDetailsList)
		is KtorScreenState.Error -> KtorScreenError(modifier = modifier, message = state.message)
	}
}
