package com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.mvi

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.model.Comment
import com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.model.Post
import com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.model.Role
import com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.model.User
import com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.mvvm.MviAction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Date
import kotlin.random.Random

class MviViewModel(
	savedStateHandle: SavedStateHandle
) : ViewModel() {

	private val _state = MutableStateFlow(MviState())
	val state = _state.asStateFlow()

	init {
		savedStateHandle.get<String>("postId")?.let { postId ->
			loadPost(postId)
		} ?: loadPost("")
	}

	fun onAction(action: MviAction) {
		when (action) {
			MviAction.ToggleLike -> toggleLike()
			MviAction.GoBack -> goBack()
		}
	}

		private fun loadPost(id: String) = viewModelScope.launch(Dispatchers.IO) {
			_state.update {  it.copy(isLoading = true) }
			delay(1000L)

			// TODO(fetch from API)
			// repository.loadPost(id)
			_state.update {
				it.copy(
					isPostLiked = Random.nextBoolean(),
					postDetails = Post(
						id = Random.nextLong().toString(),
						author = User(
							id = Random.nextLong().toString(),
							username = "Jane Doe",
							email = "jane.doe@test.com",
							role = Role.USER
						),
						content = "This is a test post for MVI screen.",
						comments = listOf(
							Comment(
								id = Random.nextLong().toString(),
								author = User(
									id = Random.nextLong().toString(),
									username = "John Doe",
									email = "John.doe@test.com",
									role = Role.ADMIN
								),
								content = "This is the comment from admin.",
								date = Date()
							)
						),
						isLiked = Random.nextBoolean(),
						date = Date()
					)
				)
			}

			_state.update {  it.copy(isLoading = false) }
		}

	private fun toggleLike() {
		_state.update { currentState ->
			currentState.copy(
				isPostLiked = !currentState.isPostLiked,
				postDetails = currentState.postDetails?.let {
					it.copy(isLiked = !it.isLiked)
				}
			)
		}
	}

	private fun goBack() {
		_state.update { it.copy(goBack = true) }
	}
}
