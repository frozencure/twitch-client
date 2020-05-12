package videos

object VideosTestData {

    const val SINGLE_VIDEO = """
            {
              "data": [{
                "id": "234482848",
                "user_id": "67955580",
                "user_name": "ChewieMelodies",
                "title": "-",
                "description": "",
                "created_at": "2018-03-02T20:53:41Z",
                "published_at": "2018-03-02T20:53:41Z",
                "url": "https://www.twitch.tv/videos/234482848",
                "thumbnail_url": "https://static-cdn.jtvnw.net/s3_vods/bebc8cba2926d1967418_chewiemelodies_27786761696_805342775/thumb/thumb0-%{width}x%{height}.jpg",
                "viewable": "public",
                "view_count": 142,
                "language": "en",
                "type": "archive",
                "duration": "3h8m33s"
              }]
            }
            """

    const val MULTIPLE_VIDEOS = """
            {
              "data": [{
                "id": "234482848",
                "user_id": "67955580",
                "user_name": "ChewieMelodies",
                "title": "-",
                "description": "",
                "created_at": "2018-03-02T20:53:41Z",
                "published_at": "2018-03-02T20:53:41Z",
                "url": "https://www.twitch.tv/videos/234482848",
                "thumbnail_url": "https://static-cdn.jtvnw.net/s3_vods/bebc8cba2926d1967418_chewiemelodies_27786761696_805342775/thumb/thumb0-%{width}x%{height}.jpg",
                "viewable": "public",
                "view_count": 142,
                "language": "en",
                "type": "archive",
                "duration": "3h8m33s"
              },
            {
                "id": "234482849",
                "user_id": "67955580",
                "user_name": "ChewieMelodies",
                "title": "-",
                "description": "",
                "created_at": "2018-03-02T20:53:41Z",
                "published_at": "2018-03-02T20:53:41Z",
                "url": "https://www.twitch.tv/videos/234482848",
                "thumbnail_url": "https://static-cdn.jtvnw.net/s3_vods/bebc8cba2926d1967418_chewiemelodies_27786761696_805342775/thumb/thumb0-%{width}x%{height}.jpg",
                "viewable": "public",
                "view_count": 142,
                "language": "en",
                "type": "archive",
                "duration": "3h8m33s"
              }]
            }
            """

    const val GAME_VIDEOS = """
            {
              "data": [{
                "id": "234482848",
                "user_id": "67955580",
                "user_name": "ChewieMelodies",
                "title": "-",
                "description": "",
                "created_at": "2018-03-02T20:53:41Z",
                "published_at": "2018-03-02T20:53:41Z",
                "url": "https://www.twitch.tv/videos/234482848",
                "thumbnail_url": "https://static-cdn.jtvnw.net/s3_vods/bebc8cba2926d1967418_chewiemelodies_27786761696_805342775/thumb/thumb0-%{width}x%{height}.jpg",
                "viewable": "public",
                "view_count": 142,
                "language": "en",
                "type": "archive",
                "duration": "3h8m33s"
              },
            {
                "id": "234482849",
                "user_id": "67955580",
                "user_name": "ChewieMelodies",
                "title": "-",
                "description": "",
                "created_at": "2018-03-02T20:53:41Z",
                "published_at": "2018-03-02T20:53:41Z",
                "url": "https://www.twitch.tv/videos/234482848",
                "thumbnail_url": "https://static-cdn.jtvnw.net/s3_vods/bebc8cba2926d1967418_chewiemelodies_27786761696_805342775/thumb/thumb0-%{width}x%{height}.jpg",
                "viewable": "public",
                "view_count": 142,
                "language": "en",
                "type": "archive",
                "duration": "3h8m33s"
              }],
              "pagination":{"cursor":"eyJiIjpudWxsLCJhIjoiMTUwMzQ0MTc3NjQyNDQyMjAwMCJ9"}
            }
            """


}