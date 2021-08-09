package com.example.demo.proxy.CGLIB;

import com.example.demo.bean.HelloWorld;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author wuyj38634
 * @date 2021/8/9
 */
public class CglibProxy {
    public static void main(String[] args) {
        //在指定目录下生成动态代理类，我们可以反编译看一下里面到底是一些什么东西
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\Users\\hspcadmin\\Desktop");

        //创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();

        // 设置目标类的字节码文件
        enhancer.setSuperclass(HelloWorld.class);

        // 设置回调函数
        enhancer.setCallback(new HelloWorldMethodInterceptor());

        // 这里的creat方法就是正式的创建代理类
        HelloWorld helloWorldProxy = (HelloWorld) enhancer.create();

        // 调用代理类的方法
        helloWorldProxy.birth();
    }
}
