package com.github.frozencure.helix.http.extensions

import com.github.frozencure.helix.exceptions.InvalidTypeException
import com.github.frozencure.helix.shared.Mappable
import io.ktor.client.request.*

fun HttpRequestBuilder.parametersOfSerializableObject(obj: Mappable) {
    obj.toMap().forEach { (key, value) ->
        when (value) {
            is String?, is Number?, is Boolean?, is Char? -> {
                value?.let { this.url.parameters.append(key, it.toString()) }
            }
            is Collection<*>? -> {
                value?.forEach { i -> this.url.parameters.append(key, i.toString()) }
            }
            else -> throw InvalidTypeException(
                "Type of $value for $key must a be number, boolean," +
                        " string or collection of strings."
            )
        }
    }
}

fun HttpRequestBuilder.headersOfSerializableObject(map: Map<String, Any?>) {
    map.forEach { (key, value) ->
        when (value) {
            is String?, is Number?, is Boolean?, is Char? -> {
                value?.let { this.headers.append(key, it.toString()) }
            }
            is Collection<*>? -> {
                value?.forEach { i -> this.headers.append(key, i.toString()) }
            }
            else -> throw InvalidTypeException(
                "Type of $value for $key must a be number, boolean," +
                        " string or collection of strings."
            )
        }
    }
}