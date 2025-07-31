package com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.mvi

import com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.model.Post

data class MviState(
	val postDetails: Post? = null,
	val isLoading: Boolean = false,
    val isPostLiked: Boolean = false,
	val goBack: Boolean = false
)
