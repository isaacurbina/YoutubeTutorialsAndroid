package com.iucoding.youtubetutorialsandroid.ui.screen.flows

import android.view.View
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class CallbackFlowTest {

	val View.onClickEvents: Flow<View>
		get() = callbackFlow {
			val onClickListener = View.OnClickListener { trySend(it) }
			setOnClickListener(onClickListener)
			awaitClose {
				setOnClickListener(null)
			}
		}
}
