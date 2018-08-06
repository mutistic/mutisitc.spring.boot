package com.mutistic.start.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @program Condition实现类：配合 @Conditional 基于条件自动装配
 * @description
 * @author mutisitic
 * @date 2018年6月21日
 */
public class TestGBKCondition implements Condition {

	/**
	 * @description 判断 System.getProperty("file.encoding") 是否为 GBK
	 * @author mutisitic
	 * @date 2018年6月21日
	 * @param context
	 * @param metadata
	 * @return
	 * @see org.springframework.context.annotation.Condition#matches(org.springframework.context.annotation.ConditionContext, org.springframework.core.type.AnnotatedTypeMetadata)
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String encoding = System.getProperty("file.encoding");
		if(encoding != null && !encoding.isEmpty()) {
			return "GBK".equals(encoding.toUpperCase());
		}
		return false;
	}

}
