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
    const val MULTIPLE_STREAM_TAGS_WITH_PAGINATION = """
    {
        "data": [
                {
                    "tag_id": "621fb5bf-5498-4d8f-b4ac-db4d40d401bf",
                    "is_auto": false,
                    "localization_names": {
                        "bg-bg": "Изчистване на 1 кредит",
                        "cs-cz": "1 čistý kredit",
                        "da-dk": "1 credit klaret",
                        "de-de": "Mit 1 Leben abschließen",
                        "el-gr": "1 μόνο πίστωση",
                        "en-us": "1 Credit Clear",
                        "es-es": "Sin continuaciones",
                        "es-mx": "Completar con 1 crédito",
                        "fi-fi": "Läpäisy ilman jatkamisia",
                        "fr-fr": "1 seul continue",
                        "hu-hu": "1 kredit rendben",
                        "it-it": "Completamento con un solo tentativo",
                        "ja-jp": "1クレジットクリア",
                        "ko-kr": "원코인 클리어",
                        "nl-nl": "Voltooien met 1 credit",
                        "no-no": "Fullført på ett forsøk",
                        "pl-pl": "Za 1 kredyt",
                        "pt-br": "Zerado com 1 crédito",
                        "pt-pt": "Terminar em 1 crédito",
                        "ro-ro": "1 credit eliminat",
                        "ru-ru": "Прохождение с одной попытки",
                        "sk-sk": "1 čistý kredit",
                        "sv-se": "Klara utan att använda Continue",
                        "th-th": "เล่นจบด้วย 1 เครดิต",
                        "tr-tr": "Tek Kredi Yeter",
                        "vi-vn": "Chơi thắng chỉ cần 1 xèng",
                        "zh-cn": "一命通关",
                        "zh-tw": "一命通關"
                    },
                    "localization_descriptions": {
                        "bg-bg": "За потоци с акцент върху завършване на аркадна игра с монети, в която не се използва продължаване",
                        "cs-cz": "Pro vysílání s důrazem na plnění mincových arkádových her bez použití pokračování.",
                        "da-dk": "Til streams med vægt på at gennemføre et arkadespil uden at bruge continues",
                        "de-de": "Für Streams mit dem Ziel, ein Coin-op-Arcade-Game mit nur einem Leben abzuschließen.",
                        "el-gr": "Για μεταδόσεις με έμφαση στην ολοκλήρωση παλαιού τύπου ηλεκτρονικών παιχνιδιών που λειτουργούν με κέρμα, χωρίς να χρησιμοποιούν συνέχειες",
                        "en-us": "For streams with an emphasis on completing a coin-op arcade game without using any continues",
                        "es-es": "Para transmisiones centradas en completar un juego arcade de monedas sin usar continuaciones.",
                        "es-mx": "Para streams centrados en completar un juego de arcade operado con monedas sin usar ningún continuar.",
                        "fi-fi": "Lähetyksille, joissa pyritään läpäisemään kolikkopeli käyttämättä jatkamismahdollisuutta.",
                        "fr-fr": "Pour les streams dont l’objet principal est de terminer un jeu d’arcade sans utiliser le moindre Continue",
                        "hu-hu": "Pénzbedobós játéktermi játékok folytatás nélküli teljesítésével kapcsolatos közvetítésekhez",
                        "it-it": "Per streaming in cui si gioca cercando di completare un gioco arcade con un solo credito",
                        "ja-jp": "コイン投入式のアーケードゲームを、コンティニューを使用せずにクリアすることを主眼とする配信に使われます",
                        "ko-kr": "동전 투입식 아케이드 게임에서 이어 하기를 사용하지 않고 완료하는 걸 주로 다루는 방송",
                        "nl-nl": "Voor streams met een nadruk op het voltooien van een speelhalgame, zonder gebruik te maken van \"continues\"",
                        "no-no": "For kringkastinger med en fokus på fullføring av arkadespill uten bruk av flere forsøk (Continues)",
                        "pl-pl": "Dla streamów skupiających się na ukończeniu automatowej gry zręcznościowej bez korzystania z możliwości kontynuacji",
                        "pt-br": "Para transmissões focadas na conclusão de um título de fliperama com ficha sem o uso de qualquer continue.",
                        "pt-pt": "Para transmissões com ênfase em completar um jogo de arcada a moedas sem usar nenhum \"continue\".",
                        "ro-ro": "Pentru redări în flux cu accent pe terminarea unui joc mecanic cu fise fără a folosi continuarea",
                        "ru-ru": "Трансляции, во время которых стример старается пройти игру на жетонном аркадном автомате с одной попытки",
                        "sk-sk": "Pre streamy s dôrazom na dokončenie mincovej arkádovej hry bez použitia \"pokračovaní\"",
                        "sv-se": "För streamar med fokus på att klara ett arkadspel med myntinkast utan att använda continues",
                        "th-th": "สำหรับสตรีมที่ให้ความสำคัญกับการเล่นเกมตู้หยอดเหรียญจนจบโดยไม่คอนทินิวเลย",
                        "tr-tr": "Jetonlu bir arkad oyununu tek jetonla tamamlamak için oynamaya odaklı yayınlar için",
                        "vi-vn": "Dành cho chương trình truyền trực tiếp nhấn mạnh vào việc hoàn thành một game giải trí trên máy nạp xu mà không cần sử dụng lượt chơi tiếp theo",
                        "zh-cn": "直播内容主要是以不续关为目标完成投币式街机游戏通关",
                        "zh-tw": "以不續關就完成投幣式街機遊戲通關為目標的實況"
                    }
                },
                {
                    "tag_id": "7b49f69a-5d95-4c94-b7e3-66e2c0c6f6c6",
                    "is_auto": false,
                    "localization_names": {
                        "bg-bg": "Дизайн",
                        "cs-cz": "Design",
                        "da-dk": "Design",
                        "de-de": "Design",
                        "el-gr": "Σχέδιο",
                        "en-us": "Design",
                        "es-es": "Diseño",
                        "es-mx": "Diseño",
                        "fi-fi": "Suunnittelu",
                        "fr-fr": "Design",
                        "hu-hu": "Dizájn",
                        "it-it": "Progettazione",
                        "ja-jp": "デザイン",
                        "ko-kr": "디자인",
                        "nl-nl": "Ontwerpen",
                        "no-no": "Design",
                        "pl-pl": "Projektowanie",
                        "pt-br": "Design",
                        "pt-pt": "Design",
                        "ro-ro": "Aspect",
                        "ru-ru": "Дизайн",
                        "sk-sk": "Dizajn",
                        "sv-se": "Design",
                        "th-th": "ออกแบบ",
                        "tr-tr": "Tasarım",
                        "vi-vn": "Thiết kế",
                        "zh-cn": "设计",
                        "zh-tw": "設計"
                    },
                    "localization_descriptions": {
                        "bg-bg": "За потоци с акцент върху креативния процес по проектирането на обект или система",
                        "cs-cz": "Pro vysílání s důrazem na kreativní proces designu předmětu či systému.",
                        "da-dk": "Til streams med vægt på den kreative proces i at designe et objekt eller system.",
                        "de-de": "Für Streams mit dem Schwerpunkt auf dem kreativen Prozess bei der Erstellung eines Objekts oder Systems.",
                        "el-gr": "Για μεταδόσεις με έμφαση στη δημιουργική διαδικασία της σχεδίασης αντικειμένων ή συστημάτων",
                        "en-us": "For streams with an emphasis on the creative process of designing an object or system",
                        "es-es": "Para transmisiones centradas en el proceso creativo de diseñar un objeto o sistema.",
                        "es-mx": "Para streams centrados en el proceso creativo de diseñar un objeto o sistema.",
                        "fi-fi": "Lähetyksille, joissa keskitytään esineen tai järjestelmän kehittämisen luomisprosessiin.",
                        "fr-fr": "Pour les streams dont l’objet principal est le processus créatif de conception d’un objet ou d’un système",
                        "hu-hu": "Tárgy vagy rendszer megtervezéséről szóló közvetítésekhez",
                        "it-it": "Per streaming dedicati al processo creativo dietro alla creazione di un oggetto o di un sistema",
                        "ja-jp": "何らかの物やシステムのデザインにおける創造的なプロセスを主に扱う配信に使われます",
                        "ko-kr": "물건이나 시스템 설계의 창의적 과정을 주로 다루는 방송",
                        "nl-nl": "Voor streams met een nadruk op het creatieve proces van het ontwerpen van een object of systeem",
                        "no-no": "For kringkastinger med en fokus på den kreative prosessen bak det å designe et objekt eller et system.",
                        "pl-pl": "Dla streamów skupiających się na kreatywnym procesie projektowania obiektów lub systemów.",
                        "pt-br": "Para transmissões focadas no processo criativo da elaboração de objetos ou sistemas.",
                        "pt-pt": "Para transmissões com ênfase no processo criativo relacionado com o design de um objeto ou sistema.",
                        "ro-ro": "Pentru redări în flux cu accent pe procesul de creație privind proiectarea unui obiect sau sistem",
                        "ru-ru": "Трансляции, посвящённые творческому процессу создания объекта или системы",
                        "sk-sk": "Pre streamy s dôrazom na kreatívny proces dizajnovania objektu alebo systému",
                        "sv-se": "För streamar med fokus på den kreativa processen att designa ett föremål eller system",
                        "th-th": "สำหรับสตรีมที่ให้ความสำคัญกับการสร้างสรรค์การออกแบบวัตถุหรือระบบ",
                        "tr-tr": "Bir nesne veya sistemin tasarlanmasındaki yaratıcı süreçlere odaklı yayınlar için",
                        "vi-vn": "Dành cho chương trình truyền trực tiếp nhấn mạnh vào quá trình sáng tạo để thiết kế một vật thể hoặc hệ thống",
                        "zh-cn": "直播内容主要是关于物品设计或系统设计的创造性过程",
                        "zh-tw": "以設計物品或系統的創意過程為主題的實況"
                    }
                }
        ],
        "pagination": {
            "cursor": "eyJiIjpudWxsLCJhIjp7IkN1cnNvciI6ImV5SnBaQ0k2ZXlKQ0lqcHVkV3hzTENKQ1QwOU1JanB1ZFd4c0xDSkNVeUk2Ym5Wc2JDd2lUQ0k2Ym5Wc2JDd2lUU0k2Ym5Wc2JDd2lUaUk2Ym5Wc2JDd2lUbE1pT201MWJHd3NJazVWVEV3aU9tNTFiR3dzSWxNaU9pSTVORFkwTVRFM09DMHhOV0ZsTFRRME9UVXRZall3WWkweE5tVmtNbVprTldObFpEQWlMQ0pUVXlJNmJuVnNiSDE5In19"
        }
    }
    """

}