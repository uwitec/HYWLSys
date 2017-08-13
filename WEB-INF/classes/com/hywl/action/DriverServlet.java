package com.hywl.action;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hywl.pojo.DriverPojo;
import com.hywl.service.DriverService;
import com.hywl.service.DriverServiceImpl;


@SuppressWarnings("serial")
public class DriverServlet extends HttpServlet{
	
	public DriverServlet(){
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		resp.setCharacterEncoding("utf-8");
		String servletPath = req.getServletPath();
		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0, methodName.length() - 7);//

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
	
	public void loginDriver(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		HttpSession session = req.getSession();
		String phone=req.getParameter("phone");
		String passwd=req.getParameter("passwd");
		DriverService driverService=new DriverServiceImpl();
		DriverPojo driverPojo=new DriverPojo();
//		System.out.println("b1:"+driverService.queryByPhone(phone));
		if(!driverService.queryByPhone(phone)){
			driverPojo.setPhone(phone);
			driverPojo.setPasswd(passwd);
//			System.out.println("b2:"+driverService.queryByPhone(driverPojo));	
			if(driverService.queryByPhone(driverPojo)){
				session.setAttribute("phone", phone);
				System.out.println("登陆成功");
				req.getRequestDispatcher("/beforeindex.do").forward(req, resp);
			}else{
				req.setAttribute("ErrorInfo", "密码错误");
				
			}
		}
		else{
			req.setAttribute("ErrorInfo", "手机号不存在或未注册");			
		}
		
	}
	public void addDriver(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String username=req.getParameter("username");
		String phone=req.getParameter("phone");
		String passwd=req.getParameter("passwd");
		String repasswd=req.getParameter("repasswd");
		DriverService driverService= new DriverServiceImpl();
		DriverPojo driverPojo=new DriverPojo();
		if(username.equals("")){
			req.setAttribute("ErrorInfo", "用户名不能为空");
			req.getRequestDispatcher("/test.jsp").forward(req, resp);
		}else{
			if(passwd.equals("")){
				req.setAttribute("ErrorInfo", "密码不能为空");
				req.getRequestDispatcher("/test.jsp").forward(req, resp);
			}else{
				if(passwd.equals(repasswd)){
					if(phone.equals("")){
						req.setAttribute("ErrorInfo", "手机号不能为空");
						req.getRequestDispatcher("/test.jsp").forward(req, resp);
					}else{
						if(driverService.queryByPhone(phone)==true){
							driverPojo.setName(username);
							driverPojo.setPasswd(passwd);
							driverPojo.setPhone(phone);
							driverService.add(driverPojo);
							System.out.println("注册成功");
						}else{
							req.setAttribute("ErrorInfo", "手机号已注册");
							req.getRequestDispatcher("/before_login.jsp").forward(req, resp);
						}
					}
				}else{
					req.setAttribute("ErrorInfo", "密码不一致");
					req.getRequestDispatcher("/test.jsp").forward(req, resp);
				}
			}
		}
	}
	
	public void deleteDriver(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		//String username=req.getParameter("username");
		String phone=req.getParameter("phone");
		DriverService driverService=new DriverServiceImpl();
		DriverPojo driverPojo=new DriverPojo();
		if(!phone.equals("")){
			if(driverService.queryByPhone(phone)==false){
				driverPojo.setPhone(phone);
				driverService.delete(driverPojo);
				System.out.println("删除成功");
				
			}else{
				req.setAttribute("ErrorInfo", "该用户不存在");
				req.getRequestDispatcher("/test2.jsp").forward(req, resp);
			}
		}else{
			req.setAttribute("ErrorInfo", "请输入手机号");
			req.getRequestDispatcher("/test2.jsp").forward(req, resp);
		}
	}
	public void updateDriver(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String username=req.getParameter("username").trim();
		String passwd=req.getParameter("passwd").trim();
		String repasswd=req.getParameter("repasswd").trim();
		String integral1=req.getParameter("integral").trim();
		String phone=req.getParameter("phone").trim();
		String changephone=req.getParameter("changephone").trim();
		String volum1=req.getParameter("volum").trim();
		String star1=req.getParameter("star").trim();
		String goodreview1=req.getParameter("goodreview").trim();
		DriverService driverService=new DriverServiceImpl();
		DriverPojo driverPojo=new DriverPojo();
		if(driverService.queryByPhone(phone)==false){
			if(repasswd.equals(passwd)){
				driverPojo.setPasswd(passwd);
				driverPojo.setPhone(phone);				
				if(!changephone.equals("")){
					if(driverService.queryByPhone(changephone)==true){
					driverPojo.setChangePhone(changephone);
					}else{
						req.setAttribute("ErrorInfo", "手机号已存在");
						req.getRequestDispatcher("/test3.jsp").forward(req, resp);
					}
				}else{
					driverPojo.setChangePhone("");
				}
				
				if(integral1.equals("")){
					int integral=-1;
					driverPojo.setIntegral(integral);
				    }
				else{
					driverPojo.setIntegral(Integer.parseInt(integral1));
				    }
				if(goodreview1.equals("")){
					int goodreview=-1;
					driverPojo.setGoodreview(goodreview);
				}else{
					driverPojo.setGoodreview(Float.parseFloat(goodreview1));
				}
				
			    driverPojo.setName(username);
			    if(star1.equals("")){
			    	int star=-1;
			    	driverPojo.setStar(star);
			    }else{
			    	driverPojo.setStar(Integer.parseInt(star1));
			    }
			    if(volum1.equals("")){
			    	int volum=-1;
			    	driverPojo.setVolum(volum);
			    }else{
			    	driverPojo.setVolum(Integer.parseInt(volum1));
			    }
			    
			    driverService.update(driverPojo);
			    System.out.println("更新成功");
			    req.getRequestDispatcher("/test3.jsp").forward(req, resp);
			
			}else{
				req.setAttribute("ErrorInfo", "密码不一致");
				req.getRequestDispatcher("/test3.jsp").forward(req, resp);
			}
			
		}else{
			req.setAttribute("ErrorInfo", "该手机号不存在或未注册");
			req.getRequestDispatcher("/test3.jsp").forward(req, resp);
		}
	}
	
	public void getAllDriver(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		DriverService driverService=new DriverServiceImpl();
		DriverPojo driverPojo=new DriverPojo();
		String username="";
		int integral=-1;
		String phone="";
		int volum=-1;
		int star=-1;
		float goodreview=-1;
		driverPojo.setName(username);
		driverPojo.setPhone(phone);
		driverPojo.setIntegral(integral);
		driverPojo.setStar(star);
		driverPojo.setGoodreview(goodreview);
		driverPojo.setVolum(volum);
		List<DriverPojo> list=driverService.all(driverPojo);
		req.setAttribute("list", list);
		if(list.size()!=0){	
		    System.out.println("查询成功");		        							
		}else{
			req.setAttribute("ErrorInfo", "无记录"); 		    	   	
        }	
		req.getRequestDispatcher("/WEB-INF/DriverMessage.jsp").forward(req, resp);
	}
	public void queryDriver(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String username=req.getParameter("username").trim();
		String integral1=req.getParameter("integral").trim();
		String phone=req.getParameter("phone").trim();
		String volum1=req.getParameter("volum").trim();
		String star1=req.getParameter("star").trim();
		String goodreview1=req.getParameter("goodreview").trim();
		DriverService driverService=new DriverServiceImpl();
		DriverPojo driverPojo=new DriverPojo();
		driverPojo.setName(username);
		driverPojo.setPhone(phone);
		if(username.equals("")&&integral1.equals("")&&phone.equals("")&&volum1.equals("")&&star1.equals("")&&goodreview1.equals("")){
			req.setAttribute("ErrorInfo", "请输入查询条件");
			req.getRequestDispatcher("/WEB-INF/DriverQuery.jsp").forward(req, resp);
		}
		if(integral1.equals("")){
			int integral=-1;
			driverPojo.setIntegral(integral);
		    }
		else{
			driverPojo.setIntegral(Integer.parseInt(integral1));
		    }
		if(goodreview1.equals("")){
			int goodreview=-1;
			driverPojo.setGoodreview(goodreview);
		}else{
			driverPojo.setGoodreview(Float.parseFloat(goodreview1));
		}
	    if(star1.equals("")){
	    	int star=-1;
	    	driverPojo.setStar(star);
	    }else{
	    	driverPojo.setStar(Integer.parseInt(star1));
	    }
	    if(volum1.equals("")){
	    	int volum=-1;
	    	driverPojo.setVolum(volum);
	    }else{
	    	driverPojo.setVolum(Integer.parseInt(volum1));
	    }
	    req.setCharacterEncoding("utf-8");
	    List<DriverPojo> list=driverService.all(driverPojo);
	    req.setAttribute("list", list);
	    
	    if(list.size()!=0){	
		    System.out.println("查询成功");		        							
		}else{
			req.setAttribute("ErrorInfo", "无记录"); 		    	   	
        }	
	    req.getRequestDispatcher("/WEB-INF/DriverQuery.jsp").forward(req, resp);
	}


}
