package br.com.amartins.springarchitecture.gateway.routes

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod

@Configuration
class StudentServiceRoute {
    companion object {
        @Value("\${student.host}")
        private lateinit var studentHost: String
    }

    @Bean
    fun myRoutes(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes()
            .route {
                it.path("/v1/student/{segment}")
                    .and()
                    .method(HttpMethod.GET)
                    .filters { f: GatewayFilterSpec ->
                        f.addRequestHeader("Authorization", "Bearer token")
                        f.setPath("/student/{segment}")
                    }
                    .uri(studentHost)
            }
            .route {
                it.path("/student")
                    .and()
                    .method(HttpMethod.GET)
                    .filters { f: GatewayFilterSpec ->
                        f.addRequestHeader("Authorization", "Bearer token")
                    }
                    .uri(studentHost)
            }
            .route {
                it.path("/v1/student")
                    .and()
                    .method(HttpMethod.POST)
                    .filters { f: GatewayFilterSpec ->
                        f.addRequestHeader("Authorization", "Bearer token")
                    }
                    .uri(studentHost)
            }
            .build()
    }
}
