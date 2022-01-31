package com.uno.getinline.dto;

import com.uno.getinline.constant.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 데이터에 들어가는 타입이 오브젝트인데 어떤타입인지 알수없음
class APIDataResponseTest {

    @DisplayName("문자열 데이터가 주어지면, 표준 성공 응답을 생성한다.")
    @Test
    void givenStringData_whenCreatingResponse_thenReturnsSuccessfulResponse(){
        //given
        String data = "test data";
        //when
        APIDataResponse<String> response = APIDataResponse.of(data);
        //then
        assertThat(response)
                .hasFieldOrPropertyWithValue("success",true)
                .hasFieldOrPropertyWithValue("errorCode",ErrorCode.OK.getCode())
                .hasFieldOrPropertyWithValue("message",ErrorCode.OK.getMessage())
                .hasFieldOrPropertyWithValue("data",data);
    }
    @DisplayName("문자열 데이터가 없을 때, 비어있는 표준 성공 응답을 생성한다.")
    @Test
    void givenNothingData_whenCreatingResponse_thenReturnsEmptySuccessfulResponse(){
        //given

        //when
        APIDataResponse<String> response = APIDataResponse.empty();
        //then
        assertThat(response)
                .hasFieldOrPropertyWithValue("success",true)
                .hasFieldOrPropertyWithValue("errorCode",ErrorCode.OK.getCode())
                .hasFieldOrPropertyWithValue("message",ErrorCode.OK.getMessage())
                .hasFieldOrPropertyWithValue("data",null);
    }
}