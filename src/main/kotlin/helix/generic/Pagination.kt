package helix.generic

import kotlinx.serialization.Serializable

@Serializable
data class Pagination(val cursor: String)