package webhook

import com.github.frozencure.helix.webhook.WebhookService
import com.github.frozencure.helix.webhook.WebhooksResponse
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking
import org.junit.Test
import util.HttpClientMockBuilder

class `Given GET webhook subscriptions is called` {

    private val webhooksHelixResponse = runBlocking<WebhooksResponse> {
        WebhookService(HttpClientMockBuilder.withJsonContent(WebhooksTestData.WEBHOOK_SUBSCRIPTIONS))
            .getSubscriptions()
    }

    @Test
    fun `then subscriptions are returned`() =
        assert(webhooksHelixResponse.resources.size == 2)


    @Test
    fun `then first is a request parameter returned`() =
        assert(webhooksHelixResponse.httpResponse.request.url.parameters["first"] == 100.toString())


    @Test
    fun `then pagination is returned`() =
        assert(webhooksHelixResponse.pagination != null)

    @Test
    fun `then total is returned`() =
        assert(webhooksHelixResponse.total != null)

    class `And next page is retrieved` {

        private val webhooksHelixResponse = runBlocking<WebhooksResponse?> {
            WebhookService(HttpClientMockBuilder.withJsonContent(WebhooksTestData.WEBHOOK_SUBSCRIPTIONS))
                .getSubscriptions().nextPage()
        }

        @Test
        fun `then videos are retrieved`() =
            assert(webhooksHelixResponse?.resources?.size == 2)

        @Test
        fun `then after is a parameter`() =
            assert(webhooksHelixResponse?.httpResponse?.request?.url?.parameters?.get("after") != null)
    }
}