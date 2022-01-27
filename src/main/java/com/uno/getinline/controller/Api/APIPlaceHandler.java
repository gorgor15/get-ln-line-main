package com.uno.getinline.controller.Api;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.function.ServerResponse.created;

@Component
public class APIPlaceHandler{


    
    public ServerResponse getPlaces(ServerRequest request) throws Exception {
        return ServerResponse.ok().body(List.of("place1","place2"));
    }
    // 구현할때 제대로 하자
    public ServerResponse createPlaces(ServerRequest request) throws Exception {
        return created(URI.create("/api/places")).body(true);
    }
    public ServerResponse getPlace(ServerRequest request) throws Exception {
        return ServerResponse.ok().body(request.pathVariable("placeId"));
    }
    public ServerResponse modifyPlace(ServerRequest request) throws Exception {
        return ServerResponse.ok().body(true);
    }
    public ServerResponse removePlace(ServerRequest request) throws Exception {
        return  ServerResponse.ok().body(true);
    }
}
