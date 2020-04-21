package util

import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.http.ContentType
import io.ktor.http.headersOf


object HttpClientMockBuilder {

    fun withUrl(url: String, content: String): HttpClient = HttpClient(MockEngine) {
        engine {
            addHandler { request ->
                when (request.url.toString()) {
                    url -> {
                        val responseHeaders = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                        respond(content, headers = responseHeaders)
                    }
                    else -> error("Unhandled ${request.url}")
                }
            }
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }
}