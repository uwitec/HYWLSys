<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="x-ua-compatible" content="ie=edge,chrome=1" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand" />
<meta name="360-site-verification"
	content="029735b839b7104f29e5e9550a456cbd" />
<link rel="stylesheet" href="css/reset.css"
	type="text/css" />
<link rel="stylesheet" href="css/index.css"
	type="text/css" />
<link rel="stylesheet" href="css/index1028.css"
	type="text/css" />
<link rel="stylesheet" href="css/index1114.css"
	type="text/css" />
<title>会员中心</title>
<meta name="keywords" content="vip ">
<meta name="description" content="vip ">
<script type="text/javascript"
	src="http://s.abwuliu.com/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="http://s.abwuliu.com/js/jquery.form.js"></script>
<script type="text/javascript"
	src="http://s.abwuliu.com/js/lhgdialog.min.js?skin=blue"></script>
<style type="text/css">
/*用户登录*/
.up_yhdl {
	width: 308px;
	height: 252px;
	margin: 0 auto;
	padding: 8px 42px 26px 42px;
	background: #fff url(../images/rzzc_img03.jpg) right bottom no-repeat;
	border: 1px solid #919191;
	box-shadow: 0 0 24px #4e4e4e;
	-moz-box-shadow: 0 0 24px #4e4e4e;
	-webkit-box-shadow: 0 0 24px #4e4e4e;
}

.up_yhdl h3 {
	height: 42px;
	color: #00a84d;
	font-size: 18px;
	margin-bottom: 18px;
	line-height: 42px;
	text-align: center;
	border-bottom: 1px solid #f0f0f0;
}

.up_yhdl h3 span {
	display: inline-block;
	position: relative;
	top: -1px;
	padding: 0 16px;
	border-bottom: 2px solid #f27c0e;
}

.up_yhdl li {
	float: none;
	width: auto;
	height: 36px;
	display: block;
	margin-bottom: 8px;
}

.up_yhdl li input {
	width: 270px;
	height: 34px;
	font-size: 14.5px;
	color: #4c4c4c;
	padding: 0 18px;
	background: none;
	border-radius: 2px;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #cfcfcf;
}

.up_yhdl .up_yhdl_list input {
	width: 154px;
	float: left;
	margin-right: 8px;
}

.up_yhdl .up_yhdl_list p {
	float: left;
	width: 107px;
	line-height: 34px;
	background: #57D4F5;
}

.up_yhdl .up_yhdl_list a {
	float: left;
	width: 108px;
	text-align: center;
	color: #fff;
	background: #1abc64;
	font-size: 14px;
	line-height: 36px;
	/*background:#c7c7c7;*/
	border-radius: 2px;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
}

.up_yhdl .up_yhdl_list a:hover {
	background: #1abc64;
}

.up_yhdl .up_yhdl_list .up_yhdl_a {
	background: #c7c7c7;
}

.up_yhdl .up_yhdl_list .up_yhdl_a:hover {
	background: #c7c7c7;
}

.up_yhdl .up_yhdl_button {
	text-align: left;
	margin-top: 22px;
	position: relative;
}

.up_yhdl .up_yhdl_button input {
	width: 192px;
	color: #fff;
	font-size: 16px;
	border: none;
	cursor: pointer;
	border-radius: 4px;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	background: url(../public/images_index/new08.jpg) left repeat-x;
}

.up_yhdl .up_yhdl_button p {
	position: absolute;
	font-size: 14px;
	padding-left: 0;
	color: #ff0000;
	top: -22px;
	left: 19px;
}

.top_head {
	display: none
}
</style>
</head>
<body>

	<div class="new_main">

		<!--头部-->
		<div class="new_header">


			<div class="i_navbg">
				<jsp:include page="header.jsp"></jsp:include>
			</div>

			<!--头部-->

			<div class="hz_importance">
				<!--个人认证-->
				<div class="rzzc_div grrz_div">
					<div class="grrz_top">
						<img src="img/bj_06.png" width="100%" height="230">
					</div>
					<div class="grrz_bottom">
						<h3 class="grrz_bottom_list">
							<span>个人中心</span>
						</h3>
						<div class="my_left">
							<ul>
								<br>
								<br>
								<li onclick="setTab2('col',1,6)" id="col1"><a
									href="login.jsp" target="main">登录</a></li>
								<li onclick="setTab2('col',2,6)" id="col2"><a
									href="suggestion.jsp" target="main">意见反馈</a></li>
								<li onclick="setTab2('col',3,6)" id="col3"><a
									href="exchange.jsp" target="main">积分商城</a></li>
								<li onclick="setTab2('col',4,6)" id="col4"><a
									href="shipselect.jsp" target="main">货源查询</a></li>
								<li onclick="setTab2('col',5,6)" id="col5"><a
									href="carselect.jsp" target="main">车源查询</a></li>
								<li onclick="setTab2('col',6,6)" id="col6"><a
									href="putout.jsp" target="main">发布货源</a></li>

							</ul>
						</div>



						<div class="my_right grrz_bottom_right">
							<iframe src="login.jsp" id='mains' name="main" width="100%"
								height="1034" scrollingX="No" frameborder="0" id="r"> </iframe>


							<div class="clear"></div>
						</div>
					</div>
					<!--个人认证-->
				</div>
			</div>
</body>
</html>

