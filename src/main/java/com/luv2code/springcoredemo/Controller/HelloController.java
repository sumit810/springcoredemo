package com.luv2code.springcoredemo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String  helloWorld(){
        return "hello World!";
    }
}