package helix.auth.oauth

import helix.auth.basic.OnlyClientAuthConfig

class OAuthConfig: OnlyClientAuthConfig() {
    lateinit var token: String
}