<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>footer</title>
    <link href="css/before_login.css" rel="stylesheet" type="text/css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
  </head>
  
  <body>
    <div class="footbg">
			<div class="footer">
				<dl class="foot_left">
					<dt>
					
					</dt>
					<dd>
						<a href="beforeindex.do">首页</a>|<a href="wantgoods.jsp">货源信息</a>|<a href="wantcar.jsp">车源信息</a>|<a
							href="companypost.jsp">最新公告</a>|<a href="industrynew.jsp">同行新闻</a>|<a href="">关于我们</a>|<a
							href="apply.jsp">加入我们</a>|
					</dd>
				</dl>
				<dl class="foot_right">
					<dt>
						客服热线：<br /> <b>4008-555-666</b>
					</dt>
					<dd>
						<img src="img/ma_1.png" /><br /> 下载手机APP
					</dd>
					<dd>
						<img src="img/ma_2.png" /><br /> 关注微信公众号
					</dd>
				</dl>
			</div>
		</div>
  </body>
</html>
