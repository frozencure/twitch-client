package com.github.frozencure.helix.extensions

import com.github.frozencure.helix.auth.model.AuthCredentials
import com.github.frozencure.helix.exceptions.BadRequestException
import com.github.frozencure.helix.extensions.model.transaction.ExtensionTransaction
import com.github.frozencure.helix.http.ResourceService
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * Service class that can be used to access **Extensions** endpoints:
 * *GET extension transactions*
 */
class ExtensionService : ResourceService {

    /**
     * Creates a new extension service object given some authentication credentials and a HTTP client configuration.
     * @param credentials The authentication credentials: can be OAuth or simple credentials with only a client ID
     */
    constructor(credentials: AuthCredentials) : super(credentials)

    /**
     * Creates a new extension service object given an HTTP client.
     * @param httpClient The HTTP client.
     */
    constructor(httpClient: HttpClient) : super(httpClient)

    private companion object {
        private const val BASE_URL = "${ResourceService.BASE_URL}/extensions"
    }

    /**
     * Allows the retrieval of a list of transactions that have occurred for one of your extensions across all of Twitch.
     * Requires an app or user access token.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#get-extension-transactions)
     * @param extensionId The identifier of the extension.
     * @param first Maximum number of transactions to return. Maximum: 100, Default: 100.
     * @param transactionIds Transaction IDs to look up. Can include multiple to fetch multiple transactions in a single request.
     * @throws BadRequestException Exception is thrown if more than 100 transaction IDs are specified.
     * @return A [TransactionsResponse] that holds a collection of [ExtensionTransaction] resources (can have multiple pages).
     * @sample samples.getExtensionTransactions
     */
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