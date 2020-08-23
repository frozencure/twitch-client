package samples

import com.github.frozencure.helix.auth.AuthService
import com.github.frozencure.helix.auth.model.AuthScope
import com.github.frozencure.helix.auth.model.request.OauthAppTokenRequestModel
import com.github.frozencure.helix.auth.model.request.OauthUserTokenRequestModel
import kotlinx.coroutines.runBlocking



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