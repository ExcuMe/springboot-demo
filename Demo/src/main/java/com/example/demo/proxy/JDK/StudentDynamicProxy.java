package com.example.demo.proxy.JDK;

import com.example.demo.bean.Person;
import com.example.demo.bean.Student;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @author wuyj38634
 * @date 2021/8/6
 * 动态代理类
 */
@Slf4j
public class StudentDynamicProxy {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        log.info("JDK动态代理");

        //创建一个实例对象，这个对象是被代理的对象
        Person student = new Student("张三");

        //创建一个与代理对象相关联的InvocationHandler
        InvocationHandler stuHandler = new StudentInvocationHandler<Person>(student);

        /**
         * JDK动态代理,基于接口的
         */
        // 使用Proxy类的getProxyClass静态方法生成一个动态代理类stuProxyClass
        Class<?> stuProxyClass = Proxy.getProxyClass(Person.class.getClassLoader(), new Class<?>[] {Person.class});

        // 获得stuProxyClass 中一个带InvocationHandler参数的构造器constructor
        Constructor<?> constructor = stuProxyClass.getConstructor(InvocationHandler.class);

        // 通过构造器constructor来创建一个动态实例stuProxy ,动态加载一个stuProxy类（包含InvocationHandler）
        Person stuProxy = (Person) constructor.newInstance(stuHandler);
        stuProxy.commitFeeCheck();

        System.out.println("===============================================================================");

        /**
         * JDK动态代理简化，使用Proxy.newProxyInstance生成代理类
         */

        //创建一个代理对象stuProxy来代理zhangsan，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        //JDK动态代理的要求： 被代理的类需要实现接口。Proxy.newProxyInstance第二个参数是接口类型的参数
        Person studentDynamicProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandler);

        //代理执行上交班费的方法
        studentDynamicProxy.commitFeeCheck();

//        InvocationHandler handler1 = new StudentInvocationHandler<>(student);
//        Person student1 = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandler);
//        student1.commitFeeCheck();

    }
}
