package com.mutistic.start.enable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program 配合 MainByEnableAutoConfiguration 实现启用属性自动注入特性 
 * @description 
 * @author mutisitic
 * @date 2018年6月22日
 */
@Component
@ConfigurationProperties(prefix="local")
public class TestEnableAutoProperties {

	private String ip;
	
	private String port;


	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "TestEnableAutoProperties [ip=" + ip + ", port=" + port + "]";
	}
	
}
