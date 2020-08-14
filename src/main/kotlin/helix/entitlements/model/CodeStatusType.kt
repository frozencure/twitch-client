package helix.entitlements.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CodeStatusType {
    @SerialName("SUCCESSFULLY_REDEEMED")
    SUCCESSFULLY_REDEEMED,

    @SerialName("ALREADY_CLAIMED")
    ALREADY_CLAIMED,

    @SerialName("EXPIRED")
    EXPIRED,

    @SerialName("USER_NOT_ELIGIBLE")
    USER_NOT_ELIGIBLE,

    @SerialName("NOT_FOUND")
    NOT_FOUND,

    @SerialName("UNUSED")
    UNUSED,

    @SerialName("INACTIVE")
    INACTIVE,

    @SerialName("INCORRECT_FORMAT")
    INCORRECT_FORMAT,

    @SerialName("INTERNAL_ERROR")
    INTERNAL_ERROR
}