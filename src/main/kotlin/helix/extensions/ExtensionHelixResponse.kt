package helix.extensions

import helix.extensions.model.Extension
import helix.http.model.CollectionHelixResponse
import helix.http.model.HelixDTO
import helix.http.model.SingleHelixResponse
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class ExtensionHelixResponse(httpResponse: HttpResponse) : SingleHelixResponse<Extension>(httpResponse) {
    override val helixDTO: HelixDTO<Extension> = runBlocking {
        httpResponse.receive<HelixDTO<Extension>>()
    }
}


class ExtensionsHelixResponse(httpResponse: HttpResponse) :
    CollectionHelixResponse<Extension>(httpResponse) {
    override val helixDTO: HelixDTO<Extension> = runBlocking {
        httpResponse.receive<HelixDTO<Extension>>()
    }
}