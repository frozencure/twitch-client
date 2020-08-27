package com.github.frozencure.helix.http.model.array

import kotlinx.serialization.Serializable

/**
 * Holds the current state of the cursor used for requesting the next part of a collection of data.
 * @constructor Creates a new pagination object.
 * @param cursor The cursor that is required to retrieve the next page of data.
 */
@Serializable
data class Pagination(val cursor: String? = null) {

    /**
     * Retrieves the [cursor] as a key, value pair.
     */
    fun asPair(): Pair<String, String?> = Pair("cursor", cursor)
}