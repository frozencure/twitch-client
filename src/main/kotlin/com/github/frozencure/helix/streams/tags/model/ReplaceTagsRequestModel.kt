package com.github.frozencure.helix.streams.tags.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Model class used as payload to request the update of stream tags.
 * @constructor Creats a new replace tags request model.
 * @param tagIds The IDs of the new tags.
 */
@Serializable
data class ReplaceTagsRequestModel(
    @SerialName("tag_ids")
    val tagIds: Collection<String>
)