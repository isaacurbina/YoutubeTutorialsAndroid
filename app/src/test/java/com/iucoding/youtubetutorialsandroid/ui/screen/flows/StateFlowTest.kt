package com.iucoding.youtubetutorialsandroid.ui.screen.flows

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

class StateFlowTest {
	private val _state = MutableStateFlow(1)
	val state = _state.asStateFlow()

	@Test
	fun main() = runBlocking {
		val stateFlow = StateFlowTest()
		launch(Dispatchers.IO) {
			stateFlow.startUpdating()
		}
		delay(5000L)
		stateFlow.state.collect(::println)
		Unit
	}

	private suspend fun startUpdating() {
		while (true) {
			delay(1000L)
			_state.update { it + 1 }
		}
	}
}
