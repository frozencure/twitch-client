package helix.users

import helix.http.model.CollectionHelixResponse
import helix.http.model.HelixDTO
import helix.http.model.SingleHelixResponse
import helix.users.model.FollowEvent
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class FollowHelixResponse(httpResponse: HttpResponse) : SingleHelixResponse<FollowEvent>(httpResponse) {
    override val helixDTO: HelixDTO<FollowEvent> = runBlocking {
        httpResponse.receive<HelixDTO<FollowEvent>>()
    }
}

class FollowsHelixResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    CollectionHelixResponse<FollowEvent>(httpResponse, httpClient) {
    override val helixDTO: HelixDTO<FollowEvent> = runBlocking {
        httpResponse.receive<HelixDTO<FollowEvent>>()
    }

    override suspend fun nextPage(): CollectionHelixResponse<FollowEvent>? =
        nextPageHttpResponse()?.let {
            FollowsHelixResponse(it, httpClient)
        }


}