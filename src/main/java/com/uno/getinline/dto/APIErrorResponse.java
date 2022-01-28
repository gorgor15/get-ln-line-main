package com.uno.getinline.dto;


import com.uno.getinline.constant.ErrorCode;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
//바깥에선 사용할수없고 생성자 내부에서만 사용하기위해 사용
@RequiredArgsConstructor(access= AccessLevel.PROTECTED)
public class APIErrorResponse {
    private final boolean success;
    private final Integer errorCode;
    private final String message;

    //생성자 메소드들
    // 완전 수정입력
    public static APIErrorResponse of(boolean success,Integer errorCode,String message){
        return new APIErrorResponse(success,errorCode,message);
    }
    //에러코드에 대응
    public static APIErrorResponse of(boolean success, ErrorCode errorCode){
        return new APIErrorResponse(success,errorCode.getCode(),errorCode.getMessage());
    }
    public static APIErrorResponse of(boolean success, ErrorCode errorCode,Exception e){
        return new APIErrorResponse(success,errorCode.getCode(),errorCode.getMessage(e));
    }
    public static APIErrorResponse of(boolean success, ErrorCode errorCode,String message){
        return new APIErrorResponse(success,errorCode.getCode(),errorCode.getMessage(message));
    }
}
