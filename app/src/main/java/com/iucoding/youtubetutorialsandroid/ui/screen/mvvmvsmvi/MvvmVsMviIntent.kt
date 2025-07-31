package com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi

sealed interface MvvmVsMviIntent {
	data object MvvmButtonClicked: MvvmVsMviIntent
	data object MviButtonClicked: MvvmVsMviIntent
}
