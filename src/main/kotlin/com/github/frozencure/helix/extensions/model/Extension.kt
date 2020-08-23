package com.github.frozencure.helix.extensions.model


import com.github.frozencure.helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Extension(
    @SerialName("id")
    val id: String,
    @SerialName("version")
    val version: String,
    @SerialName("name")
    val name: String,
    @SerialName("can_activate")
    val canActivate: Boolean,
    @SerialName("type")
    val type: List<ExtensionType>
) : AbstractResource()