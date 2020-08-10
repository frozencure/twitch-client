package helix.http.model.`object`

import helix.http.model.AbstractResource
import io.ktor.client.statement.HttpResponse

abstract class ObjectHelixResponse<T : AbstractResource>(val httpResponse: HttpResponse) {

    protected abstract val helixObjectDTO: HelixObjectDTO<T>
}

abstract class ObjectResponse<T : AbstractResource>(httpResponse: HttpResponse) :
    ObjectHelixResponse<T>(httpResponse) {

    val resource: T
        get() = helixObjectDTO.resource
}

