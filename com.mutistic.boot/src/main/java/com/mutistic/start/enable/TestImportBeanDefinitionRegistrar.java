package com.mutistic.start.enable;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @program 使用 ImportBeanDefinitionRegistrar.registerBeanDefinitions() 实现动态注入bean
 * @description 主要有 registerBeanDefinitions()的参数 BeanDefinitionRegistry 来实现动态注入
 * @author mutisitic
 * @date 2018年6月22日
 */
public class TestImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * @description 往spring容器中动态注入bean
	 * @author mutisitic
	 * @date 2018年6月22日
	 * @param importingClassMetadata
	 * @param registry
	 * @see org.springframework.context.annotation.ImportBeanDefinitionRegistrar#registerBeanDefinitions(org.springframework.core.type.AnnotationMetadata, org.springframework.beans.factory.support.BeanDefinitionRegistry)
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		registry.registerBeanDefinition("com.mutistic.start.enable.TestBeanByImport", 
				BeanDefinitionBuilder.genericBeanDefinition(TestBeanByImport.class).getBeanDefinition());
		registry.registerBeanDefinition(TestImportConfiguration.class.getName(), 
				BeanDefinitionBuilder.genericBeanDefinition(TestImportConfiguration.class).getBeanDefinition());
	}

}
