package com.mutistic.start.value;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.mutistic.utils.CommonUtil;

/**
 * @program 演示 设置 properties的默认值
 * @description
 * @author mutisitic
 * @date 2018年7月18日
 */
public class MainByValue {
	public static void main(String[] args) {
		showByEnvironment(args);
		showByValue(args);
		showBySetDefaultProperties(args);
		showByOrder(args);
	}

	/**
	 * @description 1、通过 ConfigurableEnvironment.getProperty(String key, String
	 *              defaultValue)设置默认值
	 * @author mutisitic
	 * @date 2018年7月18日
	 * @param args
	 */
	private static void showByEnvironment(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByValue.class, args);
		ConfigurableEnvironment env = context.getEnvironment();
		CommonUtil.printThree("1、通过 ConfigurableEnvironment.getProperty(String key, String defaultValue)设置默认值",
				env.getProperty("local.port", "9999"));
		context.close();
	}

	@Value("${local.port:11111}")
	private String localPort;

	/**
	 * @description 2、通过 @Value("${key:defaultValue}")设置默认值
	 * @author mutisitic
	 * @date 2018年7月18日
	 * @param args
	 */
	private static void showByValue(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByValue.class, args);
		CommonUtil.printThree("2、通过 @Value(\"${key:defaultValue}\")设置默认值",
				context.getBean(MainByValue.class).localPort);
		context.close();
	}

	/**
	 * @description 3、通过 SpringApplication.setDefaultProperties()设置默认值
	 * @author mutisitic
	 * @date 2018年7月18日
	 * @param args
	 */
	private static void showBySetDefaultProperties(String[] args) {
		SpringApplication app = new SpringApplication(MainByValue.class);
		Map<String, Object> maps = new HashMap<>();
		maps.put("local.port", "22222");
		app.setDefaultProperties(maps);

		ConfigurableApplicationContext context = app.run(args);
		CommonUtil.printThree("3、通过 SpringApplication.setDefaultProperties()设置默认值",
				context.getBean(MainByValue.class).localPort);
		context.close();
	}

	/**
	 * @description 限制配置项的优先级
	 * @author mutisitic
	 * @date 2018年7月18日
	 * @param args
	 */
	private static void showByOrder(String[] args) {
		/**
		 * 设置默认值优先级： application.properties > SpringApplication.setDefaultProperties()
		 * > @Value("${key:defaultValue}") > ConfigurableEnvironment.getProperty(String
		 * key, String defaultValue)
		 * 
		 * PS:配置文件未配置时：ConfigurableEnvironment.getProperty(String key, String
		 * defaultValue)是独立的
		 */
		SpringApplication app = new SpringApplication(MainByValue.class);
		Map<String, Object> maps = new HashMap<>();
		maps.put("local.port", "22222");
		app.setDefaultProperties(maps);

		ConfigurableApplicationContext context = app.run(args);
		ConfigurableEnvironment env = context.getEnvironment();
		CommonUtil.printThree("application.properties", env.getProperty("local.port"));
		CommonUtil.printThree("SpringApplication.setDefaultProperties()", context.getBean(MainByValue.class).localPort);
		CommonUtil.printThree("@Value(\"${key:defaultValue}\")", context.getBean(MainByValue.class).localPort);
		CommonUtil.printThree("ConfigurableEnvironment.getProperty(String key, String defaultValue)设置默认值",
				env.getProperty("local.port", "9999"));
		context.close();
	}

}
