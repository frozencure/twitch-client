package com.github.frozencure.helix.auth.basic

/**
 * Holds the configuration properties for the basic Twitch Helix authentication, where only a client ID is used.
 */
open class BaseAuthConfig {

    internal var clientKey: String = "Client-ID"

    internal lateinit var clientId: String

    internal var sendWithoutRequest: Boolean = true
}