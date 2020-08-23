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


class HelixClient(
    credentials: AuthCredentials
) {
    val analytics: AnalyticsService = AnalyticsService(credentials)
    val bits: BitsService = BitsService(credentials)
    val channels = ChannelService(credentials)
    val clips = ClipService(credentials)
    val entitlements = EntitlementService(credentials)
    val extensions = ExtensionService(credentials)
    val games = GameService(credentials)
    val moderation = ModerationService(credentials)
    val streams = StreamService(credentials)
    val subscriptions = SubscriptionService(credentials)
    val users = UserService(credentials)
    val videos = VideoService(credentials)
    val webhooks = WebhookService(credentials)
}