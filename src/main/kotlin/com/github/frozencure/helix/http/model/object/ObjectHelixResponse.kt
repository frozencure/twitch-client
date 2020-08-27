package com.github.frozencure.helix.http.model.`object`

import com.github.frozencure.helix.http.model.AbstractResource
import io.ktor.client.statement.*


/**
 * Generic class used for the Twitch Helix endpoints that return a single object and not a collection of objects.
 * @param httpResponse The HTTP response object that can be used to access the low-level properties of the response.
 * @param T The type of the resources contained in the response. Can only be [AbstractResource], which is a super class of all Twitch Helix resources.
 */
abstract class ObjectHelixResponse<T : AbstractResource>(val httpResponse: HttpResponse) {

    protected abstract val helixObjectDTO: HelixObjectDTO<T>
}

/**
 * Generic class used for the Twitch Helix endpoints that return a single object and not a collection of objects.
 * @param httpResponse The HTTP response object that can be used to access the low-level properties of the response.
 * @param T The type of the resources contained in the response. Can only be [AbstractResource], which is a super class of all Twitch Helix resources.
 */
abstract class ObjectResponse<T : AbstractResource>(httpResponse: HttpResponse) :
    ObjectHelixResponse<T>(httpResponse) {

    /**
     * The resource to be retrieved.
     */
    val resource: T
        get() = helixObjectDTO.resource
}

