package com.mutistic.start.runs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @program Spring Boot运行流程分析
 * @description
 * @author mutisitic
 * @date 2018年7月18日
 */
@SpringBootApplication
public class MainBySpringApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MainBySpringApplication.class);
		ConfigurableApplicationContext context = app.run(args);
		
		
//		ConfigurableApplicationContext c1 =  SpringApplication.run(MainBySpringApplication.class, args);
	}
}
