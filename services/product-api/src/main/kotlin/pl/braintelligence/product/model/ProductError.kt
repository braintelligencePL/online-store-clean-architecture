package pl.braintelligence.product.model

import com.fasterxml.jackson.annotation.JsonSubTypes
import org.zalando.problem.Status
import pl.braintelligence.shared.kernel.error.AppError

@JsonSubTypes(
    JsonSubTypes.Type(ProductNotFound::class, name = "OFFER_NOT_FOUND")
)
sealed class ProductError(
    override val title: String,
    override val status: Status
) : AppError(title = title, status = status)

data class ProductNotFound(
    val offerId: String
) : ProductError(
    title = "Offer with id=$offerId not found",
    status = Status.NOT_FOUND
)
