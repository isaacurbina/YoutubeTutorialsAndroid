package com.iucoding.youtubetutorialsandroid.ui.screen.lottieanimation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.iucoding.youtubetutorialsandroid.R
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun LottieAnimationScreen(
	modifier: Modifier = Modifier,
	viewModel: LottieAnimationViewModel = koinViewModel()
) {
	val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lottie))
	val isPlaying = viewModel.isPlaying.collectAsStateWithLifecycle().value
	val progress by animateLottieCompositionAsState(
		composition = composition,
		isPlaying = isPlaying
	)

	LaunchedEffect(key1 = progress, key2 = isPlaying) {
		viewModel.updateProgress(progress)

		if (progress == 0f) {
			viewModel.startAnimation()

		} else if (progress == 1f) {
			viewModel.stopAnimation()
		}
	}

	Column(
		modifier = modifier,
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		LottieAnimation(
			modifier = Modifier.fillMaxHeight(0.5f),
			composition = composition,
			progress = { progress }
		)
		Button(onClick = viewModel::startAnimation ) {
			Text(text = stringResource(R.string.lottie_animation_screen_play_again),)
		}
	}
}
