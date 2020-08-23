package com.github.frozencure.helix.users.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class BroadcasterType {
    @SerialName("partner")
    PARTNER,

    @SerialName("affiliate")
    AFFILIATE,

    @SerialName("")
    NULL
}