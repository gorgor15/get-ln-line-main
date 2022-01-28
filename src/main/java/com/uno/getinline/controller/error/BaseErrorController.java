package com.uno.getinline.controller.error;

import com.uno.getinline.constant.ErrorCode;
import com.uno.getinline.dto.APIErrorResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class BaseErrorController implements ErrorController {
    // error 페이지를 커스터마이징하기위해 implements ErrorController 을 써야된다.
    @RequestMapping(path="/error",produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView errorHtml(HttpServletResponse response){
        HttpStatus status =HttpStatus.valueOf(response.getStatus());
        ErrorCode errorCode = status.is4xxClientError()?ErrorCode.BAD_REQUEST:ErrorCode.INTERNAL_ERROR;
        return new ModelAndView("error",
                Map.of(
                        "statusCode",status.value(), //value를 넣어야 int값이나온다
                        "errorCode",errorCode,
                        "message", errorCode.getMessage(status.getReasonPhrase())
                ),
                status
        );
    }
    //json바디를 잡음
    @RequestMapping("/error")
    public ResponseEntity<APIErrorResponse> error(HttpServletResponse response){
        HttpStatus status =HttpStatus.valueOf(response.getStatus());
        ErrorCode errorCode = status.is4xxClientError()?ErrorCode.BAD_REQUEST:ErrorCode.INTERNAL_ERROR;
        return ResponseEntity
                .status(status)
                .body(APIErrorResponse.of(false,errorCode)
                );

    }
}
