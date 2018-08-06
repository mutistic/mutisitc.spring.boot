package com.mutistic.start.additional;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.mutistic.utils.CommonUtil;

/**
 * @program 通过 @Profile 当激活对应配置文件或包含指定前缀的属性，组件可以注册
 * @description 1、@Profile 不支持null和空字符串。2、@Profile可以作用在类和方法上或方法参数上。3、支持NOT运算符(!)作为前缀，当某个配置文件处于非激活状态，组件才可以注册
 * @author mutisitic
 * @date 2018年6月20日
 */
@SpringBootConfiguration
//@Profile("dev") // @Profile(dev)：当SpringApplication.setAdditionalProfiles()激活dev配置文件时，TestBeanByProfile组件才被注册 
public class TestBeanByProfile {

	@Bean
	public Runnable runnable() {
		CommonUtil.printTwo("未声明@Profile：application.properties配置文件默认是激活的。直接注册runnable bean：", "runnable");
		return () -> {};
	}
	
	@Bean
	@Profile("dev")
	public Runnable devRunnable() {
		CommonUtil.printTwo("@Profile(dev)：当SpringApplication.setAdditionalProfiles()激活dev配置文件时，注册devRunnable bean：", "devRunnable");
		return () -> {};
	}
	
	@Bean
	@Profile("test")
	public Runnable testRunnable() {
		CommonUtil.printTwo("@Profile(test)：当SpringApplication.setAdditionalProfiles()激活test配置文件时，注册testRunnable bean：", "testRunnable");
		return () -> {};
	}
	
	@Bean
	@Profile("uat")
	public Runnable uatRunnable() {
		CommonUtil.printThree("@Profile(uat)：当SpringApplication.setAdditionalProfiles()激活uat配置文件时，注册uatRunnable bean：", "uatRunnable");
		return () -> {};
	}
}
