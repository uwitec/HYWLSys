<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.hywl.pojo.*"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>货主遍历</title>
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
.maintable td {border-top:1px solid #e0e0e0; border-right:1px solid #e0e0e0;}
-->
</style>
<body>
<c:set var="pageCount" value="10"></c:set>
<c:set var="pageIndex" value="2"></c:set>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="17" valign="top" background="images/mail_leftbg.gif"><img
				src="images/left-top-right.gif" width="17" height="29" /></td>
			<td valign="top" background="images/content-bg.gif"><table
					width="100%" height="31" border="0" cellpadding="0" cellspacing="0"
					class="left_topbg" id="table2">
					<tr>
						<td height="31"><div class="titlebt">货主遍历</div></td>
					</tr>
				</table></td>

		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>

		<tr>

			<td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>

			<td valign="top" bgcolor="#F7F8F9">
                <form action="getAllShipper.done" method="post">
				<table width="98%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr><td>Shipper：</td>
				
					
					<td align="right"><input type="submit" value="查询所有货主"></td></tr>
				</table><br>
				<%
                       String info=(String)request.getAttribute("ErrorInfo"); 
                       out.println(info==null?"":info);
    %>
				</form>
				
				<table width="99%" class="maintable">
					<tr bgcolor="#DCDCDC">					
					    <td width="20%" align="center">手机号</td>
						<td width="14%" align="center">用户名</td>
						<td width="7%" align="center">积分</td>
						<td width="7%" align="center">星级</td>
						<td width="10.5%" align="center">交易数</td>
						<td width="10.5%" align="center">好评率</td>
						<td width="30%" align="center">注册时间</td>
					</tr>
					<%
					request.setCharacterEncoding("utf-8");
                   List<ShipperPojo>list=(List<ShipperPojo>)request.getAttribute("list");
					if(list!=null){
						for(int i=0;i<list.size();i++){
							out.println("<tr><td>");
							out.println(list.get(i).getSphone());
							out.println("</td><td>");
							out.println(list.get(i).getSname());
							out.println("</td><td>");
							out.println(list.get(i).getSscore());
							out.println("</td><td>");
							out.println(list.get(i).getSstar());
							out.println("</td><td>");
							out.println(list.get(i).getSsumnumber());
							out.println("</td><td>");
							out.println(list.get(i).getSnicerate());
							out.println("</td><td>");
							out.println(list.get(i).getSregister_time());
							out.println("</td></tr>");		
						}
					} 
%>
						<tr>	
				</table>               
</body>
</html>