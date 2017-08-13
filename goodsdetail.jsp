<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Goods Detail Page</title>
<link href="css/before_login.css" rel="stylesheet" type="text/css" >
<style type="text/css">
tr{ height:35px; padding: 20px;}
tr td{padding: 20px;margin-left: 30px;}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div>
			<img src="img/bj_06.png">
		</div>
<div class="ig_hyxx">
				<div class="hyxx_top">
					<span class="hyxx_title">货源信息</span><span class="hyxx_english">SUPPLY
						INFORMATION</span><span class="hyxx_more"><a href="beforeindex.do">返回</a><label>  </label><a href="sendInfo?flag=3">更多</a></span>
				</div>
				
				<dl class="hyxx_sub">
				<c:set var="goods" value="${requestScope.goods }"></c:set>
					<table>
					<tr>
					<td><strong>货源编号：</strong></td><td>${requestScope.goods.sgoodid}</td>
			
					<td><strong>出发地：</strong></td><td>${goods.sgoodstart}</td>
					</tr>
					<tr>
					<td><strong>货主编号：</strong></td><td>${goods.shipperid}</td>
					<td><strong>目的地：</strong></td><td>${goods.sgoodend}</td>
					</tr>
					<tr>
					<td><strong>货物类型：</strong></td><td>${goods.sgoodsort}</td>
					<td><strong>有效期：</strong></td><td>${goods.sgood_valid_time}</td>
					</tr>
					<tr>
					<td><strong>联系方式：</strong></td><td>${goods.sphone}</td>
					<td><strong>货布时间：</strong></td><td>${goods.sgood_time}</td>
					</tr>
					</table>
					
				</dl>
				
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>