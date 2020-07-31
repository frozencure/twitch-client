package moderation

object ModerationTestData {

    const val AUTO_MOD = """
    {
        "data": [
            {
              "msg_id": "1",
              "is_permitted": true
            },
            {
              "msg_id": "2",
              "is_permitted": false
            }
        ]
    }
    """

    const val BANNED_USERS_WITH_CURSOR = """
    {
        "data": [
            {
              "user_id": "423374343",
              "user_name": "glowillig",
              "expires_at": "2019-03-15T02:00:28Z"
            },
            {
              "user_id": "424596340",
              "user_name": "quotrok",
              "expires_at": "2018-08-07T02:07:55Z"
            }
        ],
        "pagination": {
            "cursor": "eyJiIjpudWxsLCJhIjp7IkN1cnNvciI6IjEwMDQ3MzA2NDo4NjQwNjU3MToxSVZCVDFKMnY5M1BTOXh3d1E0dUdXMkJOMFcifX0"
        }
    }
    """

    const val BAN_EVENTS_WITH_CURSOR = """
    {
        "data": [
            {
              "id": "1IPFqAb0p0JncbPSTEPhx8JF1Sa",
              "event_type": "moderation.user.ban",
              "event_timestamp": "2019-03-13T15:55:14Z",
              "version": "1.0",
              "event_data": {
                "broadcaster_id": "198704263",
                "broadcaster_name": "aan22209",
                "user_id": "424596340",
                "user_name": "quotrok",
                "expires_at": "2019-03-13T15:55:19Z"
              }
            },
            {
              "id": "1IPFsDv5cs4mxfJ1s2O9Q5flf4Y",
              "event_type": "moderation.user.unban",
              "event_timestamp": "2019-03-13T15:55:30Z",
              "version": "1.0",
              "event_data": {
                "broadcaster_id": "198704263",
                "broadcaster_name": "aan22209",
                "user_id": "424596341",
                "user_name": "quotrok",
                "expires_at": "2019-03-13T15:55:19Z"
              }
            },
            {
              "id": "1IPFqmlu9W2q4mXXjULyM8zX0rb",
              "event_type": "moderation.user.ban",
              "event_timestamp": "2019-03-13T15:55:19Z",
              "version": "1.0",
              "event_data": {
                "broadcaster_id": "198704263",
                "broadcaster_name": "aan22209",
                "user_id": "424596342",
                "user_name": "quotrok",
                "expires_at": "2019-03-13T15:55:19Z"
              }
            }
        ],
        "pagination": {
            "cursor": "eyJiIjpudWxsLCJhIjp7IkN1cnNvciI6IjE5OTYwNDI2MzoyMDIxMjA1MzE6MUlQRnFtbHU5VzJxNG1YWGpVTHlNOHpYMHJiIn19"
        }
    }
    """

    const val MODERATORS_WITH_CURSOR = """
    {
        "data": [
            {
              "user_id": "424596340",
              "user_name": "quotrok"
            },
            {
              "user_id": "424234562",
              "user_name": "user_2"
            }
        ],
        "pagination": {
            "cursor": "eyJiIjpudWxsLCJhIjp7IkN1cnNvciI6IjEwMDQ3MzA2NDo4NjQwNjU3MToxSVZCVDFKMnY5M1BTOXh3d1E0dUdXMkJOMFcifX0"
        }
    }
    """

    const val MODERATOR_EVENTS_WITH_CURSOR = """
    {
        "data": [
            {
              "id": "1IVBTnDSUDApiBQW4UBcVTK4hPr",
              "event_type": "moderation.moderator.remove",
              "event_timestamp": "2019-03-15T18:18:14Z",
              "version": "1.0",
              "event_data": {
                "broadcaster_id": "198704263",
                "broadcaster_name": "aan22209",
                "user_id": "423374343",
                "user_name": "glowillig"
              }
            },
            {
              "id": "1IVIPQdYIEnD8nJ376qkASDzsj7",
              "event_type": "moderation.moderator.add",
              "event_timestamp": "2019-03-15T19:15:13Z",
              "version": "1.0",
              "event_data": {
                "broadcaster_id": "198704263",
                "broadcaster_name": "aan22209",
                "user_id": "423374344",
                "user_name": "glowillig"
              }
            },
            {
              "id": "1IVBTP7gG61oXLMu7fvnRhrpsro",
              "event_type": "moderation.moderator.remove",
              "event_timestamp": "2019-03-15T18:18:11Z",
              "version": "1.0",
              "event_data": {
                "broadcaster_id": "198704263",
                "broadcaster_name": "aan22209",
                "user_id": "424596345",
                "user_name": "quotrok"
              }
            }
        ],
        "pagination": {
            "cursor": "eyJiIjpudWxsLCJhIjp7IkN1cnNvciI6IjEwMDQ3MzA2NDo4NjQwNjU3MToxSVZCVDFKMnY5M1BTOXh3d1E0dUdXMkJOMFcifX0"
        }
    }
    """


}