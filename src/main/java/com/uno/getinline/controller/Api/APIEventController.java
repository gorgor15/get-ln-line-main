package com.uno.getinline.controller.Api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class APIEventController {

    @GetMapping("/events")
    public List<String> getEvents(){
        return List.of("event1","event2");
    }

    @PostMapping("/events")
    public boolean createEvents(){
        return true;
    }

    @GetMapping("/events/{eventId}")
    public String getEvent(@PathVariable Integer eventId){
        return "event : "+eventId;
    }
    @PutMapping("/events/{eventId}")
    public boolean modifyEvent(@PathVariable Integer eventId){
        return true;
    }

    @DeleteMapping("/events/{eventId}")
    public boolean removeEvent(@PathVariable Integer eventId){
        return true;
    }
}
