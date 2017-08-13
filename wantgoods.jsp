<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Want Car Page</title>
<link href="css/before_login.css" rel="stylesheet" type="text/css">
<link href="css/LocationRange.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/index1114.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script language="javascript" type="text/javascript"
	src="js/DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
///搜索功能
			function sousuo(){
			
			   $.ajax({url:"goodsServlet",
			   data:"startcity="+$("#search_begincity").val()+"&endcity="+$("#search_endcity").val()+"&flag=sousuo",
			   type:"post",
			   dataType:"json",
			   success:function(data){
			    var list=eval(data);//eval()将字符串解析为js代码
			     $("#firstdiv").nextAll().remove();//删除所有同级元素
			    $(list).each(function(i){//循环
			
			       var subdiv="<div class='home_list_top'> <ul>";
			       subdiv+="<li class='cyxx_list_khxx'>"+list[i].name.sphone+"</li>";
			       subdiv+="<li class='cyxx_list_cfd'>"+list[i].name.sgoodstart+"</li>";
			       subdiv+="<li class='cyxx_list_mdd'>"+list[i].name.sgoodend+"</li>";
			       subdiv+="<li class='cyxx_list_hwms'>"+list[i].name.sgoodsort+"</li>";
			       subdiv+="<li class='cyxx_list_fbsj'>"+list[i].name.sgood_time+"</li>";
			       subdiv+="<li class='cyxx_list_cz'><a href='javascript:;' onclick='detail('"+list[i].name.sgoodid+"')'>查看</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:;' onclick='order('"+list[i].name.sgoodid+"','"+${list[i].name.sphone}+"')'>交易</a></li></ul></div>";
			       $("#parentdiv").append(subdiv);
			       
			   });
			   }
			   });
			}
			
			
///刷新功能

             function shuaxin(){
			
			   $.ajax({url:"goodsServlet",
			   data:"flag=shuaxin",
			   type:"post",
			   dataType:"json",
			   success:function(data){
			    var list=eval(data);//eval()将字符串解析为js代码
			     $("#firstdiv").nextAll().remove();//删除所有同级元素
			    $(list).each(function(i){//循环
			
			       var subdiv="<div class='home_list_top'> <ul>";
			       subdiv+="<li class='cyxx_list_khxx'>"+list[i].name.sphone+"</li>";
			       subdiv+="<li class='cyxx_list_cfd'>"+list[i].name.sgoodstart+"</li>";
			       subdiv+="<li class='cyxx_list_mdd'>"+list[i].name.sgoodend+"</li>";
			       subdiv+="<li class='cyxx_list_hwms'>"+list[i].name.sgoodsort+"</li>";
			       subdiv+="<li class='cyxx_list_fbsj'>"+list[i].name.sgood_time+"</li>";
			       subdiv+="<li class='cyxx_list_cz'><a href='javascript:;'onclick='detail()'>查看</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:;' onclick='order()'>交易</a></li></ul></div>";
			       $("#parentdiv").append(subdiv);
			       
			   });
			   }
			   });
			}
			

  
	function  detail(id){
	  //alert(id);
	  var url="goodsServlet?goodid="+id+"&flag=detail";
	  window.location.href=url;
	
	}		
	
	
	function order(phone,id){
	  var url="orderServlet?shipper="+phone+"&orderid="+id+"&flag=order";
	  window.location.href=url;
	
	}
</script>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div>
			<img src="img/bj_06.png" width="100%" height="300">
		</div>
	<div class="tab_list" >
		
		<ul>
			<li id="huo1" onclick="setTab2('huo',1,3)" class="cur"><a
				href="javascript:;">货源列表</a></li>
		</ul>
	</div>
	<div class="hy_list  list_huo1">
		<div class="list_tit tab_list_tit">
			<div class="list_tit_div">

				<input type="text" id="search_begincity" style="height:30px"
					value="选择出发地" name="startaddress"
								onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onBlur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: #999999"/>
				<div style="display: none;" class="area-select area-tab"></div>
				<a href="javascript:;" class="ch" id="search_begincity_x"
					style="display: none" onclick="closex('search_begincity')"><img
					src="img/iconfont-close.png" /></a> <img
					src="img/1_06.png" onclick="left_right()" /> 
				<input type="text" style="height:30px" 
					 id="search_endcity" value="选择目的地" name="endaddress"
								onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
								onBlur="if(!value){value=defaultValue;this.style.color='#999'}"
								style="color: #999999"/>
				<div style="display: none;" class="area-select area-tab"></div>
				<a href="javascript:;" class="ch" onclick="closex('search_endcity')"
					id="search_endcity_x" style="display: none"><img
					src="img/iconfont-close.png" /></a>
			   <input type="hidden" id="type"
					name="type" value="8" />
			 <a href="javascript:;" class="orange chaxun" 
			 onclick="sousuo()"><img src="img/1_07.png" /><span>搜索</span></a>
			 <a href="javascript:;" id="huo_1" class="refresh" onclick="shuaxin()"><img
					src="img/1_08.png"  /><span>刷新列表</span></a>

			</div>
			
		</div>



		<div class="home_list" id="parentdiv">
			<div class="home_list_top" id="firstdiv">
				<ul>
					<li class="cyxx_list_khxx">货主信息</li>
					<li class="cyxx_list_cfd">出发地</li>
					<li class="cyxx_list_mdd">目的地</li>
					<li class="cyxx_list_hwms">货物类型</li>
					<li class="cyxx_list_fbsj">发布时间</li>
					<li class="cyxx_list_cz">操作</li>
				</ul>
			</div>
			<c:set var="list1" value="${requestScope.goodslist }"/>
				
            <c:forEach  var="item" items="${list1 }">
			<div class="home_list_top" id="topdiv">
				<ul>
					<li class="cyxx_list_khxx">${item.sphone }</li>
					<li class="cyxx_list_cfd">${item.sgoodstart }</li>
					<li class="cyxx_list_mdd">${item.sgoodend }</li>
					<li class="cyxx_list_hwms">${item.sgoodsort }</li>
					<li class="cyxx_list_fbsj">${item.sgood_time }</li>
					<li class="cyxx_list_cz"><a href="javascript:;" onclick="detail(${item.sgoodid})">查看</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript:;" onclick="order(${item.sphone },${item.sgoodid})">交易</a></li>
				</ul>
			</div>
			</c:forEach>
			<div id="demo1"></div>
			
		</div>
		
	</div>
	
	<script type="text/javascript">
		var app_url = '/new_web/lib_function/';
		var app_urls = '/personal_center/lib_function/';
		function login() {
			$('.head').toggle();
		}
		function closex(id) {//清空文本框的内容
			$("#" + id).val('');
			$("#" + id + "_x").hide();//隐藏X

		}
		function collect_msg(pagenames) {//收
			$.ajax({
				type : 'POST',
				cache : false,
				dataType : 'text',
				url : app_url + "conduct_data_web.php",
				data : "test_key=233&pagename=" + pagenames,
				success : function() {
				}
			});
		}
		$('.chaxun')
				.click(
						function() {
							collect_msg('货源信息-货源列表-搜索');
							var search_begincity = $('#search_begincity').val();
							var search_endcity = $('#search_endcity').val();
							chaxun = 0;
							if (search_begincity.length <= 0
									&& search_endcity.length <= 0) {
								$('#demo1')
										.show()
										.html(
												"<div style='font-size:12px; color:#ff0000; line-height:24px; padding-left:20px;'>请输入出发城市或到达城市！</div>");
								return false;
							}
							var type = $('#type').val();
							$.post(app_url + "getgoodslist.php", {
								num : 0,
								type : type,
								search_begincity : search_begincity,
								search_endcity : search_endcity
							}, function(data) {
								if (data.resid == 3) {
									$('#demo1').html(data.msg);
									$('#getmore1').hide();
									$('#getmore_chaxun').show();
									$('.home_list_bottom:odd').css(
											'background', '#f6f6f6');
								} else {
									$('.head').show();
								}
							}, 'json');
						});

		$('#getmore_chaxun')
				.click(
						function() {
							var search_begincity = $('#search_begincity').val();
							var search_endcity = $('#search_endcity').val();
							chaxun += 1;
							if (search_begincity.length <= 0
									&& search_endcity.length <= 0) {
								$('#demo1')
										.show()
										.html(
												"<div style='font-size:12px; color:#ff0000; line-height:24px; padding-left:20px;'>请输入出发城市或到达城市！</div>");
								return false;
							}
							var type = $('#type').val();
							$.post(app_url + "getgoodslist.php", {
								num : chaxun,
								type : type,
								search_begincity : search_begincity,
								search_endcity : search_endcity
							}, function(data) {
								if (data.resid) {
									if (data.msg == "") {
										$('#getmore_chaxun').html("没有更多了");
									} else {
										$('#demo1').append(data.msg);
										$('.home_list_bottom:odd').css(
												'background', '#f6f6f6');
									}
								}
							}, 'json');
						});

		$('#huo1,#huo_1').click(function() {
			offnum = 0;
			var search_begincity = $('#search_begincity').val();
			var search_endcity = $('#search_endcity').val();
			$.post(app_url + "getgoodslist.php", {
				num : 0,
				type : 8,
				search_begincity : search_begincity,
				search_endcity : search_endcity
			}, function(data) {
				if (data.resid) {
					$('#demo1').html(data.msg);
					$('.home_list_bottom:odd').css('background', '#f6f6f6');
				}
			}, 'json');
			$('#getmore1').show().html('<a href="javascript:;">查看更多</a>');
			$('#getmore_chaxun').hide();
			//$('#search_begincity').val('');
			//$('#search_endcity').val('');
		});

		$('#getmore1').click(function() {
			collect_msg('货源信息-货源列表-查看更多');
			var mobileno = '';
			if (!mobileno) {//没登陆弹出登陆框
				$(".head").show();
				return false;
			}
			offnum += 1;
			var search_begincity = $("#search_begincity").val();
			var search_endcity = $("#search_endcity").val();
			$.post(app_url + "getgoodslist.php", {
				num : offnum,
				type : 8,
				search_begincity : search_begincity,
				search_endcity : search_endcity
			}, function(data) {
				if (data.msg == "") {
					$('#getmore1').html("没有更多了");
				} else {
					$('#demo1').append(data.msg);
					$('.home_list_bottom:odd').css('background', '#f6f6f6');
				}
			}, 'json');
		});

		$('#huo2').click(
				function() {
					num = 0;
					$.post(app_url + "web_getgoodslist.php", {
						num : 0,
						type : 1
					}, function(data) {
						if (data.resid == 5) {
							$('.head').show();
						} else {

							$('#demo2').html(data.msg);
							$('.home_list_bottom:odd').css('background',
									'#f6f6f6');
							$('#getmore2').show().html(
									'<a href="javascript:;">查看更多</a>');
						}
					}, 'json');

				});
	</script>
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>