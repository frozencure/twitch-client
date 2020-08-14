package helix.entitlements

import helix.auth.model.AuthCredentials
import helix.exceptions.BadRequestException
import helix.http.ResourceService
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.apache.ApacheEngineConfig
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post

class EntitlementService : ResourceService {
    constructor(credentials: AuthCredentials, engineConfig: HttpClientEngineConfig = ApacheEngineConfig())
            : super(credentials, engineConfig)

    constructor(httpClient: HttpClient) : super(httpClient)

    companion object {
        const val BASE_URL = "${ResourceService.BASE_URL}/entitlements"
    }

    suspend fun createEntitlementGrants(manifestId: String, type: String = "bulk_drops_grant") =
        EntitlementGrantUrlResponse(
            httpClient.post("$BASE_URL/upload") {
                if (manifestId.length !in 1 until 65) {
                    throw BadRequestException("Manifest identifier must be 1-64 characters long")
                }
                parameter("manifest_id", manifestId)
                parameter("type", type)
            }
        )

    suspend fun getCodeStatus(codes: List<String>, userId: Long) = CodeStatusResponse(
        httpClient.get("$BASE_URL/codes") {
            if (codes.size !in 1 until 21) {
                throw BadRequestException("Only 1-20 code parameters are allowed")
            }
            codes.forEach { parameter("code", it) }
            parameter("user_id", userId)
        }
    )

    suspend fun redeemCodes(codes: List<String>, userId: Long) = CodeStatusResponse(
        httpClient.post("$BASE_URL/code") {
            if (codes.size !in 1 until 21) {
                throw BadRequestException("Only 1-20 code parameters are allowed")
            }
            codes.forEach { parameter("code", it) }
            parameter("user_id", userId)
        }
    )
}