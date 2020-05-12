package helix.http.credentials

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class OauthApiCredentials(
    @SerialName("Authorization")
    private var authToken: String,
    @SerialName("Client-ID")
    private val clientId: String
) {
    init {
        authToken = "Bearer $authToken"
    }
}