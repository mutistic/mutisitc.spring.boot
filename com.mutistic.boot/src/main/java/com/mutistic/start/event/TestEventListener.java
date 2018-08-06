package com.mutistic.start.event;

import java.util.EventObject;

import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.mutistic.utils.CommonUtil;

/**
 * @program 3.4、通过 @EventListener 注解实现事件的监听
 * @description 作用于方法上，必须要有参数，参数为具体事件类 或者 EventObject子事件类（子类）
 * @author mutisitic
 * @date 2018年7月3日
 */
@Component
public class TestEventListener {

	/**
	 * @description 监听spring容器中的事件
	 * @author mutisitic
	 * @date 2018年7月3日
	 * @param event Object类或者EventObject类
	 */
	@EventListener
	public void eventObject(Object event) {
//	public void eventObject(EventObject event) {
		CommonUtil.printTwo("TestEventListener 通过 @EventListener注解监听到的事件：", event);
	}
	
	/**
	 * @description 监听指定事件 
	 * @author mutisitic
	 * @date 2018年7月3日
	 * @param event
	 */
	@EventListener
	public void eventTest(TestApplicationEvent event) {
		CommonUtil.printTwo("TestEventListener 通过 @EventListener注解监听指定事件TestApplicationEvent：", event);
	}
	
	/**
	 * @description 监听spring事件：ContextStoppedEvent-应用停止事件
	 * @author mutisitic
	 * @date 2018年7月3日
	 * @param event
	 */
	@EventListener
	public void eventContextStop(ContextStoppedEvent event) {
		// ContextClosedEvent 应用关闭事件
		CommonUtil.printTwo("测试监听 spring 事件：ContextStoppedEvent-应用停止事件：", event);
	}
	
}
