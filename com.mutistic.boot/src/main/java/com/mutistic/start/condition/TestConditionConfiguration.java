package com.mutistic.start.condition;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * @program @Conditional 基于条件的自动配置，一般要配合 Condition接口使用
 * @description 1、@Conditional可以作用在方法和类上（方法优先级高于类）。 2、Condition.matches()返回 true在装配，返回false不装配。
 *  3、@Conditional参数 Condition 参数可以是多个，当都返回true时在装配。
 * @author mutisitic
 * @date 2018年6月21日
 */
@SpringBootConfiguration
// @Conditional({TestUTF8Condition.class, TestGBKCondition.class, TestISOCondition.class}) // 作用在类上对其所有的方法生效
public class TestConditionConfiguration {

	/**
	 * 常用的Conditional类：org.springframework.boot.autoconfigure.condition包下
	 * ConditionalOnBean/ConditionalOnMissingBean：当context存在或不存在某个bean才自动装配
	 * ConditionalOnClass/ConditionalOnMissingClass：当classpatch下存在或不存在某个class才自动装配
	 * ConditionalOnExpression/ConditionalOnMissingExpression：当匹配或不匹配某个表达才自动装配
	 * ConditionalOnJava/ConditionalOnMissingJava：当前JVM版本大于等于或小于某个版本才自动装配
	 * ConditionalOnWebApplication/ConditionalOnNotWebApplication：当前项目是或者不是web项目才自动装配
	 * ConditionalOnResource：当某个资源存在是才自动装配
	 * ConditionalOnProperty：当某个配置存在时或配置文件等于某个值存在时才自动装配
	 */

	/**
	 * @description 当@Conditional(TestUTF8Condition.class)条件为true时装配
	 * @author mutisitic
	 * @date 2018年6月21日
	 * @return
	 */
	@Bean
	@Conditional(TestUTF8Condition.class)
	public TestEncodingConvert createrTestUTF8EncodingConvert() {
		return new TestUTF8EncodingConvert();
	}

	/**
	 * @description 当@Conditional(TestGBKCondition.class)条件为true时装配
	 * @author mutisitic
	 * @date 2018年6月21日
	 * @return
	 */
	@Bean
	@Conditional(TestGBKCondition.class)
	public TestEncodingConvert createrTestGBKEncodingConvert() {
		return new TestGBKEncodingConvert();
	}

	/**
	 * @description 当@Conditional(TestISOCondition.class)条件为true时装配
	 * @author mutisitic
	 * @date 2018年6月21日
	 * @return
	 */
	@Bean
	@Conditional(TestISOCondition.class)
	public TestEncodingConvert createrTestISOEncodingConvert() {
		return new TestISOEncodingConvert();
	}

	/**
	 * @description @ConditionalOnProperty：当某个配置符合条件是才装配
	 * @author mutisitic
	 * @date 2018年6月21日
	 * @return
	 */
	@Bean
	@ConditionalOnProperty(name = "local.ip", havingValue = "127.0.0.1") // 存在属性值，且havingValue声明值一致时装配
//	@ConditionalOnProperty(name = "local.ip", havingValue = "localhost", matchIfMissing = true) // matchIfMissing不存在是也装配，存在时属性值与havingValue声明值一致时装配
	public Runnable createrByConditionalOnProperty() {
		return () -> { };
	}

	/**
	 * @description @ConditionalOnClass：当classpatch存在某个类才装配
	 * @author mutisitic
	 * @date 2018年6月21日
	 * @return
	 */
	@Bean
	@ConditionalOnClass(name = "com.mutistic.utils.CommonUtil")
	public Runnable createrByConditionalOnClass() {
		return () -> { };
	}
	
	/**
	 * @description @ConditionalOnMissingBean：当context不存在某个bean才装配
	 * @author mutisitic
	 * @date 2018年6月21日
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(name = "createrTestISOEncodingConvert")
	public Runnable createrByConditionalOnMisisingBean() {
		return () -> { };
	}
}
