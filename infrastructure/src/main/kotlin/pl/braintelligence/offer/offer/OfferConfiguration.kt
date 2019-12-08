package pl.braintelligence.offer.offer

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import pl.braintelligence.offer.OfferDomain

@Configuration
class OfferConfiguration {

    @Bean
    fun offerApi(): OfferAPI = OfferDomain.create()

}
