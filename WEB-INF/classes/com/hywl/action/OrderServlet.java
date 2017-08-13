package com.hywl.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hywl.pojo.OrderInfoPojo;
import com.hywl.service.OrderServiceImpl;
@WebServlet("/orderServlet")
public class OrderServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		req.setCharacterEncoding("utf-8");
		String flag=req.getParameter("order");
		if(flag!=null){
			String shipper=req.getParameter("shipper");
			String orderid=req.getParameter("orderid");
			String userid=(String) session.getAttribute("phone");
			OrderInfoPojo o=new OrderInfoPojo();
			o.setSordergoods(shipper);
			o.setSorderdriver(userid);
			o.setSorderid(orderid);
			o.setSordermode("处理中...");
			OrderServiceImpl osi=new OrderServiceImpl();
			osi.add(o);
			req.getRequestDispatcher("/member.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
