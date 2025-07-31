package com.iucoding.youtubetutorialsandroid.ui.screen.webview

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.iucoding.youtubetutorialsandroid.ui.theme.YoutubeTutorialsAndroidTheme
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun WebViewScreen(
	url: String,
	modifier: Modifier = Modifier,
	viewModel: WebViewViewModel = koinViewModel()
) {
	LaunchedEffect(key1 = url) {
		viewModel.init(url)
	}
	val myUrl = viewModel.state.collectAsStateWithLifecycle().value?.url
	myUrl?.let {
		Column(modifier = modifier) {
			Text(
				modifier = Modifier
					.fillMaxWidth()
					.padding(top = 16.dp),
				text = myUrl,
				textAlign = TextAlign.Center,
				fontSize = 32.sp,
				fontWeight = FontWeight.Bold,
				maxLines = 1,
				overflow = TextOverflow.Ellipsis
			)

			AndroidView(factory = { context ->
				WebView(context).apply {
					layoutParams = ViewGroup.LayoutParams(
						ViewGroup.LayoutParams.MATCH_PARENT,
						ViewGroup.LayoutParams.MATCH_PARENT
					)
					webViewClient = WebViewClient()
					loadUrl(myUrl)
				}
			}, update = { webView ->
				webView.loadUrl(myUrl)
			})
		}
	}
}

@Preview
@Composable
private fun WebViewScreenPreview() {
	YoutubeTutorialsAndroidTheme {
		WebViewScreen(
			url = "http://www.wikipedia.org",
			modifier = Modifier.fillMaxSize()
		)
	}
}
