package com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.model

import java.util.Date

data class Comment(
	val id: String,
	val author: User,
	val content: String,
	val date: Date
)
