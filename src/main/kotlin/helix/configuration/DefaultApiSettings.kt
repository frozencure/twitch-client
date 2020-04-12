package helix.configuration


data class DefaultApiSettings(
    override val credentials: Map<String, Any?>
) : ApiSettings