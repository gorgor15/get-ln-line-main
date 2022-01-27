package com.uno.getinline.controller.Api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.path;
import static org.springframework.web.servlet.function.RouterFunctions.route;


@Configuration
public class APIPlaceRouter {

    @Bean
    public RouterFunction<ServerResponse> placeRouter(APIPlaceHandler apiPlaceHandler){
        return route().nest(path("/api/places"), builder -> builder
                .GET("",apiPlaceHandler::getPlaces)
                .POST("",apiPlaceHandler::createPlaces)
                .GET("/{placeId}",apiPlaceHandler::getPlace)
                .PUT("/{placeId}",apiPlaceHandler::modifyPlace)
                .DELETE("/{placeId}",apiPlaceHandler::removePlace)
        ).build();

    }
}
