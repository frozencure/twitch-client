package com.github.frozencure.helix.entitlements.model


import com.github.frozencure.helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An object that encapsulates an URL where entitlement manifet files can be uploaded.
 * @constructor Creates a new entitlement URL object.
 * @param url The URL where the entitlement manifet files can be uploaded
 */
@Serializable
data class EntitlementUrl(
    @SerialName("url")
    val url: String
) : AbstractResource()