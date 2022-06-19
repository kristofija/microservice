package com.phonenumbers.microservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    //@RequestMapping("/ui")
    public class IndexController {

        @GetMapping("/ui/")
        public String getIndex(){
            return "index";
        }
    }

