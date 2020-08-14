package helix.auth.model

open class AuthCredentials(
    open val clientId: String,
    open val clientKey: String = "Client-ID"
)