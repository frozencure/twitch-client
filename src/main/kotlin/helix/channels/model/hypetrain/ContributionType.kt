package helix.channels.model.hypetrain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Enum class that contains the different types that a contribution can have.
 */
@Serializable
enum class ContributionType {
    @SerialName("BITS")
    BITS,
    @SerialName("SUBS")
    SUBS
}