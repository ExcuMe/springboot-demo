package com.example.demo.proxy.CGLIB;


import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author wuyj38634
 * @date 2021/8/9
 * 方法拦截器
 */
@Slf4j
public class HelloWorldMethodInterceptor  implements MethodInterceptor{
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        log.info("Before Birth " + Arrays.toString(args));
        System.out.println("Before Birth" + Arrays.toString(args));
        return proxy.invokeSuper(obj, args);
    }
}
