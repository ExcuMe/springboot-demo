package com.example.demo;

import com.Interface.HelloWorldService;
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

}
