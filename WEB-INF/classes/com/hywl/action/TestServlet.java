package com.hywl.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hywl.dao.NewsDaoImpl;
import com.hywl.dao.PojoDaoImpl;
import com.hywl.pojo.DriverPojo;
import com.hywl.pojo.NewsPojo;
@WebServlet("/testServlet")
public class TestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//String text=req.getParameter("content");
		resp.setCharacterEncoding("UTF-8");
		//System.out.println(req.getParameter("content"));
//		PojoDaoImpl news=new PojoDaoImpl();
//		System.out.println(list.get(0).);
		req.getRequestDispatcher("/back_login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
