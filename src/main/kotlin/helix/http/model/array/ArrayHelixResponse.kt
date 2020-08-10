package helix.http.model.array

import helix.http.model.AbstractResource
import io.ktor.client.statement.HttpResponse

abstract class ArrayHelixResponse<T : AbstractResource>(val httpResponse: HttpResponse) {

    protected abstract val helixArrayDTO: HelixArrayDTO<T>
}