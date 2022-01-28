package com.uno.getinline.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.function.Predicate;

//에러코드의 구조를 잡아둠
@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    OK(0,ErrorCategory.NORMAL, "Ok"),

    //카테고리를 만듦
    BAD_REQUEST(10000,ErrorCategory.CLIENT_SIDE,"bad request"),
    SPRING_BAD_REQUEST(10001,ErrorCategory.CLIENT_SIDE,"Spring-detected bad request"),

    INTERNAL_ERROR(20000,ErrorCategory.SERVER_SIDE,"internal error"),
    SPRING_INTERNAL_ERROR(20001,ErrorCategory.SERVER_SIDE,"Spring-detected internal error ");
    
    private final Integer code;
    private final ErrorCategory errorCategory;
    private final String message;

    //예외를 넣거나
    public String getMessage(Exception e){
        return getMessage(e.getMessage());
    }
    //직접 문자열을 넣어줌
    public String getMessage(String message){
        return Optional.ofNullable(message)
                .filter(Predicate.not(String::isBlank)) //비어있지않다면 이걸쓰고 비워있다면 위에 에러내용 출력
                .orElse(getMessage()); //없을경우

    }

    public boolean isClientSideError(){
        return this.getErrorCategory() == ErrorCategory.CLIENT_SIDE;
    }

    public boolean isServerSideError(){
        return this.getErrorCategory() == ErrorCategory.SERVER_SIDE;
    }

    //에러코드있으면 바로 찍어내기위해
    public String toString(){
        return String.format("%s (%d)",name(),this.getCode());
    }
    
    public enum ErrorCategory{
        NORMAL,CLIENT_SIDE,SERVER_SIDE
    }



}
