package com.iucoding.youtubetutorialsandroid.ui.screen.webview

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class WebViewViewModel(
	url: String
) : ViewModel() {

	private val _state = MutableStateFlow(WebViewState(url = url))
	val state: StateFlow<WebViewState?> = _state.asStateFlow()
}
