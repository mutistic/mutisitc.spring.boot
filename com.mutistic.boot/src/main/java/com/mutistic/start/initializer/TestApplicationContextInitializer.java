package com.mutistic.start.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import com.mutistic.utils.CommonUtil;

/**
 * @program 演示Spring容器初始化之前的回调接口：ApplicationContextInitializer 
 * @description 容器初始化之前指：ConfigurableApplicationContext#refresh()。
 * @author mutisitic
 * @date 2018年7月18日
 */
public class TestApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	/**
	 * @description 演示Spring容器初始化之前的回调接口
	 * @author mutisitic
	 * @date 2018年7月18日
	 * @param applicationContext
	 * @see org.springframework.context.ApplicationContextInitializer#initialize(org.springframework.context.ConfigurableApplicationContext)
	 */
	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		CommonUtil.printTwo("TestApplicationContextInitializer 获取bean数量", applicationContext.getBeanDefinitionCount());
		for (String name : applicationContext.getBeanDefinitionNames()) {
			CommonUtil.printThree("bean name：", name);
		}
	}
}
