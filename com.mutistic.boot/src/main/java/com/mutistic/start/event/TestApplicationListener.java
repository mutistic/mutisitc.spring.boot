package com.mutistic.start.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.mutistic.utils.CommonUtil;

/**
 * @program 定义监听器
 * @description 一般是实现 ApplicationListener<E extend ApplicationEvent> 接口
 * @author mutisitic
 * @date 2018年7月3日
 */
//@Component // 3.2、可以使用 SpringApplication.addListeners(new TestApplicationListener()); 添加监听器
public class TestApplicationListener implements ApplicationListener<TestApplicationEvent> {

	/**
	 * @description 事件监听
	 * @author mutisitic
	 * @date 2018年7月3日
	 * @param event
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(TestApplicationEvent event) {
		CommonUtil.printTwo("定义监听器:TestApplicationListener，监听事件：", event);
	}

}
