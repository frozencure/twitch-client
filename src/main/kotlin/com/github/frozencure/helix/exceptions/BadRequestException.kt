package com.github.frozencure.helix.exceptions

/**
 * An exception that is thrown when an invalid request is executed.
 * For example, an invalid configuration of request parameters is used.
 * @param message Explains why the exception was thrown
 * @constructor Creates a new bad request exception.
 */
class BadRequestException(message: String) : Exception(message)