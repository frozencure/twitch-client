package samples

import helix.auth.AuthService
import helix.auth.model.AuthScope
import helix.auth.model.request.OauthAppTokenRequestModel
import helix.auth.model.request.OauthUserTokenRequestModel
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ImplicitReflectionSerializer

@ImplicitReflectionSerializer
fun authenticateUser() {
    val requestModel = OauthUserTokenRequestModel(
        "<your client id here>", // client-id
        "http://localhost", // redirect-URI
        "token", // response type
        AuthScope.values().toList() // all scopes
    )
    val authService = AuthService()
    runBlocking {
        val response = authService.requestUserToken(requestModel)
        println(response)
    }
}


@ImplicitReflectionSerializer
fun authenticateApp() {
    val requestModel = OauthAppTokenRequestModel(
        "<your client id here>",
        "<your client secret here>",
        AuthScope.values().toList()
    )
    val authService = AuthService()
    runBlocking {
        val response = authService.requestAppToken(requestModel)
        println(response)
    }
}