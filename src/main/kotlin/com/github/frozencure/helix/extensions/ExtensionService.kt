package com.github.frozencure.helix.extensions

import com.github.frozencure.helix.auth.model.AuthCredentials
import com.github.frozencure.helix.exceptions.BadRequestException
import com.github.frozencure.helix.http.ResourceService
import io.ktor.client.*
import io.ktor.client.request.*

class ExtensionService : ResourceService {

    constructor(credentials: AuthCredentials) : super(credentials)

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