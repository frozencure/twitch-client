package com.github.frozencure.helix.entitlements

import com.github.frozencure.helix.entitlements.model.CodeStatus
import com.github.frozencure.helix.http.model.array.CollectionResponse
import com.github.frozencure.helix.http.model.array.HelixArrayDTO
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

/**
 * A collection response that contains one or multiple code status objects.
 * @constructor Creates a new code status response object.
 */
class CodeStatusResponse(httpResponse: HttpResponse) :
    CollectionResponse<CodeStatus>(httpResponse) {

    override val helixArrayDTO: HelixArrayDTO<CodeStatus> = runBlocking {
        httpResponse.receive<HelixArrayDTO<CodeStatus>>()
    }
}