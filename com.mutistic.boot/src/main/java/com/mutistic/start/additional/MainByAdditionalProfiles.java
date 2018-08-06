package com.mutistic.start.additional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.mutistic.utils.CommonUtil;

/**
 * @program 设置需要激活配置文件
 * @description 默认的配置文件是自动激活生效的。可以激活多个配置文件。也可以使用启动参数来激活生效的配置文件 --spring.profiles.active=test,uat
 * @author mutisitic
 * @date 2018年6月20日
 */
@SpringBootApplication
public class MainByAdditionalProfiles {

	public static void main(String[] args) {
		showPropertiesByAdditionalProfiles(args, null);
		showPropertiesByAdditionalProfiles(args, "dev");
		showPropertiesByAdditionalProfiles(args, "test");
		showPropertiesByAdditionalProfiles(args, "uat");
	}

	/**
	 * @description 通过指定的 profiles 激活配置文件
	 * @author mutisitic
	 * @date 2018年6月19日
	 * @param args
	 * @param profiles
	 */
	private static void showPropertiesByAdditionalProfiles(String[] args, String profiles) {
		SpringApplication app = new SpringApplication(MainByAdditionalProfiles.class);
		String fileName = "application.properties";
		if (profiles != null && !profiles.isEmpty()) {
			app.setAdditionalProfiles(profiles, "dev"); // 设置生效文件，可以设置多个。
			fileName = "application-" + profiles + ".properties或包含"+ fileName +"前缀的属性";
		}
		ConfigurableApplicationContext context = app.run(args);
		ConfigurableEnvironment env = context.getEnvironment();

		CommonUtil.printOne("通过SpringApplication.setAdditionalProfiles()激活文件：" + fileName);
		if("test".equals(profiles)) {
			CommonUtil.printThree("获取激活后的" + fileName + "属性值：test.jdbcUrl", env.getProperty("test.jdbcUrl"));
			CommonUtil.printThree("获取激活后的" + fileName + "属性值：test.driverClassName", env.getProperty("test.driverClassName"));
			CommonUtil.printThree("获取激活后的" + fileName + "属性值：test.jdbcUsername", env.getProperty("test.jdbcUsername"));
			CommonUtil.printThree("获取激活后的" + fileName + "属性值：test.jdbcPassword", env.getProperty("test.jdbcPassword"));
		} else {
			CommonUtil.printThree("获取激活后的" + fileName + "属性值：jdbc.url", env.getProperty("jdbc.url"));
			CommonUtil.printThree("获取激活后的" + fileName + "属性值：jdbc.driverClassName", env.getProperty("jdbc.driverClassName"));
			CommonUtil.printThree("获取激活后的" + fileName + "属性值：jdbc.username", env.getProperty("jdbc.username"));
			CommonUtil.printThree("获取激活后的" + fileName + "属性值：jdbc.password", env.getProperty("jdbc.password"));
		}
		
		context.close();
		CommonUtil.println();
	}

}
