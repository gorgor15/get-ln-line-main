package com.uno.getinline.controller.Api;

import com.uno.getinline.constant.EventStatus;
import com.uno.getinline.dto.APIDataResponse;
import com.uno.getinline.dto.EventResponse;
import com.uno.getinline.exception.GeneralException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api")
@RestController
public class APIEventController {

    @GetMapping("/events")
    public APIDataResponse<List<EventResponse>> getEvents() throws Exception {
        return APIDataResponse.of(List.of(EventResponse.of(
                1L,
                null,
                "오후 운동",
                EventStatus.OPENED,
                LocalDateTime.of(2021,1,1,13,0,0),
                LocalDateTime.of(2021,1,1,16,0,0),
                0,
                24,
                "마스크 꼭 착용하세요"
        )));
    }

    @PostMapping("/events")
    public boolean createEvents() {
        throw new GeneralException("장군님");
//        return true;
    }

    @GetMapping("/events/{eventId}")
    public String getEvent(@PathVariable Integer eventId) {
        throw new RuntimeException("런타임 에러");
//        return "event : " + eventId;
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
