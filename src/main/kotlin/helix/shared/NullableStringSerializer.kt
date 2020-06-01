package helix.shared

import kotlinx.serialization.*

@Serializer(forClass = String::class)
object NullableStringSerializer : KSerializer<String?> {
    override val descriptor: SerialDescriptor =
        PrimitiveDescriptor("NullableStringSerializer", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: String?) {
        if (value?.isEmpty() == false) {
            encoder.encodeString(value)
        }
    }

    override fun deserialize(decoder: Decoder): String? {
        val str = decoder.decodeString()
        if (str.isEmpty()) return null
        return str
    }
}