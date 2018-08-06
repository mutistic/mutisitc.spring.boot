package com.mutistic.start.runner;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.mutistic.utils.CommonUtil;

/**
 * @program 演示Spring容器运行后的最后一次回调接口：CommandLineRunner 或 ApplicationRunner
 * @description PS：不能通过@Component方式注册
 * @author mutisitic
 * @date 2018年7月18日
 */
@SpringBootApplication
public class MainByRunner {
	
	/**
	 * Spring容器运行后的最后一次回调接口：
	 * 1、实现 CommandLineRunner 或 ApplicationRunner 接口。
	 * 2、注册 CommandLineRunner 或 ApplicationRunner 实现类。
	 * PS：可用通过 @Order 注解 或者 org.springframework.core.Ordered接口 实现执行顺序（数字小的先执行）
	 */
	public static void main(String[] args) {
		// 系统参数定义格式：--key=value
		if(null == args || args.length == 0) {
			args = new String[2];
			args[0] = "--test1=自定义测试运行参数1";
			args[1] = "--tset2=自定义测试运行参数2";
		}
		showByRunner(args);
		showByApplicationArguments(args);
	}

	/**
	 * @description 演示 Spring容器运行后的最后一次回调接口
	 * @author mutisitic
	 * @date 2018年7月18日
	 * @param args
	 */
	private static void showByRunner(String[] args) {
		CommonUtil.printOne("演示 Spring容器运行后的最后一次回调接口：");
		SpringApplication.run(MainByRunner.class, args).close();
	}
	
	/**
	 * @description 演示通过 ApplicationArguments 获取系统运行参数
	 * @author mutisitic
	 * @date 2018年7月18日
	 * @param args
	 */
	private static void showByApplicationArguments(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainByRunner.class, args);
		
		CommonUtil.printOne("演示通过 ApplicationArguments 获取系统运行参数：");
		ApplicationArguments appArgs = context.getBean(ApplicationArguments.class);
		CommonUtil.printThree("通过 ApplicationArguments.getSourceArgs() 获取系统运行参数：", Arrays.asList(appArgs.getSourceArgs()));
		CommonUtil.printThree("通过 ApplicationArguments.getOptionNames() 获取运行参数--key集合： ", appArgs.getOptionNames());
		CommonUtil.printThree("通过 ApplicationArguments.getOptionValues() 获取运行参数--key绑定的值： ", appArgs.getOptionValues("testArgs"));
	}
	
}
