package helix

import helix.analytics.AnalyticsService
import helix.auth.model.AuthCredentials
import helix.bits.BitsService
import helix.channels.ChannelService
import helix.clips.ClipService
import helix.entitlements.EntitlementService
import helix.extensions.ExtensionService
import helix.games.GameService
import helix.moderation.ModerationService
import helix.streams.StreamService
import helix.subscriptions.SubscriptionService
import helix.users.UserService
import helix.videos.VideoService
import helix.webhook.WebhookService
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.apache.ApacheEngineConfig

class HelixClient(
    credentials: AuthCredentials,
    httpClientEngineConfig: HttpClientEngineConfig = ApacheEngineConfig()
) {
    val analytics: AnalyticsService = AnalyticsService(credentials, httpClientEngineConfig)
    val bits: BitsService = BitsService(credentials, httpClientEngineConfig)
    val channels = ChannelService(credentials, httpClientEngineConfig)
    val clips = ClipService(credentials, httpClientEngineConfig)
    val entitlements = EntitlementService(credentials, httpClientEngineConfig)
    val extensions = ExtensionService(credentials, httpClientEngineConfig)
    val games = GameService(credentials, httpClientEngineConfig)
    val moderation = ModerationService(credentials, httpClientEngineConfig)
    val streams = StreamService(credentials, httpClientEngineConfig)
    val subscriptions = SubscriptionService(credentials, httpClientEngineConfig)
    val users = UserService(credentials, httpClientEngineConfig)
    val videos = VideoService(credentials, httpClientEngineConfig)
    val webhooks = WebhookService(credentials, httpClientEngineConfig)
}