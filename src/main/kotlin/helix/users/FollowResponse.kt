package helix.users

import helix.http.model.array.CollectionResponse
import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.ScrollableResponse
import helix.http.model.array.SingleResponse
import helix.users.model.FollowEvent
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class FollowsResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableResponse<FollowEvent>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<FollowEvent> = runBlocking {
        httpResponse.receive<HelixArrayDTO<FollowEvent>>()
    }

    override suspend fun nextPage(): CollectionResponse<FollowEvent>? =
        nextPageHttpResponse()?.let {
            FollowsResponse(it, httpClient)
        }


}