package com.mutistic.start.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @program 演示Spring初始化处理器：ApplicationContextInitializer
 * @description PS：不能通过@Component方式注册初始化处理器
 * @author mutisitic
 * @date 2018年7月18日
 */
@SpringBootApplication
public class MainByInitializer {
	
	/**
	 * ApplicationContextInitializer 接口是 Spring容器refresh()之前的回调接口：
	 * 1、实现 ApplicationContextInitializer 接口。
	 * 2、注册初始化处理器 ApplicationContextInitializer 实现类。
	 * 
	 * 实现方式：
	 * 1、通过 SpringApplication.addInitializers()方法注册初始化处理器
	 * 2、通过配置项context.initializer.classes注册初始化处理器（注册初始化处理器多个用 , 逗号隔开）
	 * 3、通过MATE-INF/spring.facoties 注册初始化处理器（注册初始化处理器多个用 , 逗号隔开）
git
	 */
	/** */
	public static void main(String[] args) {
		showByAddInitializers(args);
		showByPropertions(args);
		showByFactories(args);
	}

	/**
	 * @description 1、通过 SpringApplication.addInitializers()方法注册初始化处理器
	 * @author mutisitic
	 * @date 2018年7月18日
	 * @param args
	 */
	private static void showByAddInitializers(String[] args) {
		SpringApplication app = new SpringApplication(MainByInitializer.class);
		app.addInitializers(new TestApplicationContextInitializer());

		ConfigurableApplicationContext context = app.run(args);
		context.close();
	}

	/**
	 * @description 2、通过配置项context.initializer.classes注册初始化处理器（注册多个用 , 逗号隔开）
	 * @author mutisitic
	 * @date 2018年7月18日
	 * @param args
	 */
	private static void showByPropertions(String[] args) {
		SpringApplication.run(MainByInitializer.class, args).close();
	}

	/**
	 * @description 3、通过MATE-INF/spring.facoties 注册初始化处理器（注册多个用 , 逗号隔开）
	 * @author mutisitic
	 * @date 2018年7月18日
	 * @param args
	 */
	private static void showByFactories(String[] args) {
		SpringApplication.run(MainByInitializer.class, args).close();
	}

}
