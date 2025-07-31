package com.iucoding.youtubetutorialsandroid.di

import com.iucoding.youtubetutorialsandroid.ui.screen.webview.WebViewViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val webViewModule = module {
	viewModelOf(::WebViewViewModel)
}
