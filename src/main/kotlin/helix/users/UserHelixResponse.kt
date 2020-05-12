package helix.users

import helix.http.model.HelixDTO
import helix.http.model.ScrollableHelixResponse
import helix.http.model.SingleHelixResponse
import helix.users.model.User
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class UserHelixResponse(httpResponse: HttpResponse) : SingleHelixResponse<User>(httpResponse) {
    override val helixDTO: HelixDTO<User> = runBlocking {
        httpResponse.receive<HelixDTO<User>>()
    }
}


class UsersHelixResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableHelixResponse<User>(httpResponse, httpClient) {
    override val helixDTO: HelixDTO<User> = runBlocking {
        httpResponse.receive<HelixDTO<User>>()
    }

    override suspend fun nextPage(): UsersHelixResponse? =
        nextPageHttpResponse()?.let {
            UsersHelixResponse(
                it, httpClient
            )
        }
}

