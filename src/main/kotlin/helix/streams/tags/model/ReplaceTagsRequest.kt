package helix.streams.tags.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReplaceTagsRequest(
    @SerialName("tag_ids")
    val tagIds: Collection<String>
)