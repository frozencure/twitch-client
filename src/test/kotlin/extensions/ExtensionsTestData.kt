package extensions

object ExtensionsTestData {

    const val MULTIPLE_TRANSACTIONS_WITH_PAGINATION = """
    {
        "data": [
            {
               "id": "74c52265-e214-48a6-91b9-23b6014e8041",
               "timestamp": "2019-01-28T04:15:53.325Z",
               "broadcaster_id": "439964613",
               "broadcaster_name": "chikuseuma",
               "user_id": "424596340",
               "user_name": "quotrok",
               "product_type": "BITS_IN_EXTENSION",
               "product_data": {
                     "sku": "testSku100",
                     "cost": {
                          "amount": 100,
                          "type": "bits"
                     },
                     "displayName": "Test Sku",
                     "inDevelopment": false
                }
            },
            {
                "id": "8d303dc6-a460-4945-9f48-59c31d6735cb",
                "timestamp": "2019-01-18T09:10:13.397Z",
                "broadcaster_id": "439964613",
                "broadcaster_name": "chikuseuma"
                "user_id": "439966926",
                "user_name": "liscuit"
                "product_type": "BITS_IN_EXTENSION",
                "product_data": {
                     "sku": "testSku100",
                     "cost": {
                          "amount": 100,
                          "type": "bits"
                     },
                     "displayName": "Test Sku",
                     "inDevelopment": false
                }
            }
        ],
        "pagination": {
            "cursor": "cursorString"
        }
    }
    """


}