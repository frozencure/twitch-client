package helix.entitlements

import helix.entitlements.model.CodeStatus
import helix.http.model.array.CollectionResponse
import helix.http.model.array.HelixArrayDTO
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking

class CodeStatusResponse(httpResponse: HttpResponse) :
    CollectionResponse<CodeStatus>(httpResponse) {
    override val helixArrayDTO: HelixArrayDTO<CodeStatus> = runBlocking {
        httpResponse.receive<HelixArrayDTO<CodeStatus>>()
    }
}