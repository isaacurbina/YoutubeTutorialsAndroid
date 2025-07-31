package com.iucoding.youtubetutorialsandroid.di

import com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.MvvmVsMviViewModel
import com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.mvi.MviViewModel
import com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.mvvm.MvvmViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val mvvmVsMviModule = module {
	viewModelOf(::MvvmVsMviViewModel)
	viewModelOf(::MvvmViewModel)
	viewModelOf(::MviViewModel)
}
