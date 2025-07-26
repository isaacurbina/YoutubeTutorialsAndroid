package com.iucoding.youtubetutorialsandroid.ui.screen.livedatavsflow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LiveDataVsFlowViewModel : ViewModel() {

	// region properties

	private val _liveData = MutableLiveData("Hello World!")
	val liveData: LiveData<String> = _liveData

	private val _stateFlow = MutableStateFlow("Hello World!")
	val stateFlow = _stateFlow.asStateFlow()

	private val _sharedFlow = MutableSharedFlow<String>()
	val sharedFlow = _sharedFlow.asSharedFlow()

	// endregion

	// region UI interactions

	fun triggerLiveData() {
		_liveData.postValue(System.currentTimeMillis().toString())
	}

	fun triggerStateFlow() {
		_stateFlow.update { System.currentTimeMillis().toString() }
	}

	fun triggerFlow() : Flow<String> {
		return flow {
			repeat(60) {
				emit("Item $it")
				delay(1000L)
			}
		}.flowOn(Dispatchers.IO)
	}

	fun triggerSharedFlow() = viewModelScope.launch(Dispatchers.IO) {
		_sharedFlow.emit(System.currentTimeMillis().toString())
	}

	// endregion
}
