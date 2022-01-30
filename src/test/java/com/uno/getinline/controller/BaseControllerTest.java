package com.uno.getinline.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@AutoConfigureMockMvc
//@SpringBootTest
@WebMvcTest(BaseController.class)
class BaseControllerTest {

    //junit 5
    private final MockMvc mvc;

    public BaseControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] 기본 페이지 요청")
    @Test
    void root() throws Exception{
        //given

        //when & then

        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(content().string(containsString("this is default index")))
                .andExpect(view().name("index"))
                .andDo(print());
    }

    // junit 4 스타일로 많이 했었음
//    @Autowired
//    private MockMvc mvc;
//
//    @DisplayName("[view][GET] 기본 페이지 요청")
//    @Test
//    void root() throws Exception{
//        //given
//
//        //when & then
//
//        mvc.perform(get("/"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
//                .andExpect(content().string(containsString("this is default index")))
//                .andExpect(view().name("index"))
//                .andDo(print());
//    }
}