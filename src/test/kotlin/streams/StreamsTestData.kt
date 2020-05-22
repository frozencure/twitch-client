package streams

object StreamsTestData {


    const val SINGLE_STREAM_MARKER = """
    {
        "data": [
                {
                    "id": "106b8d6243a4f883d25ad75e6cdffdc4",
                    "created_at": "2018-08-20T20:10:03Z",
                    "description": "hello, this is a marker!",
                    "position_seconds": 244
                }
        ]
    }
    """

    const val MULTIPLE_STREAMS_WITH_PAGINATION = """
    {
        "data": [
                    {
                      "id": "123",
                      "user_id": "23161357",
                      "user_name": "LIRIK",
                      "game_id": "417752",
                      "type": "live",
                      "title": "Hey Guys, It's Monday - Twitter: @Lirik",
                      "viewer_count": 32575,
                      "started_at": "2017-08-14T16:08:32Z",
                      "language": "en",
                      "thumbnail_url": "https://static-cdn.jtvnw.net/previews-ttv/live_user_lirik-{width}x{height}.jpg",
                      "tag_ids":  [
                            "6ea6bca4-4712-4ab9-a906-e3336a9d8039"
                        ]
                    },
                    {
                      "id": "1234",
                      "user_id": "23161357",
                      "user_name": "LIRIK",
                      "game_id": "417752",
                      "type": "live",
                      "title": "Hey Guys, It's Monday - Twitter: @Lirik",
                      "viewer_count": 32575,
                      "started_at": "2017-08-14T16:08:32Z",
                      "language": "en",
                      "thumbnail_url": "https://static-cdn.jtvnw.net/previews-ttv/live_user_lirik-{width}x{height}.jpg",
                      "tag_ids":  [
                            "6ea6bca4-4712-4ab9-a906-e3336a9d8039"
                        ]
                    }

        ],
        "pagination": {
            "cursor": "eyJiIjpudWxsLCJhIjp7Ik9mZnNldCI6MjB9fQ=="
        }
    }
    """

    const val USER_STREAM_MARKERS_WITH_PAGINATION = """
    {
        "data": [
                    {
                      "user_id": "123",
                      "user_name": "Display Name",
                      "videos": [
                        {
                          "video_id": "456",
                          "markers": [
                            {
                              "id": "106b8d6243a4f883d25ad75e6cdffdc4",
                              "created_at": "2018-08-20T20:10:03Z",
                              "description": "hello, this is a marker!",
                              "position_seconds": 244,
                              "URL": "https://twitch.tv/videos/456?t=0h4m06s"
                            },
                            {
                              "id": "106b8d6243a4f883d25ad75e6cdffdc4",
                              "created_at": "2018-08-20T20:10:03Z",
                              "description": "hello, this is a marker!",
                              "position_seconds": 244,
                              "URL": "https://twitch.tv/videos/456?t=0h4m06s"
                            }
                          ]
                        }
                      ]
                    }
        ],
        "pagination": {
            "cursor": "eyJiIjpudWxsLCJhIjoiMjk1MjA0Mzk3OjI1Mzpib29rbWFyazoxMDZiOGQ1Y"
        }
    }
    """

    const val OVERWATCH_STREAM_METADATA = """
    {
        "data": [
            {
              "user_id": "23161357",
              "user_name": "LIRIK",
              "game_id": "488552",
              "overwatch": {
                "broadcaster": {
                  "hero": {
                    "role": "Offense",
                    "name": "Soldier 76",
                    "ability": "Heavy Pulse Rifle"
                  }
                }
              },
              "hearthstone": null
            }
        ]
    }
    """

    const val HEARTHSTONE_STREAM_METADATA = """
    {
        "data": [
            {
              "user_id": "1564968",
              "user_name": "OnlyATest",
              "game_id": "138585",
              "overwatch": null,
              "hearthstone": {
                "broadcaster": {
                  "hero": {
                    "type": "Classic hero",
                    "class": "Shaman",
                    "name": "Thrall"
                  }
                },
                "opponent": {
                  "hero": {
                    "type": "Classic hero",
                    "class": "Warrior",
                    "name": "Garrosh Hellscream"
                  }
                }
              }
            }
        ]
    }
        """

    const val EMPTY_STREAM_METADATA = """
    {
        "data": [
            {
              "user_id": "5848726",
              "user_name": "FooBar",
              "game_id": null,
              "overwatch": null,
              "hearthstone": null
            }
        ]
    }
    """

    const val MULTIPLE_STREAMS_METADATA_WITH_PAGINATION = """
    {
        "data": [
            {
              "user_id": "23161357",
              "user_name": "LIRIK",
              "game_id": "488552",
              "overwatch": {
                "broadcaster": {
                  "hero": {
                    "role": "Offense",
                    "name": "Soldier 76",
                    "ability": "Heavy Pulse Rifle"
                  }
                }
              },
              "hearthstone": null
            },
            {
              "user_id": "1564968",
              "user_name": "OnlyATest",
              "game_id": "138585",
              "overwatch": null,
              "hearthstone": {
                "broadcaster": {
                  "hero": {
                    "type": "Classic hero",
                    "class": "Shaman",
                    "name": "Thrall"
                  }
                },
                "opponent": {
                  "hero": {
                    "type": "Classic hero",
                    "class": "Warrior",
                    "name": "Garrosh Hellscream"
                  }
                }
              }
            },
            {
              "user_id": "5848726",
              "user_name": "FooBar",
              "game_id": null,
              "overwatch": null,
              "hearthstone": null
            }
        ],
        "pagination": {
            "cursor": "eyJiIjpudWxsLCJhIjp7Ik9mZnNldCI6MjB9fQ=="
        }
    }
    """


}