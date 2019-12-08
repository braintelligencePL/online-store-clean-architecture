package pl.braintelligence.offer

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import pl.braintelligence.offer.model.OfferQuery
import pl.braintelligence.offer.model.response.OffersResponse
import pl.braintelligence.shared.kernel.arrow.getOrThrow
import pl.braintelligence.shared.kernel.paging.PageRequest

@RestController
@RequestMapping("/api/offers", produces = [MediaType.APPLICATION_JSON_VALUE])
class OfferEndpoint(
    private val offerAPI: OfferAPI
) {

    @GetMapping
    fun getOffers(
        @RequestParam(name = "page", required = false, defaultValue = "0") page: Int,
        @RequestParam(name = "size", required = false, defaultValue = "50") size: Int
    ): OffersResponse = OfferQuery(PageRequest(pageNumber = page, pageSize = size)).let {
        offerAPI.findOffers(it).getOrThrow()
    }

}