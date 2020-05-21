package subscriptions

object SubscriptionsTestData {

    const val SINGLE_SUBSCRIPTION = """
    {
      "data": [
            {
              "broadcaster_id": "123",
              "broadcaster_name": "test_user",
              "is_gift": false,
              "tier": "1000",
              "plan_name": "The Ninjas",
              "user_id": "456",
              "user_name": "test_user2"
            }
        ]
    }
    """

    const val SINGLE_SUBSCRIPTION_WITH_GIFTER = """
    {
      "data": [
            {
              "broadcaster_id": "123",
              "broadcaster_name": "test_user",
              "is_gift": false,
              "gifter_id": "1012",
              "gifter_name": "test_user4",
              "tier": "1000",
              "plan_name": "The Ninjas",
              "user_id": "456",
              "user_name": "test_user2"
            }
        ]
    }
    """

    const val MULTIPLE_SUBSCRIPTIONS = """
        {
      "data": [
            {
              "broadcaster_id": "123",
              "broadcaster_name": "test_user",
              "is_gift": false,
              "tier": "1000",
              "plan_name": "The Ninjas",
              "user_id": "456",
              "user_name": "test_user2"
            },
            {
              "broadcaster_id": "123",
              "broadcaster_name": "test_user",
              "is_gift": false,
              "gifter_id": "1012",
              "gifter_name": "test_user4",
              "tier": "1000",
              "plan_name": "The Ninjas",
              "user_id": "456",
              "user_name": "test_user2"
            }
        ],
        "pagination": {
            "cursor": "xxxx"
        }
    }
    """

}