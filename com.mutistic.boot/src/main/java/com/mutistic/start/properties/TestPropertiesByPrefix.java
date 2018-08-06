package com.mutistic.start.properties;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.mutistic.utils.CommonUtil;

/**
 * @program 5、通过 @ConfigurationProperties 加载指定前缀属性
 * @description 通过prefix属性会从默认加载指定前缀的属性（加载后，则不会再次加载。默认配置文件查找不到，会匹配整个上下文资源文件中的前缀），通过字段的set方法注入。
 * @author mutisitic
 * @date 2018年6月19日
 */
@Component
@PropertySource(value = "test-jdbc.properties")
@ConfigurationProperties(prefix = "test") // prefix指定属性前缀。其中locations属性已删除
public class TestPropertiesByPrefix {

	private String jdbcUrl;

	private String driverClassName;

	private String jdbcUsername;
	
	private String jdbcPassword;
	
	// 声明格式 key[index]=value
	private List<String> jdbcHostList;// = new ArrayList<String>();
	
	// 声明格式 key[index]=value
	private Integer[] jdbcProtArray;

	public void show() {
		CommonUtil.printTwo("通过 @Value 自动注入 test-jdbc.properties声明的属性：jdbcUrl", jdbcUrl);
		CommonUtil.printThree("通过 @Value 自动注入 test-jdbc.properties声明的属性：driverClassName", driverClassName);
		CommonUtil.printThree("通过 @Value 自动注入 test-jdbc.properties声明的属性：jdbcUsername", jdbcUsername);
		CommonUtil.printThree("通过 @Value 自动注入 test-jdbc.properties声明的属性：jdbcPassword", jdbcPassword);
		CommonUtil.printThree("通过 @Value 自动注入 test-jdbc.properties声明的属性(集合)：jdbcHostList", jdbcHostList);
		CommonUtil.printThree("通过 @Value 自动注入 test-jdbc.properties声明的属性(数组)：jdbcProtArray", Arrays.asList(jdbcProtArray));
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getJdbcUsername() {
		return jdbcUsername;
	}

	public void setJdbcUsername(String jdbcUsername) {
		this.jdbcUsername = jdbcUsername;
	}

	public String getJdbcPassword() {
		return jdbcPassword;
	}

	public void setJdbcPassword(String jdbcPassword) {
		this.jdbcPassword = jdbcPassword;
	}

	public List<String> getJdbcHostList() {
		return jdbcHostList;
	}

	public void setJdbcHostList(List<String> jdbcHostList) {
		this.jdbcHostList = jdbcHostList;
	}

	public Integer[] getJdbcProtArray() {
		return jdbcProtArray;
	}

	public void setJdbcProtArray(Integer[] jdbcProtArray) {
		this.jdbcProtArray = jdbcProtArray;
	}

}
