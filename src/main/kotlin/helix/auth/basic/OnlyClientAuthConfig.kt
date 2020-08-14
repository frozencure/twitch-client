package helix.auth.basic

class BasicAuthConfig {

    var clientKey: String = "Client-ID"

    lateinit var clientId: String

    var sendWithoutRequest: Boolean = false
}