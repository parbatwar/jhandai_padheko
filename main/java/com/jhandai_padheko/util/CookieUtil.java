package com.jhandai_padheko.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;

/*
 * Adds a cookie with the specified name, value and max age.
 * 
 * @param response the HttpServletResponse to add the cookie to
 * @param name - name of the cookie
 * @param value - the value of the cookies
 * @param maxAge - the max age of the cookie in seconds
 */
public class CookieUtil{
	public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(maxAge);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	/**
	 * Retrieves a cookie by its name from the HttpServletRequest.
	 *
	 * @param request the HttpServletRequest to get the cookie from
	 * @param name    the name of the cookie to retrieve
	 * @return        the Cookie object if found, otherwise null
	 */
	public static Cookie getCookie(HttpServletRequest request, String name) {
	    if (request.getCookies() != null) {
	        return Arrays.stream(request.getCookies())
	                     .filter(cookie -> name.equals(cookie.getName()))
	                     .findFirst()
	                     .orElse(null);
	    }
	    return null;
	}

	/**
	 * Deletes a cookie by setting its max age to 0.
	 *
	 * @param response the HttpServletResponse to add the deletion cookie to
	 * @param name     the name of the cookie to delete
	 */
	public static void deleteCookie(HttpServletResponse response, String name) {
	    Cookie cookie = new Cookie(name, null);
	    cookie.setMaxAge(0);
	    cookie.setPath("/"); // Make cookie available to the entire application
	    response.addCookie(cookie);
	}
}
