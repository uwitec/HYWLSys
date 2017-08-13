package com.hywl.action;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hywl.pojo.ShipperPojo;
import com.hywl.service.ShipperService;
import com.hywl.service.ShipperServiceImpl;

@SuppressWarnings("serial")
public class ShipperServlet extends HttpServlet{
	public ShipperServlet() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String servletPath = req.getServletPath();
		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0, methodName.length() - 5);//

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
	public void loginShipper(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		HttpSession session = req.getSession();
		String phone=req.getParameter("phone");
		String passwd=req.getParameter("passwd");
		ShipperService shipperService=new ShipperServiceImpl();
		ShipperPojo shipperPojo=new ShipperPojo();
		System.out.println(shipperService.queryByPhone(phone));
		if(shipperService.queryByPhone(phone)==false){
			shipperPojo.setSphone(phone);
			shipperPojo.setSpassword(passwd);
			System.out.println(shipperService.queryByPhone(shipperPojo));
			if(shipperService.queryByPhone(shipperPojo)==true){
				 session.setAttribute("phone", phone);
				req.getRequestDispatcher("beforeindex.do").forward(req, resp);
			    System.out.println("登陆成功");
			}else{
				req.setAttribute("ErrorInfo", "密码错误");
				req.getRequestDispatcher("/test4.jsp").forward(req, resp);
			}
		}else{
			req.setAttribute("ErrorInfo", "手机号不存在或未注册");
			req.getRequestDispatcher("/test4.jsp").forward(req, resp);
		}
		
	}
	public void addShipper(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String username=req.getParameter("username");
		String phone=req.getParameter("phone");
		String passwd=req.getParameter("passwd");
		String repasswd=req.getParameter("repasswd");
		ShipperService shipperService=new ShipperServiceImpl();
		ShipperPojo shipperPojo=new ShipperPojo();
		
		if(username.equals("")){
			req.setAttribute("ErrorInfo", "用户名不能为空");
			req.getRequestDispatcher("/test1.jsp").forward(req, resp);
		}else{
			if(passwd.equals("")){
				req.setAttribute("ErrorInfo", "密码不能为空");
				req.getRequestDispatcher("/test1.jsp").forward(req, resp);
			}else{
				if(passwd.equals(repasswd)){
					if(phone.equals("")){
						req.setAttribute("ErrorInfo", "手机号不能为空");
						req.getRequestDispatcher("/test1.jsp").forward(req, resp);
					}else{
						if(shipperService.queryByPhone(phone)==true){
							shipperPojo.setSname(username);
							shipperPojo.setSpassword(passwd);;
							shipperPojo.setSphone(phone);
							shipperService.add(shipperPojo);
							System.out.println("注册成功");
						}else{
							req.setAttribute("ErrorInfo", "手机号已注册");
							req.getRequestDispatcher("/test1.jsp").forward(req, resp);
						}
					}
				}else{
					req.setAttribute("ErrorInfo", "密码不一致");
					req.getRequestDispatcher("/test1.jsp").forward(req, resp);
				}
			}
		}
	}
	
	public void deleteShipper(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		//String username=req.getParameter("username");
		String phone=req.getParameter("phone");
		ShipperService shipperService=new ShipperServiceImpl();
		ShipperPojo shipperPojo=new ShipperPojo();
		if(!phone.equals("")){
			if(shipperService.queryByPhone(phone)==false){
				shipperPojo.setSphone(phone);
				shipperService.delete(shipperPojo);
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
	
	public void updateShipper(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String username=req.getParameter("username");
		String passwd=req.getParameter("passwd");
		String repasswd=req.getParameter("repasswd");
		String integral1=req.getParameter("integral");
		String phone=req.getParameter("phone");
		String changephone=req.getParameter("changephone");
		String volum1=req.getParameter("volum");
		String star1=req.getParameter("star");
		String goodreview1=req.getParameter("goodreview");
		ShipperService shipperService=new ShipperServiceImpl();
		ShipperPojo shipperPojo=new ShipperPojo();
		if(shipperService.queryByPhone(phone)==false){
			if(repasswd.equals(passwd)){
				shipperPojo.setSpassword(passwd);
				shipperPojo.setSphone(phone);
				
				if(!changephone.equals("")){
					if(shipperService.queryByPhone(changephone)==true){
					shipperPojo.setChangePhone(changephone);
					}else{
						req.setAttribute("ErrorInfo", "手机号已存在");
						req.getRequestDispatcher("/test3.jsp").forward(req, resp);
					}
				}else{
					shipperPojo.setChangePhone("");
				}
				
				if(integral1.equals("")){
					int integral=-1;
				    shipperPojo.setSscore(integral);
				    }
				else{
				    	shipperPojo.setSscore(Integer.parseInt(integral1));
				    }
				if(goodreview1.equals("")){
					int goodreview=-1;
					shipperPojo.setSnicerate(goodreview);
				}else{
					shipperPojo.setSnicerate(Float.parseFloat(goodreview1));
				}
				
			    shipperPojo.setSname(username);
			    if(star1.equals("")){
			    	int star=-1;
			    	shipperPojo.setSstar(star);
			    }else{
			    	shipperPojo.setSstar(Integer.parseInt(star1));
			    }
			    if(volum1.equals("")){
			    	int volum=-1;
			    	shipperPojo.setSsumnumber(volum);
			    }else{
			    	shipperPojo.setSsumnumber(Integer.parseInt(volum1));
			    }
			    
			    shipperService.update(shipperPojo);
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
	
	public void getAllShipper(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		ShipperService shipperService=new ShipperServiceImpl();
		ShipperPojo shipperPojo=new ShipperPojo();
		String username="";
		int integral=-1;
		String phone="";
		int volum=-1;
		int star=-1;
		float goodreview=-1;
		shipperPojo.setSname(username);
		shipperPojo.setSphone(phone);
		shipperPojo.setSscore(integral);
		shipperPojo.setSstar(star);
		shipperPojo.setSnicerate(goodreview);
		shipperPojo.setSsumnumber(volum);
		List<ShipperPojo> list=shipperService.all(shipperPojo);
		req.setAttribute("list", list);		
		if(list.size()!=0){	
			    System.out.println("查询成功");		        							
			}else{
				req.setAttribute("ErrorInfo", "无记录"); 		    	   	
	        }	    
		req.getRequestDispatcher("/WEB-INF/ShipperMessage.jsp").forward(req, resp);		
	}
	public void queryShipper(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String username=req.getParameter("username").trim();
		String integral1=req.getParameter("integral").trim();
		String phone=req.getParameter("phone").trim();
		String volum1=req.getParameter("volum").trim();
		String star1=req.getParameter("star").trim();
		String goodreview1=req.getParameter("goodreview").trim();
		ShipperService shipperService=new ShipperServiceImpl();
		ShipperPojo shipperPojo=new ShipperPojo();
		shipperPojo.setSname(username);
		shipperPojo.setSphone(phone);
		if(username.equals("")&&integral1.equals("")&&phone.equals("")&&volum1.equals("")&&star1.equals("")&&goodreview1.equals("")){
			req.setAttribute("ErrorInfo", "请输入查询条件");
			req.getRequestDispatcher("/WEB-INF/ShipperQuery.jsp").forward(req, resp);
		}
		if(integral1.equals("")){
			int integral=-1;
		    shipperPojo.setSscore(integral);
		    }
		else{
		    	shipperPojo.setSscore(Integer.parseInt(integral1));
		    }
		if(goodreview1.equals("")){
			int goodreview=-1;
			shipperPojo.setSnicerate(goodreview);
		}else{
			shipperPojo.setSnicerate(Float.parseFloat(goodreview1));
		}
	    if(star1.equals("")){
	    	int star=-1;
	    	shipperPojo.setSstar(star);
	    }else{
	    	shipperPojo.setSstar(Integer.parseInt(star1));
	    }
	    if(volum1.equals("")){
	    	int volum=-1;
	    	shipperPojo.setSsumnumber(volum);
	    }else{
	    	shipperPojo.setSsumnumber(Integer.parseInt(volum1));
	    }
	    req.setCharacterEncoding("utf-8");
	    List<ShipperPojo> list=shipperService.all(shipperPojo);	  
	    if(list.size()!=0){	
		    System.out.println("查询成功");		        							
		}else{
			req.setAttribute("ErrorInfo", "无记录"); 		    	   	
        }	
	    req.getRequestDispatcher("/WEB-INF/ShipperQuery.jsp").forward(req, resp);	    
	}	
}


