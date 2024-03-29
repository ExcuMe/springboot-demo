package com.example.demo;

import com.example.demo.bean.Person;
import com.example.demo.bean.Student;
import com.example.demo.proxy.StudentStaticProxy;
import com.example.demo.service.HelloWorldService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private HelloWorldService helloWorldService;

	@Test
	public void helloWorld(){
//		helloWorldService.sa
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void staticProxyTest(){
		Person student = new Student("zhangSan");
		Person studentProxy = new StudentStaticProxy(student);
		studentProxy.commitFee();
	}

}
