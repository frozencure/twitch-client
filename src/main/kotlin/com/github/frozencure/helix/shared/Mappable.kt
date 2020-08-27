package com.github.frozencure.helix.shared

/**
 * Represents all objects that can be converted to a [Map].
 */
interface Mappable {

    /**
     * Converts the object to a [Map].
     */
    fun toMap(): Map<String, Any?>

}