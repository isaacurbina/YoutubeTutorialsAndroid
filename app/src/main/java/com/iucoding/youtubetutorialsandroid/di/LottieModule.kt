package com.iucoding.youtubetutorialsandroid.di

import com.iucoding.youtubetutorialsandroid.ui.screen.lottieanimation.LottieAnimationViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val lottieModule = module {
	viewModelOf(::LottieAnimationViewModel)
}
