import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import kotlinx.serialization.Serializable
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

@Serializable
data class User(
    val id: String,
    val login: String,
    val display_name: String,
    val type: String,
    val broadcaster_type: String,
    val description: String,
    val profile_image_url: String,
    val offline_image_url: String,
    val view_count: Long
)


@OptIn(UnstableDefault::class)
suspend fun main() {
    val userId = "44322889"
    val clientId = "nyufzvu4k8h80iq0r7ya4zx1fsas7d"
    val url = "https://api.twitch.tv/helix/users?id=$userId"
    val client = HttpClient(Apache)
    val response: HttpResponse = client.get(url) {
        header("Client-ID", clientId)
    }
    val responseUserArray = Json.parseJson(response.readText()).jsonObject.getArray("data")
    responseUserArray.forEach { e ->
        println(Json.parse(User.serializer(),e.toString()))
    }
}