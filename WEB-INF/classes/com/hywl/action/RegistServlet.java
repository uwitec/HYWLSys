package com.hywl.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hywl.pojo.DriverPojo;
import com.hywl.pojo.ShipperPojo;
import com.hywl.service.DriverServiceImpl;
import com.hywl.service.ShipperServiceImpl;

@WebServlet("/registServlet")

public class RegistServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		String name=req.getParameter("username");
		String phone=req.getParameter("phone");
		String pwd=req.getParameter("passwd");
		String role=req.getParameter("user_type");
		
		//System.out.println(role);
		if(role.equals("2")){
			System.out.println("fgshg");
			DriverPojo d=new DriverPojo();
			d.setName(name);
			d.setPasswd(pwd);
			d.setRole("司机");
			d.setPhone(phone);
			DriverServiceImpl ds=new DriverServiceImpl();
			try {
				ds.add(d);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(role.equals("1")){
			System.out.println("qqerfhgf");
			ShipperPojo d=new ShipperPojo();
			d.setSname(name);
			d.setSpassword(pwd);
			d.setSrole("货主");
			d.setSphone(phone);
			ShipperServiceImpl ds=new ShipperServiceImpl();
			try {
				ds.add(d);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
