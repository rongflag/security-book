package com.rongflag.chapter3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : aihuxi
 * @version V1.0
 * @Project: chapter2
 * @Package com.rongflag.chapter2.controller
 * @Description: TODO
 * @email : worongbo@163.com
 * @date 2019年12月06日 18:51
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    @GetMapping("hello")
    public String sayHello(){
        return "admin say hello";
    }
}
