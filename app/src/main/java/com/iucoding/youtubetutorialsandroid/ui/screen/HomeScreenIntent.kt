package com.iucoding.youtubetutorialsandroid.ui.screen

sealed class HomeScreenIntent {
	data object LiveDataVsFlowsButtonClicked : HomeScreenIntent()
}
