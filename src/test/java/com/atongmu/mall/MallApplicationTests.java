package com.atongmu.mall;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class MallApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Before
	public void beforeTest(){
		System.out.println("<<<<<-------------开始测试------------->>>>>");
	}

	@After
	public void afterTest(){
		System.out.println("<<<<<-------------开始测试------------->>>>>");
	}

}
