package pl.braintelligence.product.model.request

import java.math.BigDecimal
import java.net.URI

data class NewProductRequest(
    val name: String,
    val description: String,
    val price: BigDecimal,
    val image: URI
)
