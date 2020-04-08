# Kotlin Twitch API Client

A modern Kotlin library for accessing the newest Twitch Helix API. 

## 1. Getting started

## 2. Currently Supported Endpoints
    
## 3. Dependencies

### 1. Ktor client

- Built on top of the *Ktor* library
- Resons for choosing *Ktor* over *Spring Boot*:
    - More lightweight, less complexity
    - Customaziable, doesn't include all of the extra dependencies that are brought with Spring Boot

### 2. Kotlinx.serializaiton

- All JSON operations are done using the *Kotlinx Serialization* library
- Reasons for choosing *Kotlinx* over other libraries:
    - Made for Kotlin and not Java, makes use of some Kotlin only features (for example optionals)
    - Is relatively fast (see [this benchmark](https://github.com/wizzardo/json-benchmarks))
    - Even though it is currently pretty unstable, it will probably be the default Kotlin serialization library to use future language versions
