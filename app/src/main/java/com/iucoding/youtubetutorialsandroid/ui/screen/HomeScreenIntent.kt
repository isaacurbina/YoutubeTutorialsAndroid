package com.iucoding.youtubetutorialsandroid.ui.screen

sealed interface HomeScreenIntent {
	data object LiveDataVsFlowsButtonClicked : HomeScreenIntent
	data object KtorButtonClicked : HomeScreenIntent
	data object LottieButtonClicked : HomeScreenIntent
	data object MvvmVsMviButtonClicked : HomeScreenIntent
}
