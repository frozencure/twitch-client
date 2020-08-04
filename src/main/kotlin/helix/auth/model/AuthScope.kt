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
     * Add or remove channels from your follower list.
     */
    @SerialName("user:edit:follows")
    USER_EDIT_FOLLOWS("user:edit:follows"),

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
    USER_READ_EMAIL("user:read:email"),


    /**
     * Access auto-mod messages, banned users, ban events, channel moderators, moderator events.
     */
    @SerialName("moderation:read")
    MODERATION_READ("moderation:read"),

    /**
     * Access hype train events that happened in the past on the given channel.
     */
    @SerialName("channel:read:hype_train")
    CHANNEL_READ_HYPE_TRAIN("channel:read:hype_train"),

    /**
     * Access the stream key for the given channel.
     */
    @SerialName("channel:read:stream_key")
    CHANNEL_READ_STREAM_KEY("channel:read:stream_key"),

    /**
     * Start a commercial programmatically on the given channel.
     */
    @SerialName("channel:edit:commercial")
    CHANNEL_EDIT_COMMERCIAL("channel:edit:commercial")
}