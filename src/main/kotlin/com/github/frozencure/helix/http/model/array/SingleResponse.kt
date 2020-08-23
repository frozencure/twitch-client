package com.github.frozencure.helix.http.model.array

import com.github.frozencure.helix.http.model.AbstractResource
import io.ktor.client.statement.HttpResponse


abstract class SingleResponse<T : AbstractResource>(httpResponse: HttpResponse) :
    ArrayHelixResponse<T>(httpResponse) {

    val resource: T?
        get() = helixArrayDTO.resources?.firstOrNull()
}