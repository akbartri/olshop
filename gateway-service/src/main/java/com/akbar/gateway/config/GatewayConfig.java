package com.akbar.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class GatewayConfig {
//    @Autowired
//    AuthenticationFilter filter;
//
//    @Bean
//    public RouteLocator routes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("auth-service", r -> r.path("/auth/**")
//                        .filters(f -> f.filter(filter))
//                        .uri("lb://auth-service"))
//                .route("user-service", r -> r.path("/users/**")
//                        .filters(f -> f.filter(filter))
//                        .uri("lb://user-service"))
//                .route("department-service", r -> r.path("/departments/**")
//                        .filters(f -> f.filter(filter))
//                        .uri("lb://department-service"))
//                .build();
//    }
}
