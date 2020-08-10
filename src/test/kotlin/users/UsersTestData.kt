package users


object UsersTestData {

    const val SINGLE_USER_WITH_EMAIL = """
            {
              "data": [{
                "id": "44322889",
                "login": "dallas",
                "display_name": "dallas",
                "type": "staff",
                "broadcaster_type": "",
                "description": "Just a gamer playing games and chatting. :)",
                "profile_image_url": "https://static-cdn.jtvnw.net/jtv_user_pictures/dallas-profile_image-1a2c906ee2c35f12-300x300.png",
                "offline_image_url": "https://static-cdn.jtvnw.net/jtv_user_pictures/dallas-channel_offline_image-1a2c906ee2c35f12-1920x1080.png",
                "view_count": 191836881,
                "email": "login@provider.com"
              }]
            }
        """

    const val SINGLE_USER = """
            {
              "data": [{
                "id": "44322889",
                "login": "dallas",
                "display_name": "dallas",
                "type": "staff",
                "broadcaster_type": "",
                "description": "Just a gamer playing games and chatting. :)",
                "profile_image_url": "https://static-cdn.jtvnw.net/jtv_user_pictures/dallas-profile_image-1a2c906ee2c35f12-300x300.png",
                "offline_image_url": "https://static-cdn.jtvnw.net/jtv_user_pictures/dallas-channel_offline_image-1a2c906ee2c35f12-1920x1080.png",
                "view_count": 191836881
              }]
            }
        """

    const val MULTIPLE_USERS = """
            {
              "data": [{
                "id": "44322889",
                "login": "dallas",
                "display_name": "dallas",
                "type": "staff",
                "broadcaster_type": "",
                "description": "Just a gamer playing games and chatting. :)",
                "profile_image_url": "https://static-cdn.jtvnw.net/jtv_user_pictures/dallas-profile_image-1a2c906ee2c35f12-300x300.png",
                "offline_image_url": "https://static-cdn.jtvnw.net/jtv_user_pictures/dallas-channel_offline_image-1a2c906ee2c35f12-1920x1080.png",
                "view_count": 191836881
              },
              {
                "id": "54232423",
                "login": "user_2",
                "display_name": "user_2",
                "type": "staff",
                "broadcaster_type": "partner",
                "description": "Just a gamer playing games and chatting. :)",
                "profile_image_url": "https://static-cdn.jtvnw.net/jtv_user_pictures/dallas-profile_image-1a2c906ee2c35f12-300x300.png",
                "offline_image_url": "https://static-cdn.jtvnw.net/jtv_user_pictures/dallas-channel_offline_image-1a2c906ee2c35f12-1920x1080.png",
                "view_count": 191836881
              }]
            }
        """

    const val MULTIPLE_USERS_WITH_PAGINATION =
        """
            {
              "data": [{
                "id": "44322889",
                "login": "dallas",
                "display_name": "dallas",
                "type": "staff",
                "broadcaster_type": "",
                "description": "Just a gamer playing games and chatting. :)",
                "profile_image_url": "https://static-cdn.jtvnw.net/jtv_user_pictures/dallas-profile_image-1a2c906ee2c35f12-300x300.png",
                "offline_image_url": "https://static-cdn.jtvnw.net/jtv_user_pictures/dallas-channel_offline_image-1a2c906ee2c35f12-1920x1080.png",
                "view_count": 191836881
              },
              {
                "id": "54232423",
                "login": "user_2",
                "display_name": "user_2",
                "type": "staff",
                "broadcaster_type": "partner",
                "description": "Just a gamer playing games and chatting. :)",
                "profile_image_url": "https://static-cdn.jtvnw.net/jtv_user_pictures/dallas-profile_image-1a2c906ee2c35f12-300x300.png",
                "offline_image_url": "https://static-cdn.jtvnw.net/jtv_user_pictures/dallas-channel_offline_image-1a2c906ee2c35f12-1920x1080.png",
                "view_count": 191836881
              }],
              "pagination":{
                            "cursor": "eyJiIjpudWxsLCJhIjoiMTUwMzQ0MTc3NjQyNDQyMjAwMCJ9"
                        }
            }
        """

    const val USER_FOLLOWERS = """{
                            "total": 12345,
                            "data":
                            [
                                {
                                    "from_id": "171003792",
                                    "from_name": "IIIsutha067III",
                                    "to_id": "23161357",
                                    "to_name": "LIRIK",
                                    "followed_at": "2017-08-22T22:55:24Z"
                                },
                                {
                                    "from_id": "113627897",
                                    "from_name": "Birdman616",
                                    "to_id": "23161357",
                                    "to_name": "LIRIK",
                                    "followed_at": "2017-08-22T22:55:04Z"
                                }
                            ],
                            "pagination":{
                            "cursor": "eyJiIjpudWxsLCJhIjoiMTUwMzQ0MTc3NjQyNDQyMjAwMCJ9"
                        }
                        }"""

    const val USER_EXTENSIONS = """
        {
          "data": [
            {
              "id": "wi08ebtatdc7oj83wtl9uxwz807l8b",
              "version": "1.1.8",
              "name": "Streamlabs Leaderboard",
              "can_activate": true,
              "type": [
                "panel"
              ]
            },
            {
              "id": "d4uvtfdr04uq6raoenvj7m86gdk16v",
              "version": "2.0.2",
              "name": "Prime Subscription and Loot Reminder",
              "can_activate": true,
              "type": [
                "overlay"
              ]
            },
            {
              "id": "rh6jq1q334hqc2rr1qlzqbvwlfl3x0",
               "version": "1.1.0",
              "name": "TopClip",
              "can_activate": true,
              "type": [
                "mobile",
                "panel"
              ]
            },
            {
              "id": "zfh2irvx2jb4s60f02jq0ajm8vwgka",
              "version": "1.0.19",
              "name": "Streamlabs",
              "can_activate": true,
              "type": [
                "mobile",
                "overlay"
              ]
            },
            {
              "id": "lqnf3zxk0rv0g7gq92mtmnirjz2cjj",
              "version": "0.0.1",
              "name": "Dev Experience Test",
              "can_activate": true,
              "type": [
                "component",
                "mobile",
                "panel",
                "overlay"
              ]
            }
          ]
        }
    """

    const val USER_ACTIVE_EXTENSIONS = """
    {   
        "data": {
            "panel": {
                "1": {
                    "active": true,
                    "id": "rh6jq1q334hqc2rr1qlzqbvwlfl3x0",
                    "version": "1.1.0",
                    "name": "TopClip"
                },
                "2": {
                    "active": true,
                    "id": "wi08ebtatdc7oj83wtl9uxwz807l8b",
                    "version": "1.1.8",
                    "name": "Streamlabs Leaderboard"
                },
                "3": {
                    "active": true,
                    "id": "naty2zwfp7vecaivuve8ef1hohh6bo",
                    "version": "1.0.9",
                    "name": "Streamlabs Stream Schedule & Countdown"
                }
            },
            "overlay": {
                "1": {
                    "active": true,
                    "id": "zfh2irvx2jb4s60f02jq0ajm8vwgka",
                    "version": "1.0.19",
                    "name": "Streamlabs"
                }
            },
            "component": {
                "1": {
                    "active": true,
                    "id": "lqnf3zxk0rv0g7gq92mtmnirjz2cjj",
                    "version": "0.0.1",
                    "name": "Dev Experience Test",
                    "x": 0,
                    "y": 0
                },
                "2": {
                    "active": false
                }
            }
        }
    }
    """

    const val USER_ACTIVE_EXTENSIONS_WITHOUT_WRAPPER = """
    {
            "panel": {
                "1": {
                    "active": true,
                    "id": "rh6jq1q334hqc2rr1qlzqbvwlfl3x0",
                    "version": "1.1.0",
                    "name": "TopClip"
                },
                "2": {
                    "active": true,
                    "id": "wi08ebtatdc7oj83wtl9uxwz807l8b",
                    "version": "1.1.8",
                    "name": "Streamlabs Leaderboard"
                },
                "3": {
                    "active": true,
                    "id": "naty2zwfp7vecaivuve8ef1hohh6bo",
                    "version": "1.0.9",
                    "name": "Streamlabs Stream Schedule & Countdown"
                }
            },
            "overlay": {
                "1": {
                    "active": true,
                    "id": "zfh2irvx2jb4s60f02jq0ajm8vwgka",
                    "version": "1.0.19",
                    "name": "Streamlabs"
                }
            },
            "component": {
                "1": {
                    "active": true,
                    "id": "lqnf3zxk0rv0g7gq92mtmnirjz2cjj",
                    "version": "0.0.1",
                    "name": "Dev Experience Test",
                    "x": 0,
                    "y": 0
                },
                "2": {
                    "active": false
                }
            }
    }
    """


}