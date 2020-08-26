package com.github.frozencure.helix.entitlements.model


import com.github.frozencure.helix.http.model.AbstractResource
import com.github.frozencure.helix.shared.InstantSerializer

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

/**
 * Data transfer object for an entitlement.
 * One-to-one mapping to the Twitch entitlement JSON object.
 * @constructor Creates a new entitlement object.
 * @param id The identifier of the entitlemnt.
 * @param benefitId The identifier of the benefit
 * @param timestamp Represents the moment when this entitlement was granted on Twitch.
 * @param userId The identifier of the user who received entitlement.
 * @param gameId The identifier of the game that was being played when this benefit was granted.
 */
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