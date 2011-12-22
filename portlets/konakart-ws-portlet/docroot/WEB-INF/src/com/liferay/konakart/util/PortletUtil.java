package com.liferay.konakart.util;

import com.liferay.portal.kernel.util.StringUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PortletUtil {
	
	public static String cutOut(String s, int length) {
		Pattern pattern = Pattern.compile("\t|\r|\n");
		
		Matcher matcher = pattern.matcher(s);
		
		s = matcher.replaceAll("");
		
		if (s.length() > length) {
			s = StringUtil.shorten(s, length);
		}
		
		return s;
	}
	
	public static String cutOut(String s) {
		return cutOut(s, 100);
	}
}