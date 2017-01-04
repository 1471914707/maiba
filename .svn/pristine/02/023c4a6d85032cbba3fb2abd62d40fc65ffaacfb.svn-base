package com.lin.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class UrlUtil {

	public static String getURL(HttpServletRequest request){
		String url = "";
		url = request.getRequestURL()+"?";
		url += param(request);

		return url;
	}

	private static String param(HttpServletRequest request) {
		String url = "";
		Enumeration param = request.getParameterNames();
		while (param.hasMoreElements()){
			String pname = param.nextElement().toString();
			url += pname+"="+request.getParameter(pname)+"&";
		}
		if (url.endsWith("&")){
			url = url.substring(0,url.lastIndexOf("&"));
		}
		return url;
	}
}
