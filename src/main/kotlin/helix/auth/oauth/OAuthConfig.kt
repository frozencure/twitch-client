package helix.auth.oauth

import helix.auth.basic.BaseAuthConfig

class OAuthConfig: BaseAuthConfig() {
    lateinit var token: String
}