package util

import com.github.frozencure.helix.auth.model.AuthCredentials
import com.github.frozencure.helix.http.ResourceService
import com.github.frozencure.helix.http.model.AbstractResource
import com.github.frozencure.helix.http.model.array.CollectionResponse
import com.github.frozencure.helix.http.model.array.HelixArrayDTO
import com.github.frozencure.helix.http.model.array.ScrollableResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable

@Serializable
data class TestDTO(val test: String) : AbstractResource()


class TestService : ResourceService {

    constructor(credentials: AuthCredentials)
            : super(credentials)

    constructor(httpClient: HttpClient) : super(httpClient)

}

class TestsResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    ScrollableResponse<TestDTO>(httpResponse, httpClient) {
    override val helixArrayDTO: HelixArrayDTO<TestDTO> = runBlocking {
        httpResponse.receive<HelixArrayDTO<TestDTO>>()
    }

    override suspend fun nextPage(): CollectionResponse<TestDTO>? =
        nextPageHttpResponse()?.let {
            TestsResponse(it, httpClient)
        }


}