package helix.auth.model

/**
 * Class that store the authentication credentials necessary for the default Twitch Helix authentication, where only a client ID is used.
 * @constructor Creates a new authentication credentials object.
 * @param clientId The client ID of the Twitch application. Can be found in the Twitch Developer console.
 * @param clientKey The header key used for the client ID value.
 */
open class AuthCredentials(
    open val clientId: String,
    open val clientKey: String = "Client-ID"
)