package com.github.frozencure.helix.extensions

import com.github.frozencure.helix.extensions.model.Extension
import com.github.frozencure.helix.http.model.array.CollectionResponse
import com.github.frozencure.helix.http.model.array.HelixArrayDTO
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

class ExtensionsResponse(httpResponse: HttpResponse) :
    CollectionResponse<Extension>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<Extension> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Extension>>()
    }
}