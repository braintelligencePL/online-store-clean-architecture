package pl.braintelligence.offer.model.request

import java.math.BigDecimal
import java.net.URI

data class NewOfferRequest(
    val name: String,
    val description: String,
    val price: BigDecimal,
    val image: URI
)
