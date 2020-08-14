package helix.auth.basic

open class OnlyClientAuthConfig {

    var clientKey: String = "Client-ID"

    lateinit var clientId: String

    var sendWithoutRequest: Boolean = false
}