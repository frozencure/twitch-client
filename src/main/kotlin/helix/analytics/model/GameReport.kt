package helix.analytics.model


import helix.http.model.AbstractResource
import helix.http.model.array.DateRange
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameReport(
    @SerialName("game_id")
    val gameId: String,
    @SerialName("URL")
    val uRL: String,
    @SerialName("type")
    val type: String,
    @SerialName("date_range")
    val dateRange: DateRange
) : AbstractResource()