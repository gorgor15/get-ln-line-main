package com.uno.getinline.dto;


import com.uno.getinline.constant.ErrorCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
//EqualsAndHashCode 할때 extends한 APIErrorResponse 필드도 검사 가능하게한다
@EqualsAndHashCode(callSuper = true)
public class APIDataResponse<T> extends APIErrorResponse{
    // 제네릭 타입으로 변경 APIPlaceController에 적용위함
    // 22-01-30 18:00
    private final T data;

    private APIDataResponse(T data){
        super(true, ErrorCode.OK.getCode(), ErrorCode.OK.getMessage());
        this.data=data;
    }

    public static <T> APIDataResponse<T> of(T data){
        return new APIDataResponse<>(data);
    }
    public static <T> APIDataResponse<T> empty(){
        return new APIDataResponse<>(null);
    }
}
