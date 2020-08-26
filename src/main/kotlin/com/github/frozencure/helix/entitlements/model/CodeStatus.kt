package com.github.frozencure.helix.entitlements.model


import com.github.frozencure.helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An object that represents the status of a redeemable Twitch code.
 * @constructor Creates a new code status object.
 * @param code The code for which the status is provided.
 * @param status The status of the code.
 */
@Serializable
data class CodeStatus(
    @SerialName("code")
    val code: String,
    @SerialName("status")
    val status: CodeStatusType
) : AbstractResource()