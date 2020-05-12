package helix.util

import kotlinx.serialization.*
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.util.*

@Serializer(forClass = Date::class)
object DateSerializer : KSerializer<Date> {

    override val descriptor: SerialDescriptor =
        PrimitiveDescriptor("WithCustomDefault", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Date) {
        encoder.encodeString(DateTimeFormatter.ISO_DATE_TIME.format(value.toInstant()))
    }

    override fun deserialize(decoder: Decoder): Date {
        return Date.from(Instant.parse(decoder.decodeString()))
    }
}