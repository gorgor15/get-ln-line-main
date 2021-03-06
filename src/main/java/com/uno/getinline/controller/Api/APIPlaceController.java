package com.uno.getinline.controller.Api;


import com.uno.getinline.constant.PlaceType;
import com.uno.getinline.dto.APIDataResponse;
import com.uno.getinline.dto.PlaceDTO;
import com.uno.getinline.dto.PlaceResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class APIPlaceController {

    @GetMapping("/places")
    public APIDataResponse<List<PlaceResponse>> getPlaces(){
        return APIDataResponse.of(List.of(PlaceResponse.of(
                PlaceType.COMMON,
                "랄라배드민턴장",
                "경기도 부천시",
                "010-1234-4567",
                "신장 개업",
                30
        )));
    }

//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("/places")
//    public APIDataResponse<void> createPlace(@RequestBody PlaceRequest placeRequest){
//        return APIDataResponse.empty();
//    }

    @GetMapping("/places/{placeId}")
    public APIDataResponse<PlaceDTO> getPlace(@PathVariable Integer placeId){
        //테스트를 위해 임시로 만듦
        if(placeId.equals(2)){
            return APIDataResponse.of(null);
        }

        return APIDataResponse.of(PlaceDTO.of(
                PlaceType.COMMON,
                "랄라배드민턴장",
                "경기도 부천시",
                "010-1234-4567",
                30,
                "신장 개업"
        ));
    }

    @PutMapping("/places/{placeId}")
    public Boolean modifyPlace(@PathVariable Integer placeId){
        return true;
    }
    @DeleteMapping("/places/{placeId}")
    public Boolean removePlace(@PathVariable Integer placeId){
        return true;
    }
}
