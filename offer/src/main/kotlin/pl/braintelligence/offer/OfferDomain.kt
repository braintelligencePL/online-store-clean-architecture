package pl.braintelligence.offer

import pl.braintelligence.offer.offer.OfferAPI
import pl.braintelligence.offer.offer.model.OfferResponse
import pl.braintelligence.offer.service.OfferService

open class OfferDomain internal constructor(
    private val offerService: OfferService
) : OfferAPI {

    override fun getOffers(): OfferResponse {
        return offerService.getOffers()
    }

    companion object {
        fun create(): OfferAPI = OfferDomain(
            offerService = OfferService()
        )
    }

}
