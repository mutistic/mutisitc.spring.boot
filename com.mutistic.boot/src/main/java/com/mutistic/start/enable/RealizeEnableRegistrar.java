package com.mutistic.start.enable;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

/**
 * @program 模拟@Enable注解
 * @description 特性：通过@Import 导入RealizeImportBeanDefinitionRegistrar 将传递过来的class参数注入到spring容器中
 * @author mutisitic
 * @date 2018年6月22日
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RealizeImportBeanDefinitionRegistrar.class)
public @interface RealizeEnableRegistrar {
	
//	Class[] beans();
	Class<?>[] beans(); 
}
