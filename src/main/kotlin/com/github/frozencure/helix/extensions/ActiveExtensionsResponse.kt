package com.github.frozencure.helix.extensions

import com.github.frozencure.helix.extensions.model.active.ActiveExtensions
import com.github.frozencure.helix.http.model.`object`.HelixObjectDTO
import com.github.frozencure.helix.http.model.`object`.ObjectResponse
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

/**
 * An object response that contains a active extensions object as payload.
 * @constructor Creates a new active extensions response object.
 */
class ActiveExtensionsResponse(httpResponse: HttpResponse) : ObjectResponse<ActiveExtensions>(httpResponse) {
    override val helixObjectDTO: HelixObjectDTO<ActiveExtensions> = runBlocking {
        httpResponse.receive<HelixObjectDTO<ActiveExtensions>>()
    }
}
