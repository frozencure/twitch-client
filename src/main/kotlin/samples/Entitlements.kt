package samples

import com.github.frozencure.helix.HelixClient
import com.github.frozencure.helix.auth.model.OAuthCredentials
import kotlinx.coroutines.runBlocking

fun createEntitlementGrants() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        println(
            helixClient.entitlements.createEntitlementGrants("manifestid-example")
        )
    }
}


fun getCodeStatus() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        println(
            helixClient.entitlements.getCodeStatus(
                codes = listOf("code1", "code2", "code3"),
                userId = 123456
            )
        )
    }
}

fun redeemCodes() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        println(
            helixClient.entitlements.redeemCodes(
                codes = listOf("code1", "code2", "code3"),
                userId = 123456
            )
        )
    }
}


fun getDropsEntitlement() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        println(
            helixClient.entitlements.getDropsEntitlement(
                "entitlement-id-example"
            ).resource
        )
    }
}


fun getDropsEntitlements() {
    val credentials = OAuthCredentials("<OAuth access token here>", "<App Client ID here>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        println(
            helixClient.entitlements.getDropsEntitlements(
                userId = 123456,
                gameId = 654321,
                first = 10
            ).resources
        )
    }
}