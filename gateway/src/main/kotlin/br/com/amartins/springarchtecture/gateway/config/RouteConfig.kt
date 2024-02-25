package br.com.amartins.springarchtecture.gateway.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RouteConfig {
    companion object {
        @Value("\${student.host}")
        private lateinit var studentHost: String
    }

    @Bean
    fun myRoutes(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes().route {
            it.path("/get").filters { f: GatewayFilterSpec ->
                f.addRequestHeader("Authorization", "Bearer token")
            }.uri(studentHost)
        }.build()
    }
}
