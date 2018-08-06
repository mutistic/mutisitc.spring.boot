package com.mutistic.start.properties;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.mutistic.utils.CommonUtil;

/**
 * @program 获取默认配置文件或其他配置文件声明的属性值
 * @description 
 * @author mutisitic
 * @date 2018年6月14日
 */
@SpringBootApplication
public class MainByProperties {
	public static void main(String[] args) {
		showPropertiesByConfigurableEnvironment(args);
		showPropertiesBySystemEnvironment(args);
		showPropertiesByEnvironment(args);
		showPropertiesByValue(args);
		showPropertiesByPropertySource(args);
		showPropertiesByPrifex(args);
		showPropertiesByEnvironmentPostProcessor(args);
	}

	/**
	 * @description 1.1、通过ConfigurableApplicationContext.getEnvironment().getProperty()获取具体属性值
	 * @author mutisitic
	 * @date 2018年6月14日
	 * @param args
	 */
	private static void showPropertiesByConfigurableEnvironment(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByProperties.class, args);
		ConfigurableEnvironment env = context.getEnvironment();
		
		CommonUtil.printOne("1.1、通过ConfigurableApplicationContext.getEnvironment().getProperty()获取指定属性值：");
		CommonUtil.printThree("获取 application.properties声明的属性：local.ip", env.getProperty("local.ip"));
		CommonUtil.printThree("获取 application.yml声明的属性：local.name", env.getProperty("local.name"));
		
		context.close();
		CommonUtil.println();
	}
	
	/**
	 * @description 1.2、通过ConfigurableEnvironment.getSystemEnvironment()获取指定系统环境中的属性值
	 * @author mutisitic
	 * @date 2018年6月14日
	 * @param args
	 */
	private static void showPropertiesBySystemEnvironment(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByProperties.class, args);
		ConfigurableEnvironment env = context.getEnvironment();

		CommonUtil.printOne("1.2、通过ConfigurableApplicationContext.getSystemEnvironment()获取指定系统环境中的属性值：");
		Map<String, Object> systemMap = env.getSystemEnvironment();
		for (String key : systemMap.keySet()) {
			CommonUtil.printThree("获取系统环境中的属性："+key, systemMap.get(key));
		}
		
		context.close();
		CommonUtil.println();
	}
	
	/**
	 * @description 2、通过 自动注入 Environment 获取属性值
	 * @author mutisitic
	 * @date 2018年6月14日
	 * @param args
	 */
	private static void showPropertiesByEnvironment(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByProperties.class, args);
		CommonUtil.printOne("2、通过 自动注入 Environment 的 getProperty() 获取属性值：");
		
		context.getBean(TestPropertiesByEnvironment.class).show();
		
		context.close();
		CommonUtil.println();
	}
	
	/**
	 * @description 3、通过 @Value 自动注入 application.properties声明的属性
	 * @author mutisitic
	 * @date 2018年6月14日
	 * @param args
	 */
	private static void showPropertiesByValue(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByProperties.class, args);
		CommonUtil.printOne("3、通过 @Value 自动注入 application.properties声明的属性：");
		
		context.getBean(TestPropertiesByValue.class).show();
		
		context.close();
		CommonUtil.println();
	}
	
	/**
	 * @description 4、通过 @PropertySource 加载指定资源文件
	 * @author mutisitic
	 * @date 2018年6月14日
	 * @param args
	 */
	private static void showPropertiesByPropertySource(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByProperties.class, args);
		CommonUtil.printOne("4、通过 @PropertySource 加载指定资源文件：");
		
		context.getBean(TestPropertiesByPropertySource.class).show();
		
		ConfigurableEnvironment env = context.getEnvironment();
		CommonUtil.printThree("通过 env.getProperty() 获取 test-jdbc.properties声明的属性：jdbcUrl", env.getProperty("jdbcUrl"));
		CommonUtil.printThree("通过 env.getProperty() 获取 test-jdbc.properties声明的属性：driverClassName", env.getProperty("driverClassName"));
		
		context.close();
		CommonUtil.println();
	}
	
	/**
	 * @description 5、通过 @ConfigurationProperties 加载指定前缀属性
	 * @author mutisitic
	 * @date 2018年6月14日
	 * @param args
	 */
	private static void showPropertiesByPrifex(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByProperties.class, args);
		CommonUtil.printOne("5、通过 @ConfigurationProperties 加载指定前缀属性：");
		
		context.getBean(TestPropertiesByPrefix.class).show();
		
		context.close();
		CommonUtil.println();
	}
	
	/**
	 * @description 6、通过实现 EnvironmentPostProcessor 自定义注入配置文件： 
	 * @author mutisitic
	 * @date 2018年6月19日
	 * @param args
	 */
	private static void showPropertiesByEnvironmentPostProcessor(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByProperties.class, args);
		ConfigurableEnvironment env = context.getEnvironment();
		CommonUtil.printOne("6、通过实现 EnvironmentPostProcessor 动态注入自定义配置文件：");
		CommonUtil.printThree("TestEnvironmentPostProcessor 实现 EnvironmentPostProcessor bean：", context.getBean(TestEnvironmentPostProcessor.class));
		CommonUtil.printThree("获取 自定义配置文件 test-processor.properties 的属性值 project：", env.getProperty("project"));
		CommonUtil.printThree("获取 自定义配置文件 test-processor.properties 的属性值 author：", env.getProperty("author"));
		CommonUtil.printThree("获取 自定义配置文件 test-processor.properties 的属性值 time：", env.getProperty("time"));
	}
	
}
