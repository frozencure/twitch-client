package helix.extensions

import helix.extensions.model.Extension
import helix.http.model.array.CollectionResponse
import helix.http.model.array.HelixArrayDTO
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class ExtensionsResponse(httpResponse: HttpResponse) :
    CollectionResponse<Extension>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<Extension> = runBlocking {
        httpResponse.receive<HelixArrayDTO<Extension>>()
    }
}