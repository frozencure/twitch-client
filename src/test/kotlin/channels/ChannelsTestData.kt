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
}