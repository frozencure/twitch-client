package clips

object ClipsTestData {

    const val SINGLE_CLIP = """
        {
            "data": [
                {
                  "id": "AwkwardHelplessSalamanderSwiftRage",
                  "url": "https://clips.twitch.tv/AwkwardHelplessSalamanderSwiftRage",
                  "embed_url": "https://clips.twitch.tv/embed?clip=AwkwardHelplessSalamanderSwiftRage",
                  "broadcaster_id": "67955580",
                  "broadcaster_name": "ChewieMelodies",
                  "creator_id": "53834192",
                  "creator_name": "BlackNova03",
                  "video_id": "205586603",
                  "game_id": "488191",
                  "language": "en",
                  "title": "babymetal",
                  "view_count": 10,
                  "created_at": "2017-11-30T22:34:18Z",
                  "thumbnail_url": "https://clips-media-assets.twitch.tv/157589949-preview-480x272.jpg"
                }
            ]
        }
    """

    const val MULTIPLE_CLIPS = """
    {
        "data": [
            {
              "id":"RandomClip1",
              "url":"https://clips.twitch.tv/AwkwardHelplessSalamanderSwiftRage",
              "embed_url":"https://clips.twitch.tv/embed?clip=RandomClip1",
              "broadcaster_id":"1234",
              "broadcaster_name": "JJ",
              "creator_id":"123456",
              "creator_name": "MrMarshall",
              "video_id":"1234567",
              "game_id":"33103",
              "language":"en",
              "title":"random1",
              "view_count":10,
              "created_at":"2017-11-30T22:34:18Z",
              "thumbnail_url":"https://clips-media-assets.twitch.tv/157589949-preview-480x272.jpg"
            },
            {
              "id":"RandomClip2",
              "url":"https://clips.twitch.tv/AwkwardHelplessSalamanderPogChamp",
              "embed_url":"https://clips.twitch.tv/embed?clip=RandomClip2",
              "broadcaster_id":"1234",
              "broadcaster_name": "JJ",
              "creator_id":"123456",
              "creator_name": "MrMarshall",
              "video_id":"1234567",
              "game_id":"33103",
              "language":"en",
              "title":"random2",
              "view_count":10,
              "created_at":"2017-11-30T22:34:18Z",
              "thumbnail_url":"https://clips-media-assets.twitch.tv/157589949-preview-480x272.jpg"
            }
        ]
    }
    """

    const val MULTIPLE_CLIPS_WITH_PAGINATION = """
    {
        "data": [
            {
              "id":"RandomClip1",
              "url":"https://clips.twitch.tv/AwkwardHelplessSalamanderSwiftRage",
              "embed_url":"https://clips.twitch.tv/embed?clip=RandomClip1",
              "broadcaster_id":"1234",
              "broadcaster_name": "JJ",
              "creator_id":"123456",
              "creator_name": "MrMarshall",
              "video_id":"1234567",
              "game_id":"33103",
              "language":"en",
              "title":"random1",
              "view_count":10,
              "created_at":"2017-11-30T22:34:18Z",
              "thumbnail_url":"https://clips-media-assets.twitch.tv/157589949-preview-480x272.jpg"
            },
            {
              "id":"RandomClip2",
              "url":"https://clips.twitch.tv/AwkwardHelplessSalamanderPogChamp",
              "embed_url":"https://clips.twitch.tv/embed?clip=RandomClip2",
              "broadcaster_id":"1234",
              "broadcaster_name": "JJ",
              "creator_id":"123456",
              "creator_name": "MrMarshall",
              "video_id":"1234567",
              "game_id":"33103",
              "language":"en",
              "title":"random2",
              "view_count":10,
              "created_at":"2017-11-30T22:34:18Z",
              "thumbnail_url":"https://clips-media-assets.twitch.tv/157589949-preview-480x272.jpg"
            }
        ],
        "pagination": {
            "cursor": "eyJiIjpudWxsLCJhIjoiIn0"
        }
    }
    """


}