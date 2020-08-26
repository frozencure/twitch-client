package samples

import com.github.frozencure.helix.HelixClient
import com.github.frozencure.helix.auth.model.OAuthCredentials
import kotlinx.coroutines.runBlocking


fun getExtensionTransactions() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        println(
            helixClient.extensions.getTransactions(
                extensionId = "example-extension-id",
                first = 10
            ).resources
        )
    }
}
