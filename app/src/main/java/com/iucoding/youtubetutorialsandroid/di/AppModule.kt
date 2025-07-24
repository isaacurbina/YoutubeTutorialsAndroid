package com.iucoding.youtubetutorialsandroid.di

import com.iucoding.youtubetutorialsandroid.ui.screen.livedatavsflow.LiveDataVsFlowViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
	viewModelOf(::LiveDataVsFlowViewModel)
}
