package com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.mvvm

sealed interface MviAction {
	data object ToggleLike : MviAction
	data object GoBack: MviAction
}
