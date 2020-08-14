package helix.auth.model

class OAuthCredentials(
    val token: String,
    override val clientId: String,
    override val clientKey: String = "Client-ID"
) : AuthCredentials(clientId)