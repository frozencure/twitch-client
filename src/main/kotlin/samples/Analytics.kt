package samples

import helix.HelixClient
import helix.auth.model.OAuthCredentials
import kotlinx.coroutines.runBlocking
import java.time.Duration
import java.time.Instant


val credentials = OAuthCredentials("4j4u933wfyaayp71pxilgqrva7693c", "nyufzvu4k8h80iq0r7ya4zx1fsas7d")


fun getExtensionAnalytics() {
    val helixClient = HelixClient(credentials)
    runBlocking {
        print(helixClient.analytics.getExtensionAnalytics(12345, Instant.now() - Duration.ofDays(1), Instant.now()))
    }
}

fun getGameAnalytics() {
    val helixClient = HelixClient(credentials)
    runBlocking {
        print(helixClient.analytics.getGameAnalytics(12345, Instant.now() - Duration.ofDays(1), Instant.now()))
    }
}