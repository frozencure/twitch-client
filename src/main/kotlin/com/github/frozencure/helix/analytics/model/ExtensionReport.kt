package com.github.frozencure.helix.analytics.model

import com.github.frozencure.helix.http.model.AbstractResource
import com.github.frozencure.helix.http.model.array.DateRange
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data transfer object for an extension report.
 * One-to-one mapping to the Twitch extension report JSON object.
 * @constructor Creates a new extension report object.
 * @param extensionId The ID of the extension.
 * @param url The URL from where the extension report can be downloaded.
 * @param type The type of game report; can be *overview_v1* or *overview_v2*.
 * @param dateRange The range of dates that the report covers.
 */

@Serializable
data class ExtensionReport(
    @SerialName("extension_id")
    val extensionId: String,
    @SerialName("URL")
    val url: String,
    @SerialName("type")
    val type: String,
    @SerialName("date_range")
    val dateRange: DateRange
) : AbstractResource()