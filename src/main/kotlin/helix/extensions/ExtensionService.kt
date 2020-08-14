package helix.extensions

import helix.auth.model.AuthCredentials
import helix.exceptions.BadRequestException
import helix.http.ResourceService
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.apache.ApacheEngineConfig
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ExtensionService : ResourceService {

    constructor(credentials: AuthCredentials, engineConfig: HttpClientEngineConfig = ApacheEngineConfig())
            : super(credentials, engineConfig)

    constructor(httpClient: HttpClient) : super(httpClient)

    companion object {
        const val BASE_URL = "${ResourceService.BASE_URL}/extensions"
    }

    suspend fun getTransactions(extensionId: String, first: Int = 100, transactionIds: Collection<String>? = null)
            : TransactionsResponse {
        transactionIds?.let {
            if (transactionIds.size > 100) {
                throw BadRequestException("A maximum of 100 transaction IDs can be provided.")
            }
        }
        return TransactionsResponse(
            httpClient.get("$BASE_URL/transactions") {
                parameter("extension_id", extensionId)
                parameter("first", first)
                transactionIds?.let { transactionIds.forEach { parameter("id", it) } }
            }, httpClient
        )
    }


}