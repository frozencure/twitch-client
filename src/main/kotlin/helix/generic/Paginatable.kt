package helix.generic

interface Paginatable<T : AbstractResource> {

    val pagination: Pagination?

    suspend fun <T : AbstractResource> nextPage(): HelixResponse<T>?
}