package pl.braintelligence.product

import arrow.core.Either
import arrow.core.Valid
import pl.braintelligence.product.model.ProductError
import pl.braintelligence.product.model.ProductQuery
import pl.braintelligence.product.model.request.NewProductRequest
import pl.braintelligence.product.model.response.Product
import pl.braintelligence.product.model.response.ProductResponse
import pl.braintelligence.product.service.ProductService

open class ProductDomain internal constructor(
    private val productService: ProductService
) : ProductAPI {

    override fun findProducts(query: ProductQuery): Either<ProductError, ProductResponse> {
        TODO("not implemented")
    }

    override fun createProduct(request: Valid<NewProductRequest>): Either<ProductError, Product> {
        TODO("not implemented")
    }

    companion object {
        fun create(): ProductAPI = ProductDomain(
            productService = ProductService()
        )
    }

}
