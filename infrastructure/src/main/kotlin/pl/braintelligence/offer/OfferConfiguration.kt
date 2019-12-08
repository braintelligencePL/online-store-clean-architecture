package pl.braintelligence.offer

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OfferConfiguration {

    @Bean
    fun offerApi(): OfferAPI = OfferDomain.create()

}
