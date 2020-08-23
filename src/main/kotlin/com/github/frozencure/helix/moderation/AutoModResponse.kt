package com.github.frozencure.helix.moderation

import com.github.frozencure.helix.http.model.array.CollectionResponse
import com.github.frozencure.helix.http.model.array.HelixArrayDTO
import com.github.frozencure.helix.moderation.model.AutoModMessageStatus
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

class AutoModResponse(httpResponse: HttpResponse) :
    CollectionResponse<AutoModMessageStatus>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<AutoModMessageStatus> = runBlocking {
        httpResponse.receive<HelixArrayDTO<AutoModMessageStatus>>()
    }
}