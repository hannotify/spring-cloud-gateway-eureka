package com.github.hannotify.scge.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/credits")
                        .uri("lb://BS-CREDITS"))
                .route(p -> p
                        .path("/intro")
                        .uri("lb://BS-INTRO"))
                .build();
    }
}
