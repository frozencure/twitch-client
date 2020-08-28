package com.github.frozencure.helix.streams.tags.model


import com.github.frozencure.helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data transfer object for a stream tag.
 * One-to-one mapping to the Twitch stream tag JSON object.
 * @constructor Creates a new stream tag object.
 * @param tagId The identifier of the tag.
 * @param isAuto Whether the tag is auto-generated or not.
 * @param localizationNames All localized names of the tag.
 * @param localizationDescriptions All localized descriptions of the tag.
 */
@Serializable
data class StreamTag(
    @SerialName("tag_id")
    val tagId: String,
    @SerialName("is_auto")
    val isAuto: Boolean,
    @SerialName("localization_names")
    val localizationNames: Localizations,
    @SerialName("localization_descriptions")
    val localizationDescriptions: Localizations
) : AbstractResource()