package com.github.frozencure.helix.games.model


import com.github.frozencure.helix.http.model.AbstractResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data transfer object for a game.
 * One-to-one mapping to the Twitch game JSON object.
 * @constructor Creates a new game object.
 * @param id The identifier of the game.
 * @param name The name of the game.
 * @param boxArtUrl The URL for the game thumbnail.
 */
@Serializable
data class Game(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("box_art_url")
    val boxArtUrl: String
) : AbstractResource()