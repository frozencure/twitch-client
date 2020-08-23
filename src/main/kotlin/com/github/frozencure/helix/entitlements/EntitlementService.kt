package com.github.frozencure.helix.entitlements

import com.github.frozencure.helix.auth.model.AuthCredentials
import com.github.frozencure.helix.exceptions.BadRequestException
import com.github.frozencure.helix.http.ResourceService
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * Service class that can be used to access **Entitlements** endpoints:
 * *POST create entitlements grants*, *GET code status*, *POST redeem code* and *GET drops entitlements*
 */
class EntitlementService : ResourceService {

    /**
     * Creates a new entitlement service object given some authentication credentials and a HTTP client configuration.
     * @param credentials The authentication credentials: can be OAuth or simple credentials with only a client ID
     */
    constructor(credentials: AuthCredentials) : super(credentials)

    /**
     * Creates a new entitlement service object given an HTTP client.
     * @param httpClient The HTTP client.
     */
    constructor(httpClient: HttpClient) : super(httpClient)

    private companion object {
        private const val BASE_URL = "${ResourceService.BASE_URL}/entitlements"
    }

    /**
     * Creates a URL where you can upload a manifest file and notify users that they have an entitlement.
     * Entitlements are digital items that users are entitled to use.
     * Requires an app access token.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#create-entitlement-grants-upload-url)
     * @param manifestId Unique identifier of the manifest file to be uploaded. Must be 1-64 characters.
     * @param type of entitlement being granted. Only *bulk_drops_grant* is supported.
     * @return A [EntitlementGrantUrlResponse] that holds a single [EntitlementUrl] resource.
     * @throws BadRequestException Exception is thrown if the manifest identifier has more than 64 characters.
     */
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

    /**
     * Gets the status of one or more provided codes.
     * Requires an app access token.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#get-code-status)
     * @param codes The list of codes to get the status for.
     * @param userId The user account for which the code status is checked.
     * @return A [CodeStatusResponse] that holds a collection of [CodeStatus] resources as payload.
     * @throws BadRequestException An exception is thrown if more than 20 codes are specified.
     */
    suspend fun getCodeStatus(codes: List<String>, userId: Long) = CodeStatusResponse(
        httpClient.get("$BASE_URL/codes") {
            if (codes.size !in 1 until 21) {
                throw BadRequestException("Only 1-20 code parameters are allowed")
            }
            codes.forEach { parameter("code", it) }
            parameter("user_id", userId)
        }
    )

    /**
     * Redeems one or more provided codes to the authenticated Twitch user.
     * Requires an app access token.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#redeem-code)
     * @param codes The list of codes to redeem for the authenticated user's account.
     * @param userId The user account which is going to receive the entitlement associated with the code.
     * @return A [CodeStatusResponse] that holds a collection of [CodeStatus] resources as payload.
     * @throws BadRequestException An exception is thrown if more than 20 codes are specified.
     */
    suspend fun redeemCodes(codes: List<String>, userId: Long) = CodeStatusResponse(
        httpClient.post("$BASE_URL/code") {
            if (codes.size !in 1 until 21) {
                throw BadRequestException("Only 1-20 code parameters are allowed")
            }
            codes.forEach { parameter("code", it) }
            parameter("user_id", userId)
        }
    )

    /**
     * Retrieves the information about an entitlement given the entitlement ID.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#get-drops-entitlements)
     * @param entitlementId The ID of the entitlement.
     * @return A [EntitlementResponse] that holds a single [Entitlement] resource as payload.
     */
    suspend fun getDropsEntitlement(entitlementId: String) = EntitlementResponse(
        httpClient.get("$BASE_URL/drops") {
            parameter("id", entitlementId)
        }
    )

    /**
     * Retrieves the information about entitlements that have been granted to a user or a game.
     * For more information visit the [Twitch Developer Reference](https://dev.twitch.tv/docs/api/reference#get-drops-entitlements)
     * @param userId The ID of the user that the entitlements have been granted to.
     * @param gameId The ID of the game that the entitlements have been granted to.
     * @param first Maximum number of entitlements to return. Default: 100, Max: 100.
     * @return A [EntitlementsResponse] that holds a collection of  [Entitlement] resources as payload. (can have multiple pages)
     */
    suspend fun getDropsEntitlements(userId: Long? = null, gameId: Long? = null, first: Int = 100) =
        EntitlementsResponse(
            httpClient.get("$BASE_URL/drops") {
                userId?.let { parameter("user_id", userId) }
                gameId?.let { parameter("game_id", gameId) }
                parameter("first", first)
            }, httpClient
        )
}