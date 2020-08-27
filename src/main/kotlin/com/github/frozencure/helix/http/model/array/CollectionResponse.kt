package com.github.frozencure.helix.http.model.array

import com.github.frozencure.helix.http.model.AbstractResource
import io.ktor.client.statement.*


/**
 * Generic class used for all Twitch Helix collection responses.
 * @param T The type of the resources contained in the response. Can only be [AbstractResource], which is a super class of all Twitch Helix resources.
 * @param httpResponse The HTTP response object that can be used to access the low-level properties of the response.
 */
abstract class CollectionResponse<T : AbstractResource>(
    httpResponse: HttpResponse
) :
    ArrayHelixResponse<T>(httpResponse) {

    /**
     * A collection containing the resources (data) that has been requested.
     */
    val resources: Collection<T>
        get() = helixArrayDTO.resources.orEmpty()

    /**
     * An object that holds the current state of the cursor used for requesting the next part of the collection of data.
     */
    val pagination: Pagination?
        get() = helixArrayDTO.pagination

    /**
     * The total number of resources retrieved. Is only present in some of the Twitch Helix endpoints.
     */
    val total: Long?
        get() = helixArrayDTO.total

    /**
     * Holds the interval between two timestamps. Is only present in some of the Twitch Helix endpoints.
     */
    val dateRange: DateRange?
        get() = helixArrayDTO.dateRange

}