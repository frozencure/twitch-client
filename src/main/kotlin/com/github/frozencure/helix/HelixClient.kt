package com.github.frozencure.helix

import com.github.frozencure.helix.analytics.AnalyticsService
import com.github.frozencure.helix.auth.model.AuthCredentials
import com.github.frozencure.helix.bits.BitsService
import com.github.frozencure.helix.channels.ChannelService
import com.github.frozencure.helix.clips.ClipService
import com.github.frozencure.helix.entitlements.EntitlementService
import com.github.frozencure.helix.extensions.ExtensionService
import com.github.frozencure.helix.games.GameService
import com.github.frozencure.helix.moderation.ModerationService
import com.github.frozencure.helix.streams.StreamService
import com.github.frozencure.helix.subscriptions.SubscriptionService
import com.github.frozencure.helix.users.UserService
import com.github.frozencure.helix.videos.VideoService
import com.github.frozencure.helix.webhook.WebhookService

/**
 * The main entry-point of the library. Can be used to access all Twitch Helix endpoints.
 * @constructor Creates a new Helix Client object.
 * @param credentials The credentials necessary to authenticate all HTTP requests.
 */
class HelixClient(
    credentials: AuthCredentials
) {
    /**
     * Can be used to access all *Analytics* Helix endpoints.
     */
    val analytics: AnalyticsService = AnalyticsService(credentials)

    /**
     * Can be used to access all *Bits* Helix endpoints.
     */
    val bits: BitsService = BitsService(credentials)

    /**
     * Can be used to access all *Channels* Helix endpoints.
     */
    val channels = ChannelService(credentials)

    /**
     * Can be used to access all *Clips* Helix endpoints.
     */
    val clips = ClipService(credentials)

    /**
     * Can be used to access all *Entitlements* Helix endpoints.
     */
    val entitlements = EntitlementService(credentials)

    /**
     * Can be used to access all *Extensions* Helix endpoints.
     */
    val extensions = ExtensionService(credentials)

    /**
     * Can be used to access all *Games* Helix endpoints.
     */
    val games = GameService(credentials)

    /**
     * Can be used to access all *Moderation* Helix endpoints.
     */
    val moderation = ModerationService(credentials)

    /**
     * Can be used to access all *Streams* Helix endpoints.
     */
    val streams = StreamService(credentials)

    /**
     * Can be used to access all *Subscriptions* Helix endpoints.
     */
    val subscriptions = SubscriptionService(credentials)

    /**
     * Can be used to access all *Users* Helix endpoints.
     */
    val users = UserService(credentials)

    /**
     * Can be used to access all *Videos* Helix endpoints.
     */
    val videos = VideoService(credentials)

    /**
     * Can be used to access all *Webhooks* Helix endpoints.
     */
    val webhooks = WebhookService(credentials)
}