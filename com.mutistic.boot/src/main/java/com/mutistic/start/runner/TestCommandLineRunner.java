package com.mutistic.start.runner;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.mutistic.utils.CommonUtil;

/**
 * @program 1、演示 Spring容器启动后的最后一次回调接口：CommandLineRunner
 * @description 
 * @author mutisitic
 * @date 2018年7月18日
 */
@Component
@Order(2)
public class TestCommandLineRunner implements CommandLineRunner {

	/**
	 * @description 1、通过CommandLineRunner接口实现Spring容器启动后的最后一次回调
	 * @author mutisitic
	 * @date 2018年7月18日
	 * @param args
	 * @throws Exception
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		CommonUtil.printTwo("1、通过CommandLineRunner接口实现Spring容器启动后的最后一次回调（spring容器已启动）：", TestCommandLineRunner.class);
		if(null != args) {
			CommonUtil.printThree("直接获取启动系统参数：", Arrays.asList(args));
		}
	}

}
