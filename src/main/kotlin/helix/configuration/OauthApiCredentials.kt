package helix.configuration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class OauthApiCredentials(
    @SerialName("Authorization")
    private var authToken: String
) {
    init {
        authToken = "Bearer $authToken"
    }
}