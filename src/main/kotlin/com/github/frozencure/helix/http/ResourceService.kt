package com.github.frozencure.helix.http

import com.github.frozencure.helix.auth.basic.default
import com.github.frozencure.helix.auth.model.AuthCredentials
import com.github.frozencure.helix.auth.model.OAuthCredentials
import com.github.frozencure.helix.auth.oauth.oauth
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.features.auth.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

abstract class ResourceService(
    protected val httpClient: HttpClient
) {
    constructor(
        credentials: AuthCredentials
    )
            : this(HttpClient(Apache) {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
        install(Auth) {
            if (credentials is OAuthCredentials) {
                oauth {
                    clientId = credentials.clientId
                    clientKey = credentials.clientKey
                    token = credentials.token
                }
            } else {
                default {
                    clientId = credentials.clientId
                    clientKey = credentials.clientKey
                }
            }
        }
    })

    companion object {
        const val BASE_URL = "https://api.twitch.tv/helix"
    }

}