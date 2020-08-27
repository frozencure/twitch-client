package com.github.frozencure.helix.http.model.array

import com.github.frozencure.helix.http.model.AbstractResource
import io.ktor.client.statement.*

/**
 * Generic class used for all Twitch Helix collection responses that return a single resource.
 * @param httpResponse The HTTP response object that can be used to access the low-level properties of the response.
 * @param T The type of the resources contained in the response. Can only be [AbstractResource], which is a super class of all Twitch Helix resources.
 */
abstract class SingleResponse<T : AbstractResource>(httpResponse: HttpResponse) :
    ArrayHelixResponse<T>(httpResponse) {

    /**
     * The requested resource.
     */
    val resource: T?
        get() = helixArrayDTO.resources?.firstOrNull()
}