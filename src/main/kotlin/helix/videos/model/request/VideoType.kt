package helix.videos.model.request

enum class VideoType(val asString: String) {
    ALL("all"),
    UPLOAD("upload"),
    ARCHIVE("archive"),
    HIGHLIGHT("highlight")
}