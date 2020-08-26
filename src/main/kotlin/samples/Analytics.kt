package samples

import com.github.frozencure.helix.HelixClient
import com.github.frozencure.helix.auth.model.OAuthCredentials
import kotlinx.coroutines.runBlocking
import java.time.Duration
import java.time.Instant


fun getExtensionAnalytics() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        print(
            helixClient.analytics.getExtensionAnalytics(12345, Instant.now() - Duration.ofDays(1), Instant.now())
                .resources
        )
    }
}

fun getGameAnalytics() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        print(
            helixClient.analytics.getGameAnalytics(12345, Instant.now() - Duration.ofDays(1), Instant.now())
                .resources
        )
    }
}