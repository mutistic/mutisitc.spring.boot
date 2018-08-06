package com.mutistic.start.enable;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.mutistic.utils.CommonUtil;

/**
 * @program 模拟 ImportBeanDefinitionRegistrar 接口 实现动态注入
 * @description 将@RealizeEnableRegistrar 将class参数注入到spring容器和RealizeBeanPostProcessor中。
 * @author mutisitic
 * @date 2018年6月22日
 */
public class RealizeImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		CommonUtil.printOne(RealizeImportBeanDefinitionRegistrar.class +"：模拟 ImportBeanDefinitionRegistrar 接口 实现动态注入bean");
		Class<?>[] beans = null;

		// 获取 @RealizeEnableRegistrar 注解的属性值
		Map<String, Object> attrMap = importingClassMetadata.getAnnotationAttributes(RealizeEnableRegistrar.class.getName());
		if (attrMap.containsKey("beans")) {
			beans = (Class<?>[]) attrMap.get("beans");
		}
		if(beans == null || beans.length <= 0) {
			return;
		}
		CommonUtil.printThree("Registrar-获取 @RealizeEnableRegistrar 注解的属性值 beans", Arrays.asList(beans));
		
		CommonUtil.printThree("Registrar-将  @RealizeEnableRegistrar 的class参数赋值到 RealizeBeanPostProcessor中，同时RealizeBeanPostProcessor注入到spring容器中", 
				RealizeBeanPostProcessor.class);
		BeanDefinitionBuilder bdb = BeanDefinitionBuilder.genericBeanDefinition(RealizeBeanPostProcessor.class);
		bdb.addPropertyValue("beans", beans); // 属性赋值
		registry.registerBeanDefinition(RealizeBeanPostProcessor.class.getName(), bdb.getBeanDefinition());
		
		for (Class<?> temp : beans) {
			CommonUtil.printThree("Registrar-将  @RealizeEnableRegistrar 的class参数  注入到spring容器中", temp);
			registry.registerBeanDefinition(temp.getName(), BeanDefinitionBuilder.genericBeanDefinition(temp).getBeanDefinition());
		}
	}

}
