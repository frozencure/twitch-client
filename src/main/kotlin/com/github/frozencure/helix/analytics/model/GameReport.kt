package com.github.frozencure.helix.analytics.model

import com.github.frozencure.helix.http.model.AbstractResource
import com.github.frozencure.helix.http.model.array.DateRange
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data transfer object for a game report.
 * One-to-one mapping to the Twitch game report JSON object.
 * @constructor @constructor Creates a new extension report object.
 * @param gameId The ID of the game.
 * @param url The URL from where the game report can be downloaded.
 * @param type The type of game report; can be *overview_v1* or *overview_v2*.
 * @param dateRange The range of dates that the report covers.
 */

@Serializable
data class GameReport(
    @SerialName("game_id")
    val gameId: Long,
    @SerialName("URL")
    val url: String,
    @SerialName("type")
    val type: String,
    @SerialName("date_range")
    val dateRange: DateRange
) : AbstractResource()