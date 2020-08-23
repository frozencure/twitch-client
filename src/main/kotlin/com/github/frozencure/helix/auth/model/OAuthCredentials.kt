package com.github.frozencure.helix.auth.model

/**
 * Class that stores the authentication credentials necessary for the OAuth Twitch Helix authentication,
 * where a client ID as well as an access token are used.
 * @constructor Creates a new OAuth credentials object.
 * @param token The OAuth access token.
 */
class OAuthCredentials(
    val token: String,
    override val clientId: String,
    override val clientKey: String = "Client-ID"
) : AuthCredentials(clientId)