package helix.extensions

import helix.extensions.model.active.ActiveExtensions
import helix.http.model.`object`.HelixObjectDTO
import helix.http.model.`object`.ObjectResponse
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class ActiveExtensionsResponse(httpResponse: HttpResponse) : ObjectResponse<ActiveExtensions>(httpResponse) {
    override val helixObjectDTO: HelixObjectDTO<ActiveExtensions> = runBlocking {
        httpResponse.receive<HelixObjectDTO<ActiveExtensions>>()
    }
}
