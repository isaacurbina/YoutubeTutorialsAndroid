package com.iucoding.youtubetutorialsandroid.ui.screen.ktor.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CarDetails(
	@SerialName("car_make")
	val make: String?,
	@SerialName("car_model")
	val model: String?,
	@SerialName("year_of_production")
	val year: Int
)
