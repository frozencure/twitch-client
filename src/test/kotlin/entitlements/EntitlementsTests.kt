package entitlements

import helix.entitlements.CodeStatusResponse
import helix.entitlements.EntitlementGrantUrlResponse
import helix.entitlements.EntitlementService
import io.ktor.client.statement.request
import kotlinx.coroutines.runBlocking
import org.junit.Test
import util.HttpClientMockBuilder

class `Given create entitlement grants with manifest ID and type is called` {

    private val manifestId = "abcdefghi"

    private val createGrantResponse = runBlocking<EntitlementGrantUrlResponse> {
        EntitlementService(HttpClientMockBuilder.withJsonContent(EntitlementsTestData.CREATE_ENTITLEMENTS_URL))
            .createEntitlementGrants(manifestId)
    }


    @Test
    fun `Then manifest ID is a parameter`() =
        assert(createGrantResponse.httpResponse.request.url.parameters["manifest_id"] == manifestId)

    @Test
    fun `Then type is a parameter`() =
        assert(createGrantResponse.httpResponse.request.url.parameters["type"] == "bulk_drops_grant")


    @Test
    fun `Then a url is retrieved`() =
        assert(createGrantResponse.resource != null)
}


class `Given GET code status with codes and user ID is called` {

    private val codes = listOf("KUHXV-4GXYP-AKAKK", "XZDDZ-5SIQR-RT5M3")

    private val userId = 123456789L


    private val codeStatusResponse = runBlocking<CodeStatusResponse> {
        EntitlementService(HttpClientMockBuilder.withJsonContent(EntitlementsTestData.CODE_STATUS))
            .getCodeStatus(codes, userId)
    }


    @Test
    fun `Then the codes are parameters`() =
        assert(codeStatusResponse.httpResponse.request.url.parameters.getAll("code") == codes)

    @Test
    fun `Then user ID is a parameter`() =
        assert(codeStatusResponse.httpResponse.request.url.parameters["user_id"] == userId.toString())


    @Test
    fun `Then the status for two codes is retrieved`() =
        assert(codeStatusResponse.resources.size == 2)
}

class `Given POST redeem codes with codes and user id is called` {

    private val codes = listOf("KUHXV-4GXYP-AKAKK", "XZDDZ-5SIQR-RT5M3")

    private val userId = 123456789L


    private val codeStatusResponse = runBlocking<CodeStatusResponse> {
        EntitlementService(HttpClientMockBuilder.withJsonContent(EntitlementsTestData.CODE_STATUS))
            .redeemCodes(codes, userId)
    }


    @Test
    fun `Then the codes are parameters`() =
        assert(codeStatusResponse.httpResponse.request.url.parameters.getAll("code") == codes)

    @Test
    fun `Then user ID is a parameter`() =
        assert(codeStatusResponse.httpResponse.request.url.parameters["user_id"] == userId.toString())


    @Test
    fun `Then the status for two codes is retrieved`() =
        assert(codeStatusResponse.resources.size == 2)
}