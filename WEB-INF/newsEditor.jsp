<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻编辑页面</title>
<script type="text/javascript" src="ckeditor/ckeditor.js"
	charset="UTF-8"></script>

</head>

<link href="images/skin.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}

textarea {
	resize: none;
}
-->
</style>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="17" valign="top" background="images/mail_leftbg.gif"><img
				src="images/left-top-right.gif" width="17" height="29" /></td>
			<td valign="top" background="images/content-bg.gif"><table
					width="100%" height="31" border="0" cellpadding="0" cellspacing="0"
					class="left_topbg" id="table2">
					<tr>
						<td height="31"><div class="titlebt">新闻编辑</div></td>
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
						<td width="100%">
							<!-- 新闻编辑块 -->

							
								<textarea class="ckeditor" cols="40" id="content"
									name="newscontent"  rows="10" id="content" ></textarea>
								<br> <br>
								<table>
									<tr>
										<td><img alt="" src="images/newstitle.png"></td>
										<td><input type="text" id="newstitle" name="newstitle" size="70"></td>
									</tr>
									<tr>
										<td><img alt="" src="images/zhaiyao.png"></td>
										<td><textarea name="zhaiyao" id="zhaiyao"cols="52" rows="2"></textarea></td>
									</tr>
									<tr>
										<td><img alt="" src="images/newssort.png"></td>
										<td><select name="newssort" id="newssort"><option
													value="picnews">公司新闻</option>
												<option value="textnews">行业新闻</option>
												<option value="gonggao">公司公告</option>
												</select></td>
									</tr>
									
									<tr>
										<td><img alt="" src="images/newssource.png"></td><td><input type="text" name="newssource" id="newssource" size="70"></td>
									</tr>
									
									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr><td align="right"><img alt="" src="images/fabunews.jpg" onclick="sendnews()"></td>
									<td align="center"><img alt="" src="images/savecaogao.jpg" onclick="savenews()"></td></tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
								</table>
								

						</td>
					</tr>
				</table>

			</td>
		</tr>
	</table>
	<script type="text/javascript" charset="UTF-8">
	//<![CDATA[    
	var editor=CKEDITOR.replace('content' );
	
	//]]>
	
	function sendnews(){
	   go("check");
	  
	}
	function savenews(){
		go("drafts");
	}
	function go(s){
		
		var newscontent=editor.getData();
		var newssort=document.getElementById("newssort").value;	
		var newssource=document.getElementById("newssource").value;
		var zhaiyao=document.getElementById("zhaiyao").value;
		var newstitle=document.getElementById("newstitle").value;
		
	    var url="newsServlet?flag="+s+"&newstitle="+newstitle+"&newscontent="+newscontent+"&newssort="+newssort+"&newstitle"+newstitle+"&newssource="+newssource+"&zhaiyao="+zhaiyao;;
	    
	    window.location.href=url;
	 
	}
	
</script>
</body>
</html>