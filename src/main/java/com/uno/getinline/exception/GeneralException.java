package com.uno.getinline.exception;

import com.uno.getinline.constant.ErrorCode;
import lombok.Getter;

// 런타임 Exception 내용을 재구현 한것이다.
@Getter
public class GeneralException extends RuntimeException{
    private final ErrorCode errorcode;

    public GeneralException(){
        super();
        this.errorcode= ErrorCode.INTERNAL_ERROR;
    }
    public GeneralException(String message){
        super(message);
        this.errorcode = ErrorCode.INTERNAL_ERROR;
    }
    public GeneralException(String message,Throwable cause){
        super(message,cause);
        this.errorcode = ErrorCode.INTERNAL_ERROR;
    }
    public GeneralException(Throwable cause){
        super(cause);
        this.errorcode = ErrorCode.INTERNAL_ERROR;
    }
    public GeneralException(String message,Throwable cause, boolean enableSuppression,boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorcode = ErrorCode.INTERNAL_ERROR;
    }
    public GeneralException(ErrorCode errorcode){
        super(errorcode.getMessage());
        this.errorcode = errorcode;
    }

    public GeneralException(ErrorCode errorcode,Throwable cause){
        super(errorcode.getMessage(),cause);
        this.errorcode=errorcode;
    }
    public GeneralException(ErrorCode errorcode,Throwable cause,boolean enableSuppression,boolean writableStackTrace){
        super(errorcode.getMessage(),cause,enableSuppression,writableStackTrace);
        this.errorcode = ErrorCode.INTERNAL_ERROR;
    }

}
