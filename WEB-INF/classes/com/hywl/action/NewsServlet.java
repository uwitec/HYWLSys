package com.hywl.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hywl.dao.NewsDaoImpl;
import com.hywl.pojo.NewsPojo;
import com.hywl.service.NewsServiceImpl;

public class NewsServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		String name = (String) session.getAttribute("adminName");// 获取当前用户名
		resp.setCharacterEncoding("utf-8");
		String flag = req.getParameter("flag");

		String title = req.getParameter("newstitle");// 标题
		String type = req.getParameter("newssort");// 类型
		String zhaiyao = req.getParameter("zhaiyao");// 摘要
		String content = req.getParameter("newscontent");// 内容
		String source = req.getParameter("newssource");// 来源
		/********* 向新闻表里添加记录 **********/
		NewsPojo np = new NewsPojo();
		np.setTitle(title);
		np.setScourse(source);
		np.setContent(content);
		np.setPname(name);
		
		np.setAbs(zhaiyao);
		if(flag.equals("back")){
			String newsno=req.getParameter("newsno");
			NewsServiceImpl service = new NewsServiceImpl();
			service.updateStatus("back", newsno);//状态   新闻编号
			req.getRequestDispatcher("/WEB-INF/draftsEditor.jsp").forward(req,
					resp);
		}
		else if (flag.equals("allow")) {
			String newsno=req.getParameter("newsno");
			
			NewsServiceImpl service = new NewsServiceImpl();
			service.updateStatus("allow", newsno);//状态   新闻编号
			req.getRequestDispatcher("/WEB-INF/checknewsEditor.jsp").forward(req,
					resp);
		}
		else if(flag.equals("change")){
			String newsid=req.getParameter("newsno");
			NewsServiceImpl n=new NewsServiceImpl ();
			NewsPojo news=n.getById(newsid);
			req.setAttribute("news", news);
			req.getRequestDispatcher("/WEB-INF/newsEditor.jsp").forward(req,
					resp);
		}
		
		
		else {
			if (type.equals("picnews")) {
				np.setClassify("公司新闻");
			} else if(type.equals("textnews")){
				np.setClassify("行业新闻");
			}else{
				np.setClassify("公告");
			}
			if (flag.equals("check"))
				np.setStatus("check");
			else if (flag.equals("drafts"))
				np.setStatus("drafts");// 设置新闻状态
			NewsServiceImpl service = new NewsServiceImpl();
			service.add(np);
			req.getRequestDispatcher("/WEB-INF/newsEditor.jsp").forward(req,
					resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
