package helix.http.model

import io.ktor.client.statement.HttpResponse


abstract class SingleHelixResponse<T : AbstractResource>(httpResponse: HttpResponse) :
    HelixResponse<T>(httpResponse) {

    val resource: T?
        get() = helixDTO.resources.firstOrNull()
}