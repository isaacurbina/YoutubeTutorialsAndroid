package com.iucoding.youtubetutorialsandroid.ui.screen.webview

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class WebViewViewModel : ViewModel() {

	private val _state = MutableStateFlow<WebViewState?>(null)
	val state: StateFlow<WebViewState?> = _state.asStateFlow()

	fun init(url: String) {
		_state.update { WebViewState(url = url) }
	}
}
