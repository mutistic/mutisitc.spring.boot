package com.mutistic.start.enable;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.mutistic.utils.CommonUtil;

/**
 * @program 配合 RealizeImportBeanDefinitionRegistrar 实现 @RealizeEnableRegistrar 参数注入
 * @description
 * @author mutisitic
 * @date 2018年6月22日
 */
public class RealizeBeanPostProcessor implements BeanPostProcessor {

	private Class<?>[] beans;
	private boolean isPrint = false;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		if (isPrint || beans == null || beans.length < 0) {
			return bean;
		}
		CommonUtil.printOne(RealizeBeanPostProcessor.class +"：配合 RealizeImportBeanDefinitionRegistrar 实现 @RealizeEnableRegistrar 参数注入");
		CommonUtil.printThree("Processor-获取传入的参数：beans", Arrays.asList(beans));
		isPrint = true;

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	public Class<?>[] getBeans() {
		return beans;
	}

	public void setBeans(Class<?>[] beans) {
		this.beans = beans;
	}

}
