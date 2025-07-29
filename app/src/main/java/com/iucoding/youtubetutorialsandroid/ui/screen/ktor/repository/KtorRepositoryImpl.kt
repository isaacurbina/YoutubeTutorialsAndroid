package com.iucoding.youtubetutorialsandroid.ui.screen.ktor.repository

import android.util.Log
import com.iucoding.youtubetutorialsandroid.ui.screen.ktor.KtorScreenState
import com.iucoding.youtubetutorialsandroid.ui.screen.ktor.model.CarDetails
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.URLProtocol
import io.ktor.http.encodedPath

internal class KtorRepositoryImpl(
	private val httpClient: HttpClient
) : KtorRepository {

	override suspend fun getState(): KtorScreenState {
		val result = try {
			val httpResponse: HttpResponse =  httpClient.get {
				url {
					protocol = URLProtocol.HTTPS
					host = "www.google.com"
					encodedPath = "path/file.html"
				}
			}
			when (httpResponse.status.value) {
				200 -> {
					Log.d(TAG, "getCarDetails: Success")
					val response = httpResponse.body<List<CarDetails?>>()
					KtorScreenState.Success(carDetailsList = response.filterNotNull())
				}

				else -> {
					Log.w(TAG, "getCarDetails: Error ${httpResponse.status.value}")
					KtorScreenState.Error("Error ${httpResponse.status.value}")
				}
			}

		} catch (e: Exception) {
			Log.e(TAG, "getCarDetails: ", e)
			KtorScreenState.Error(e.message.orEmpty())
		}

		return result
	}

	companion object {
		private const val TAG = "KtorRepositoryImpl"
	}
}
