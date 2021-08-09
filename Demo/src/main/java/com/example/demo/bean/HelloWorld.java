package com.example.demo.bean;

import lombok.Data;

/**
 * @author wuyj38634
 * @date 2021/8/9.
 * 此类没有实现接口，所以不能使用JDK动态代理，可使用CGLIB动态代理的方式
 */
@Data
public class HelloWorld {
    private String name;

    HelloWorld(String name){
        this.name = name;
    }

    HelloWorld(){}

    public void birth(){
        System.out.println("HELLO WORLD " + name);
    }
}
