package pl.braintelligence.product

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OfferConfiguration {

    @Bean
    fun offerApi(): ProductAPI = ProductDomain.create()

}
