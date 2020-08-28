package samples

import com.github.frozencure.helix.HelixClient
import com.github.frozencure.helix.auth.model.OAuthCredentials
import kotlinx.coroutines.runBlocking

fun getStreams() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        print(
            helixClient.streams.getStreams(
                first = 10,
                languages = listOf("en"),
                gameIds = listOf(417752)
            ).resources
        )
    }
}

fun createStreamMarker() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        print(
            helixClient.streams.createStreamMarker(
                userId = 12345,
                description = "A new stream marker."
            ).resource
        )
    }
}

fun getUserStreamMarkers() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        print(
            helixClient.streams.getUserStreamMarkers(
                userId = 12345,
                first = 10
            ).resources
        )
    }
}

fun getVideoStreamMarkers() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        print(
            helixClient.streams.getVideoStreamMarkers(
                videoId = 12345,
                first = 10
            ).resources
        )
    }
}

fun getAllStreamTags() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        print(
            helixClient.streams.getAllStreamTags(
                first = 10
            ).resources
        )
    }
}

fun getStreamTags() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        print(
            helixClient.streams.getStreamTags(
                broadcasterId = 12345
            ).resources
        )
    }
}

fun updateStreamTags() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        print(
            helixClient.streams.updateStreamTags(
                broadcasterId = 12345,
                tags = listOf("tag ID 1", "tag ID 2")
            )
        )
    }
}

fun getStreamKey() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        print(
            helixClient.streams.getStreamKey(
                broadcasterId = 12345
            ).resource
        )
    }
}



