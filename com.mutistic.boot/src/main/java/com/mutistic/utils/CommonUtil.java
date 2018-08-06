package com.mutistic.utils;

/**
 * @program 普通工具类
 * @description
 * @author mutisitic
 * @date 2018年6月5日
 */
public class CommonUtil {

	public final static String T_LEFT = "【";
	public final static String T_RIGTH = "】";
	public final static String LINE_LONG = "------------------------";
	public final static String LINE_LONG_LN = "\n\n" + LINE_LONG;
	public final static String LINE_SHORT = "----------------";
	public final static String LINE_SHORT_LN = "\n" + LINE_SHORT;

	public static void println() {
		System.out.println();
	}
	
	public static void printErr(Object str) {
		System.err.println(LINE_LONG_LN + (str == null ? "" : str));
	}

	public static void printOne(Object str) {
		System.out.println(LINE_LONG_LN + (str == null ? "" : str));
	}

	public static void printTwo(Object str, Object obj) {
		System.out.println(LINE_SHORT_LN + (str == null ? "" : str) + (obj == null ? "" : T_LEFT + obj + T_RIGTH));
	}

	public static void printThree(Object str, Object obj) {
		System.out.println(LINE_SHORT + (str == null ? "" : str) + (obj == null ? "" : T_LEFT + obj + T_RIGTH));
	}

}
