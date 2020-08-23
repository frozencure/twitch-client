package com.github.frozencure.helix.moderation.model

import com.github.frozencure.helix.http.model.AbstractResource
import com.github.frozencure.helix.shared.InstantSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant


@Serializable
data class BanEvent(
    @SerialName("id")
    val id: String,
    @SerialName("event_type")
    val eventType: BanEventType,
    @SerialName("event_timestamp")
    @Serializable(with = InstantSerializer::class)
    val eventTimestamp: Instant,
    @SerialName("version")
    val version: String,
    @SerialName("event_data")
    val eventData: ModerationEventData
) : AbstractResource()