package helix.entitlements.model


import helix.http.model.AbstractResource
import helix.shared.InstantSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class Entitlement(
    @SerialName("id")
    val id: String,
    @SerialName("benefit_id")
    val benefitId: String,
    @SerialName("timestamp")
    @Serializable(with = InstantSerializer::class)
    val timestamp: Instant,
    @SerialName("user_id")
    val userId: String,
    @SerialName("game_id")
    val gameId: String
) : AbstractResource()