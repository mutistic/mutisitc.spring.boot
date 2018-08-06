package com.mutistic.start.enable;

import org.springframework.context.annotation.Bean;

/**
 * @program 配合 MainByImport 使用@Import导入配置类
 * @description 
 * @author mutisitic
 * @date 2018年6月25日
 */
//@SpringBootConfiguration // @Import导入可以不用声明@SpringBootConfiguration等注解
public class TestImportConfiguration {

	@Bean
	public TestBeanByImport createrTestBeanByImport() {
		return new TestBeanByImport();
	}
	
	
	@Bean
	public TestBeanByImport createrTestBeanByImport2() {
		return new TestBeanByImport();
	}
	
}
