package com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.mvi

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.composable.PostItem
import com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.mvvm.MviAction
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MviScreenRoot(
	onBackClick: () -> Unit,
	modifier: Modifier = Modifier,
	viewModel: MviViewModel = koinViewModel()
) {
	val state = viewModel.state.collectAsState().value

	LaunchedEffect(state.goBack) {
		if (state.goBack) {
			onBackClick()
		}
	}

	MviScreen(
		modifier = modifier.padding(16.dp),
		state = state,
		onAction = viewModel::onAction
	)
}

@Composable
private fun MviScreen(
	state: MviState,
	onAction: (MviAction) -> Unit,
	modifier: Modifier = Modifier
) {
	if (state.isLoading) {
		Box(
			modifier = modifier,
			contentAlignment = Alignment.Center
		) {
			CircularProgressIndicator()
		}

	} else {
		state.postDetails?.let {
			PostItem(
				modifier = modifier,
				post = it,
				onToggleClick = { onAction(MviAction.ToggleLike) }
			)
		}
	}
}
