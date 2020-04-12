package helix.auth.model.request

import kotlinx.serialization.SerialName

data class OauthRevokeRequestModel(
    @SerialName("client_id")
    val clientId: String,
    @SerialName("token")
    val authToken: String
)
