package moderation

import helix.moderation.*
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

class `Given GET banned user with broadcaster and user ids is called` {
    private val broadcasterId: Long = 1

    private val userIds: Collection<Long> = listOf(423374343, 424596340)

    private val bannedUsersResponse = runBlocking<BannedUsersScrollableResponse> {
        ModerationService(HttpClientMockBuilder.withJsonContent(ModerationTestData.BANNED_USERS_WITH_CURSOR))
            .getBannedUsers(broadcasterId, userIds)
    }

    @Test
    fun `then request has broadcaster id as parameter`() =
        assert(bannedUsersResponse.httpResponse.request.url.parameters["broadcaster_id"] == broadcasterId.toString())

    @Test
    fun `then request has user ids as parameters`() =
        assert(bannedUsersResponse.httpResponse.request.url.parameters.getAll("user_id") == userIds.map { i -> i.toString() })

    @Test
    fun `then two banned users are returned`() =
        assert(bannedUsersResponse.resources.size == 2)

    @Test
    fun `then pagination cursor exists`() =
        assert(bannedUsersResponse.pagination != null)


    class `When the next page is requested` {
        private val broadcasterId: Long = 1

        private val userIds: Collection<Long> = listOf(423374343, 424596340)

        private val bannedUsersResponse = runBlocking<BannedUsersScrollableResponse?> {
            ModerationService(HttpClientMockBuilder.withJsonContent(ModerationTestData.BANNED_USERS_WITH_CURSOR))
                .getBannedUsers(broadcasterId, userIds).nextPage()
        }

        @Test
        fun `then two banned users are returned`() =
            assert(bannedUsersResponse?.resources?.size == 2)
    }
}

class `Given GET moderators with broadcaster and user ids is called` {
    private val broadcasterId: Long = 1

    private val userIds: Collection<Long> = listOf(423374343, 424596340)

    private val moderatorsResponse = runBlocking<ModeratorsScrollableHelixResponse> {
        ModerationService(HttpClientMockBuilder.withJsonContent(ModerationTestData.MODERATORS_WITH_CURSOR))
            .getModerators(broadcasterId, userIds)
    }

    @Test
    fun `then request has broadcaster id as parameter`() =
        assert(moderatorsResponse.httpResponse.request.url.parameters["broadcaster_id"] == broadcasterId.toString())

    @Test
    fun `then request has user ids as parameters`() =
        assert(moderatorsResponse.httpResponse.request.url.parameters.getAll("user_id") == userIds.map { i -> i.toString() })

    @Test
    fun `then two moderators are returned`() =
        assert(moderatorsResponse.resources.size == 2)

    @Test
    fun `then pagination cursor exists`() =
        assert(moderatorsResponse.pagination != null)

    class `When next page is requested` {
        private val broadcasterId: Long = 1

        private val userIds: Collection<Long> = listOf(423374343, 424596340)

        private val moderatorsResponse = runBlocking<ModeratorsScrollableHelixResponse?> {
            ModerationService(HttpClientMockBuilder.withJsonContent(ModerationTestData.MODERATORS_WITH_CURSOR))
                .getModerators(broadcasterId, userIds).nextPage()
        }

        @Test
        fun `then two moderators are returned`() =
            assert(moderatorsResponse?.resources?.size == 2)
    }
}

class `Given GET ban events with broadcaster and user ids is called` {

    private val broadcasterId: Long = 1

    private val userIds: Collection<Long> = listOf(424596340, 424596341, 424596342)

    private val banEventsResponse = runBlocking<BanEventsScrollableResponse> {
        ModerationService(HttpClientMockBuilder.withJsonContent(ModerationTestData.BAN_EVENTS_WITH_CURSOR))
            .getBanEvents(broadcasterId, userIds)
    }

    @Test
    fun `then request has broadcaster id as parameter`() =
        assert(banEventsResponse.httpResponse.request.url.parameters["broadcaster_id"] == broadcasterId.toString())

    @Test
    fun `then request has first with default value as parameter`() =
        assert(banEventsResponse.httpResponse.request.url.parameters["first"] == 100.toString())

    @Test
    fun `then request has user ids as parameters`() =
        assert(banEventsResponse.httpResponse.request.url.parameters.getAll("user_id") == userIds.map { i -> i.toString() })

    @Test
    fun `then three ban events are returned`() =
        assert(banEventsResponse.resources.size == 3)

    @Test
    fun `then ban event data has expires at timestamp`() =
        banEventsResponse.resources.forEach { r ->
            assert(r.eventData.expiresAt != null)
        }

    @Test
    fun `then pagination cursor exists`() =
        assert(banEventsResponse.pagination != null)


    class `When next page is reqeusted` {
        private val broadcasterId: Long = 1

        private val userIds: Collection<Long> = listOf(424596340, 424596341, 424596342)

        private val banEventsResponse = runBlocking<BanEventsScrollableResponse?> {
            ModerationService(HttpClientMockBuilder.withJsonContent(ModerationTestData.BAN_EVENTS_WITH_CURSOR))
                .getBanEvents(broadcasterId, userIds).nextPage()
        }

        @Test
        fun `then three ban events are returned`() =
            assert(banEventsResponse?.resources?.size == 3)
    }
}

class `Given GET moderator events with broadcaster id and user ids is called` {

    private val broadcasterId: Long = 1

    private val userIds: Collection<Long> = listOf(424596343, 424596344, 424596345)

    private val moderatorEventsResponse = runBlocking<ModeratorEventsScrollableResponse> {
        ModerationService(HttpClientMockBuilder.withJsonContent(ModerationTestData.MODERATOR_EVENTS_WITH_CURSOR))
            .getModeratorEvents(broadcasterId, userIds)
    }

    @Test
    fun `then request has broadcaster id as parameter`() =
        assert(moderatorEventsResponse.httpResponse.request.url.parameters["broadcaster_id"] == broadcasterId.toString())

    @Test
    fun `then request has user ids as parameters`() =
        assert(moderatorEventsResponse.httpResponse.request.url.parameters.getAll("user_id") == userIds.map { i -> i.toString() })

    @Test
    fun `then three moderator events are returned`() =
        assert(moderatorEventsResponse.resources.size == 3)

    @Test
    fun `then ban event data does not have expires at timestamp`() =
        moderatorEventsResponse.resources.forEach { r ->
            assert(r.eventData.expiresAt == null)
        }

    @Test
    fun `then pagination cursor exists`() =
        assert(moderatorEventsResponse.pagination != null)

    class `When next page is requested` {
        private val broadcasterId: Long = 1

        private val userIds: Collection<Long> = listOf(424596343, 424596344, 424596345)

        private val moderatorEventsResponse = runBlocking<ModeratorEventsScrollableResponse?> {
            ModerationService(HttpClientMockBuilder.withJsonContent(ModerationTestData.MODERATOR_EVENTS_WITH_CURSOR))
                .getModeratorEvents(broadcasterId, userIds).nextPage()
        }

        @Test
        fun `then three moderator events are returned`() =
            assert(moderatorEventsResponse?.resources?.size == 3)
    }
}