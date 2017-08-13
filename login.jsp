<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>卓捷速递会员登录</title>
<meta name="keywords" content="卓捷速递" />
<meta name="description" content="卓捷速递" />
<meta name="author" content="zwy">
<link href="css/layout.css" rel="stylesheet" type="text/css">
<link href="css/base.css" rel="stylesheet" type="text/css">
</head>
<body>
<link href="css/dialog2.2.css" rel="stylesheet" type="text/css">
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div id="page">
  <div id="topNav" class="warp-all">
        <dl class="user-entry">
      <dt>您好，欢迎来到<span><a href="homepage.html" title="首页" alt="首页">卓捷速递</a></span></dt>
      <dd>[<a href="login.jsp">登录</a>]</dd>
      <dd>[<a href="register.jsp">注册</a>]</dd>
    </dl>        
  </div>
</div>
<header id="topHeader">
  <div class="site-logo" style="margin-left:80px;margin-top:10px;">
  <!-- <img src="images/logo.png" class="pngFix"> -->
  </div>  
</header>
<link href="css/home_login.css" rel="stylesheet" type="text/css">
<style type="text/css">
#search, #navBar {
	display: none !important;
}
</style>
<div class="nc-login-layout">
  <div class="left-pic"><img src="images/3.jpg"  border="0"></div>
  <div class="nc-login">
    <div class="nc-login-title">
      <h3>用户登录</h3>
    </div>
    <div class="nc-login-content" id="demo-form-site">
      <form id="login_form" method="post" class="bg" action="beforeindex.do">
        <dl>
          <dt>手机号</dt>
          <dd style="min-height:54px;">
            <input type="text" class="text" autocomplete="off"  name="phone" id="phone">
          </dd>
        </dl>
        <dl>
          <dt>密&nbsp;&nbsp;&nbsp;码 </dt>
          <dd style="min-height:54px;">

            <input type="password" class="text" name="password" autocomplete="off"  id="password">
            <label></label>
          </dd>
        </dl>
                <dl>
          <dt>验证码</dt>
          <dd style="min-height:54px;">
            <input type="text" name="captcha" class="text w50 fl" id="captcha" maxlength="4" size="10" />
            <img src="images/code.jpg" name="codeimage" border="0" id="codeimage" class="fl ml5">
             <a href="javascript:void(0)" class="ml5" >看不清，换一张</a>
            <label></label>
          </dd>
        </dl>
                <dl>
          <dt>&nbsp;</dt>
          <dd>
            <input type="submit" class="submit" value="登&nbsp;&nbsp;&nbsp;录" >
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a class="forget" href="#">忘记密码？</a>
            <input type="hidden" value="" name="ref_url"></dd>
        </dl>
        
      </form>
      <dl class="mt10 mb10">
        <dt>&nbsp;</dt>
        <dd>还不是本站会员？立即<a title="" href="register.jsp" class="register">注册</a></dd>
      </dl>
            <dl>
        
        <dd class="nc-login-other">
          <p>您可以用合作伙伴账号登录：</p>
          <img src="images/qq.png" style="width:20px;height:20px;">QQ登录  
          <img src="images/sina.jpg" style="width:20px;height:20px;">微博登录  
                  </dd>
          
      </dl>
          </div>
    <div class="nc-login-bottom"></div>
  </div>
</div>
<script>
</script>
<div class="clear">&nbsp;</div>
<div id="footer">
  <p><a href="#">首页</a>
                | <a  href="#">广告合作</a>
                | 卓捷速递<a  href="#"></a>
                | <a  href="#">联系我们</a>  </p>
 <br />
   </div>
</body>
</html>
