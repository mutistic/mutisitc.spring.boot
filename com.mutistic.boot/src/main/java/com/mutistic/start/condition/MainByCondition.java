package com.mutistic.start.condition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.mutistic.utils.CommonUtil;

/**
 * @program 使用 @Conditional 和 Condition 组合实现基于条件的自动装配bean
 * @description
 * @author mutisitic
 * @date 2018年6月21日
 */
@SpringBootApplication
public class MainByCondition {

	public static void main(String[] args) {
		try {
			ConfigurableApplicationContext context = SpringApplication.run(MainByCondition.class, args);
			
			showBeanbyCustom(context);
			showBeanByConditional(context);
			context.close();
		} catch (Exception e) {
			e.printStackTrace();
//			CommonUtil.printErr(e.getMessage());
		}
	}

	/**
	 * @description 1、使用 @Conditional 和 Condition 组合自定义实现根据条件自动装配bean
	 * @author mutisitic
	 * @date 2018年6月21日
	 * @param context
	 */
	private static void showBeanbyCustom(ConfigurableApplicationContext context) {
		CommonUtil.printOne("1、使用 @Conditional 和 Condition 组合自定义实现根据条件自动装配bean");
		CommonUtil.printThree("系统启动参数：file.encoding", System.getProperty("file.encoding"));
		CommonUtil.printThree("系统启动自定义参数：test.encoding", System.getProperty("test.encoding")); // 可以自定义配置VM启动时参数 -Dtest.encoding=ISO-8859-1
		CommonUtil.printThree("根据 System.getProperty(\"file.encoding\") 条件自动装配bean", context.getBeansOfType(TestEncodingConvert.class));
	}

	/**
	 * @description 2、使用常用的Conditional类实现自动装配bean
	 * @author mutisitic
	 * @date 2018年6月21日
	 * @param context
	 */
	private static void showBeanByConditional(ConfigurableApplicationContext context) {
		CommonUtil.printOne("2、使用org.springframework.boot.autoconfigure.condition包下常用的Conditional类实现自动装配bean");
		CommonUtil.printThree("根据常用的Conditional类实现自动装配bean", context.getBeansOfType(Runnable.class));
		CommonUtil.printThree("@ConditionalOnProperty：当某个配置符合条件是才装配", context.getBean("createrByConditionalOnProperty"));
		CommonUtil.printThree("@ConditionalOnClass：当classpatch存在某个类才装配", context.getBean("createrByConditionalOnClass"));
		CommonUtil.printThree("@ConditionalOnMissingBean：当context不存在某个bean才装配", context.getBean("createrByConditionalOnMisisingBean"));
	}
}
