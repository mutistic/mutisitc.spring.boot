package com.mutistic.start.banner;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program 演示 Banner
 * @description 
 * @author mutisitic
 * @date 2018年7月18日
 */
@SpringBootApplication
public class MainByBanner {
	public static void main(String[] args) {
		closeBanner(args);
		showByBanner(args);
	}

	/**
	 * @description 关闭 Banner
	 * @author mutisitic
	 * @date 2018年7月18日
	 * @param args
	 */
	private static void closeBanner(String[] args) {
		SpringApplication app = new SpringApplication(MainByBanner.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args).close();
	}
	
	/**
	 * @description 演示 自定义 Banner
	 * @author mutisitic
	 * @date 2018年7月18日
	 * @param args
	 */
	private static void showByBanner(String[] args) {
		/**
		 * banner文件：
		 * 1、默认banner文件：resources/banner.txt
		 * 2、spring.banner.location 配置项来指定banner文件路径
		 * 3、spring.banner.charset 配置项来指定banner文件编码格式（默认GBK）
		 * 
		 * banner图片：
		 * 1、默认resources/banner.jpg
		 * 2、spring.banner.image.location 配置项来指定banner图片路径
		 * 3、图片格式支持jpg,png,gif等
		 */
		SpringApplication.run(MainByBanner.class, args).close();
	}
	
}
