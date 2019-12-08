package pl.braintelligence.offer.model

import com.fasterxml.jackson.annotation.JsonSubTypes
import org.zalando.problem.Status
import pl.braintelligence.shared.kernel.error.AppError

@JsonSubTypes(
    JsonSubTypes.Type(OfferNotFound::class, name = "OFFER_NOT_FOUND")
)
sealed class OfferError(
    override val title: String,
    override val status: Status
) : AppError(title = title, status = status)

data class OfferNotFound(
    val offerId: String
) : OfferError(
    title = "Offer with id=$offerId not found",
    status = Status.NOT_FOUND
)