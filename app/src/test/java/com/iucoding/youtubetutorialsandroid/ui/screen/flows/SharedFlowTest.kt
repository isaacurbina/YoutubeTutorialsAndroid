package com.iucoding.youtubetutorialsandroid.ui.screen.flows

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

class SharedFlowTest {

	private val _events = MutableSharedFlow<Long>(replay = 1)
	val events = _events.asSharedFlow()

	@Test
	fun main() = runBlocking {
		val eventBus = SharedFlowTest()
		launch(Dispatchers.IO) {
			eventBus.startUpdating()
		}
		delay(5000L)
		eventBus.events.collect(::println)
		Unit
	}

	private suspend fun startUpdating() {
		while (true) {
			delay(2000L)
			_events.emit(System.currentTimeMillis())
		}
	}
}
