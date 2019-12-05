package com.rongflag.chapter1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Chapter1Application {

    @GetMapping("/")
    public String hello(){
        return "hello security";
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter1Application.class, args);
    }

}
