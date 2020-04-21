package helix.http

import helix.http.model.AbstractResource
import helix.http.model.Pagination
import helix.http.model.HelixResponse

interface Paginatable<T : AbstractResource> {

    val pagination: Pagination?

    suspend fun <T : AbstractResource> nextPage(): HelixResponse<T>?
}