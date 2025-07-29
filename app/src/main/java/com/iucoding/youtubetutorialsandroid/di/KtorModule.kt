package com.iucoding.youtubetutorialsandroid.di

import com.iucoding.youtubetutorialsandroid.ui.screen.ktor.KtorViewModel
import com.iucoding.youtubetutorialsandroid.ui.screen.ktor.repository.KtorRepository
import com.iucoding.youtubetutorialsandroid.ui.screen.ktor.repository.KtorRepositoryImpl
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val ktorModule = module {
	viewModelOf(::KtorViewModel)
	single<KtorRepository> { KtorRepositoryImpl(get()) }
	single {
		HttpClient(Android) {
			install(ContentNegotiation) {
				json()
			}
			install(HttpTimeout) {
				requestTimeoutMillis = 10000
			}
		}
	}
}
