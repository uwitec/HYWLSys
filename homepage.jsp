<%@ page language="java" import="java.util.*,com.hywl.pojo.*"
	pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>HYWLWeb Home Page</title>
<link href="css/before_login.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="jquery-1.7.2.js">
	
</script>

</head>
<body class="html" onload="getInfo()">

	<div id="wapper">
		<jsp:include page="header.jsp"></jsp:include>
		<div id="banner_tabs" class="flexslider">
			<ul class="slides">
				<li><a title="" href="#"> <img alt=""
						style="background: url(img/banner1.jpg) no-repeat center;">
				</a></li>
				<li><a title="" href="#"> <img alt=""
						style="background: url(img/banner2.jpg) no-repeat center;"></a></li>
				<li><a title="" href="#"> <img alt=""
						style="background: url(img/banner3.jpg) no-repeat center;"></a></li>
			</ul>
			<ul class="flex-direction-nav">
				<li><a class="flex-prev" href="javascript:;">Previous</a></li>
				<li><a class="flex-next" href="javascript:;">Next</a></li>
			</ul>
			<ol id="bannerCtrl" class="flex-control-nav flex-control-paging">
				<li><a>1</a></li>
				<li><a>2</a></li>
				<li><a>2</a></li>
			</ol>
		</div>
		<script src="js/jquery-1.10.2.min.js"></script>
		<script src="js/slider.js"></script>
		<script type="text/javascript">
			$(function() {
				var bannerSlider = new Slider($('#banner_tabs'), {
					time : 5000,
					delay : 400,
					event : 'hover',
					auto : true,
					mode : 'fade',
					controller : $('#bannerCtrl'),
					activeControllerCls : 'active'
				});
				$('#banner_tabs .flex-prev').click(function() {
					bannerSlider.prev();
				});
				$('#banner_tabs .flex-next').click(function() {
					bannerSlider.next();
				});
			});

			function detail(id) {
				//alert(id);
				var url = "goodsServlet?goodid=" + id + "&flag=detail";
				window.location.href = url;

			}
		</script>

		<!---->
		<div class="i_bg1">
			<div class="warp">
				<dl class="i_wl">
					<dd>
						<img src="img/i_pic1.jpg" /><br /> <a class="want_shipment"
							href="sendInfo?flag=1">我要发货</a>
					</dd>
					<dd>
						<img src="img/i_pic2.jpg" /><br /> <a class="want_car"
							href="sendInfo?flag=2">我要找车</a>
					</dd>
					<dd>
						<img src="img/i_pic3.jpg" /><br /> <a class="want_goods"
							href="sendInfo?flag=3">我要找货</a>
					</dd>
					<dt>
						<img src="img/i_pic4.jpg" />
					</dt>
					<p>中国首家大型货物物流公司， 阿里巴巴产业带 运营商参股的互联网金融平台，以控制风险，稳健理财为理念，提供
						安全、有担保、高收益 的互联网理财服务。</p>
				</dl>
				<div class="i_hy">
					<div class="hy_top">最新入网会员</div>
					<div class="myscroll">
						<ul>
							<li>186****1074 张玉生 河南省郑州市</li>
							<li>186****2423 屈石磊 河南省郑州市</li>
							<li>181****4286 田喜东 河南省新乡市</li>
							<li>136****6932 王丰 河南省郑州市</li>
							<li>155****9485 刘勇超 河南省郑州市</li>
							<li>151****7324 马新建 河南省周口市</li>
							<li>155****0787 王崇凤 安徽省阜阳市</li>
							<li>188****1795 马金刚 河北省沧州市</li>
							<li>139****9642 张焕兵 河南省许昌市</li>
							<li>152****1854 高山 辽宁省抚顺市</li>
							<li>137****7098 李东明 河南省新乡市</li>
						</ul>
					</div>

					<script src="js/scroll.js"></script>
					<script type="text/javascript">
						$(function() {
							$('.myscroll').myScroll({
								speed : 40, //数值越大，速度越慢
								rowHeight : 26
							//li的高度
							});
						});
					</script>
				</div>
			</div>
		</div>
		<!---->

		<div class="warp">
			<div class="i_hyxx">
				<div class="hyxx_top">
					<span class="hyxx_title">货源信息</span><span class="hyxx_english">SUPPLY
						INFORMATION</span><span class="hyxx_more"><a
						href="sendInfo?flag=3">更多</a></span>
				</div>
				<dl class="hyxx_sub">
					<dd class="hy_s1">
						<strong>始发地</strong>
					</dd>
					<dd class="hy_s2">
						<strong>目的地</strong>
					</dd>
					<dd class="hy_s3">
						<strong>货物类型</strong>
					</dd>
					<dd class="hy_s4">
						<strong>发布时间</strong>
					</dd>
					<dd class="hy_s5">
						<strong>操作</strong>
					</dd>
				</dl>
				<c:set var="list1" value="${requestScope.glist }" />

				<c:forEach var="item" items="${list1 }">

					<dl class="hyxx_sub">
						<dd class="hy_s1">${item.sgoodstart }</dd>
						<dd class="hy_s2">${item.sgoodend}</dd>
						<dd class="hy_s3">${item.sgoodsort}</dd>
						<dd class="hy_s4">${item.sgood_time }</dd>
						<dd class="hy_s5">
							<a href="javascript:;" class="btn_ck"
								onclick="detail(${item.sgoodid})">查看</a>
						</dd>
					</dl>
				</c:forEach>
			</div>
			<dl class="i_ann">
				<dt>
					<span class="title">最新公告</span><span class="more"><a
						href="companypost.jsp">更多</a></span>
				</dt>
				<c:set var="list2" value="${requestScope.gg }" />

				<c:forEach var="item2" items="${list2 }">

					<dd>
						<a href="postdetail.jsp">${item2.title}</a>
					</dd>
				</c:forEach>
			</dl>
			<div class="i_zx">
				<img src="img/i_zx.jpg" />
			</div>
		</div>
		<div class="ADD">
			<img src="img/gg1.jpg" />
		</div>
		<div class="warp">
			<div class="i_hyxx">
				<div class="hyxx_top">
					<span class="hyxx_title">车源信息</span><span class="hyxx_english">VEHICLE
						SOURCE INFORMATION</span><span class="hyxx_more"><a
						href="wantcar.jsp">更多</a></span>
				</div>
				<dl class="hyxx_sub_2">
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
					<dd class="hy_s6">
						<strong>操作</strong>
					</dd>
				</dl>

				<%
					List<DriverRoutePojo> list = (List<DriverRoutePojo>) request
							.getAttribute("dlist");
					if (list != null) {
						for (int i = 0; i < list.size(); i++) {
				%>
				<dl class="hyxx_sub_2">
					<dd class="hy_s1"><%=list.get(i).getStartPlace()%></dd>
					<dd class="hy_s2"><%=list.get(i).getDestination()%></dd>
					<dd class="hy_s3"><%=list.get(i).getCarno()%></dd>
					<dd class="hy_s4"><%=list.get(i).getCarweigth()%></dd>
					<dd class="hy_s5"><%=list.get(i).getCarlength()%></dd>
					<dd class="hy_s6">
						<a
							href="queryByPhone.work?phone=<%=list.get(i).getDriverphone()%>"
							class="btn_ck">查看</a>
					</dd>
					<>
					<%
						if (i > 7) {
									break;
								}
							}
						}
					%>
				
			</div>
			<dl class="i_ann">
				<dt>
					<span class="title">新闻动态</span><span class="more"><a
						href="companyne.jsp">更多</a></span>
				</dt>
				<c:set var="list3" value="${requestScope.news }" />

				<c:forEach var="item3" items="${list3 }">

					<dd>
						<a href="newdetail.jsp">${item3.title }</a>

					</dd>
				</c:forEach>
			</dl>
		</div>

		<!---->
		<div class="i_hzwlbg">
			<dl class="i_hzwl">
				<dt class="title">合作物流</dt>
				<dd>
					<a href=""><img src="img/i_wl1.jpg" /></a>
				</dd>
				<dd>
					<a href=""><img src="img/i_wl2.jpg" /></a>
				</dd>
				<dd>
					<a href=""><img src="img/i_wl3.jpg" /></a>
				</dd>
				<dd>
					<a href=""><img src="img/i_wl4.jpg" /></a>
				</dd>
				<dd>
					<a href=""><img src="img/i_wl5.jpg" /></a>
				</dd>
			</dl>
		</div>
		<div class="ADD">
			<img src="img/gg2.jpg" />
		</div>
		<!--底部-->
		<jsp:include page="footer.jsp"></jsp:include>

	</div>

</body>
</html>