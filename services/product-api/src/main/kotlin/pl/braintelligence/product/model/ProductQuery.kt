package pl.braintelligence.product.model

import pl.braintelligence.shared.kernel.paging.PageRequest

data class ProductQuery(
    val page: PageRequest = PageRequest(0, 50)
)
