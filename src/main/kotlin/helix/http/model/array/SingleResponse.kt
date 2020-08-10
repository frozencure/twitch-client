package helix.http.model.array

import helix.http.model.AbstractResource
import io.ktor.client.statement.HttpResponse


abstract class SingleResponse<T : AbstractResource>(httpResponse: HttpResponse) :
    ArrayHelixResponse<T>(httpResponse) {

    val resource: T?
        get() = helixArrayDTO.resources?.firstOrNull()
}