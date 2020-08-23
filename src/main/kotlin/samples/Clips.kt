package samples

import com.github.frozencure.helix.HelixClient
import com.github.frozencure.helix.auth.model.OAuthCredentials
import kotlinx.coroutines.runBlocking

fun getSingleClip() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        print(
            helixClient.clips.getClip(
                "AwkwardHelplessSalamanderSwiftRage"
            )
        )
    }
}

fun getMultipleClips() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        print(
            helixClient.clips.getClips(
                listOf("AwkwardHelplessSalamanderSwiftRage", "ArbitraryImportantPoxNononoCat")
            )
        )
    }
}

fun getClipsByBroadcaster() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        print(
            helixClient.clips.getClipsByBroadcaster(
                83035654
            )
        )
    }
}

fun getClipsByGame() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        print(
            helixClient.clips.getClipsByGame(
                12345
            )
        )
    }
}


fun createClip() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        print(
            helixClient.clips.createClip(
                83035654
            )
        )
    }
}