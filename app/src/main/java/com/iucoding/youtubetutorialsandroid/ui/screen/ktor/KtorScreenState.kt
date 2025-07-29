package com.iucoding.youtubetutorialsandroid.ui.screen.ktor

import com.iucoding.youtubetutorialsandroid.ui.screen.ktor.model.CarDetails

sealed class KtorScreenState {
	data object Loading : KtorScreenState()
	data class Success(val carDetailsList: List<CarDetails>) : KtorScreenState()
	data class Error(val message: String) : KtorScreenState()
}
