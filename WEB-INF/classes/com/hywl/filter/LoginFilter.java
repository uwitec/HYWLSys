package com.hywl.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter extends HttpFilter{

	/**
	 * 验证是否登录的过滤器
	 */
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		
		String username=(String) session.getAttribute("username");
		
		if(username==null||username.equals("")){//若为空则返回登录界面
			req.getRequestDispatcher("/back_login.jsp").forward(req, resp);
			
			//禁止浏览器缓存的代码
			resp.setDateHeader("Expires", -1);
			resp.setHeader("Cache-Control", "no-cache");
			resp.setHeader("Pragma", "no-cache");
		}
		else{//否则传到下一个过滤器
			doFilter(req, resp, chain);
		}
	}

}
