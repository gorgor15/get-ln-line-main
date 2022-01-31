package com.uno.getinline.dto;

import com.uno.getinline.constant.EventStatus;

import java.time.LocalDateTime;

public record EventDTO(
        Long id,
        PlaceDTO placeDTO,
        String eventName,
        EventStatus eventStatus,
        LocalDateTime eventStartDatetime,
        LocalDateTime eventEndDatetime,
        Integer currentNumberOfPeople,
        Integer capacity,
        String memo,
        LocalDateTime createAt,
        LocalDateTime modifiedAt

) {
        public static EventDTO of(
                Long id,
                PlaceDTO placeDTO,
                String eventName,
                EventStatus eventStatus,
                LocalDateTime eventStartDatetime,
                LocalDateTime eventEndDatetime,
                Integer currentNumberOfPeople,
                Integer capacity,
                String memo,
                LocalDateTime createAt,
                LocalDateTime modifiedAt
        ) {
            return new EventDTO(
                    id,
                    placeDTO,
                    eventName,
                    eventStatus,
                    eventStartDatetime,
                    eventEndDatetime,
                    currentNumberOfPeople,
                    capacity,
                    memo,
                    createAt,
                    modifiedAt
            );
        }

}
