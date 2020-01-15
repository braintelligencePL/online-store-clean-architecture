package pl.braintelligence.product

import arrow.core.Either
import arrow.core.Valid
import pl.braintelligence.product.model.ProductError
import pl.braintelligence.product.model.ProductQuery
import pl.braintelligence.product.model.request.NewProductRequest
import pl.braintelligence.product.model.response.Product
import pl.braintelligence.product.model.response.ProductResponse

interface ProductAPI {
    fun findProducts(query: ProductQuery): Either<ProductError, ProductResponse>
    fun createProduct(request: Valid<NewProductRequest>): Either<ProductError, Product>
}
