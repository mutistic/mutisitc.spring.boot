package com.mutistic.start.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.config.DelegatingApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListenerFactory;
import org.springframework.context.event.EventListenerMethodProcessor;

import com.mutistic.start.initializer.MainByInitializer;
import com.mutistic.start.initializer.TestApplicationContextInitializer;
import com.mutistic.utils.CommonUtil;

/**
 * @program 简单实现自定义事件和监听
 * @description
 * @author mutisitic
 * @date 2018年7月3日
 */
@SpringBootApplication
public class MainByApplicationEvent {

	/**
	 * 发布事件流程：
	 * 1、自定义事件：一般是继承 ApplicationEvent 抽象类，重写构造函数
	 * 2、定义监听器：一般是实现 ApplicationListener 接口，重写 onApplicationEvent()方法
	 * 
	 * 3、启动时，要注册监听器到Application中
	 * 3.1、可以使用 SpringApplication.addListeners();
	 * 3.2、可以使用 @Component 等方式注册监听器到spring容器中
	 * 
	 * 3.3、通过配置项 context.listener.classes 注冊(默认配置文件：application.properties)（注册多个用 , 逗号隔开）
		1、具体实现原理是通过 DelegatingApplicationListener.onApplicationEvent() > getListeners()方法
		2、获取参数DelegatingApplicationListener.PROPERTY_NAME 配置的值
		3、然后在反射出具体类的 ApplicationListener 监听器

	 * 3.4、通过 @EventListener 注解实现事件的监听（作用于方法上，必须要有参数，参数为具体事件类 或者 EventObject子事件类（子类））
	 * 3.4.1、具体实现原理是通过 EventListenerMethodProcessor.afterSingletonsInstantiated() > processBean()方法：
	 * 	从spring容器中查找 有标注EventListener注解的方法
	 * 	然后方法参数通过 EventListenerFactory.createApplicationListener() 反射出ApplicationListener 监听器
	 * 
	 * 3.5、通过META-INF/spring.factories注册（注册多个用 , 逗号隔开）
	 * 
	 * 4、发布事件到Context中：使用的是 ApplicationContext接口，其继承的 ApplicationEventPublisher接口的 publishEvent()方法实现事件的发布
	 */
	/** 
	 * 1、spring已经声明的的监听器：参考 org.springframework.context.event包下：
	 *  如：ApplicationContextEvent、ContextStartedEvent
	 * 2、spring boot已经声明的的监听器：参考 org.springframework.boot.context.event包下:
	 *  如：ApplicationEnvironmentPreparedEvent、ApplicationStartedEvent
	 */ 
	
	public static void main(String[] args) {
		showByAddListeners(args);
		showByComponent(args);
		showByPropertions(args);
		showByEventListener(args);
		showByFactories(args);
	}
	
	
	/**
	 * @description 3.1、通过 SpringApplication.addListeners()方法注册监听器
	 * @author mutisitic
	 * @date 2018年7月18日
	 * @param args
	 */
	private static void showByAddListeners(String[] args) {
		CommonUtil.printOne("3.1、通过 SpringApplication.addListeners()方法注册监听器：");
		SpringApplication app = new SpringApplication(MainByApplicationEvent.class);
		app.addListeners(new TestApplicationListener());  // 3.1、添加监听器：将监听器注册到spring容器（application）中
		
		ConfigurableApplicationContext context = app.run(args);
		context.publishEvent(new TestApplicationEvent(new Object())); // 发布事件：将事件注册到context中
		context.close();
	}
	
	/**
	 * @description 3.2、通过  @Component 等方式注册监听器到spring容器中
	 * @author mutisitic
	 * @date 2018年7月18日
	 * @param args
	 */
	private static void showByComponent(String[] args) {
		CommonUtil.printOne("3.2、通过  @Component 等方式注册监听器到spring容器中：");
		SpringApplication app = new SpringApplication(MainByApplicationEvent.class);
		
		ConfigurableApplicationContext context = app.run(args);
		context.publishEvent(new TestApplicationEvent(new Object())); // 发布事件：将事件注册到context中
		context.close();
	}

	/**
	 * @description 3.3、通过配置项context.initializer.classes注册（注册多个用 , 逗号隔开）
	 * @author mutisitic
	 * @date 2018年7月18日
	 * @param args
	 */
	private static void showByPropertions(String[] args) {
		CommonUtil.printOne("3.3、通过配置项context.initializer.classes注册（注册多个用 , 逗号隔开）：");
		SpringApplication app = new SpringApplication(MainByApplicationEvent.class);
		
		ConfigurableApplicationContext context = app.run(args);
		context.publishEvent(new TestApplicationEvent(new Object())); // 发布事件：将事件注册到context中
		context.close();
	}
	
	/**
	 * @description  3.4、通过 @EventListener 注解实现事件的监听
	 * @author mutisitic
	 * @date 2018年7月18日
	 * @param args
	 */
	private static void showByEventListener(String[] args) {
		CommonUtil.printOne(" 3.4、通过 @EventListener 注解实现事件的监听：");
		SpringApplication app = new SpringApplication(MainByApplicationEvent.class);
		
		ConfigurableApplicationContext context = app.run(args);
		context.publishEvent(new TestApplicationEvent(new Object())); // 发布事件：将事件注册到context中
		context.close();
	}
	
	/**
	 * @description 3.5、通过MATE-INF/spring.facoties 注册监听器（注册多个用 , 逗号隔开）
	 * @author mutisitic
	 * @date 2018年7月18日
	 * @param args
	 */
	private static void showByFactories(String[] args) {
		CommonUtil.printOne("3.5、通过MATE-INF/spring.facoties 注册监听器（注册多个用 , 逗号隔开）：");
		SpringApplication app = new SpringApplication(MainByApplicationEvent.class);
		
		ConfigurableApplicationContext context = app.run(args);
		context.publishEvent(new TestApplicationEvent(new Object())); // 发布事件：将事件注册到context中
		context.close();
	}

}
