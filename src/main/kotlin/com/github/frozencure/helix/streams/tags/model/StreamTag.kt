package com.github.frozencure.helix.streams.tags.model


import com.github.frozencure.helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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