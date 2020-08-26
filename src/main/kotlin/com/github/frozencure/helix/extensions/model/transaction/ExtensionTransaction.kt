package com.github.frozencure.helix.extensions.model.transaction

import com.github.frozencure.helix.http.model.AbstractResource
import com.github.frozencure.helix.shared.InstantSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant


/**
 * Data transfer object for an extension transaction.
 * One-to-one mapping to the Twitch extension transaction JSON object.
 * @constructor Creates a new extension transaction.
 * @param id The identifier of the transaction.
 * @param timestamp The moment when the transaction occurred.
 * @param broadcasterId The identifier of the user who owns the channel where the transaction occurred on.
 * @param broadcasterName The name of the user who owns the channel where the transaction occurred on.
 * @param userId The identifier of the user who generated the transaction.
 * @param productType The type of the product, for example *BITS_IN_EXTENSION*
 * @param product Holds data about the product that was the subject of the transaction.
 */
@Serializable
data class ExtensionTransaction(
    @SerialName("id")
    val id: String,
    @SerialName("timestamp")
    @Serializable(with = InstantSerializer::class)
    val timestamp: Instant,
    @SerialName("broadcaster_id")
    val broadcasterId: String,
    @SerialName("broadcaster_name")
    val broadcasterName: String,
    @SerialName("user_id")
    val userId: String,
    @SerialName("user_name")
    val userName: String,
    @SerialName("product_type")
    val productType: String,
    @SerialName("product_data")
    val product: Product
) : AbstractResource()