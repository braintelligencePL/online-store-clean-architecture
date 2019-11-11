package pl.braintelligence.offer.offer

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pl.braintelligence.offer.offer.model.OfferResponse

@RestController
@RequestMapping("/api/offers", produces = [MediaType.APPLICATION_JSON_VALUE])
class OfferEndpoint(
    private val offerAPI: OfferAPI
) {

    @GetMapping
    fun getOffers(): OfferResponse = offerAPI.getOffers()

}
