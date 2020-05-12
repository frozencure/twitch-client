package helix.videos.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class VideoType {
    @SerialName("upload")
    UPLOAD,

    @SerialName("archive")
    ARCHIVE,

    @SerialName("highlight")
    HIGHLIGHT
}