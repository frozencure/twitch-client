package webhook

object WebhooksTestData {


    const val WEBHOOK_SUBSCRIPTIONS = """
                {
           "total": 12,
           "data": [
               {
                   "topic": "https://api.twitch.tv/helix/streams?user_id=123",
                   "callback": "http://example.com/your_callback",
                   "expires_at": "2018-07-30T20:00:00Z"
               },
               {
                   "topic": "https://api.twitch.tv/helix/streams?user_id=345",
                   "callback": "http://example.com/your_callback",
                   "expires_at": "2018-07-30T20:03:00Z"
               }
           ],
           "pagination": {
               "cursor": "eyJiIjpudWxsLCJhIjp7IkN1cnNvciI6IkFYc2laU0k2TVN3aWFTSTZNWDAifX0"
           }
        }
    """

}