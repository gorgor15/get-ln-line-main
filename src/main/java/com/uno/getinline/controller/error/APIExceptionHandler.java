package com.uno.getinline.controller.error;

import com.uno.getinline.constant.ErrorCode;
import com.uno.getinline.dto.APIErrorResponse;
import com.uno.getinline.exception.GeneralException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//APi만 적용이됨 view들은 적용이안됨
@RestControllerAdvice(annotations = RestController.class)
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

    // error 페이지를 커스터마이징하기위해 implements ErrorController 을 써야된다.
    //여기 클래스내에서 에러가 터지는걸 잡는것 (general)
    @ExceptionHandler
    public ResponseEntity<Object> general(GeneralException e,WebRequest request) {
        ErrorCode errorCode = e.getErrorcode();
        HttpStatus status = errorCode.isClientSideError() ?
                HttpStatus.BAD_REQUEST :
                HttpStatus.INTERNAL_SERVER_ERROR;

        return super.handleExceptionInternal(
                e,
                APIErrorResponse.of(false,errorCode.getCode(), errorCode.getMessage(e)),
                HttpHeaders.EMPTY,
                status,
                request
        );
    }

    // 전체적으로 에러가 발생했을때
    @ExceptionHandler
    public ResponseEntity<Object> exception(Exception e,WebRequest request) {
        ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        return super.handleExceptionInternal(
                e,
                APIErrorResponse.of(false,errorCode.getCode(), errorCode.getMessage(e)),
                HttpHeaders.EMPTY,
                status,
                request
        );

    }

    // 스프링 부트의 에러를 잡아줘야된다.
    // Ctrl + o 를 눌러줘서 오버라이드한다.

    //body값만 넣어주면된다.
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorCode errorCode = status.is4xxClientError()?
                ErrorCode.SPRING_BAD_REQUEST:
                ErrorCode.SPRING_INTERNAL_ERROR;


        return super.handleExceptionInternal(
                ex,
                APIErrorResponse.of(false,errorCode.getCode(), errorCode.getMessage(ex)),
                headers,
                status,
                request
        );
    }
}
