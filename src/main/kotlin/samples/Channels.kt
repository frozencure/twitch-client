package samples

import com.github.frozencure.helix.HelixClient
import com.github.frozencure.helix.auth.model.OAuthCredentials
import com.github.frozencure.helix.channels.model.commercial.CommercialLength
import kotlinx.coroutines.runBlocking

fun searchChannels() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        print(
            helixClient.channels.getChannels(
                query = "xQcOw",
                liveOnly = true,
                first = 5
            ).resources
        )
    }
}

fun getHypeTrainEvents() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        print(
            helixClient.channels.getHypeTrainEvents(
                broadcasterId = 12345L
            ).resources
        )
    }
}


fun startCommercial() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        print(
            helixClient.channels.startCommercial(
                broadcasterId = 12345L,
                length = CommercialLength.THIRTY
            ).resource
        )
    }
}

fun modifyChannelInfo() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        print(
            helixClient.channels.modifyChannelInfo(
                broadcasterId = 12345L,
                title = "New title"
            )
        )
    }
}