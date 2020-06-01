import clips.ClipsTestData
import helix.clips.ClipHelixResponse
import helix.clips.ClipService
import helix.clips.ClipsHelixResponse
import helix.clips.ScrollableClipsResponse
import io.ktor.client.statement.request
import kotlinx.coroutines.runBlocking
import org.junit.Test
import util.HttpClientMockBuilder
import java.time.Instant


class `Given GET clip with id is called` {

    private val id: String = "AwkwardHelplessSalamanderSwiftRage"

    private val clipResponse = runBlocking<ClipHelixResponse> {
        ClipService(HttpClientMockBuilder.withJsonContent(ClipsTestData.SINGLE_CLIP))
            .getClip(id)
    }

    @Test
    fun `then request has id as parameter`() =
        assert(clipResponse.httpResponse.request.url.parameters["id"] == id)


    @Test
    fun `then clip is returned`() =
        assert(clipResponse.resource != null)
}

class `Given GET clips with ids is called` {

    private val ids = listOf<String>("AwkwardHelplessSalamanderSwiftRage", "AwkwardHelplessSalamanderPogChamp")

    private val clipsResponse = runBlocking<ClipsHelixResponse> {
        ClipService(HttpClientMockBuilder.withJsonContent(ClipsTestData.MULTIPLE_CLIPS))
            .getClips(ids)
    }

    @Test
    fun `then request has ids as parameters`() {
        clipsResponse.httpResponse.request.url.parameters.getAll("id")?.let {
            assert(
                it == ids
            )
        }
    }

    @Test
    fun `then clips are returned`() =
        assert(clipsResponse.resources.size == 2)
}


class `Given GET clips with broadcaster ID is called` {

    private val broadcasterId: Long = 67955580

    private val startedAt: String = "2017-11-30T22:34:18Z"

    private val clipsResponse = runBlocking<ScrollableClipsResponse> {
        ClipService(HttpClientMockBuilder.withJsonContent(ClipsTestData.MULTIPLE_CLIPS_WITH_PAGINATION))
            .getClipsByBroadcaster(broadcasterId, startedAt = Instant.parse(startedAt))
    }

    @Test
    fun `then request has broadcaster ID as parameter`() =
        assert(clipsResponse.httpResponse.request.url.parameters["broadcaster_id"] == broadcasterId.toString())

    @Test
    fun `then request has started at date as parameter`() =
        assert(clipsResponse.httpResponse.request.url.parameters["started_at"] == startedAt)


    @Test
    fun `then clips are returned`() =
        assert(clipsResponse.resources.size == 2)

    @Test
    fun `then pagination exists`() =
        assert(clipsResponse.pagination != null)

    class `And next page is retrieved` {
        private val broadcasterId: Long = 67955580

        private val clipsResponse = runBlocking<ScrollableClipsResponse?> {
            ClipService(HttpClientMockBuilder.withJsonContent(ClipsTestData.MULTIPLE_CLIPS_WITH_PAGINATION))
                .getClipsByBroadcaster(broadcasterId).nextPage()
        }

        @Test
        fun `then request has pagination cursor as parameter`() =
            assert(clipsResponse?.httpResponse?.request?.url?.parameters?.get("after") != null)

        @Test
        fun `then clips are returned`() =
            assert(clipsResponse?.resources?.size == 2)
    }
}

class `Given GET clips with game ID is called` {

    private val gameId: Long = 488191

    private val startedAt: String = "2017-11-30T22:34:18Z"

    private val clipsResponse = runBlocking<ScrollableClipsResponse> {
        ClipService(HttpClientMockBuilder.withJsonContent(ClipsTestData.MULTIPLE_CLIPS_WITH_PAGINATION))
            .getClipsByGame(gameId, startedAt = Instant.parse(startedAt))
    }

    @Test
    fun `then request has game ID as parameter`() =
        assert(clipsResponse.httpResponse.request.url.parameters["game_id"] == gameId.toString())

    @Test
    fun `then request has started at date as parameter`() =
        assert(clipsResponse.httpResponse.request.url.parameters["started_at"] == startedAt)


    @Test
    fun `then clips are returned`() =
        assert(clipsResponse.resources.size == 2)

    @Test
    fun `then pagination exists`() =
        assert(clipsResponse.pagination != null)

    class `And next page is retrieved` {
        private val gameId: Long = 488191

        private val clipsResponse = runBlocking<ScrollableClipsResponse?> {
            ClipService(HttpClientMockBuilder.withJsonContent(ClipsTestData.MULTIPLE_CLIPS_WITH_PAGINATION))
                .getClipsByGame(gameId).nextPage()
        }

        @Test
        fun `then request has pagination cursor as parameter`() =
            assert(clipsResponse?.httpResponse?.request?.url?.parameters?.get("after") != null)

        @Test
        fun `then clips are returned`() =
            assert(clipsResponse?.resources?.size == 2)
    }

}