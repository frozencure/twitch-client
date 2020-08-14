package helix.auth.basic

open class BaseAuthConfig {

    var clientKey: String = "Client-ID"

    lateinit var clientId: String

    var sendWithoutRequest: Boolean = true
}