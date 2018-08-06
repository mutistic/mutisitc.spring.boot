package com.mutistic.start.event;

import org.springframework.context.ApplicationEvent;

import com.mutistic.utils.CommonUtil;

/**
 * @program 自定义事件
 * @description 一般是继承 ApplicationEvent抽象类
 * @author mutisitic
 * @date 2018年7月3日
 */
public class TestApplicationEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	/**
	 * 重写构造函数
	 * @param source
	 */
	public TestApplicationEvent(Object source) {
		super(source);
//		CommonUtil.printTwo("自定义事件：TestApplicationEvent，构造器入参：", source);
	}
	
}
