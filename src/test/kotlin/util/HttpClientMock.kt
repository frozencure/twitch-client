package util

import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.engine.mock.respondError
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf


object HttpClientMockBuilder {

    fun withJsonContent(content: String): HttpClient = HttpClient(MockEngine) {
        engine {
            addHandler {
                val responseHeaders = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                respond(content, headers = responseHeaders)
            }
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }


    fun withStatusResponse(status: HttpStatusCode): HttpClient = HttpClient(MockEngine) {
        engine {
            addHandler {
                val responseHeaders = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                respond("", status = status, headers = responseHeaders)
            }
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    fun withStatusException(httpStatusCode: HttpStatusCode): HttpClient = HttpClient(MockEngine) {
        engine {
            addHandler {
                respondError(httpStatusCode)
            }
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }
}