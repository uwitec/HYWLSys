package com.hywl.action;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hywl.pojo.GoodsPojo;
import com.hywl.pojo.NewsPojo;
import com.hywl.service.GoodsServiceImpl;
import com.hywl.service.NewsServiceImpl;

public class BackFowardServlet extends HttpServlet {

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

	/**
	 * 登录页面跳转到首页
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void backlogin(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		String username=req.getParameter("username");
		String passwd=req.getParameter("password");
		session.setAttribute("adminName", username);
		session.setAttribute("adminPwd", passwd);//session保存后台管理员的账号和密码
		req.getRequestDispatcher("/WEB-INF/back_index.jsp").forward(req, resp);
	}

	
	/**
	 * 后台处理：
	 * 根据不同的flag值包含相应的right页面
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void backindex(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String flag=req.getParameter("flag");
		if(flag.equals("top")){
			req.getRequestDispatcher("/WEB-INF/admin_top.html").include(req, resp);
		}
		else if(flag.equals("right")){
			req.getRequestDispatcher("/WEB-INF/right.html").include(req, resp);
		}
		else if(flag.equals("left")){
			req.getRequestDispatcher("/WEB-INF/left.html").include(req, resp);
		}
		else if(flag.equals("leftfirst")){
			req.getRequestDispatcher("/WEB-INF/newsEditor.jsp").include(req, resp);
		}
		else if(flag.equals("leftsecond")){
			setParam("drafts", "draftslist", req);
			req.getRequestDispatcher("/WEB-INF/draftsEditor.jsp").forward(req, resp);
		}
		else if(flag.equals("leftthird")){
			setParam("check", "checklist", req);
			req.getRequestDispatcher("/WEB-INF/checknewsEditor.jsp").forward(req, resp);
		}
		else if(flag.equals("leftforth")){
			
			req.getRequestDispatcher("/WEB-INF/dynamic.jsp").forward(req, resp);
		}
        else if(flag.equals("leftsix")){
			
			req.getRequestDispatcher("/WEB-INF/dynamic.jsp").forward(req, resp);
		}
        else if(flag.equals("userfirst")){
			req.getRequestDispatcher("/WEB-INF/DriverMessage.jsp").include(req, resp);
		}
		else if(flag.equals("usersecond")){
			req.getRequestDispatcher("/WEB-INF/ShipperMessage.jsp").include(req, resp);
		}
		else if(flag.equals("userthird")){
			req.getRequestDispatcher("/WEB-INF/DriverQuery.jsp").include(req, resp);
		}
		else if(flag.equals("userfourth")){
			req.getRequestDispatcher("/WEB-INF/ShipperQuery.jsp").include(req, resp);
		}
		else if(flag.equals("userfifth")){
			req.getRequestDispatcher("/WEB-INF/DriverUpdate.jsp").include(req, resp);
		}
		else if(flag.equals("usersixt")){
			req.getRequestDispatcher("/WEB-INF/ShipperUpdate.jsp").include(req, resp);
		}
		else if(flag.equals("usersevent")){
			req.getRequestDispatcher("/WEB-INF/DriverDelete.jsp").include(req, resp);
		}
		else if(flag.equals("userelevent")){
			req.getRequestDispatcher("/WEB-INF/ShipperDelete.jsp").include(req, resp);
		}
		
	}

	/**
	 * 前台：
	 * 发货，找货，找车页面的跳转
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void sendInfo(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	public void  beforelogin(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	
	
	
	public void  beforeindex(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		//禁止浏览器缓存的代码
				resp.setDateHeader("Expires", -1);
				resp.setHeader("Cache-Control", "no-cache");
				resp.setHeader("Pragma", "no-cache");
				
		List<GoodsPojo> list1=new ArrayList<GoodsPojo>();//货源信息list
	//	List<GoodsPojo> list2=new ArrayList<GoodsPojo>();//车源信息列表
		List<NewsPojo> news=null;
		List<NewsPojo> gonggao=null;
		GoodsServiceImpl g=new GoodsServiceImpl();
		list1=g.selectByPage(0, 6);
	   // System.out.println(list1.size());
		NewsServiceImpl nsi=new NewsServiceImpl();
		news=nsi.select(null, "classify", "公司新闻");
		gonggao=nsi.select(null, "classify", "公司公告");
		
		req.setAttribute("news", news);
		req.setAttribute("gg", gonggao);
		req.setAttribute("glist", list1);
		
		req.getRequestDispatcher("homepage.jsp").include(req, resp);
	}
	public void setParam(String status,String flag,HttpServletRequest req){
		NewsServiceImpl news=new NewsServiceImpl();
		NewsPojo p=new NewsPojo();
		p.setStatus(status);
		List<NewsPojo> list=news.select(p,"status",status);
		if(list.size()>0)
		{
			
			req.setAttribute(flag, list);
		}
	}

}
