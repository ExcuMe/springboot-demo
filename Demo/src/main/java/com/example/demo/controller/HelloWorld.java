package com.example.demo.controller;

import com.Interface.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloWorld {

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping("/helloWorld")
    public String say(){
        if(helloWorldService!=null)
            return helloWorldService.getMessage();
        else
            return "helloworld";
    }
}
