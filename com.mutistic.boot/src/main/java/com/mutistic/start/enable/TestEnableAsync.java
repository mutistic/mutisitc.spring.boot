package com.mutistic.start.enable;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.mutistic.utils.CommonUtil;

/**
 * @program 配合 MainByEnableAsync 实现启用异步执行特性 
 * @description 
 * @author mutisitic
 * @date 2018年6月22日
 */
@Component
public class TestEnableAsync implements Runnable {

	@Async // 异步执行注解
	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				CommonUtil.printThree("TestEnableAnsyc 执行输出", i);
				TimeUnit.MICROSECONDS.sleep(500); // 线程暂停
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
