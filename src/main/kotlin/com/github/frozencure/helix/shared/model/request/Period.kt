package com.github.frozencure.helix.shared.model.request

/**
 * An enum class that holds all period types that can be used in the Twitch Helix API.
 * @constructor Creates a new period type.
 * @param asString The period in [String] format.
 */
enum class Period(val asString: String) {

    DAY("day"),
    WEEK("week"),
    MONTH("month"),
    ALL("all")

}