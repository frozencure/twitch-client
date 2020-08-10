package helix.moderation

import helix.http.model.array.CollectionResponse
import helix.http.model.array.HelixArrayDTO
import helix.moderation.model.AutoModMessageStatus
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class AutoModResponse(httpResponse: HttpResponse) :
    CollectionResponse<AutoModMessageStatus>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<AutoModMessageStatus> = runBlocking {
        httpResponse.receive<HelixArrayDTO<AutoModMessageStatus>>()
    }
}