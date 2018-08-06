package com.mutistic.start.enable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import com.mutistic.utils.CommonUtil;

/**
 * @program 使用 @EnableAsync 启用异步执行特性
 * @description
 * @author mutisitic
 * @date 2018年6月22日
 */
@SpringBootApplication
@EnableAsync // 启用异步特性
public class MainByEnableAsync {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByEnableAsync.class, args);
		CommonUtil.printOne("使用 @EnableAsync 启用异步执行特性");
		context.getBean("testEnableAsync", Runnable.class).run();
		CommonUtil.printOne("使用 @EnableAsync 启用异步执行特性===END===");
		context.close();
	}
}
