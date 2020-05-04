package util

import helix.http.ResourceService
import helix.http.credentials.ApiSettings
import helix.http.model.AbstractResource
import helix.http.model.CollectionHelixResponse
import helix.http.model.HelixDTO
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

class TestsHelixResponse(httpResponse: HttpResponse, httpClient: HttpClient) :
    CollectionHelixResponse<TestDTO>(httpResponse, httpClient) {
    override val helixDTO: HelixDTO<TestDTO> = runBlocking {
        httpResponse.receive<HelixDTO<TestDTO>>()
    }

    override suspend fun nextPage(): CollectionHelixResponse<TestDTO>? =
        nextPageHttpResponse()?.let {
            TestsHelixResponse(it, httpClient)
        }


}