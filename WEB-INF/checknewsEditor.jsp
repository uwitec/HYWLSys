<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>待审核</title>
<script type="text/javascript">
function allownews(newsno){
   var url="newsServlet?flag=allow&newsno="+newsno;
   window.location.href=url;
}
function backnews(newsno){
   var url="newsServlet?flag=back&newsno="+newsno;
   window.location.href=url;
}
</script>
</head>

<link href="images/skin.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 10px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
.maintable{border:1px solid #d3d3d3;}
.maintable td {border-top:1px solid #e0e0e0; border-right:1px solid #e0e0e0;text-align: center;}

-->
</style>
<body>
<c:set var="checklist" value="${requestScope.checklist }"/>

<c:set var="pageCount" value="10"/>
<c:set var="pageIndex" value="2"/>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="17" valign="top" background="images/mail_leftbg.gif"><img
				src="images/left-top-right.gif" width="17" height="29" /></td>
			<td valign="top" background="images/content-bg.gif"><table
					width="100%" height="31" border="0" cellpadding="0" cellspacing="0"
					class="left_topbg" id="table2">
					<tr>
						<td height="31"><div class="titlebt">待审核</div></td>
					</tr>
				</table></td>

		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>

		<tr>

			<td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>

			<td valign="top" bgcolor="#F7F8F9">

				<table width="98%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td>记录数：${fn:length(requestScope.checklist)}个</td>
						<td ></td>
						<td align="right">类型：<select>
						<option value="picnews">公司新闻</option>
												<option value="textnews">行业新闻</option>
												<option value="gonggao">公司公告</option>
												</select>
					</tr>
				</table>
				<br>
				<table width="99%" class="maintable" style="font-size:13px;">
					<tr bgcolor="#DCDCDC">
						<td width="10%">编号</td>
						<td width="15%">标题</td>
						<td width="26%">摘要</td>
						<td width="10%">保存人</td>
						<td width="13%">保存时间</td>
						<td width="9%">类型</td>
						<td width="10%"></td>
					</tr>
					<c:if test="${fn:length(requestScope.checklist)>0 }">
					<c:forEach var="item" items="${checklist }">
					
					<td>${item.newsno}</td>
					<td>${item.title}</td>
					<td>${item.abs}</td>
					<td>${item.pname}</td>
					<td>${item.date}</td>
					<td>${item.classify}</td>
					<td><input type="button" value="通过" onclick="allownews(${item.newsno})">
					<input type="button" value="退回" onclick="backnews(${item.newsno})"></td>
					
					</c:forEach>
				</c:if>
				</table>



			</td>
		</tr>
	</table>
</body>
</html>