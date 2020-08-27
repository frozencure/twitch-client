package com.github.frozencure.helix.http.extensions

import com.github.frozencure.helix.exceptions.InvalidTypeException
import com.github.frozencure.helix.shared.Mappable
import io.ktor.client.request.*

/**
 * Adds all properties of a [Serializable] object as URL parameters to a HTTP request.
 * @param obj A [Serializable] and [Mappable] object
 * @exception InvalidTypeException The given map can only contain numbers, booleans, strings or collection of strings.
 */
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

/**
 * Adds all tuples from a [Map] to the header of a HTTP request.
 * @param map The given map
 * @exception InvalidTypeException The given map can only contain numbers, booleans, strings or collection of strings.
 */
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