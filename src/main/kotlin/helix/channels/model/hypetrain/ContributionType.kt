package helix.channels.model.hypetrain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
enum class ContributionType {
    @SerialName("BITS")
    BITS,
    @SerialName("SUBS")
    SUBS
}