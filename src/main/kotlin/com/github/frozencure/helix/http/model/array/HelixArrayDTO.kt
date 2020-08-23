package com.github.frozencure.helix.http.model.array

import com.github.frozencure.helix.http.model.AbstractResource

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * A wrapper data transfer object, that contains the fields used in all Twitch Helix endpoints.
 * @constructor Creates a new Helix data transfer wrapper object used for collection responses.
 * @param resources A collection containing the resources (data) that has been requested.
 * @param pagination An object that holds the current state of the cursor used for requesting the next part of the collection of data.
 * @param total The total number of resources retrieved. Is only present in some of the Twitch Helix endpoints.
 * @param dateRange Holds the interval between two timestamps. Is only present in some of the Twitch Helix endpoints.
 */

@Serializable
data class HelixArrayDTO<T : AbstractResource>(
    @SerialName("data")
    val resources: Collection<T>? = emptyList(),
    @SerialName("pagination")
    val pagination: Pagination? = null,
    @SerialName("total")
    val total: Long? = null,
    @SerialName("date_range")
    val dateRange: DateRange? = null
)