package com.mutistic.start.enable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.mutistic.utils.CommonUtil;

/**
 * @program 模拟实现 @Enable、@Import、ImportBeanDefinitionRegistrar、BeanPostProcessor组合使用
 * @description 
 * @author mutisitic
 * @date 2018年6月22日
 */
@SpringBootApplication
@RealizeEnableRegistrar(beans = {RealizeBeanOne.class, RealizeBeanTwo.class}) // 启用 @RealizeEnableRegistrar 特性
public class MainByRealizeEnable {
	
	public static void main(String[] args) {
		CommonUtil.printOne(MainByRealizeEnable.class +"：模拟实现 @Enable、@Import、ImportBeanDefinitionRegistrar、BeanPostProcessor组合使用：");
		ConfigurableApplicationContext context = SpringApplication.run(MainByRealizeEnable.class, args);
		CommonUtil.printTwo("Main-通过 @RealizeEnableRegistrar 获取注入spring容器中的RealizeBeanOne bean", context.getBean(RealizeBeanOne.class));
		CommonUtil.printThree("Main-通过 @RealizeEnableRegistrar 获取注入到spring容器中的RealizeBeanTwo bean", context.getBean(RealizeBeanTwo.class));
		context.close();
	}
}
