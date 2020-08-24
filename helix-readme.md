# Module twitch-client

# About

*Twitch-Client* is a modern Kotlin library that permits an easy and quick interaction with the Twitch services. Currently, the library can be used in *Java* or *Kotlin/JVM* projects and will be extended to other platforms in the future with the help of *Kotlin-Multiplatform*. The library is built on top of the [Ktor Client](https://ktor.io/clients/index.html) which is one of the best performing HTTP clients for Kotlin.

---
## Features

* All [Twitch Helix](https://dev.twitch.tv/docs/api) endpoints are implemented and tested
* Works with Kotlin/JVM and Java projects
* Works with Android Studio projects
* Authentication service included for an easy OAuth flow implementation
* Nullable types are used for all Twitch API response objects
* 100% unit test coverage
* All public methods and members are documented
* Documentation includes code samples for all endpoints
* Easy handling of multi-page Twitch collection responses

## Installation

1. Add the Bintray maven repository to the `repositories` block:
- Gradle Kotlin DSL:
    ```
    repositories {
        mavenCentral()
        maven {
            setUrl("https://dl.bintray.com/frozencure/maven")
        }
    }
    ```
- Gradle Groovy DSL:
    ```
    repositories {
        mavenCentral()
        maven {
            url 'https://dl.bintray.com/frozencure/maven'
        }
    }
    ```
- Maven:
    ```
    <repository>
        <id>twitch-client-repo</id>
        <url>https://dl.bintray.com/frozencure/maven</url>
    </repository>
    ```

2. Add the library as a dependency:
* Gradle Kotlin DSL:
    ```
    dependencies {
        ...
        implementation("com.github.frozencure:twitch-client:0.0.1")
    }
    ```
* Gradle Groovy DSL:
    ```
    dependencies {
        ...
        implementation 'com.github.frozencure:twitch-client:0.0.1'
    }
    ```
* Maven:
    ```
    <dependency>
        <groupId>com.github.frozencure</groupId>
        <artifactId>twitch-client</artifactId>
        <version>0.0.1</version>
        <type>pom</type>
    </dependency>
    ```

---
## Performing the first request

* Using only a client ID (without OAuth)

    In order to get a client ID for your Twitch extension follow [this guide](https://dev.twitch.tv/docs/api).

    Example of performing a GET user request:
    ```
    val credentials = AuthCredentials("<app client id>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        println(helixClient.users.getUser().resource.toString())
    }
    ```
* Using an OAuth token:

    Most of the Twitch endpoints require the user/app to be authenticated using the OAuth 2.0 Standard.

    More information about how to retrieve a user token and how the authentication works can be found in Authentication section or in the [Twitch API reference authentication section](https://dev.twitch.tv/docs/authentication).

    Example of performing a GET user request:
    ```
    val credentials = OauthCredentials("<your access token", "<app client id>")
    val helixClient = HelixClient(credentials)
    runBlocking {
        println(helixClient.users.getUser().resource.toString())
    }
    ```
  
# Dependencies

## Ktor client

- Built on top of the *Ktor* library
- Reasons for choosing *Ktor* over *Spring Boot*:
    - More lightweight, less complexity
    - Customizable, doesn't include all of the extra dependencies that are brought with Spring Boot
---

## Kotlinx.serializaiton

- All JSON operations are done using the *Kotlinx Serialization* library
- Reasons for choosing *Kotlinx* over other libraries:
    - Made for Kotlin and not Java, makes use of some Kotlin only features (for example optionals)
    - Is relatively fast (see [this benchmark](https://github.com/wizzardo/json-benchmarks))
    - Even though it is currently pretty unstable, it will probably be the default Kotlin serialization library to use future language versions

# License

This project is available under the MIT license. See the LICENSE file for more information.
