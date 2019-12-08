package pl.braintelligence.offer

import arrow.core.Either
import arrow.core.Valid
import pl.braintelligence.offer.model.OfferError
import pl.braintelligence.offer.model.OfferQuery
import pl.braintelligence.offer.model.request.NewOfferRequest
import pl.braintelligence.offer.model.response.Offer
import pl.braintelligence.offer.model.response.OffersResponse

interface OfferAPI {
    fun findOffers(query: OfferQuery): Either<OfferError, OffersResponse>
    fun createOffer(request: Valid<NewOfferRequest>): Either<OfferError, Offer>
}
