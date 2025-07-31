package com.iucoding.youtubetutorialsandroid

import android.app.Application
import com.iucoding.youtubetutorialsandroid.di.appModule
import com.iucoding.youtubetutorialsandroid.di.ktorModule
import com.iucoding.youtubetutorialsandroid.di.lottieModule
import com.iucoding.youtubetutorialsandroid.di.mvvmVsMviModule
import com.iucoding.youtubetutorialsandroid.di.webViewModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

	override fun onCreate() {
		super.onCreate()
		startKoin {
			androidContext(this@MyApp)
			modules(
				appModule +
					ktorModule +
					lottieModule +
					mvvmVsMviModule +
					webViewModule
			)
		}
	}
}
