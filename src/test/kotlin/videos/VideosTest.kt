package videos

import helix.videos.ScrollableVideosResponse
import helix.videos.VideoHelixResponse
import helix.videos.VideoService
import helix.videos.VideosHelixResponse
import helix.videos.model.VideoType
import helix.videos.model.VideoVisibility
import io.ktor.client.statement.request
import kotlinx.coroutines.runBlocking
import org.junit.Test
import util.HttpClientMockBuilder

class `Given GET video with id is called` {

    private val inputId: Long = 234482848

    private val videoResponse = runBlocking<VideoHelixResponse> {
        VideoService(HttpClientMockBuilder.withJsonContent(VideosTestData.SINGLE_VIDEO))
            .getVideo(inputId)
    }

    @Test
    fun `then video is returned`() =
        assert(videoResponse.resource != null)

    @Test
    fun `then request id as parameter`() =
        assert(videoResponse.httpResponse.request.url.parameters["id"] == inputId.toString())

    @Test
    fun `then video type is archive`() =
        assert(videoResponse.resource?.type == VideoType.ARCHIVE)

    @Test
    fun `then video creation date exists`() =
        assert(videoResponse.resource?.createdAt != null)

    @Test
    fun `then video publish date exists`() =
        assert(videoResponse.resource?.publishedAt != null)

    @Test
    fun `then video visibility is public`() =
        assert(videoResponse.resource?.viewable == VideoVisibility.PUBLIC)

}

class `Given GET videos with IDs is called` {

    private val inputIds = listOf<Long>(234482848, 234482849)

    private val videosResponse = runBlocking<VideosHelixResponse> {
        VideoService(HttpClientMockBuilder.withJsonContent(VideosTestData.MULTIPLE_VIDEOS))
            .getVideos(inputIds)
    }


    @Test
    fun `then videos are returned`() =
        assert(videosResponse.resources.size == 2)

    @Test
    fun `then request ids are parameters`() =
        assert(videosResponse.httpResponse.request.url.parameters
            .getAll("id") == inputIds.map { it.toString() })

}


class `Given GET videos with Game ID is called` {

    private val gameId: Long = 1245678

    private val videosResponse = runBlocking<ScrollableVideosResponse> {
        VideoService(HttpClientMockBuilder.withJsonContent(VideosTestData.GAME_VIDEOS))
            .getVideosByGame(gameId)
    }

    @Test
    fun `then videos are returned`() =
        assert(videosResponse.resources.size == 2)

    @Test
    fun `then request game id is a parameter`() =
        assert(videosResponse.httpResponse.request.url.parameters["game_id"] == gameId.toString())


    class `And next page is retrieved` {
        private val gameId: Long = 1245678

        private val videosResponse = runBlocking<ScrollableVideosResponse?> {
            VideoService(HttpClientMockBuilder.withJsonContent(VideosTestData.GAME_VIDEOS))
                .getVideosByGame(gameId).nextPage()
        }

        @Test
        fun `then videos are retrieved`() =
            assert(videosResponse?.resources?.size == 2)

        @Test
        fun `then after is a parameter`() =
            assert(videosResponse?.httpResponse?.request?.url?.parameters?.get("after") != null)
    }
}


class `Given GET videos with User ID is called` {

    private val userId: Long = 1245678

    private val videosResponse = runBlocking<ScrollableVideosResponse> {
        VideoService(HttpClientMockBuilder.withJsonContent(VideosTestData.GAME_VIDEOS))
            .getVideosByUser(userId)
    }

    @Test
    fun `then videos are returned`() =
        assert(videosResponse.resources.size == 2)

    @Test
    fun `then request game id is a parameter`() =
        assert(videosResponse.httpResponse.request.url.parameters["user_id"] == userId.toString())


    class `And next page is retrieved` {
        private val userId: Long = 1245678

        private val videosResponse = runBlocking<ScrollableVideosResponse?> {
            VideoService(HttpClientMockBuilder.withJsonContent(VideosTestData.GAME_VIDEOS))
                .getVideosByUser(userId).nextPage()
        }

        @Test
        fun `then videos are retrieved`() =
            assert(videosResponse?.resources?.size == 2)

        @Test
        fun `then after is a parameter`() =
            assert(videosResponse?.httpResponse?.request?.url?.parameters?.get("after") != null)

    }
}