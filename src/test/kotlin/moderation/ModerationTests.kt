package moderation

import helix.moderation.AutoModHelixResponse
import helix.moderation.ModerationService
import helix.moderation.model.AutoModMessage
import helix.moderation.model.AutoModRequest
import io.ktor.client.statement.request
import io.ktor.content.TextContent
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import org.junit.Test
import util.HttpClientMockBuilder

@UnstableDefault
@ImplicitReflectionSerializer
class `Given auto mod check with messages and broadcaster id is called` {
    private val userId: Long = 1

    private val messages: Collection<AutoModMessage> = listOf(
        AutoModMessage("1", "Hello World!", userId),
        AutoModMessage("2", "Boooooo!", userId)
    )

    private val autoModResponse = runBlocking<AutoModHelixResponse> {
        ModerationService(HttpClientMockBuilder.withJsonContent(ModerationTestData.AUTO_MOD))
            .checkMessagesWithAutoMod(userId, messages)
    }

    @Test
    fun `then request has user id as parameter`() =
        assert(autoModResponse.httpResponse.request.url.parameters["broadcaster_id"] == userId.toString())

    @Test
    fun `then request has messages as body`() {
        assert(
            (autoModResponse.httpResponse.request.content as TextContent).text ==
                    Json.toJson(AutoModRequest(messages)).toString()
        )
    }

    @Test
    fun `then two auto mod statuses are returned`() =
        assert(autoModResponse.resources.size == 2)
}