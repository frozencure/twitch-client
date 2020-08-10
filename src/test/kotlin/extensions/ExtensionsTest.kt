package extensions

import helix.extensions.ExtensionService
import helix.extensions.TransactionsResponse
import io.ktor.client.statement.request
import kotlinx.coroutines.runBlocking
import org.junit.Test
import util.HttpClientMockBuilder

class `Given GET extension transactions is called` {

    private val extensionId = "12345"

    private val transactionIds = listOf("1", "2")

    private val transactionsResponse = runBlocking<TransactionsResponse> {
        ExtensionService(HttpClientMockBuilder.withJsonContent(ExtensionsTestData.MULTIPLE_TRANSACTIONS_WITH_PAGINATION))
            .getTransactions(extensionId, transactionIds = transactionIds)
    }

    @Test
    fun `then request has first as parameter`() =
        assert(transactionsResponse.httpResponse.request.url.parameters["first"] != null)


    @Test
    fun `then request has extension id as parameter`() =
        assert(transactionsResponse.httpResponse.request.url.parameters["extension_id"] != null)


    @Test
    fun `then request has transcation ids as parameters`() =
        assert(transactionsResponse.httpResponse.request.url.parameters.getAll("id") == transactionIds)

    @Test
    fun `then transactions are returned`() =
        assert(transactionsResponse.resources.size == 2)

    @Test
    fun `then pagination exists`() =
        assert(transactionsResponse.pagination != null)


    class `And next paged is retrieved` {

        private val extensionId = "12345"

        private val transactionsResponse = runBlocking<TransactionsResponse?> {
            ExtensionService(HttpClientMockBuilder.withJsonContent(ExtensionsTestData.MULTIPLE_TRANSACTIONS_WITH_PAGINATION))
                .getTransactions(extensionId).nextPage()
        }

        @Test
        fun `then request has after as parameter`() =
            assert(transactionsResponse?.httpResponse?.request?.url?.parameters?.get("after") != null)

        @Test
        fun `then games are returned`() =
            assert(transactionsResponse?.resources?.size == 2)

    }

}