package pl.braintelligence.offer.offer

import pl.braintelligence.offer.offer.model.OfferResponse

interface OfferAPI {
    fun getOffers(): OfferResponse
}
