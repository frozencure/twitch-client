package com.github.frozencure.helix.users.model


import com.github.frozencure.helix.http.model.AbstractResource
import com.github.frozencure.helix.shared.NullableStringSerializer

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class User(
    @SerialName("id")
    val id: Long,
    @SerialName("login")
    val login: String,
    @SerialName("display_name")
    val displayName: String,
    @SerialName("type")
    val type: UserType,
    @SerialName("broadcaster_type")
    val broadcasterType: BroadcasterType,
    @SerialName("description")
    @Serializable(with = NullableStringSerializer::class)
    val description: String? = null,
    @SerialName("profile_image_url")
    val profileImageUrl: String,
    @SerialName("offline_image_url")
    @Serializable(with = NullableStringSerializer::class)
    val offlineImageUrl: String? = null,
    @SerialName("view_count")
    val viewCount: Int,
    @SerialName("email")
    val email: String? = null
) : AbstractResource()