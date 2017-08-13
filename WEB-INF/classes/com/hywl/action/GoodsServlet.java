package com.hywl.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import com.hywl.pojo.GoodsPojo;
import com.hywl.service.GoodsServiceImpl;
@WebServlet("/goodsServlet")
public class GoodsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession();
	
		String startcity=req.getParameter("startcity");
		String endcity=req.getParameter("endcity");
		String phone=req.getParameter("phone");
		
		String runtime=req.getParameter("runtime");
		String price=(req.getParameter("price"));
		String goodsort=req.getParameter("goodsort");
		String shipperid=(String) session.getAttribute("phone");//获取登录用户的编号
		GoodsPojo g=new GoodsPojo();
		g.setSgoodstart(startcity);	
		if(price!=null){
			g.setSgoodprice(Float.parseFloat(price));
		}
		
		g.setSphone(phone);
		g.setShipperid(shipperid);
		g.setSgoodsort(goodsort);
		g.setSgood_valid_time(runtime);
		g.setSgoodend(endcity);
		if(req.getParameter("flag")!=null){
			String flag=req.getParameter("flag");
			if(flag.equals("sousuo")){
				GoodsServiceImpl goods=new GoodsServiceImpl();
				out.print(goods.getJSON(startcity, endcity).toString());
			}
			else if(flag.equals("shuaxin")){
				GoodsServiceImpl goods=new GoodsServiceImpl();
				out.print(goods.getAllJSON().toString());
			}
			else if(flag.equals("detail")){
				String id=req.getParameter("goodid");
				GoodsServiceImpl goods=new GoodsServiceImpl();
				
					GoodsPojo gp=goods.getById(id);
					req.setAttribute("goods", gp);
					req.getRequestDispatcher("/goodsdetail.jsp").forward(req, resp);
				
			}
		}
		else{
		GoodsServiceImpl goods=new GoodsServiceImpl();		
		goods.add(g);
		req.getRequestDispatcher("/wantshipment.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
