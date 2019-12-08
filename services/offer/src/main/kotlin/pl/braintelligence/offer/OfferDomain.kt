package pl.braintelligence.offer

import arrow.core.Either
import arrow.core.Valid
import pl.braintelligence.offer.model.OfferError
import pl.braintelligence.offer.model.OfferQuery
import pl.braintelligence.offer.model.request.NewOfferRequest
import pl.braintelligence.offer.model.response.Offer
import pl.braintelligence.offer.model.response.OffersResponse
import pl.braintelligence.offer.service.OfferService

open class OfferDomain internal constructor(
    private val offerService: OfferService
) : OfferAPI {

    override fun findOffers(query: OfferQuery): Either<OfferError, OffersResponse> {
        TODO("not implemented")
    }

    override fun createOffer(request: Valid<NewOfferRequest>): Either<OfferError, Offer> {
        TODO("not implemented")
    }

    companion object {
        fun create(): OfferAPI = OfferDomain(
            offerService = OfferService()
        )
    }

}
