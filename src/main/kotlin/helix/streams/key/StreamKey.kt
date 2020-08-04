package helix.streams.key


import helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StreamKey(
    @SerialName("stream_key")
    val streamKey: String
) : AbstractResource()