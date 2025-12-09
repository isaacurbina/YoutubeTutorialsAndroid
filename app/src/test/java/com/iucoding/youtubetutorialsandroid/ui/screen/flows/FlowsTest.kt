package com.iucoding.youtubetutorialsandroid.ui.screen.flows

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Test

class FlowsTest {

	@Test
	fun main() = runBlocking {
		makeFlow2()
			.filter { it % 2 == 0 }
			.map { "Value: $it" }
			.collect(::println)
	}

	private fun makeFlow() = listOf(1, 2, 3, 4).asFlow()

	private fun makeFlow2() = flow {
		for (i in 0..10) {
			doAsync()
			emit(i)
		}
	}

	private suspend fun doAsync() = withContext(Dispatchers.IO) {
		delay(100L)
	}
}
