<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'header.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<link href="css/before_login.css" rel="stylesheet" type="text/css">

  </head>
  
  <body>
   	<div class="i_header2">
				<div id="logo">
					<p class="i_logo">
						<img src="img/logo.jpg">
					</p>
				</div>
				<div id="navfirst">
					<ul>
						<li id="p"><a href=companypost.jsp>公司公告</a></li>
						<li id="sp"><a href=support.jsp>供求信息</a></li>
						<li id="m"><a href=member.jsp>会员中心</a></li>
						<li id="cn"><a href=companynew.jsp>公司新闻</a></li>
						<li id="in"><a href=industrynew.jsp>行业新闻</a></li>
						<li id="a"><a href=apply.jsp>招贤纳士</a></li>
						<li id="s"><a href=summary.jsp>公司简介</a></li>
						<li id="h"><a href=beforeindex.do>首页</a></li>
					</ul>
				</div>
			</div>
  </body>
</html>
