package helix.auth.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class AuthScope(val scope: String) {
    /**
     * View analytics data for your extensions.
     */
    @SerialName("analytics:read:extensions")
    ANALYTICS_READ_EXTENSIONS("analytics:read:extensions"),

    /**
     * View analytics data for your games.
     */
    @SerialName("analytics:read:games")
    ANALYTICS_READ_GAMES("analytics:read:games"),

    /**
     * View Bits information for your channel.
     */
    @SerialName("bits:read")
    BITS_READ("bits:read"),

    /**
     * Get a list of all subscribers to your channel and check if a user is subscribed to your channel
     */
    @SerialName("channel:read:subscriptions")
    CHANNEL_READ_SUBSCRIPTIONS("channel:read:subscriptions"),

    /**
     * Manage a clip object.
     */
    @SerialName("clips:edit")
    EDIT_CLIPS("clips:edit"),

    /**
     * Manage a user object.
     */
    @SerialName("user:edit")
    USER_EDIT("user:edit"),

    /**
     * Edit your channel’s broadcast configuration,
     * including extension configuration. (This scope implies user:read:broadcast capability.)
     */
    @SerialName("user:edit:broadcast")
    USER_EDIT_BROADCAST("user:edit:broadcast"),

    /**
     * View your broadcasting configuration,
     * including extension configurations.
     */
    @SerialName("user:read:broadcast")
    USER_READ_BROADCAST("user:read:broadcast"),

    /**
     * Read authorized user’s email address.
     */
    @SerialName("user:read:email")
    USER_READ_EMAIL("user:read:email")
}