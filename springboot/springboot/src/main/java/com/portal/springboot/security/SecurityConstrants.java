package com.portal.springboot.security;

public class SecurityConstrants {
	public static final String SECRET = "qwerty123";
	public static final long EXPIRATION_TIME = 86400_000;
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/api/v1/signup";
}
