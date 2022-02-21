package me.gary.test.config

import me.gary.test.config.FluxHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.*

/**
 * @Classname FluxRouter
 * @Description TODO
 * @Date 2022/2/21 18:03
 * @Auth gary
 */
@Configuration
open class FluxRouter {
    @Bean
    open fun routerFlux(fLuxHandler: FluxHandler?): RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.path("/001"),
            { request: ServerRequest? -> ServerResponse.ok().body(BodyInserters.fromValue("haha")) })
    }
}

@Component
open class FluxHandler{

}