package games


object GamesTestData {
    const val SINGLE_GAME = """
            {
              "data":
              [{
                 "id": "493057",
                 "name": "PLAYERUNKNOWN'S BATTLEGROUNDS",
                 "box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/PLAYERUNKNOWN%27S%20BATTLEGROUNDS-{width}x{height}.jpg"
              }]
            }"""


    const val MULTIPLE_GAMES = """
            {
              "data":
              [{
                 "id": "493057",
                 "name": "PLAYERUNKNOWN'S BATTLEGROUNDS",
                 "box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/PLAYERUNKNOWN%27S%20BATTLEGROUNDS-{width}x{height}.jpg"
              },
              {
                 "id": "493242",
                 "name": "League of Legends",
                 "box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/PLAYERUNKNOWN%27S%20BATTLEGROUNDS-{width}x{height}.jpg"
              }]
            }"""

    const val MULTIPLE_GAMES_WITH_PAGINATION = """
            {
              "data":
              [{
                 "id": "493057",
                 "name": "PLAYERUNKNOWN'S BATTLEGROUNDS",
                 "box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/PLAYERUNKNOWN%27S%20BATTLEGROUNDS-{width}x{height}.jpg"
              },
              {
                 "id": "493242",
                 "name": "League of Legends",
                 "box_art_url": "https://static-cdn.jtvnw.net/ttv-boxart/PLAYERUNKNOWN%27S%20BATTLEGROUNDS-{width}x{height}.jpg"
              }],
              "pagination":{"cursor":"eyJiIjpudWxsLCJhIjp7Ik9mZnNldCI6MjB9fQ=="}
            }"""
}