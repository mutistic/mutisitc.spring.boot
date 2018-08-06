package com.mutistic.start.runner;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.mutistic.utils.CommonUtil;

/**
 * @program 2、演示 Spring容器启动后的最后一次回调接口：ApplicationRunner
 * @description
 * @author mutisitic
 * @date 2018年7月18日
 */
@Component
public class TestApplicationRunner implements ApplicationRunner, Ordered {

	/**
	 * @description 通过ApplicationRunner接口实现Spring容器启动后的最后一次回调
	 * @author mutisitic
	 * @date 2018年7月18日
	 * @param args
	 * @throws Exception
	 * @see org.springframework.boot.ApplicationRunner#run(org.springframework.boot.ApplicationArguments)
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {
		CommonUtil.printTwo("2、通过ApplicationRunner接口实现Spring容器启动后的最后一次回调（spring容器已启动）：", TestCommandLineRunner.class);
		if (null != args) {
			CommonUtil.printThree("通过 ApplicationArguments.getSourceArgs()方法获取启动参数：",
					Arrays.asList(args.getSourceArgs()));
		}
	}

	/**
	 * @description 自定义执行顺序
	 * @author mutisitic
	 * @date 2018年7月18日
	 * @return
	 * @see org.springframework.core.Ordered#getOrder()
	 */
	@Override
	public int getOrder() {
		return 0;
	}

}
