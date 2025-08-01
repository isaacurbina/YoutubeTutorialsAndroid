package com.iucoding.youtubetutorialsandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.iucoding.youtubetutorialsandroid.navigation.NavigationRoot
import com.iucoding.youtubetutorialsandroid.ui.theme.YoutubeTutorialsAndroidTheme

class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			YoutubeTutorialsAndroidTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					NavigationRoot(
						modifier = Modifier
							.fillMaxSize()
							.padding(innerPadding)
					)
				}
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	YoutubeTutorialsAndroidTheme {
		NavigationRoot(modifier = Modifier.fillMaxSize())
	}
}
