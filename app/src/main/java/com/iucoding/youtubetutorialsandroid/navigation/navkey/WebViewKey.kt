package com.iucoding.youtubetutorialsandroid.navigation.navkey

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data class WebViewKey(val url: String) : NavKey
