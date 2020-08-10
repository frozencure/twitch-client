package helix.users

import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.ScrollableResponse
import helix.http.model.array.SingleResponse
import helix.users.model.User
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class UserResponse(httpResponse: HttpResponse) : SingleResponse<User>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<User> = runBlocking {
        httpResponse.receive<HelixArrayDTO<User>>()
    }
}


class UsersResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableResponse<User>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<User> = runBlocking {
        httpResponse.receive<HelixArrayDTO<User>>()
    }

    override suspend fun nextPage(): UsersResponse? =
        nextPageHttpResponse()?.let {
            UsersResponse(
                it, httpClient
            )
        }
}

