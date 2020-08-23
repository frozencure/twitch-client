package samples

import com.github.frozencure.helix.HelixClient
import com.github.frozencure.helix.auth.model.OAuthCredentials
import com.github.frozencure.helix.shared.model.request.Period
import kotlinx.coroutines.runBlocking
import java.time.Duration
import java.time.Instant

fun getBitsLeaderboard() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        print(
            helixClient.bits.getBitsLeaderboard(
                count = 10,
                period = Period.ALL,
                startedAt = Instant.now() - Duration.ofDays(1)
            )
        )
    }
}