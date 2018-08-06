package com.mutistic.start.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mutistic.utils.CommonUtil;

/**
 * @program Spring Boot Application模板类
 * @description 应用程序的启动引导类（bootstrap class），也是主要的Spring配置类
 * @author mutisitic
 * @date 2018年5月31日
 */
@SpringBootApplication
public class DemoApplication {

	/**
	 * @SpringBootApplication：开启(Spring)组件扫描和(Spring Boot)自动配置
	  	实际上，@SpringBootApplication将三个有用的注解组合在了一起，早期版本1.2.0之前还是需要同时标注这三个注解。
  		1、Spring的 @Configuration：标明该类使用Spring基于Java的配置。作为Java开发者会更倾向于使用基于Java而不是XML的配置。
  		2、Spring的 @ComponentScan：启用组件扫描，这样Web控制器类和其他组件才能被自动发现并注册为Spring应用程序上下文里的Bean。
  		3、Spring Boot的 @EnableAutoConfiguration：这个注解也可以称为 @Abracadabra，就是这一行配置开启了SpringBoot自动配置的功能，避免再写成篇的配置。 
	 */
	
	/**
	 * @description  应用程序入口
	 * @author mutisitic
	 * @date 2018年5月31日
	 * @param args 命令行参数
	 */
	public static void main(String[] args) {
		CommonUtil.printOne("@SpringBootApplication Demo启动类：");
		
		/**
		 * SpringApplication.run(DemoApplication.class, args); 负责启动引导应用程序
			 DemoApplication 本身还是一个启动引导类，提供main()方法。要运行Spring Boot应用程序有几种方式，其中包含传统的WAR文件部署。
			  但这里的 main() 方法让你可以在命令行里把该应用程序当作一个可执行JAR文件来运行。
			  这里向 SpringApplication.run() 传递了一个DemoApplication 类的引用，还有命令行参数，通过这些东西启动应用程序。
		 */
		SpringApplication.run(DemoApplication.class, args);
	}
}
