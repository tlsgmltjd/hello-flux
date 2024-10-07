package com.example.helloflux.router;

import com.example.helloflux.handler.MemberHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class MemberRouter {
    @Bean
    public RouterFunction<ServerResponse> routes(MemberHandler memberHandler) {
        return route()
                .GET("/users", memberHandler::getAllUsers)
                .POST("/users", memberHandler::createUser)
                .build();
    }
}
