package com.organic.agriculture.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public class CommonUtils {

	public static String getCurrentDate() {

		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("YYYY/MM/dd");

		return ft.format(dNow);
	}

	public static boolean isProductNoNotEmpty(String productNo) {
		if (StringUtils.isEmpty(productNo)) {
			return false;
		}
		return true;
	}

	public static boolean isProductNo(String productNo) {

		String s = "[A-Z]+-[A-Z]+|[A-Z]+[0-9]+|[A-Z]+";
		Pattern p = Pattern.compile(s);
		Matcher matcher = p.matcher(productNo);
		if (matcher.find()) {
			return true;
		}
		return false;
	}

	public static boolean containsProductNo(String productName, String productNo) {
		return productName.toUpperCase().replaceAll("-", "").contains(productNo.toUpperCase().replaceAll("-", ""));
	}

	public static boolean isCsv(String fileName) {
		if (StringUtils.isEmpty(fileName)) {
			return false;
		}
		int len = fileName.indexOf(".");

		String filetype = fileName.substring(len + 1);

		if ("csv".equals(filetype)) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		CommonUtils c = new CommonUtils();
		boolean b = c.containsProductNo("エレコム　USB2.0延長ケーブルAタイプ　5m　USB2EXA50", "USB2-EXA50");
		System.out.println(b);
	}
}
