package com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.mvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.model.Comment
import com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.model.Post
import com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.model.Role
import com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Date
import kotlin.random.Random

class MvvmViewModel(
	savedStateHandle: SavedStateHandle
) : ViewModel() {

	var postDetails by mutableStateOf<Post?>(null)
	private set

	var isLoading by mutableStateOf(false)
		private set

	var isPostLiked by mutableStateOf(false)
		private set

	init {
		savedStateHandle.get<String>("postId")?.let { postId ->
			loadPost(postId)
		} ?: loadPost("")
	}

	fun toggleLike() {
		postDetails?.let { post ->
			postDetails = post.copy(isLiked = !post.isLiked)
		}
	}

	private fun loadPost(id: String) = viewModelScope.launch(Dispatchers.IO) {
		isLoading = true
		delay(1000L)

		// TODO(fetch from API)
		// repository.loadPost(id)
		isPostLiked = Random.nextBoolean()
		postDetails = Post(
			id = Random.nextLong().toString(),
			author = User(
				id = Random.nextLong().toString(),
				username = "John Doe",
				email = "john.doe@test.com",
				role = Role.ADMIN
			),
			content = "This is a test post for MVVM screen.",
			comments = listOf(
				Comment(
					id = Random.nextLong().toString(),
					author = User(
						id = Random.nextLong().toString(),
						username = "Jane Doe",
						email = "jane.doe@test.com",
						role = Role.USER
					),
					content = "This is the first comment.",
					date = Date()
				),
				Comment(
					id = Random.nextLong().toString(),
					author = User(
						id = Random.nextLong().toString(),
						username = "Jane Doe",
						email = "jane.doe@test.com",
						role = Role.USER
					),
					content = "Second comment goes here.",
					date = Date()
				),
				Comment(
					id = Random.nextLong().toString(),
					author = User(
						id = Random.nextLong().toString(),
						username = "Jane Doe",
						email = "jane.doe@test.com",
						role = Role.USER
					),
					content = "Leaving a 3rd comment.",
					date = Date()
				)
			),
			isLiked = Random.nextBoolean(),
			date = Date()
		)

		isLoading = false
	}
}
