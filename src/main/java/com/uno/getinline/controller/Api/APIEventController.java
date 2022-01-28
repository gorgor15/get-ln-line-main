package com.uno.getinline.controller.Api;

import com.uno.getinline.exception.GeneralException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class APIEventController {

    @GetMapping("/events")
    public List<String> getEvents() {
        throw new GeneralException("테스트 메세지");
//        return List.of("event1", "event2");
    }

    @PostMapping("/events")
    public boolean createEvents() {
        throw new RuntimeException("테스트 메세지");
//        return true;
    }

    @GetMapping("/events/{eventId}")
    public String getEvent(@PathVariable Integer eventId) {
        return "event : " + eventId;
    }

    @PutMapping("/events/{eventId}")
    public boolean modifyEvent(@PathVariable Integer eventId) {
        return true;
    }

    @DeleteMapping("/events/{eventId}")
    public boolean removeEvent(@PathVariable Integer eventId) {
        return true;
    }

}
