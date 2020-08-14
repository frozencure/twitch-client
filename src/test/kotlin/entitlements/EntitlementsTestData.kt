package entitlements

object EntitlementsTestData {

    const val CREATE_ENTITLEMENTS_URL = """
    {
        "data":[
            {
                "url": "https://twitch-ds-vhs-drops-granted-uploads-us-west-2-prod.s3-us-west-2.amazonaws.com/<clientID>/<time>-123456789.json?X-Amz-Algorithm=AWS4-HMAC-SHA256\u0026X-Amz-Credential=<credential>%2Fus-west-2%2Fs3%2Faws4_request\u0026X-Amz-Date=<date>\u0026X-Amz-Expires=900\u0026X-Amz-Security-Token=<token>\u0026X-Amz-SignedHeaders=host\u0026X-Amz-Signature=<signature>"
            }
        ]
    }
    """

    const val CODE_STATUS = """
    {
        "data":[
            {
                "code":"KUHXV-4GXYP-AKAKK",
                "status":"UNUSED"
            },
            {
                "code":"XZDDZ-5SIQR-RT5M3",
                "status":"ALREADY_CLAIMED"
            }
        ]
    }
    """


}