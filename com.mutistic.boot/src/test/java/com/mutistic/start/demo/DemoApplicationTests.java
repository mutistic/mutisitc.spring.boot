package com.mutistic.start.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.mutistic.start.demo.DemoApplication;

/**
 * @program Spring Boot Application 模板测试类
 * @description 基于Junit4 的基本的集成测试类
 * @author mutisitic
 * @date 2018年5月31日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@ActiveProfiles(profiles = "test")
public class DemoApplicationTests {

	/**
	 * @RunWith(SpringRunner.class)：RunWith：运行器。SpringRunner.class：运行Spring测试环境
	   @SpringBootTest：SpringBoot自1.4.0版本开始引入的一个用于测试的注解。
		  1、classes：属性指定具体的启动类。
		  2、SpringBootTest.WebEnvironment.RANDOM_PORT 经常和测试类中 @LocalServerPort 一起在注入属性时使用。会随机生成一个端口号。
	   @ActiveProfiles(profiles = "test")：在测试类上面指定profiles，可以改变当前spring 的profile，来达到多环境的测试
	 */
	
	
	/**
	 * @description 测试方法入口：加载上下文
	 * @author mutisitic
	 * @date 2018年5月31日
	 */
	@Test
	public void contextLoads() {
		System.out.println("Demo Application Spring Boot Tests!");
	}

}
