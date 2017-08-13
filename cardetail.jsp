<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Car Detail Page</title>
<link href="css/before_login.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div>
		<img src="img/bj_06.png">
	</div>
	<div class="ic_hyxx">
		<div class="hyxx_top">
			<span class="hyxx_title">车源信息</span><span class="hyxx_english">VEHICLE
				SOURCE INFORMATION</span><span class="hyxx_more"><a href="homepage.jsp">返回</a><label>  </label><a
				href="sendInfo?flag=2">更多</a></span>
		</div>
		<dl class="hyxx_sub_2">
		<dd class="hy_s6">
				<strong>车主信息</strong>
			</dd>
			<dd class="hy_s1">
			
				<strong>始发地</strong>
			</dd>
			<dd class="hy_s2">
				<strong>目的地</strong>
			</dd>
			<dd class="hy_s3">
				<strong>车牌号</strong>
			</dd>
			<dd class="hy_s4">
				<strong>承重/吨</strong>
			</dd>
			<dd class="hy_s5">
				<strong>车长/米</strong>
			</dd>
			
		</dl>
		<dl class="hyxx_sub_2">
			<dd class="hy_s6">刘师傅</dd>
			<dd class="hy_s1">湖北省，武汉市</dd>
			<dd class="hy_s2">广西省，桂林市</dd>
			<dd class="hy_s3">鄂A86678</dd>
			<dd class="hy_s4">25</dd>
			<dd class="hy_s5">16</dd>
			
		</dl>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>