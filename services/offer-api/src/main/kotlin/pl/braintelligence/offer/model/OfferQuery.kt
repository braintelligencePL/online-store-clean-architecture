package pl.braintelligence.offer.model

import pl.braintelligence.shared.kernel.paging.PageRequest

data class OfferQuery(
    val page: PageRequest = PageRequest(0, 50)
)