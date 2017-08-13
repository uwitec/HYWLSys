<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" media="screen" href="css/1.css" />
 <link href="css/base.css" rel="stylesheet" type="text/css">
    <script src="js/2.js"></script>
        <script src="js/3.js"></script>
        <script src="js/4.js"></script>
<title>Before Login Page</title>
</head>
<body>
<!--头部-->
<div id="page">
  <div id="topNav" class="warp-all">
        <dl class="user-entry">
      <dt>您好，欢迎来到<span><a href="homepage.jsp" title="首页" alt="首页">卓捷速递</a></span></dt>
      <dd>[<a href="before_login.jsp">登录</a>]</dd>
      <dd>[<a href="register.jsp">注册</a>]</dd>
    </dl>        
  </div>
</div>
	<div id="main">
		<div class="txtimg-show"></div>
		<form id="logon" action="loginDriver.action"
			accept-charset="UTF-8" method="post">
			<input name="utf8" type="hidden" value="&#x2713;" /><input
				type="hidden" name="authenticity_token"
				value="mrn4tvJxgHlktQSnxZcDSEsusLdD5yu5vHfljbDnBU/fe+vlkzkY7kcRRkUbnmClh01C38y8gjJiJqj9KzxngQ==" />
			<ul class="memberzone clearfix">
				<li class="present" data-show-case="bfb">货主登录</li>
				<li class="" data-show-case="mic">司机登陆</li>
			</ul>
			<div class="tabcon">
				<fieldset>
					<div class="wrapdiv">
						<label data-show-case="bfb">手机号：</label> <label
							data-show-case="mic" style="display: none">手机号：</label> <input
							type="text" name="phone" id="logUserName" value=""
							class="inputtext" size="17" maxlength="160" tabindex="1" />
					</div>
					<div class="wrapdiv">
						<div>
							<a href="" class="forget"
								data-show-case="bfb"></a><label>密码：</label>
						</div>
						<input type="password" name="passwd" id="logPassword" value=""
							class="inputtext" size="17" tabindex="2" />
					</div>
					<input type="hidden" name="back_url" id="back_url" />
					<div class="logBtn logbtnre">
						<input type="submit" name="commit" value="" />
					</div>
				</fieldset>
			   <a href="register.jsp" data-show-case="bfb">免费注册</a>
				<p class="madein" style="display: none" data-show-case="mic">登录即表示您已同意遵守物流网服务条款并同意获取您的中国制造网国际站部分信息。</p>
			</div>
		</form>
	</div>
	  <script type="text/javascript">
    jQuery(function($) {
      $("#logUserName").focus();

      var $logonForm = $("#logon")
      var clearError = true

      $(".memberzone").on('click', 'li', function() {
        var $self = $(this)
        if (!$self.hasClass('present')) {
          // 切换tab
          $self.addClass('present')
          var $other = $self.siblings().first()
          $other.removeClass('present')
          // 切换下方显示信息
          var showCase = $self.data("showCase")
          $logonForm.find(".tabcon [data-show-case]").hide();
          $logonForm.find(".tabcon [data-show-case=" + showCase + "]").show();
          // 切换表单提交地址
          if (showCase == 'mic') {
            $logonForm[0].action = 'loginDriver.action'
          } else {
            $logonForm[0].action = 'loginShipper.done'
          }
          // 清空表单和错误信息
          if (clearError) {
            $logonForm.find('input:visible').val('')
            $logonForm.find('.erText').remove();
            clearError = true
          }
        }
      });
  });
  </script>
  <!--尾部-->
<div id="footer">
  <p><a href="homepage.jsp">首页</a>
                | <a  href="#">广告合作</a>
                | 卓捷速递<a  href="#"></a>
                | <a  href="#">联系我们</a>  </p>
 <br />
   </div>
</body>
</html>