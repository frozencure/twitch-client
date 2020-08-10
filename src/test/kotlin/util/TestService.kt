package util

import helix.http.ResourceService
import helix.http.credentials.ApiSettings
import helix.http.model.AbstractResource
import helix.http.model.array.CollectionResponse
import helix.http.model.array.HelixArrayDTO
import helix.http.model.array.ScrollableResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable

@Serializable
data class TestDTO(val test: String) : AbstractResource()


class TestService : ResourceService {

    constructor(apiSettings: ApiSettings, httpClientEngineConfig: HttpClientEngineConfig)
            : super(apiSettings, httpClientEngineConfig)

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