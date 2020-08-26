package samples

import com.github.frozencure.helix.HelixClient
import com.github.frozencure.helix.auth.model.OAuthCredentials
import kotlinx.coroutines.runBlocking

fun getGameByName() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        println(
            helixClient.games.getGame(
                name = "Overwatch"
            ).resource
        )
    }
}

fun getGameById() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        println(
            helixClient.games.getGame(
                id = 33214
            ).resource
        )
    }
}

fun getGames() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        println(
            helixClient.games.getGames(
                ids = listOf(33214),
                names = listOf("Overwatch")
            ).resources
        )
    }
}

fun getTopGames() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        println(
            helixClient.games.getTopGames(
                first = 50
            ).resources
        )
    }
}


fun searchGames() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        println(
            helixClient.games.getGames(
                query = "League Of Legends",
                first = 5
            ).resources
        )
    }
}