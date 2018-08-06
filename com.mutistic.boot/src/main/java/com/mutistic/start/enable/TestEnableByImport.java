package com.mutistic.start.enable;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

/**
 * @program 使用自定义注解 实现 @Import：模拟@Enable注解
 * @description 
 * @author mutisitic
 * @date 2018年6月22日
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(TestImportSelector.class) // 使用 @Import 导入 TestImportSelector
public @interface TestEnableByImport {

	String name() ;
}
