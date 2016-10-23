package com.cs.rest;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("Its me destroy");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("Its me doFilter");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Its me INIT");
	}

}
