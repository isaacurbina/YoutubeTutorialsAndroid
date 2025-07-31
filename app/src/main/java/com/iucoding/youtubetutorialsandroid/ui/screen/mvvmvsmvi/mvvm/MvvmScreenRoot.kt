package com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.mvvm

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.composable.PostItem
import com.iucoding.youtubetutorialsandroid.ui.screen.mvvmvsmvi.model.Post
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MvvmScreenRoot(
	onBackClick: () -> Unit,
	modifier: Modifier = Modifier,
	viewModel: MvvmViewModel = koinViewModel()
) {
	MvvmScreen(
		modifier = modifier.padding(16.dp),
		postDetails = viewModel.postDetails,
		isLoading = viewModel.isLoading,
		isPostLiked = viewModel.isPostLiked,
		onToggleLike = viewModel::toggleLike,
		onBackClick = onBackClick
	)
}

@Composable
private fun MvvmScreen(
	postDetails: Post?,
	isLoading: Boolean,
	isPostLiked: Boolean,
	onToggleLike: () -> Unit,
	onBackClick: () -> Unit,
	modifier : Modifier = Modifier
) {
	if (isLoading) {
		Box(
			modifier = modifier,
			contentAlignment = Alignment.Center
		) {
			CircularProgressIndicator()
		}

	} else {
		postDetails?.let {
			PostItem(
				modifier = modifier,
				post = it,
				onToggleClick = onToggleLike
			)
		}
	}
}
