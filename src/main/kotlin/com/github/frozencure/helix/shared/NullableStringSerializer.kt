package com.github.frozencure.helix.shared

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object NullableStringSerializer : KSerializer<String?> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("NullableStringSerializer", PrimitiveKind.STRING)

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