<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>卓捷速递会员注册</title>
<meta name="keywords" content="卓捷速递" />
<meta name="description" content="卓捷速递" />
<meta name="author" content="zwy">
<link href="css/layout.css" rel="stylesheet" type="text/css">
<link href="css/base.css" rel="stylesheet" type="text/css">
<link href="css/dialog2.2.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/common.js" charset="utf-8"></script>

</head>
<body>

	<div id="append_parent"></div>
	<div id="ajaxwaitid"></div>
	<div id="page">
		<div id="topNav" class="warp-all">
			<dl class="user-entry">
				<dt>
					您好，欢迎来到<span><a href="homepage.jsp" title="首页" alt="首页">卓捷速递</a></span>
				</dt>
				<dd>
					[<a href="before_login.jsp">登录</a>]
				</dd>
				<dd>
					[<a href="register.jsp">注册</a>]
				</dd>
			</dl>
		</div>
	</div>
	<header id="topHeader">
	<div class="site-logo" style="margin-left: 80px; margin-top: 10px;">
	</div>
	</header>
	<link href="css/home_login.css" rel="stylesheet" type="text/css">
	<style type="text/css">
#search, #navBar {
	display: none !important;
}
</style>
	<div class="nc-login-layout">
		<div class="nc-login">
			<div class="nc-login-title">
				<h3>用户注册</h3>
			</div>
			<form id="register_form" method="post" action="registServlet">
			<div class="nc-login-content">
			        <dl>
						<dt>用户类型</dt>
						<dd style="min-height: 54px;">
							<input type="radio" name="user_type" id="user_type" value="1"
								onClick="javascript:get_user_type(this.value);" />货主
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							<input type="radio"
								name="user_type" id="user_type" value="2"
								onClick="javascript:get_user_type(this.value);" />司机

						</dd>
					</dl>
					
				
					
					<dl>
						<dt>用户名</dt>
						<dd style="min-height: 54px;">
							<input type="text" id="username" name="username" class="text tip"
								title="以字母开头，长度在6-18之间， 
　　只能包含字符、数字和下划线" />
						</dd>
						<!--正则表达式 ^[a-zA-Z]w{5,17}$ -->
					</dl>
					<dl>
						<dt>设置密码</dt>
						<dd style="min-height: 54px;">
							<input type="password" id="passwd" name="passwd" class="text tip"
								title="6-16位字符，可由英文、数字及标点符号组成" />

						</dd>
					</dl>
					<dl>
						<dt>确认密码</dt>
						<dd style="min-height: 54px;">
							<input type="password" id="repasswd" name="repasswd"
								class="text tip" title="请再次输入您的密码" />
						</dd>
					</dl>
					<dl>
						<dt>手机号</dt>
						<dd style="min-height: 54px;">
							<input type="text" id="phone" name="phone" class="text tip"
								title="输入可用11位手机号码" />
						</dd>
					</dl>
					<dl>
						<dt>邮箱</dt>
						<dd style="min-height: 54px;">
							<input type="text" id="email" name="email" class="text tip"
								title="请输入常用的邮箱，将用来找回密码、接受订单通知等" />
						</dd>
					</dl>
					<dl>
						<dt>地址</dt>
						<dd style="min-height: 54px;">
							<input type="text" id="address" name="address" class="text tip"
								title="请输入您的常驻地址，支持格式为省市地区" />

						</dd>
					</dl>

					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<input name="submit" type="submit" value="立即注册" class="submit fl"
								title="立即注册" /> <input name="agree" type="checkbox"
								class="fl mt10 ml10" id="clause" value="1" checked="checked" />
							<span for="clause" class="fl ml5">阅读并同意<a href="#"
								target="_blank" class="agreement" title="阅读并同意">服务协议</a></span>
						</dd>
					</dl>
				</form>
				<div class="clear"></div>
			</div>
			<div class="nc-login-bottom"></div>
		</div>
		<div class="nc-login-left">
			<img src="images/3.jpg" border="0">
			<h3 class="mt20">如果您是本站用户</h3>
			<div class="nc-login-now mt10">
				<span class="ml20">我已经注册过帐号，立即<a href="before_login.jsp" title=""
					class="register">登录</a></span><span></span>
			</div>
		</div>
	</div>

	<div class="clear">&nbsp;</div>
	<div id="footer">
		<p>
			<a href="homepage.jsp">首页</a> | <a href="#">广告合作</a> | 卓捷速递<a href="#"></a> | <a
				href="#">联系我们</a>
		</p>
		<br />
	</div>

	<!-- 表单的验证 -->
	<script type="text/javascript">
		//校验用户名
		$("#username").blur(function() {//用户框失去鼠标焦点
			if ($("#username").val() == "") {
				$("#username").val("请输入用户名!");
				$("#username").fadeIn("slow", function() {
					$("#username").css("border", "1px solid red");
				});
			}else{
				if(!$("#username").val().match(/^[a-zA-Z]+\w{5,17}$/)){
					$("#username").val("请按格式填写!");$("#username").fadeIn("slow", function() {
						$("#username").css("border", "1px solid red");
					});
			}
			}
		});
		$("#username").focus(function() {//用户框获取鼠标焦点
			$("#username").fadeIn("fast", function() {
				$("#username").css("border", "1px solid #DCDCDC");
			});
			$("#username").val("");
		});
		//校验密码
		$("#passwd").blur(function() {
			if ($("#passwd").val() == "") {
				//$("#passwd").css("type", "text");
				$("#password").val("请输入密码!");
				$("#passwd").fadeIn("slow", function() {
					$("#passwd").css("border", "1px solid red");
				});
			}
		});
		$("#passwd").focus(function() {
			$("#passwd").fadeIn("fast", function() {
				$("#passwd").css("border", "1px solid #DCDCDC");
			});
			$("#passwd").val("");
		});
		
		//校验密码是否一致
		$("#repasswd").blur(function() {
			if ($("#repasswd").val() != $("passwd").val()) {
				$("#repassword").val("两次密码不一致!");
				$("#repasswd").fadeIn("slow", function() {
					$("#repasswd").css("border", "1px solid red");
				});
			}
		});
		$("#repasswd").focus(function() {//用户框获取鼠标焦点
			$("#repasswd").fadeIn("fast", function() {
				$("#repasswd").css("border", "1px solid #DCDCDC");
			});
			$("#repasswd").val("");
		});
		//校验手机号
		$("#phone").blur(function() {//用户框失去鼠标焦点
			if ($("#phone").val() == "") {
				$("#phone").val("请输入手机号!");
				$("#phone").fadeIn("slow", function() {
					$("#phone").css("border", "1px solid red");
				});
			}
			else{
				if(!$("#phone").val().match(/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/)){
					$("#phone").val("手机号格式不对!");$("#phone").fadeIn("slow", function() {
						$("#phone").css("border", "1px solid red");
					});
			}
			}
		});
		$("#phone").focus(function() {//用户框获取鼠标焦点
			$("#phone").fadeIn("fast", function() {
				$("#phone").css("border", "1px solid #DCDCDC");
			});
			$("#phone").val("");
		});
		
		//校验邮箱
		$("#email").blur(function() {//用户框失去鼠标焦点
			if ($("#email").val() == "") {
				$("#email").val("请输入邮箱!");
				$("#email").fadeIn("slow", function() {
					$("#email").css("border", "1px solid red");
				});
			}else{
				if(!$("#email").val().match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) {
					$("#email").val("邮箱格式不对!");$("#email").fadeIn("slow", function() {
						$("#email").css("border", "1px solid red");
					});
			}
			}
		});
		$("#email").focus(function() {//用户框获取鼠标焦点
			$("#email").fadeIn("fast", function() {
				$("#email").css("border", "1px solid #DCDCDC");
			});
			$("#email").val("");
		});
		//校验地址
		$("#address").blur(function() {//用户框失去鼠标焦点
			if ($("#address").val() == "") {
				$("#address").val("请输入地址!");
				$("#address").fadeIn("slow", function() {
					$("#address").css("border", "1px solid red");
				});
			}
		});
		$("#address").focus(function() {//用户框获取鼠标焦点
			$("#address").fadeIn("fast", function() {
				$("#address").css("border", "1px solid #DCDCDC");
			});
			$("#address").val("");
		});
		
	</script>
</body>
</html>