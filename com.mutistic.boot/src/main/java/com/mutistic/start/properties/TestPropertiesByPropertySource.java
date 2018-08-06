package com.mutistic.start.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import com.mutistic.utils.CommonUtil;

/**
 * @program 4、通过 @PropertySource 加载指定资源文件
 * @description 通过其 value 属性指定资源文件路径： classpath 默认去查找根路径下的文件。file 可以指定绝对路径
 * @author mutisitic
 * @date 2018年6月19日
 */
@Component
@PropertySource(value = "test-jdbc.properties")
@PropertySource(value = "file:C:/Work/Study/GitProduct/mutistic.spring/com.mutistic.boot/notes/test/test-jdbc2.properties") // 可以加载多个配置文件
//@PropertySource( name="test-jdbc.properties", value= {"classpath:test-jdbc.properties"}, ignoreResourceNotFound=false, encoding="UTF-8")
//@PropertySource(value = {"clapatch:test-jdbc.properties", "file:C:/Work/Study/GitProduct/mutistic.spring/com.mutistic.boot/notes/test/test-jdbc2.properties"}) // 可以用使用 value 加载多个配置文件
//@PropertySources({@PropertySource(value = "test-jdbc.properties"), @PropertySource(value = "file:C:/Work/Study/GitProduct/mutistic.spring/com.mutistic.boot/notes/test/test-jdbc2.properties")}) // 可以使用 @PropertiesSources 加载多个配置为文件
public class TestPropertiesByPropertySource {

	@Value("${test.jdbcUrl}")
	private String jdbcUrl;

	@Value("${test.driverClassName}")
	private String driverClassName;

	@Value("${jdbc2.username}") // test-jdbc2.properties
	private String jdbcUsername;
	
	@Value("${jdbc2.password}") // test-jdbc2.properties
	private String jdbcPassword;
	
	public void show() {
		CommonUtil.printTwo("通过 @Value 自动注入 test-jdbc.properties声明的属性：test.jdbcUrl", jdbcUrl);
		CommonUtil.printThree("通过 @Value 自动注入 test-jdbc.properties声明的属性：test.driverClassName", driverClassName);
		CommonUtil.printThree("通过 @Value 自动注入 test-jdbc2.properties声明的属性：jdbc2.username", jdbcUsername);
		CommonUtil.printThree("通过 @Value 自动注入 test-jdbc2.properties声明的属性：jdbc2.password", jdbcPassword);
	}

}
