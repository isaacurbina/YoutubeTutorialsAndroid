package com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.model

data class User(
	val id: String,
	val username: String,
	val email: String,
	val role: Role,
) {
	fun isAllowedToDeletePost(post: Post): Boolean {
		return when(role) {
			Role.ADMIN -> true
			Role.USER -> id == post.author.id
		}
	}
}
