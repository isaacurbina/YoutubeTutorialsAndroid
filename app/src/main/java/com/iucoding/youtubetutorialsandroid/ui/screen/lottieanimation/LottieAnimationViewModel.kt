package com.iucoding.youtubetutorialsandroid.ui.screen.lottieanimation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LottieAnimationViewModel  : ViewModel() {

	private val _isPlaying = MutableStateFlow(false)
	val isPlaying: StateFlow<Boolean> = _isPlaying.asStateFlow()

	fun startAnimation()= viewModelScope.launch(Dispatchers.IO){
		_isPlaying.update { true }
	}

	fun stopAnimation() = viewModelScope.launch(Dispatchers.IO){
		_isPlaying.update { false }
	}

	fun updateProgress(progress: Float) = viewModelScope.launch(Dispatchers.IO){
		if (progress == 0f) {
			_isPlaying.update { true }
		} else if (progress == 1f) {
			_isPlaying.update { false }
		}
	}
}
