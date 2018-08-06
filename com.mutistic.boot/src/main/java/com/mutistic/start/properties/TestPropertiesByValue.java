package com.mutistic.start.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mutistic.utils.CommonUtil;

/**
 * @program 3、通过 @Value 自动注入 application.properties声明的属性
 * @description 
 * @author mutisitic
 * @date 2018年6月14日
 */
@Component
public class TestPropertiesByValue {

	@Value("${local.ip}")
//	@Value(value = "${local.ip}")
	private String localIP;
	
	@Value("${name}")
	private String name;
	/**
	 * 通过  @Value 注解自动注入时 会根据字段类型进行转换
	 */
	@Value("${local.port}")
	private Integer localPort;
	
	
	/**
	 * 在application.properties 可以用 ${key}引用声明的属性
	 */
	@Value("${project.name}")
	private String projectName;
	
	/**
	 * 通过  @Value 注解，可以用 ${key:value}对字段给定默认值
	 */
	@Value("${tomcat.prot:9090}")
	private String tomcatPort;
	
	/**
	 * @description 通过  @Value 注解自动注入属性值
	 * @author mutisitic
	 * @date 2018年6月14日
	 */
	public void show() {
		CommonUtil.printThree("通过  @Value 注解自动注入 application.properties声明的属性：local.ip", localIP);
		CommonUtil.printThree("通过  @Value 注解自动注入 application.properties声明的属性(会根据字段类型进行转换)：local.prot:", localPort);
		CommonUtil.printThree("通过  @Value 注解自动注入 application.properties声明的属性：name", name);
		CommonUtil.printThree("通过  @Value 注解自动注入 在application.properties 可以用 ${key}引用声明的属性：project.name 引用 name", projectName);
		CommonUtil.printThree("通过  @Value 注解，可以用 ${key:value}对字段给定默认值，优先取application.properties的值", tomcatPort);
	}
	
}
