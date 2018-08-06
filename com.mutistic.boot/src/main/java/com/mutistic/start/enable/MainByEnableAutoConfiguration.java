package com.mutistic.start.enable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.mutistic.utils.CommonUtil;

/**
 * @program 使用 @EnableAutoConfiguration 启用一个特性：将配置文件的属性注入到bean中
 * @description 1、实际上起作用的是 @EnableConfigurationProperties 注解。2、@SpringBootApplication 中标注了 @EnableAutoConfiguration注解。
 * 3、@Enable 启用特性实际上是使用 @Import 导入类来实现的。
 * @author mutisitic
 * @date 2018年6月22日
 */
@EnableAutoConfiguration
// @EnableConfigurationProperties
@ComponentScan
public class MainByEnableAutoConfiguration {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByEnableAutoConfiguration.class, args);
		CommonUtil.printOne("使用 @EnableAutoConfiguration 启用一个特性：将配置文件的属性注入到bean中");
		CommonUtil.printThree("使用@ConfigurationProperties 注解通过set方法注入属性", context.getBean(TestEnableAutoProperties.class).toString());
		context.close();
	} 
}
