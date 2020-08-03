package helix.channels.model.hypetrain


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Contribution(
    @SerialName("total")
    val total: Int,
    @SerialName("type")
    val type: ContributionType,
    @SerialName("user")
    val userId: Long
)