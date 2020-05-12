package helix.auth.model.request


import helix.auth.model.AuthScope
import kotlinx.serialization.*

@Serializable
data class OauthAuthorizeRequestModel(
    @SerialName("client_id")
    val clientId: String,
    @SerialName("redirect_uri")
    val redirectUri: String,
    @SerialName("response_type")
    val responseType: String = "token",
    @Serializable(with = AuthScopeListSerializer::class)
    @SerialName("scope")
    val scope: List<AuthScope>,
    @SerialName("force_verify")
    val forceVerify: Boolean? = null,
    @SerialName("state")
    val state: String? = null
)

@Serializer(forClass = List::class)
private object AuthScopeListSerializer : KSerializer<List<AuthScope>> {
    override val descriptor: SerialDescriptor
        get() = PrimitiveDescriptor("AuthScopeList", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): List<AuthScope> {
        throw NotImplementedError()
    }

    override fun serialize(encoder: Encoder, value: List<AuthScope>) {
        val strBuilder = StringBuilder()
        value.forEach {
            strBuilder.append("${it.scope} ")
        }
        encoder.encodeString(strBuilder.trim().toString())
    }


}