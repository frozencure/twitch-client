package helix.extension

import helix.exceptions.InvalidTypeException
import io.ktor.client.request.HttpRequestBuilder
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.Properties

@ImplicitReflectionSerializer
inline fun <reified T : Any> HttpRequestBuilder.parametersOfSerializableObject(obj: T) {
    Properties.storeNullable(obj).forEach { (key, value) ->
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