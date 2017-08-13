<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>草稿箱</title>
<script type="text/javascript">
function changenews(newsid){
    var url="newsServlet?flag=change&newsno="+newsid;
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
<c:set var="draftslist" value="${requestScope.draftslist }"/>
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
						<td height="31"><div class="titlebt">草稿箱</div></td>
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
						<td>草稿数：${fn:length(requestScope.draftslist)} 个</td>
						<td ></td>
						<td align="right">类型：<select><option
													value="picnews">公司新闻</option>
												<option value="textnews">行业新闻</option>
												<option value="gonggao">公司公告</option>
												</select></td>
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
					
					<c:if test="${fn:length(requestScope.draftslist)>0 }">
					<c:forEach var="item" items="${draftslist }">					
					<td>${item.newsno}</td>
					<td>${item.title}</td>
					<td>${item.abs}</td>
					<td>${item.pname}</td>
					<td>${item.date}</td>
					<td>${item.classify}</td>
					<td><input type="button" value="修改" onclick="changenews(${item.newsno})>
					<input type="button" value="发布" onclick="sendnews(${item.newsno})"></td>
					
					</c:forEach>
				</c:if>
					
				</table>
                <table width="100%" align="center">

							<tr>
								<td>
								<c:if test="${pageIndex==1}">首页</c:if>
								<c:if test="${pageIndex!=1}">
								<a href="show?pageIndex=1">首页</a></c:if>
								</td>
								<td>
						       <c:if test="${pageIndex==1}">上一页</c:if>
								<c:if test="${pageIndex!=1}"><a href="show?pageIndex${ pageIndex - 1}">上一页</a>
								</c:if>								</td>
							    <c:forEach var="i" begin="1" end="${pageCount}">
								<td>
									<c:if test="${pageIndex==i}">${i}</c:if>
									<c:if test="${pageIndex!=i}">
									<a href="show?pageIndex=${i }">${i }</a></c:if>
								</td>
								</c:forEach>
								<td>
									<c:if test="${pageCount==pageIndex }">
										下一页
									</c:if>
									<c:if test="${pageCount!=pageIndex }">
									 <a href="show?pageIndex=${pageIndex+1}">下一页</a></c:if>
								</td>
							
								<td>
									<c:if test="${pageCount==pageIndex }">
											尾页</c:if>
									<c:if test="${pageCount!=pageIndex }">
									<a href="show?pageIndex=${pageIndex}">尾页</a></c:if>
								</td>
							</tr>
						</table> 


			</td>
		</tr>
	</table>
</body>
</html>