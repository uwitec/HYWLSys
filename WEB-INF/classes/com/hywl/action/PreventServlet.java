package com.hywl.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hywl.pojo.DriverRoutePojo;
import com.hywl.pojo.GoodsPojo;
import com.hywl.service.GoodsServiceImpl;
import com.hywl.service.RouteServiceImpl;
@WebServlet("/sendInfo")
public class PreventServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		
		
		if(session.getAttribute("phone")==null){
			System.out.println("session1:"+session.getAttribute("phone"));
			req.getRequestDispatcher("/before_login.jsp").forward(req, resp);
		}
		else{
			System.out.println("session2:"+session.getAttribute("phone"));
			String flag=req.getParameter("flag");
			
			if(flag.equals("1")){
				
				req.getRequestDispatcher("/wantshipment.jsp").forward(req, resp);
			}
			else if(flag.equals("2")){
				RouteServiceImpl route=new RouteServiceImpl();
				try{
					List<DriverRoutePojo> list=route.queryAll();

					req.setAttribute("list", list);
					req.getRequestDispatcher("/wantcar.jsp").forward(req, resp);
				}catch(SQLException e){
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			

			}
			else if(flag.equals("3")){
				GoodsServiceImpl g=new GoodsServiceImpl();
				try {
					List<GoodsPojo> list=g.selectAll();
					req.setAttribute("goodslist", list);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				req.getRequestDispatcher("/wantgoods.jsp").forward(req, resp);
			}
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
