package helix.http.model

import io.ktor.client.statement.HttpResponse

abstract class HelixResponse<T : AbstractResource>(val httpResponse: HttpResponse) {

    protected abstract val helixDTO: HelixDTO<T>
}