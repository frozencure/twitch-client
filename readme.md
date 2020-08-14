# Module twitch-client
# Kotlin Twitch API Client

A modern Kotlin library for accessing the newest Twitch Helix API. 

## 1. Getting started

### 1.1 Using only a client ID (without OAuth)


In order to get a client id for your twitch extension follow [this guide](https://dev.twitch.tv/docs/api).

Example of performing a GET user request
```
val credentials = AuthCredentials("<app client id>")
val userService = UserService(credentials)
runBlocking {
    println(userService.getUser("frozencure").resource.toString())
}
```

### 1.2 Using an OAuth token

This library currently supports only the *Implicit OAuth code flow*. It is advised to first go through the [Twitch API reference authentication section](https://dev.twitch.tv/docs/authentication) for a more in depth understanding.

#### 1.2.1 Getting an OAuth token for an user

The first step in the OAuth flow is to register the Twitch user with your app. This means that the user will have to authorize your app to access his private Twitch data or perform requests on his behalf.

Firstly, you will have to create an instance of the `OauthUserTokenRequestModel` class, which has the following fields:

* **clientId** -> your app's client ID
* **redirectURI** -> the URI where the user will be redirected after authorization, you can find it in the Twitch Developer console. It has to be the same as the one mentioned in your Twitch app settings, otherwise the authorization will not work
* **responseType** -> for the implicit OAuth code flow the only available option is "token"
* **scope** -> the scopes that the user will be asked to authorize
* **forceVerify** -> when true, (re)authorization will be required for every single request (optional)
* **state** -> variable used to mitigate CSFR attacks (optional)

Here is an example of a valid `OauthUserTokenRequestModel` instance:
```
val requestModel = OauthUserTokenRequestModel(
    "nsfsgvu4k8h80iq0r7ya4zx1fasfa", // client-id
    "http://localhost", // redirect-URI
    "token", // response type
    AuthScope.values().toList()// scopes
)
```

Next, we will use the `AuthService` to retrieve URL where the user will be directed to login. This can be done in the following way:
```
val authService = AuthService(ApacheEngineConfig())
runBlocking {
        val response = authService.authorizeAppForUser(requestModel)
        println(response)
    }
```

The code snippet from above will return the following response with URL:
```
https://www.twitch.tv/login?client_id=<your client id>&redirect_params=<scopes + other parameters>
```

Next, the user will authorize the app by accepting the requested permissions and logging in to Twitch. After the login completes successfully, he will be redirected to the `redirectURI` mentioned above:
```
http://localhost/#access_token=1abcgtpzp1iwrsiiqlr0tvfvkiawy3&scope=<accepted scopes>&token_type=bearer
```

Inside the redirect URL you will be able to find the OAuth user token.

From now on, you will be able to use this token to make request on the user behalf. For example:
```
val credentials = OAuthCredentials("<OAuth token>", "<app client id>")
val userService = UserService(credentials)
runBlocking {
    println(userService.getUser("frozencure").resource.toString())
}
```

### 1.2.2 OAuth token validation

When using OAuth tokens to perform requests, it is advised to periodically validate the token, to make sure that the user didn't revoke access of the app to his data. The Twitch team mentions that failure of doing this can lead revoking the developer API key or throttling of the application.

The `AuthService` also supports validation:
```
val authService = AuthService(ApacheEngineConfig())
    runBlocking {
        val tokenValidationModel = authService.validateUser("<the auth token>")
        println(tokenValidationModel)
    }
```
This will retrieve the following `TokenValidation` instance:

```
TokenValidation(
    clientId=nyufzabdsf8h80iq0r7ya4zx1fsas7d, userLogin=frozencure, 
    scopes=[ANALYTICS_READ_EXTENSIONS, ANALYTICS_READ_GAMES, BITS_READ, CHANNEL_READ_SUBSCRIPTIONS, ...], userId=83035654, 
    expirationTime=5662299
)
```

### 1.2.3 Revoking a token

To clean up previously obtained access tokens, the `AuthService` offers support for programatically revoking the OAuth tokens:
```
    val authService = AuthService(ApacheEngineConfig())
    runBlocking {
        val response = authService.revokeToken(
            OauthRevokeRequestModel("<client-id>",
            "<auth-token>")
        )
        println(response)
    }
```

### 1.2.4 Getting an app OAuth token

You can simply obtain an app access token by simply calling the `requestAppToken(requestModel: OauthAppTokenRequestModel)` function.
Firstly, you will have to create an instance of the `OauthAppTokenRequestModel` class, which has the following fields:

* **clientId** -> your app's client ID
* **clientSecret** -> your app's secret, can also be found in the Twitch Developer Console
* **scope** -> the scopes that the user will be asked to authorize
* **grantType** -> will always be `client_credentials`

Next, we'll use the `AuthService` to make the request to retrieve the token:

```
val requestModel = OauthAppTokenRequestModel(
        "<client id>",
        "<client secret>",
        AuthScope.values().toList()
    )
    val authService = AuthService(ApacheEngineConfig())
    runBlocking {
        val response = authService.requestAppToken(requestModel)
        println(response)
    }
```


## 2. Currently supported features

### 2.1 Endpoints

* Users
    * GET users :heavy_check_mark:
    * GET followers :heavy_check_mark:
    * POST create user follow :heavy_check_mark:
    * DELETE delete user follow :heavy_check_mark:
    * PUT update user :heavy_check_mark:
    * GET user extensions :heavy_check_mark:
    * GET user active extensions :heavy_check_mark:
    * PUT update user extensions :heavy_check_mark:
* Videos
    * GET videos :heavy_check_mark:
* Clips
    * GET clips :heavy_check_mark:
    * POST create clip :heavy_check_mark:
* Webhooks
    * GET subscriptions :heavy_check_mark:
* Games
    * GET games :heavy_check_mark:
    * GET top games :heavy_check_mark:
    * GET search categories :heavy_check_mark:
* Analytics
    * GET extension analytics :x:
    * GET game analytics :x:
* Bits
    * GET bits leaderboard :heavy_check_mark:
    * GET cheermotes :x:
* Extensions
    * GET extension transactions :heavy_check_mark:
* Entitlements
    * POST Create entitlement grants upload URL :x:
    * GET code status :x:
    * POST redeem code :x:
* Moderation
    * POST check auto-mod status :heavy_check_mark:
    * GET banned events :heavy_check_mark:
    * GET banned users :heavy_check_mark:
    * GET moderators :heavy_check_mark:
    * GET moderator events :heavy_check_mark:
* Streams
    * POST create stream marker :heavy_check_mark:
    * GET streams :heavy_check_mark:
    * GET stream markers :heavy_check_mark:
    * GET stream metadata :heavy_check_mark:
    * GET stream key :heavy_check_mark:
* Subscriptions
    * GET broadcaster subscriptions :heavy_check_mark:
* Stream tags
    * GET all stream tags :heavy_check_mark:
    * GET stream tags :heavy_check_mark:
    * PUT replace stream tags :heavy_check_mark:
* Channels
    * GET search channels :heavy_check_mark:
    * POST start commercial :heavy_check_mark:
    * GET hype train events :heavy_check_mark:
    * PATCH modify channel information :heavy_check_mark:
    
### 2.2 Webhooks
* Subscribe To/Unsubscribe From Events :x:
* Topic: User Follows :x:
* Topic: Stream Changed :x:
* Topic: User Changed :x:
* Topic: Topic: Extension Transaction Created :x:
* Topic: Moderator Change Events :x:
* Topic: Channel Ban Change Events :x:
* Topic: Topic: Subscription Events :x:

### 2.3 Authentication
* User access token :heavy_check_mark:
* App access token :heavy_check_mark:
    
## 3. Dependencies

### 3.1 Ktor client

- Built on top of the *Ktor* library
- Reasons for choosing *Ktor* over *Spring Boot*:
    - More lightweight, less complexity
    - Customizable, doesn't include all of the extra dependencies that are brought with Spring Boot

### 3.2 Kotlinx.serializaiton

- All JSON operations are done using the *Kotlinx Serialization* library
- Reasons for choosing *Kotlinx* over other libraries:
    - Made for Kotlin and not Java, makes use of some Kotlin only features (for example optionals)
    - Is relatively fast (see [this benchmark](https://github.com/wizzardo/json-benchmarks))
    - Even though it is currently pretty unstable, it will probably be the default Kotlin serialization library to use future language versions
