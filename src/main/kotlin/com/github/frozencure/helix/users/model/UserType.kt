package com.github.frozencure.helix.users.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class UserType {
    @SerialName("staff")
    STAFF,

    @SerialName("admin")
    ADMIN,

    @SerialName("global_mod")
    GLOBAL_MOD,

    @SerialName("")
    NULL
}