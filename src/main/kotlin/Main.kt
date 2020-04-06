import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText

suspend fun main() {
    val videoId = "584303799"
    val clientId = "nyufzvu4k8h80iq0r7ya4zx1fsas7d"
    val url = "https://api.twitch.tv/v5/videos/$videoId/comments"
    val client = HttpClient(Apache)
    val response: HttpResponse = client.get(url) {
        header("Client-ID", clientId)
    }
    println(response.readText())
}