package com.mutistic.start.auto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.google.gson.Gson;
import com.mutistic.utils.CommonUtil;

/**
 * @program @EnableAutoConfiguration 深入分析
 * @description 
 * @author mutisitic
 * @date 2018年6月25日
 */
//@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class MainByEnableAutoConfiguration {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByEnableAutoConfiguration.class, args);
		showBeanBySpringFactories(context);
		showBeanByGsonAutoConfiguration(context);
		context.close();
	}

	/**
	 * 一、@SpringBootApplication 能够启用自动配置Spring应用程序上下文的原因：
	 * 1、标注了 @EnableAutoConfiguration 注解
	 * 2、@EnableAutoConfiguration 本身 使用了 @Import 导入了 AutoConfigurationImportSelector.class
	 * 3、AutoConfigurationImportSelector 本身是 ImportSelector接口的一个实现子类。
	 * 
	 * 二、spring boot 通过 EnableAutoConfiguration.ENABLED_OVERRIDE_PROPERTY = "spring.boot.enableautoconfiguration"
	 *  参数启用自动配置（默认为true，false表示不启用自动配置）properties语法：key=value：spring.boot.enableautoconfiguration=true
	 *  
	 * 三、 @EnableAutoConfiguration 配置类，从所有的classpatch中搜索 META-INF/spring.factories 设置需要启用自动配置的类：
	 * spring.factories语法(多个类用 , 隔开)：key=classname,classname
	 * org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.mutistic.start.auto.MainByEnableAutoConfiguration
	 * 
	 * 四、AutoConfigurationImportSelector 加载机制
	 * 1、通过 isEnabled()方法判断自动配置是否启用即：EnableAutoConfiguration.ENABLED_OVERRIDE_PROPERTY=true
	 * 2、通过 getAttributes() 方法获取 spring.factories 获取需要自动配置的类
	 * 3、通过 getCandidateConfigurations 方法：通过SpringFactoriesLoader.loadFactoryNames()方法从 classpatch中
	 * 搜索所有的META-INF/spring.factories配置文件，并读取其配置的类。
	 * 4、通过 selectImports() 方法返回最终要导入的类的集合给@Import完成导入，并同时注册bean到spring中
	 * 
	 * 五、@EnableAutoConfiguration 可以通过 exclude() 根据类class来排除，可以通过excludeName() 根据类名排除。
	 * 
	 * 六、可以参考 spring-boot-autoconfigure/META-INF/spring.factories的配置文件，
	 * org.springframework.boot.autoconfigure包下spring boot启动时默认自动配置bean
	 */
	@Bean
	public Runnable createrRunnable() {
		return () -> {};
	}
	
	/**
	 * @description 从META-INF/spring.factories设置 EnableAutoConfiguration
	 * @author mutisitic
	 * @date 2018年6月25日
	 * @param context
	 */
	private static void showBeanBySpringFactories(ConfigurableApplicationContext context) {
		CommonUtil.printOne("从META-INF/spring.factories设置 EnableAutoConfiguration：");
		CommonUtil.printThree("spring.factories语法：key=class", 
				"org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.mutistic.start.auto.MainByEnableAutoConfiguration");
		CommonUtil.printThree("获取依赖项目的配置的bean", context.getBeansOfType(Runnable.class));
	}
	
	@Bean
	public Gson createrGson() {
		return new Gson();
	}
	
	/**
	 * @description 查看spring boot 启动时默认自动配置bean
	 * @author mutisitic
	 * @date 2018年6月25日
	 * @param context
	 */
	private static void showBeanByGsonAutoConfiguration(ConfigurableApplicationContext context) {
		CommonUtil.printOne("查看spring boot 启动时默认自动配置bean");
		CommonUtil.printThree("自定义 ：Gson bean", context.getBean("createrGson"));
		CommonUtil.printThree("获取org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration自动配置的默认的Gson bean", "gson()");
		CommonUtil.printThree("GsonAutoConfiguration：Gson bean", context.getBeansOfType(Gson.class)); // 自定义注册的Gson bean优先级高于GsonAutoConfiguration注册的bean
	}
	
}
