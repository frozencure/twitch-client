package helix.http.model.array

import helix.http.model.AbstractResource
import io.ktor.client.statement.HttpResponse

/**
 * Generic class used for all Twitch Helix collection responses.
 * @param T The type of the resources contained in the response. Can only be [AbstractResource], which is a super class of all Twitch Helix resources.
 * @param httpResponse The HTTP response object that can be used for access to the low-level properties of the response.
 */
abstract class ArrayHelixResponse<T : AbstractResource>(val httpResponse: HttpResponse) {

    /**
     * A wrapper data transfer object, that contains the fields used in all Twitch Helix endpoints.
     */
    protected abstract val helixArrayDTO: HelixArrayDTO<T>
}