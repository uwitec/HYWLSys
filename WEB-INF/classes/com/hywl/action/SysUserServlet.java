package com.hywl.action;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hywl.pojo.SystemUsersPojo;
import com.hywl.service.SystemUserService;
import com.hywl.service.SystemUserServiceImpl;

@SuppressWarnings("serial")
public class SysUserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		String servletPath = req.getServletPath();
		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0, methodName.length() - 3);//

		try {
			Method method = getClass().getDeclaredMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	public void addSysUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String username=req.getParameter("username");
		String passwd=req.getParameter("passwd");
		int age=Integer.parseInt(req.getParameter("age"));
		String email=req.getParameter("email");
		String tel=req.getParameter("phone");
		String account=req.getParameter("account");
		SystemUserService sysuserService=new SystemUserServiceImpl();
		SystemUsersPojo sysuserPojo=new SystemUsersPojo();
		if(account.equals("22222222")){
			sysuserPojo.setName(username);
			sysuserPojo.setPwd(passwd);
			sysuserPojo.setAge(age);
			sysuserPojo.setEmail(email);
			sysuserPojo.setTel(tel);
			sysuserService.add(sysuserPojo);
		}else{
			req.setAttribute("ErrorInfo", "没有添加权限");			
		}
		req.getRequestDispatcher("/WEB-INF/SystemUserAdd.jsp").forward(req, resp);
	}
	
	public void deleteSysUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String reaccount=req.getParameter("account");
		String account=req.getParameter("account");
		SystemUserService sysuserService=new SystemUserServiceImpl();
		SystemUsersPojo sysuserPojo=new SystemUsersPojo();
		if(account.equals("22222222")){
		if(sysuserService.queryByAccount(reaccount)==true){
			sysuserPojo.setAccount(reaccount);
			sysuserService.delete(sysuserPojo);
		}else{
			req.setAttribute("ErrorInfo", "该账户不存在");	
		}
	}else{
		req.setAttribute("ErrorInfo", "没有权限");		
	}
		req.getRequestDispatcher("/WEB-INF/SystemUserAdd.jsp").forward(req, resp);	
	}
	
	
	public List<SystemUsersPojo> querySysUser(HttpServletRequest req, HttpServletResponse resp){
		int age=Integer.parseInt(req.getParameter("age"));
		String email=req.getParameter("email");
		String tel=req.getParameter("phone");
		String account=req.getParameter("account");
		String username=req.getParameter("username");
		SystemUserService sysuserService=new SystemUserServiceImpl();
		SystemUsersPojo sysuserPojo=new SystemUsersPojo();

		return null;
		
	}

}
