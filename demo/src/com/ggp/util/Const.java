package com.ggp.util;

public class Const {
	public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(code)|(app)).*"; //不对匹配该值的访问路径拦截（正则）
	
	public static final String SESSION_USER = "sessionUser";
	
	public static final String LOGIN = "/login_tologin.do";
	
	 public static final String KEY_SHA = "SHA"; 
}
