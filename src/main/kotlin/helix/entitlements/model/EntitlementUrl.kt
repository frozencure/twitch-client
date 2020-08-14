package helix.entitlements.model


import helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EntitlementUrl(
    @SerialName("url")
    val url: String
) : AbstractResource()