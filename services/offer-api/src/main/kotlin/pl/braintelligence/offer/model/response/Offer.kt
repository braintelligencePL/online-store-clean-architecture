package pl.braintelligence.offer.model.response

import java.math.BigDecimal
import java.net.URI

data class Offer(
    val id: String,
    val name: String,
    val description: String,
    val price: BigDecimal,
    val image: URI
)
