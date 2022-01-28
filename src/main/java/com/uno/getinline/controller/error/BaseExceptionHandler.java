package com.uno.getinline.controller.error;

import com.uno.getinline.constant.ErrorCode;
import com.uno.getinline.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

//전체 컨트롤러 동작감시
@ControllerAdvice
public class BaseExceptionHandler {

    // error 페이지를 커스터마이징하기위해 implements ErrorController 을 써야된다.
    @ExceptionHandler
    public ModelAndView errorHtml(GeneralException e,HttpServletResponse response){
        ErrorCode errorCode = e.getErrorcode();
        HttpStatus status = errorCode.isClientSideError()?
                HttpStatus.BAD_REQUEST:
                HttpStatus.INTERNAL_SERVER_ERROR;

        return new ModelAndView("error",
                Map.of(
                        "statusCode",status.value(), //value를 넣어야 int값이나온다
                        "errorCode",errorCode,
                        "message", errorCode.getMessage(e)
                ),
                status
        );
    }

    // 전체적으로 에러가 발생했을때
    @ExceptionHandler
    public ModelAndView exception(Exception e){
        ErrorCode errorCode =ErrorCode.INTERNAL_ERROR;
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        return new ModelAndView("error",
                Map.of(
                        "statusCode",status.value(), //value를 넣어야 int값이나온다
                        "errorCode",errorCode,
                        "message", errorCode.getMessage(e)
                ),
                status
        );
    }
}
