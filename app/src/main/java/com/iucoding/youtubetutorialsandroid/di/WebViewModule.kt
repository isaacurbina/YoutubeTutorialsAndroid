package com.iucoding.youtubetutorialsandroid.di

import com.iucoding.youtubetutorialsandroid.ui.screen.webview.WebViewViewModel
import org.koin.dsl.module

val webViewModule = module {
	factory { (url: String) -> WebViewViewModel(url) }
}
