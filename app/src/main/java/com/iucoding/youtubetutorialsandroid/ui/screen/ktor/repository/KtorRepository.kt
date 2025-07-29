package com.iucoding.youtubetutorialsandroid.ui.screen.ktor.repository

import com.iucoding.youtubetutorialsandroid.ui.screen.ktor.KtorScreenState

interface KtorRepository {
	suspend fun getState(): KtorScreenState
}
