package com.github.frozencure.helix.videos.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class VideoType {
    @SerialName("all")
    ALL,

    @SerialName("upload")
    UPLOAD,

    @SerialName("archive")
    ARCHIVE,

    @SerialName("highlight")
    HIGHLIGHT
}