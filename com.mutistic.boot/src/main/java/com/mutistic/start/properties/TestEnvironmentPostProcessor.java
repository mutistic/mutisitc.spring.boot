package com.mutistic.start.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;

import com.mutistic.utils.CommonUtil;

/**
 * @program 6、通过实现 EnvironmentPostProcessor 自定义注入配置文件
 * @description
 * @author mutisitic
 * @date 2018年6月19日
 */
@Component
public class TestEnvironmentPostProcessor implements EnvironmentPostProcessor {

	/**
	 * @description 给定的环境的后置处理器
	 * @author mutisitic
	 * @date 2018年6月19日
	 * @param environment
	 * @param application
	 * @see org.springframework.boot.env.EnvironmentPostProcessor#postProcessEnvironment(org.springframework.core.env.ConfigurableEnvironment, org.springframework.boot.SpringApplication)
	 */
	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		String fileName = "C:/Work/Study/GitProduct/mutistic.spring/com.mutistic.boot/notes/test/test-processor.properties";
		try {
			InputStream input = new FileInputStream(fileName);
			Properties source = new Properties();
			source.load(input); // 从输入字节流中读取属性列表（键和元素对）

			PropertiesPropertySource propertySource = new PropertiesPropertySource("testInput", source);
			environment.getPropertySources().addLast(propertySource); // 添加具有最低优先级的给定属性源对象
		} catch (IOException e) {
			CommonUtil.printErr("TestEnvironmentPostProcessor 无法加载到指定资源fileName：" + fileName);
			e.printStackTrace();
		}
	}
}
