package com.uno.getinline.dto;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
//EqualsAndHashCode 할때 extends한 APIErrorResponse 필드도 검사 가능하게한다
@EqualsAndHashCode(callSuper = true)
public class APIDataResponse extends APIErrorResponse{
    private final Object data;

    private APIDataResponse(boolean success,Integer errorCode,String message,Object data){
        super(success,errorCode,message);
        this.data=data;
    }

    public static APIDataResponse of(boolean success,Integer errorCode,String message,Object data){
        return new APIDataResponse(success,errorCode,message,data);
    }
}
