package helix.shared

import kotlinx.serialization.*
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.temporal.ChronoUnit

@Serializer(forClass = Instant::class)
object NullableInstantSerializer : KSerializer<Instant?> {

    override val descriptor: SerialDescriptor =
        PrimitiveDescriptor("Instant", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Instant?) {
        value?.let { encoder.encodeString(DateTimeFormatter.ISO_INSTANT.format(value.truncatedTo(ChronoUnit.SECONDS))) }
    }

    override fun deserialize(decoder: Decoder): Instant? {
        return try {
            Instant.parse(decoder.decodeString())
        } catch (e: DateTimeParseException) {
            null
        }
    }
}