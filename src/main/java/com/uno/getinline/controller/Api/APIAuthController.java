package com.uno.getinline.controller.Api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class APIAuthController {


    //예전엔 responseBody body로 인증을 보냈었다.
    @GetMapping("/sign-up")
    public String signUp(){
        return "done.";
    }

    @GetMapping("/login")
    public String login(){
        return "done.";
    }
}
