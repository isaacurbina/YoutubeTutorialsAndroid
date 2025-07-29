package com.iucoding.youtubetutorialsandroid.ui.screen

sealed class HomeScreenIntent {
	data object LiveDataVsFlowsButtonClicked : HomeScreenIntent()
	data object KtorButtonClicked : HomeScreenIntent()
	data object LottieButtonClicked : HomeScreenIntent()
}
