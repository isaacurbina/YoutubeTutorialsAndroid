package com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.model

import java.util.Date

data class Post(
	val id: String,
	val author: User,
	val content: String,
	val comments: List<Comment>,
	val isLiked: Boolean,
	val date: Date,
)
