package helix.moderation

import helix.http.model.CollectionHelixResponse
import helix.http.model.HelixDTO
import helix.moderation.model.AutoModMessageStatus
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class AutoModHelixResponse(httpResponse: HttpResponse) :
    CollectionHelixResponse<AutoModMessageStatus>(httpResponse) {
    override val helixDTO: HelixDTO<AutoModMessageStatus> = runBlocking {
        httpResponse.receive<HelixDTO<AutoModMessageStatus>>()
    }
}