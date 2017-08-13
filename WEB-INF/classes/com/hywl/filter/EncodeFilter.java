package com.hywl.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodeFilter extends HttpFilter{
	
	/**
	 * 1.在web.xml中设置字符编码的初始化参数
	 * 2.通过重写init()方法获取参数值
	 */
	private String encoding;
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		encoding=getFilterConfig().getServletContext().getInitParameter("encoding");
	}
	
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding(encoding);
		chain.doFilter(req, resp);
	}

}
