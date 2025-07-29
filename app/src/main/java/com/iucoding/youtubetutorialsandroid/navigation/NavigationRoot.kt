package com.iucoding.youtubetutorialsandroid.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import com.iucoding.youtubetutorialsandroid.navigation.navkey.HomeScreenKey
import com.iucoding.youtubetutorialsandroid.navigation.navkey.KtorKey
import com.iucoding.youtubetutorialsandroid.navigation.navkey.LiveDataVsFlowsKey
import com.iucoding.youtubetutorialsandroid.navigation.navkey.LottieAnimationKey
import com.iucoding.youtubetutorialsandroid.ui.screen.HomeScreen
import com.iucoding.youtubetutorialsandroid.ui.screen.HomeScreenIntent
import com.iucoding.youtubetutorialsandroid.ui.screen.ktor.KtorScreen
import com.iucoding.youtubetutorialsandroid.ui.screen.livedatavsflow.LiveDataVsFlowScreen
import com.iucoding.youtubetutorialsandroid.ui.screen.lottieanimation.LottieAnimationScreen

@Composable
fun NavigationRoot(
	modifier: Modifier = Modifier
) {
	val backStack = rememberNavBackStack(HomeScreenKey)
	NavDisplay(
		modifier = modifier,
		backStack = backStack,
		entryDecorators = listOf(
			rememberSavedStateNavEntryDecorator(),
			rememberViewModelStoreNavEntryDecorator(),
			rememberSceneSetupNavEntryDecorator()
		),
		entryProvider = { key ->
			when (key) {
				is HomeScreenKey -> NavEntry(key = key) {
					HomeScreen(
						modifier = Modifier.fillMaxSize(),
						onIntent = { intent ->
							when (intent) {
								HomeScreenIntent.LiveDataVsFlowsButtonClicked ->
									backStack.add(LiveDataVsFlowsKey)

								HomeScreenIntent.KtorButtonClicked ->
									backStack.add(KtorKey)

								HomeScreenIntent.LottieButtonClicked ->
									backStack.add(LottieAnimationKey)
							}
						}
					)
				}

				is LiveDataVsFlowsKey -> NavEntry(key = key) {
					LiveDataVsFlowScreen(modifier = Modifier.fillMaxSize())
				}

				is KtorKey -> NavEntry(key = key) {
					KtorScreen(modifier = Modifier.fillMaxSize())
				}

				is LottieAnimationKey -> NavEntry(key = key) {
					LottieAnimationScreen(modifier = Modifier.fillMaxSize())
				}

				else -> throw RuntimeException("Invalid NavKey.")
			}

		}
	)
}
