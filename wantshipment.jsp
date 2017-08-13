<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Want Shipment Page</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link href="css/before_login.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/index1114.css?get=1" type="text/css" />
<link href="css/LocationRange.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/PCASClass.js"></script>
<script type="text/javascript">
	function banner() {
		var bn_id = 0;
		var bn_id2 = 1;
		var speed33 = 5000;
		var qhjg = 1;
		var MyMar33;
		$("#banner .d1").hide();
		$("#banner .d1").eq(0).fadeIn("slow");
		if ($("#banner .d1").length > 1) {
			$("#banner_id li").eq(0).addClass("nuw");
			function Marquee33() {
				bn_id2 = bn_id + 1;
				if (bn_id2 > $("#banner .d1").length - 1) {
					bn_id2 = 0;
				}
				$("#banner .d1").eq(bn_id).css("z-index", "2");
				$("#banner .d1").eq(bn_id2).css("z-index", "1");
				$("#banner .d1").eq(bn_id2).show();
				$("#banner .d1").eq(bn_id).fadeOut("slow");
				$("#banner_id li").removeClass("nuw");
				$("#banner_id li").eq(bn_id2).addClass("nuw");
				bn_id = bn_id2;
			}
			;

			MyMar33 = setInterval(Marquee33, speed33);

			$("#banner_id li").click(function() {
				var bn_id3 = $("#banner_id li").index(this);
				if (bn_id3 != bn_id && qhjg == 1) {
					qhjg = 0;
					$("#banner .d1").eq(bn_id).css("z-index", "2");
					$("#banner .d1").eq(bn_id3).css("z-index", "1");
					$("#banner .d1").eq(bn_id3).show();
					$("#banner .d1").eq(bn_id).fadeOut("slow", function() {
						qhjg = 1;
					});
					$("#banner_id li").removeClass("nuw");
					$("#banner_id li").eq(bn_id3).addClass("nuw");
					bn_id = bn_id3;
				}
			})
			$("#banner_id").hover(function() {
				clearInterval(MyMar33);
			}, function() {
				MyMar33 = setInterval(Marquee33, speed33);
			})
		} else {
			$("#banner_id").hide();
		}
	}
</script>
<script language="javascript" type="text/javascript"
	src="js/WdatePicker.js"></script>
</head>

<body>
		<jsp:include page="header.jsp"></jsp:include>
	<div class="banner" id="banner">
		<a href="#" class="d1"
			style="background: url(img/5.jpg) center no-repeat;"></a> <a href="#"
			class="d1" style="background: url(img/1.jpg) center no-repeat;"></a>
		<a href="#" class="d1"
			style="background: url(img/2.jpg) center no-repeat;"></a> <a href="#"
			class="d1" style="background: url(img/3.jpg) center no-repeat;"></a>
		<a href="#" class="d1"
			style="background: url(img/4.jpg) center no-repeat;"></a>

		<div class="d2" id="banner_id">
			<ul>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</div>

		<div class="banner_div new_importance_tab">

			<div class="banner_tab">
				<ul class="banner_tab_list">
					<li class="cur" id="one1" onclick="setTab('one',1,2)"><a
						href="javascript:;"><img src="img/1_03.png" /></a></li>
					<li id="one2" onclick="setTab('one',2,2)"><a
						href="javascript:;"><img src="img/1_04.png" /></a></li>
				</ul>
				<form action="goodsServlet" method="post">
				<div class="banner_tab_div list_one_1 list_one1">
				
					<!-- ---------------货源内容-------------------->
						<ul class="formcss">
							<li><label><span>*</span>出发城市</label><input type="text"
								 class="add_shipmentdz" 
								value="请输入出发城市" name="startcity"
								onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onBlur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: #999999" /><label></label> <label><span>*</span>到达城市</label>
								<input type="text"  class="get_shipmentdz" value="请输入到达城市" name="endcity"
								onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onBlur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: #999999" /></li>
							<li><label><span>*</span>收货电话</label><input type="text"
								 class="get_shipmentphone"  
								value="请输入收货电话"
								onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onBlur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: #999999" /><label></label> <label>发货电话</label><input
								type="text"  class="get_shipmentputphone"
								 value="请输入发货电话" name="phone"
								onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onBlur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: #999999" /></li>
							<li><label><span>*</span>发货时间</label><input name="starttime"
								onFocus="WdatePicker({isShowClear:false,readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-{%d}'})"
								id="runtime" class="Wdate add_input" value="2016-01-05 09:49:18"
								type="text" value="" /></li>
							<li><label><span>*</span>有效期</label><input name="runtime"
								onFocus="WdatePicker({isShowClear:false,readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-{%d}'})"
								id="runtime" class="Wdate add_input" value="2016-01-05 09:49:18"
								type="text" value="" /></li>
							<li><label><span>*</span>货物类型</label><input type="text"
								 class="get_shipmentmsg"
								value="请输入货物类型"   name="goodsort"
								onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onBlur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: #999999" /><label></label> <label>意愿价格</label><input
								type="text"  class="get_shipmentprice"
								 value="请输入意愿价格" name="price"
								 
								onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onBlur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: #999999" /></li>
								<li><input type="submit"   class="orange btnLogin" value="发布货源"></li>
						</ul>
					<div class="clear"></div>
				</div>
				</form>
				
				<div class="banner_tab_div banner_tab_cy list_one2"
					style="display: none;">
					<!-- ---------------车源内容---------------------- -->
					<ul><li><label></label></li></ul>
					<ul>
						<li><label><span>*</span>出发城市</label><input type="text"
								 class="add_cardz" 
								value="请输入出发城市"
								onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onBlur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: #999999" /><label></label><label><span>*</span>到达城市</label><input
								type="text" class="get_cardz"
								value="请输入到达城市"
								onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onBlur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: #999999" /></li>
						<li><label>车辆类型</label><input type="text"
								 class="add_carsort" 
								value="请输入车辆类型"
								onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onBlur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: #999999" /><label></label> <label>车辆长度</label><input
								type="text"  class="get_cardz"
								 value="请输入车辆长度"
								onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onBlur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: #999999" /></li>
						<li><label>重量/体积</label><input type="text"
								 class="add_carzl" 
								value="请输入吨数"
								onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onBlur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: #999999" /><label></label><input
								type="text"  class="get_cartj"
								 value="请输入立方数"
								onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onBlur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: #999999" /></li>
								<li><label><span>*</span>发车电话</label><input
								type="text"  class="get_carphone"
								 value="请输入发车电话"
								onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onBlur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: #999999" /></li>
								<li><label><span>*</span>发车时间</label><input name="runtime"
								onFocus="WdatePicker({isShowClear:false,readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-{%d}'})"
								id="runtime" class="Wdate add_input" value="2016-01-05 09:49:18"
								type="text" value="" /> </li>
								<li><a href="javascript:;"   class="orange btnLogin">发布车源</a></li>
					</ul>
					<div class="clear"></div>
				</div>

				<div class="clear"></div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		banner()
	</script>
	<!--轮播完-->


	<script type="text/javascript">
		var app_url = 'new_web/lib_function/';
		function setTab(name, cursel, n) {
			for (i = 1; i <= n; i++) {
				if (cursel == i) {
					$('#' + name + i).attr("class", "cur");

					$('.list_' + name + i).css("display", "block");
				} else {
					$('#' + name + i).attr("class", "");
					$('.list_' + name + i).css("display", "none");
				}
			}
		}
		function closex(id){//清空文本框的内容
		    $("#"+id).val('');
		    $("#"+id+"_x").hide();//隐藏X

		 }

	</script>
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>