package com.github.frozencure.helix.auth.oauth

import com.github.frozencure.helix.auth.basic.BaseAuthConfig

/**
 * Holds the configuration properties for an OAuth authentication, where a client ID as well as a OAuth token are used.
 */
class OAuthConfig : BaseAuthConfig() {
    internal lateinit var token: String
}