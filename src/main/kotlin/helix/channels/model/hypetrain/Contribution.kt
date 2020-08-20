package helix.channels.model.hypetrain


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An object that represents a contribution in [ContributionType.BITS] or [ContributionType.SUBS]
 * @constructor Creates a new contribution object.
 * @param total The total number of [ContributionType.BITS] or [ContributionType.SUBS] donated.
 * @param type The type of the contribution.
 * @param userId The ID of the contributing user.
 */
@Serializable
data class Contribution(
    @SerialName("total")
    val total: Int,
    @SerialName("type")
    val type: ContributionType,
    @SerialName("user")
    val userId: Long
)