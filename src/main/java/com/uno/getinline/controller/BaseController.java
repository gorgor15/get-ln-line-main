package com.uno.getinline.controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController implements ErrorController {

    @GetMapping("/")
    public String root(){
        return "index";
    }

    // error 페이지를 커스터마이징하기위해 implements ErrorController 을 써야된다.
    @RequestMapping("/error")
    public String error(){
        return "error";
    }

}