package com.mutistic.start.enable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.mutistic.utils.CommonUtil;


/**
 * @program 使用 @Import 导入一个或多个类（可以普通类、配置类、ImportSelector接口实现类、ImportBeanDefinitionRegistrar接口实现类）
 * @description
 * @author mutisitic
 * @date 2018年6月22日
 */
@SpringBootApplication
@Import({TestBeanByImport.class, TestImportConfiguration.class})
//@Import(TestImportSelector.class) // 使用ImportSelector.selectImports() 导入返回的class数组。ImportSelector接口实现类本身不会被默认装配成bean
//@TestEnableByImport(name = "mainByImport") // 使用自定义注解实现 @Import：模拟@Enable注解
//@Import(TestImportBeanDefinitionRegistrar.class) // 使用ImportBeanDefinitionRegistrar接口实现类，动态注入bean
public class MainByImport {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByImport.class, args);
		CommonUtil.printOne("使用 @Import 导入一个或多个类：");
		CommonUtil.printThree("获取导入的普通类：", context.getBean("com.mutistic.start.enable.TestBeanByImport"));
		CommonUtil.printThree("获取导入的配置类：", context.getBeansOfType(TestImportConfiguration.class));
		CommonUtil.printThree("获取导入的配置类创建的bean：", context.getBeansOfType(TestBeanByImport.class));
		context.close();
	}
}
