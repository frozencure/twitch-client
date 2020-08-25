# Package com.github.frozencure.analytics

# Analytics

This package contains the implementation for accessing the following endpoints: 
* [GET extension analytics](https://dev.twitch.tv/docs/api/reference#get-extension-analytics)
    - see the *AnalyticsService.getExtensionAnalytics()* sample 
* [GET game analytics](https://dev.twitch.tv/docs/api/reference#get-game-analytics)
    - see the *AnalyticsService.getGameAnalytics()* sample 

# Package com.github.frozencure.bits

# Bits

This package contains the implementation for accessing the following endpoints: 
* [GET bits leaderboard](https://dev.twitch.tv/docs/api/reference#get-bits-leaderboard)
    - see the *BitsService.getBitsLeaderboard()* sample 

# Package com.github.frozencure.channels

# Channels

This package contains the implementation for accessing the following endpoints: 
* [GET search channels](https://dev.twitch.tv/docs/api/reference#search-channels)
    - see the *ChannelService.getChannels()* sample 
* [GET hype train events](https://dev.twitch.tv/docs/api/reference#get-hype-train-events)
    - see the *ChannelService.getHypeTrainEvents()* sample 
* [POST start commercial](https://dev.twitch.tv/docs/api/reference#start-commercial)
    - see the *ChannelService.startCommercial()* sample 
* [PATCH modify channel information](https://dev.twitch.tv/docs/api/reference#modify-channel-information)
    - see the *ChannelService.modifyChannelInfo()* sample 

# Package com.github.frozencure.clips

# Clips

This package contains the implementation for accessing the following endpoints: 
* [GET clips](https://dev.twitch.tv/docs/api/reference#get-clips)
    - see the *ClipService.getClips()* sample 
* [POST create clip](https://dev.twitch.tv/docs/api/reference#create-clip)
    - see the *ClipService.createClip()* sample 


# Package com.github.frozencure.entitlements

# Entitlements

This package contains the implementation for accessing the following endpoints: 
* [POST create entitlement grants upload URL](https://dev.twitch.tv/docs/api/reference#create-entitlement-grants-upload-url)
    - see the *EntitlementService.createEntitlementGrants()* sample 
* [GET code status](https://dev.twitch.tv/docs/api/reference#get-code-status)
    - see the *EntitlementService.getCodeStatus()* sample
* [POST redeem code](https://dev.twitch.tv/docs/api/reference#redeem-code)
    - see the *EntitlementService.redeemCodes()* sample
* [GET drops entitlements](https://dev.twitch.tv/docs/api/reference#get-drops-entitlements)
    - see the *EntitlementService.getDropsEntitlement()* sample
    
    
# Package com.github.frozencure.extensions

# Extensions

This package contains the implementation for accessing the following endpoints: 
* [GET extension transactions](https://dev.twitch.tv/docs/api/reference#get-extension-transactions)
    - see the *ExtensionService.getTransactions()* sample 

# Package com.github.frozencure.games

# Games

This package contains the implementation for accessing the following endpoints: 
* [GET games](https://dev.twitch.tv/docs/api/reference#get-games)
    - see the *GameService.getGames()* sample 
* [GET top games](https://dev.twitch.tv/docs/api/reference#get-top-games)
    - see the *GameService.getTopGames()* sample 

# Package com.github.frozencure.moderation

# Moderation

This package contains the implementation for accessing the following endpoints: 
* [POST check auto-mod status](https://dev.twitch.tv/docs/api/reference#check-automod-status)
    - see the *ModerationService.checkMessagesWithAutoMod()* sample 
* [GET banned users](https://dev.twitch.tv/docs/api/reference#get-banned-users)
    - see the *ModerationService.getBannedUsers()* sample 
* [GET banned events](https://dev.twitch.tv/docs/api/reference#get-banned-events)
    - see the *ModerationService.getBanEvents()* sample 
* [GET moderators](https://dev.twitch.tv/docs/api/reference#get-moderators)
    - see the *ModerationService.getModerators()* sample 
* [GET moderator events](https://dev.twitch.tv/docs/api/reference#get-moderator-events)
    - see the *ModerationService.getModeratorEvents()* sample 

# Package com.github.frozencure.streams

# Streams

This package contains the implementation for accessing the following endpoints: 
* [GET streams](https://dev.twitch.tv/docs/api/reference#get-streams)
    - see the *AnalyticsService.getStreams()* sample 
* [GET stream key](https://dev.twitch.tv/docs/api/reference#get-stream-key)
    - see the *StreamService.getStreamKey()* sample 
* [POST create stream marker](https://dev.twitch.tv/docs/api/reference#create-stream-marker)
    - see the *StreamService.createStreamMarker()* sample
* [GET stream markers](https://dev.twitch.tv/docs/api/reference#get-stream-markers)
    - see the *StreamService.getUserStreamMarkers()* or *StreamService.getVideoStreamMarkers()* sample 
* [GET stream tags](https://dev.twitch.tv/docs/api/reference#get-stream-tags)
    - see the *StreamService.getStreamTags()* sample
* [GET all stream tags](https://dev.twitch.tv/docs/api/reference#get-all-stream-tags)
    - see the *StreamService.getStreamTags()* sample
* [PUT replace stream tags](https://dev.twitch.tv/docs/api/reference#replace-stream-tags)
    - see the *StreamService.updateStreamTags()* sample
      
# Package com.github.frozencure.subscriptions

# Subscriptions

This package contains the implementation for accessing the following endpoints: 
* [GET subscriptions](https://dev.twitch.tv/docs/api/reference#get-broadcaster-subscriptions)
    - see the *SubscriptionService.getSubscriptions()* sample

# Package com.github.frozencure.users

# Users

This package contains the implementation for accessing the following endpoints: 
* [GET users](https://dev.twitch.tv/docs/api/reference#get-users)
    - see the *UserService.getUsers()* sample 
* [GET users follows](https://dev.twitch.tv/docs/api/reference#get-users-follows)
    - see the *UserService.getUserFollowers()* sample
* [PUT update user](https://dev.twitch.tv/docs/api/reference#update-user)
    - see the *UserService.updateUserDescription()* sample 
* [GET user extensions](https://dev.twitch.tv/docs/api/reference#get-user-extensions)
    - see the *UserService.getUserExtensions()* sample 
* [GET user active extensions](https://dev.twitch.tv/docs/api/reference#get-user-active-extensions)
    - see the *UserService.getUserActiveExtensions()* sample
* [PUT update user extensions](https://dev.twitch.tv/docs/api/reference#update-user-extensions)
    - see the *UserService.updateActiveUserExtensions()* sample 
* [POST create user follow](https://dev.twitch.tv/docs/api/reference#create-user-follows)
    - see the *UserService.createFollow()* sample 
* [DELETE user follow](https://dev.twitch.tv/docs/api/reference#delete-user-follows)
    - see the *UserService.deleteFollow()* sample 

# Package com.github.frozencure.videos

# Videos

This package contains the implementation for accessing the following endpoints: 
* [GET videos](https://dev.twitch.tv/docs/api/reference#get-videos)
    - see the *VideoService.getVideos()* sample

# Package com.github.frozencure.webhook

# Webhooks

This package contains the implementation for accessing the following endpoints: 
* [GET webhooks](https://dev.twitch.tv/docs/api/reference#get-webhook-subscriptions)
    - see the *WebhookService.getSubscriptions()* sample



