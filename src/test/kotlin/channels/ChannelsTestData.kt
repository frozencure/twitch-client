package channels

object ChannelsTestData {
    const val MULTIPLE_CHANNELS_WITH_PAGINATION = """
    {
        "data": [
            {
              "broadcaster_language": "en",
              "display_name": "loserfruit",
              "game_id": "498000",
              "id": "41245072",
              "is_live": false,
              "tag_ids": [],
              "thumbnail_url": "https://static-cdn.jtvnw.net/jtv_user_pictures/fd17325a-7dc2-46c6-8617-e90ec259501c-profile_image-300x300.png",
              "title": "loserfruit",
              "started_at": ""
            },
            {
              "broadcaster_language": "en",
              "display_name": "lirik",
              "game_id": "498000",
              "id": "41245072",
              "is_live": true,
              "tag_ids": ["6ea6bca4-4712-4ab9-a906-e3336a9d8039"],
              "thumbnail_url": "https://static-cdn.jtvnw.net/jtv_user_pictures/fd17325a-7dc2-46c6-8617-e90ec259501c-profile_image-300x300.png",
              "title": "loserfruit",
              "started_at": "2018-08-20T20:10:03Z"
            }
        ],
        "pagination": {
            "cursor": "Mg=="
        }
    }
    """


    const val HYPE_TRAIN_EVENTS_WITH_PAGINATION = """
    {
        "data": [
            {
              "id": "1b0AsbInCHZW2SQFQkCzqN07Ib2",
              "event_type": "hypetrain.progression",
              "event_timestamp": "2020-04-24T20:07:24Z",
              "version": "1.0",
              "event_data": {
                "broadcaster_id": "270954519",
                "cooldown_end_time": "2020-04-24T20:13:21.003802269Z",
                "expires_at": "2020-04-24T20:12:21.003802269Z",
                "goal": 1800,
                "id": "70f0c7d8-ff60-4c50-b138-f3a352833b50",
                "last_contribution": {
                  "total": 200,
                  "type": "BITS",
                  "user": "134247454"
                },
                "level": 2,
                "started_at": "2020-04-24T20:05:47.30473127Z",
                "top_contributions": [
                  {
                    "total": 600,
                    "type": "BITS",
                    "user": "134247450"
                  }
                ],
                "total": 600
              }
            }
        ],
        "pagination": {
            "cursor": "eyJiIjpudWxsLCJhIjp7IkN1cnNvciI6IjI3MDk1NDUxOToxNTg3NzU4ODQ0OjFiMEFzYkluQ0haVzJTUUZRa0N6cU4wN0liMiJ9fQ"
        }
    }
    """


    const val COMMERCIAL = """
    {
        "data": [{
            "length" : 60,
            "message" : "",
            "retry_after" : 480
        }]
    }
    """
}