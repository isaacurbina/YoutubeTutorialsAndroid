package com.iucoding.youtubetutorialsandroid.ui.screen.ktor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iucoding.youtubetutorialsandroid.ui.screen.ktor.repository.KtorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class KtorViewModel(
	private val ktorRepository: KtorRepository
) : ViewModel() {

	private val _carDetailsList = MutableStateFlow<KtorScreenState>(KtorScreenState.Loading)
	val carDetailsList: StateFlow<KtorScreenState> = _carDetailsList
		.onStart {
			_carDetailsList.emit(ktorRepository.getState())
		}
		.catch { e->
			emit(KtorScreenState.Error(e.message ?: "Error on flow"))
		}
		.flowOn(Dispatchers.IO)
		.stateIn(
			scope = viewModelScope,
			started = SharingStarted.WhileSubscribed(5000),
			initialValue = KtorScreenState.Loading
		)
}
