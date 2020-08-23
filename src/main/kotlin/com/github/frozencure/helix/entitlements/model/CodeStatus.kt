package com.github.frozencure.helix.entitlements.model


import com.github.frozencure.helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CodeStatus(
    @SerialName("code")
    val code: String,
    @SerialName("status")
    val status: CodeStatusType
) : AbstractResource()