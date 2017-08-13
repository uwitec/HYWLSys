<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="x-ua-compatible" content="ie=edge,chrome=1" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand" />
<meta name="360-site-verification" content="029735b839b7104f29e5e9550a456cbd" />
<meta name="keywords" content="wuliupingtai" />
<meta name="description" content="wuliupingtai" />
<title>sujie货源信息</title>
<link href="http://s.abwuliu.com/js/LocationRange.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/index1114.css" type="text/css" />
<link rel="stylesheet" href="css/index1028.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/keyboard.css" />
<script type="text/javascript" src="http://s.abwuliu.com/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../public/js/keyboard.js"></script>
<script language="javascript" type="text/javascript" src="public/js/DatePicker/WdatePicker.js"></script>
<style>
.error{ line-height:18px; padding-left:65px; color:#FF0000}
.header{ display:none;}
.select_list + .input_xl{ display:none}
.yz_ts{ display:none;}

#my_send_money,#qiandan,.head,#getmore_chaxun{display:none; }
#huo_detail,#my_send_money,#car_detail{z-index:10;}
#confirm{ z-index:30}
.xiangqing,.web_con,.dianzi{ z-index:990;}
#chengjiao_pay{ text-align:left; color:#333}
.billbtn_status_top{ color:#fff}
#chengjiao_pay,.pay{z-index:30;}
#hide_x{ padding-top:20px;}
.left_folat{ float:left; padding-left:20px;  display: block}
.d_car{ width:446px; height:100px; padding:18px;  }
.d_car_list{ width:390px;  padding-left:56px; background-color:#f0f9fe;  height:48px; line-height:48px; border-bottom:1px solid #fff;  font-size:15px; color:#1c1a1b; }
.d_car_list span{color:#fe0000;  } 

</style>


</head>
<body>
<div class="new_main">
<div id="my_popup_pass" class="my_popup_k" style=" display:none;position:fixed; padding-top:10%; z-index:100;">
       <div id="container"  class="my_popup">
       <span>请输入支付密码</span><a id="close_button" style="position: absolute; top: 10px; background: transparent none repeat scroll 0% 0%; width: 14px; right: 3px;" href="javascript:;"><img src="../public/images_index/1_16.png" /></a>

       <input type="password" id="write"><input type="button"id='pay_but' value="提交"><input type="button" style="background: transparent none repeat scroll 0% 0%; color:green;text-align:right;" id="forget_pass" value="忘记密码?">
        <ul id="keyboard">
            <li class="symbol"><span class="off">1</span></li>
            <li class="symbol"><span class="off">2</span></li>
            <li class="symbol"><span class="off">3</span></li>
            <li class="symbol"><span class="off">4</span></li>
            <li class="symbol"><span class="off">5</span></li>
            <li class="symbol"><span class="off">6</span></li>
            <li class="symbol"><span class="off">7</span></li>
            <li class="symbol"><span class="off">8</span></li>
            <li class="symbol"><span class="off">9</span></li>
            <li class="symbol zero"><span class="off">0</span></li>
            <li class="delete lastitem"><img src="../public/images_index/deletes.png"></li>
        </ul>
        <p class="null_button"></p>
        <div class="clear"></div>
   </div>
</div>

<div class="my_popup_k dianzi" style=" margin-top:-100px;display:none">
<div class="my_popup_dz" style="padding:15px 30px;">
                    <p class="popup_dz_p">货物运输合同书</p>
                    <ul class="popup_dz_list">
                        <li>到达日期：<span  class="dz_reach_date"></span></li>
                        <li class="popup_dz_ddh">运单号：<span  class="dz_billno"></span></li>
                    </ul>
                    <div class="clear"></div>
                    <div class="popup_dz_div">
                        <table cellpadding="0" cellspacing="0" border="0" width="100%">
                            <tr>
                                <td class="popup_dz_n">出发地址</td>
                                <td class="popup_dz_bz"><div  class="dz_start_addr left_folat"></div> <div class="left_folat dz_start_detailaddr"> </div></td>
                            </tr>
                            <tr>
                                <td class="popup_dz_n">到达地址</td>
                                <td class="popup_dz_bz"><div class="dz_end_addr left_folat"></div> <div class="dz_end_detailaddr left_folat"> </div></td>
                            </tr>
                            <tr>
                                <td class="popup_dz_n">托运人</td>
                                <td class="popup_dz_cf"><span class="dz_bill_name"></span></td>
                                <td class="popup_dz_n">联系电话</td>
                                <td class="popup_dz_x no"><span class="dz_bill_mobileno"></span></td>
                            </tr>
                            <tr>
                                <td class="popup_dz_n">承运人</td>
                                <td class="popup_dz_cf"><span class="dz_car_name"></span></td>
                                <td class="popup_dz_n">联系电话</td>
                                <td class="popup_dz_x no"><span class="dz_car_mobileno"></span></td>
                            </tr>
                            <tr>
                                <td class="popup_dz_n">收货人</td>
                                <td class="popup_dz_cf"><span class="dz_receiver_name"></span></td>
                                <td class="popup_dz_n">联系电话</td>
                                <td class="popup_dz_x no"><span class="dz_receiver_mobileno"></span></td>
                            </tr>
                            <tr>
                                <td class="popup_dz_n">货物描述</td>
                                <td class="popup_dz_bz"><span class="dz_goods_desc"></span></td>
                            </tr>

                            <tr>


                                <td class="popup_dz_n">货物重量</td>
                                <td class="popup_dz_hw dz_bill_weight"></td>
                                <td class="popup_dz_n">货物体积</td>
                                <td class="popup_dz_hw dz_bill_volume"></td>
                                <td class="popup_dz_n">包装</td>
                                <td class="popup_dz_hw dz_goods_detaildesc"></td>
                                <td class="popup_dz_n">参考报价</td>
                                <td class="popup_dz_hw no dz_pay_money"></td>
                            </tr>
                            <tr>
                                <td class="popup_dz_n">备注</td>
                                <td class="popup_dz_bz"></td>
                            </tr>
                            <tr>
                                <td class="popup_dz_xs">
                                    <b>双方协商最终运费金额</b>
                                    <p><span  class="dz_shipping_charge"></span><span  class="dz_shipping_charge_chi"></span></p>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <ul class="popup_dz_zj">
                                        <li class="zj_yd"><span>承运人已认证：</span><span class=" dz_alreadly_auth"></span></li>
                                        <li class="zj_yd"><span>承运人未认证：</span><span class=" dz_lack_str"></span></li>

                                    </ul>
                                   <!-- <a id="dz_ht" href="javascript:;" target="_blank">查看货物运输合同详情&gt;&gt;</a>-->
                                </td>
                            </tr>
                        </table>

                    </div>
                    <div class="popup_zfxy_div"><!--<label><input type="checkbox"  />我已确定订单信息无误并同意合同内容</label>--><input type="button"  class="colse" id="return_re" value="重新填写" /><input type="button" class="my_popup_q" id="return_tu"  value="确定" /></div>
                </div>
 </div>


<div class="my_popup_k xiangqing" style="display:none">
<div class="my_popup_dz my_popup_tx">
                    <div class="popup_dz_div">
                        <p class="popup_dz_p">请完善货物信息</p>
                        <ul class="popup_dz_ul">
                            <li>
                                <p class="popup_dz_top"><label>出发地址：</label><span class="start_addr"></span></p><input type="text" class="popup_dz_xx" value="" id="start_detailaddr" placeholder="详细地址" /><div class="clear"></div>
                            </li>
                            <li>
                                <p class="popup_dz_top"><label>到达地址：</label><span  class="end_addr"></span></p><input type="text" class="popup_dz_xx"  id="end_detailaddr" value="" placeholder="详细地址" /><div class="clear"></div>
                            </li>
                            <li>
                                <p class="popup_dz_top"><label>货物描述：</label><span class="goods_desc"></span></p><div class="clear"></div>
                            </li>
                            <li>
                                <label>包装：</label><input type="text"  id="goods_detaildesc" style="float:left;margin:0"  class="popup_dz_xx" value="" placeholder="建议填写货物包装详情" /><div class="clear"></div>
                            </li>
                            <li>
                            	<label><b>&lowast;</b>收货人：</label><input type="text" id="receiver_name" class="popup_dz_name" value="" placeholder="收货人姓名" /><label><b>&lowast;</b>联系电话：</label><input type="text" class="popup_dz_name no" id="receiver_mobileno" value="" placeholder="收货人手机号" /><div class="clear"></div>
                            </li>
                            <li>
                            	<label><b>&lowast;</b>到达日期：</label><input type="text" onFocus="WdatePicker({minDate:'%y-%M-{%d}'})" onkeydown="return false;" id="reach_date" class="Wdate xyin_s popup_dz_date"   value=""/>
                                <label><b>&lowast;</b>实际运费：</label><input type="text"  id="shipping_charge" class="popup_dz_money" value="" placeholder="双方协商实际运费"/>元<div class="clear"></div> <input type="hidden" id="billno_edit" value=""  />
                                <div class="clear"></div>
                            </li>
                            <li>

                        <input type="hidden" id="car_userid_edit" value=""  />
                        <input type="hidden" id="electronic_bill_id" value=""  />
                            </li>
                        </ul>
                        <div class="popup_zfxy_div"><p style=" color:#ff0000; padding-left:40px; float:left; font-size:16px; line-height:30px;" class="dz_erro"></p><input type="button" class="colse" id="billno_false" value="取消" /><input id="bill_edit"  type="button" class="my_popup_q" value="下一步" /></div>
                    </div>
  </div>
</div>
 <div class="my_popup_k pay" style="display:none">
    <!--支付-->
    <div class="handle_popoup" style="margin-left:-239px;">
        <div class="my_popup_zf handle_popoup_div">
            <div class="my_order_p handle_popoup_tit">
                支付
                <a href="javascript:;" id="hide_x"><img src="../public/images_index/1_54.png" /></a>
                <div class="clear"></div>
            </div>
            <p class="binding_tit">注：支付金额为扣税后的实际金额</p>
            <div class="my_account_div balanceCash">
            <form>
                <ul>
                    <li><label>收款人姓名：</label><a id="car_username"></a></li>
                    <li><label>收款人账号：</label><a id="caruser_mobileno"></a></li>
                    <input id="car_billno" name="car_billno" type="hidden" value="" />
                    <input id="car_userid" name="car_userid" type="hidden" value="" />
                    <li><label><span>*</span>运费金额：</label><input type="text" class="NumDecText" onkeyup="value=value.replace(/[^\d.]/g,'')" id="amount" name="amount" value="" /><span>元</span></li>
                    <li class="no"><p id='error_pic_money'></p><input type="button" class="pay_but" id='pass_word' value="提交"  /></li>
                </ul>
            </form>
            </div>
        </div>
    </div>
    
</div>
  <div class="my_popup_k" id="zfxy" style=" display:none">
   <div class="my_popup_zf" style="padding-top:25px;">


                    <iframe src="http://www.abwuliu.com/webApp/agreement/pay.html"  border="0" width="100%"; height="350px"></iframe>

                <p class="popup_zfxy_p"><label><input type="checkbox" name="tongyi" class="tongyi"  />下次不再提示</label></p>
                <p class="text-left fankui" style=" display:none; color:#FF0000"></p>
                <div class="popup_zfxy_div"><input type="button" class='colse' style='width:170px;' value="取消" /><input style='width:170px; padding-left:25px' type="button"  class="protocol_but my_popup_q" value="我已阅读并同意" /></div>
            </div>
  </div>
   <div id="confirm" class="my_popup_k"  style="display:none">
        <div class="my_popup">
         <p class="my_popup_t" id="chengjiao_xx"></p>
        <input type="button" class="my_popup_q colse" value="确定" />
        </div>
        </div>
   <div id="confirm_zf" class="my_popup_k"  style="z-index:30;display:none">
    <div class="my_popup">
        <p class="my_popup_t" id="chengjiao_zf"></p>
    <a href="#" class="my_popup_q" target="_blank" style=" background-color:#05ad52; color:#fff" id="chengjiao_zf_msg"/>确定</a>  <a href="#" class="colse" />取消</a>
    </div>
    </div>

    <div id="web_con" class="my_popup_k" style="display:none">
        <div class="my_popup">
            <p class="my_popup_t" id="chengjiao_msg"></p>
        <a href="#" class="colse" />取消</a>  <a href="#" class="my_popup_q colse" style=" background-color:#05ad52; color:#fff" id="chengjiao"/>确定</a>
        </div>
        </div>


                <!--提醒-->
                <div id="billno_del" class="handle_popoup" style="margin-left:-128px;margin-top:-190px;display:none">
                    <div class="handle_popoup_div my_popup_txs">
                        <div class="my_order_p handle_popoup_tit">
                            提醒
                            <a href="javascript:;"  onclick="billno_del_cancel()"><img src="/public/images_index/1_54.png" /></a>
                            <div class="clear"></div>
                        </div>
                        <p class="qxdd_tit" id="billno_del_msg"> </p>
                        <p class="home_prompt_button"><a href="javascript:;" id="billno_del_but" class="my_popup_q">是</a>
                        <a href="javascript:;" onclick="billno_del_cancel()">否</a></p>
                    </div>
                </div>
                <!--提醒-->

<!--确定支付-->
       <div id="ture_pay" class="my_popup_k" style="display:none">
        <div class="my_popup">
            <div class="my_popup_t" id="chengjiao_pay"></div>
        <input type="button" class="colse" value="取消" /><input id="pass_word_pay" type="button" class="my_popup_q" value="确定" />
        </div>
        </div>
  <!--保错-->
    <div class="handle_popoup" id="huo_detail" style="display:none">
                    	<div class="handle_popoup_div">
                        	<div class="handle_popoup_tit">
                                运单号：<span class="d_billno"></span> <!-- 【<span class="billbtn_status_top"></span>】-->
                                <a href="javascript:;" class="huo_detail"><img src="public/images_index/1_54.png" /></a>
                                <div class="clear"></div>
                            </div>
                            <div class="handle_popoup_bottom">
                            	<div class="handle_popoup_left">
                                	<ul class="handle_left_address">
                                    	<li>
                           					<span>起：</span><b class="d_beginunit"></b>
                                            <p class="d_get_addr"></p>
                                        </li>
                                        <li>
                           					<span>终：</span><b  class="d_endunit"></b>
                                            <p class="d_put_addr"></p>
                                        </li>
                                    </ul>
                                	<ul class="handle_popoup_h handle_left_list">
                                    	<li><span>里&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;程：</span>约<span class="d_transport_course"></span>公里</li>
                                        <li><span>货物详情：</span><leb class="d_goodstype"></leb></li>
                                        <li><span>车辆需求：</span><leb class="d_cartype"></leb></li>
                                        <li><span>意向价格：</span><leb class="d_carriage"></leb></li>
                                        <li><span>收货电话：</span><leb class="d_endmobile"></leb></li>
                                        <li><span>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</span><leb class="d_remark"></leb></li>
                                    </ul>
                                    <ul class="handle_left_time">
                                    	<li>发布时间：<span class="d_pubtime"></span></li>
                                        <li class="electronic_bill_id"></li>
                                        <li class="bill_dynamic"></li>
                                        
                                        
                                    </ul>
                                    <div class="bxfh billno_del"></div>
                                </div>
                                <div class="handle_popoup_right">
                                	<div class="handle_popoup_h handle_right_tit">
                                    	<ul>
                                        	<li>接单人信息(<span class="d_count_car_persons"></span>人)</li>
                                            <li>参考报价<!--<span class="d_carriage"></span>--> </li>
                                            <li class="billbtn_status_wz">&nbsp;</li>
                                        </ul>
                                        <div class="clear"></div>
                                    </div>

                                	<div class="handle_right_div">
                                      <div class="d_arr"></div>

                                          <div class="handle_right_bottom tjpj" style=" display:none">
                                        	<div class="handle_evaluation">
                                            	<div class="handle_evaluation_tit">
                                                <input type="radio" id="assessment1" name='assessment' value="1"  checked/> <!--class="mobile-ui-form mobile-ui-h"-->
                                                <label for="a">好评</label>
                                                <input type="radio" type="radio" id="assessment2" name='assessment' value="0" />
                                                <label for="b">差评</label>
                                                </div>
                                                <div class="pjbc"></div>
                                                <input name='billno' class='billno_val' value='' type='hidden' /><input name='roles' class='roles' value='bill' type='hidden' />
                                            	<textarea name='content' class='content popup_pl_textarea' placeholder="请填写评价"></textarea>
                                                <a href="javascript:;" id='tjpj' class="handle_right_a">评价</a>
                                                </div>
                                        </div>
                                        <div class="assessment" style=" display:none"></div>
                                        <!--结束-->
                                    </div>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>
                    </div>

           

 <!--我发的货-->
     <div class="handle_popoup" id="car_detail" style="display:none">
                    	<div class="handle_popoup_div">
                        	<div class="handle_popoup_tit">
                                运单号：<span class="d_billno"></span>【<span class="billbtn_status_top"></span>】
                                <a href="javascript:;" class="car_detail"><img src="public/images_index/1_54.png" /></a>
                                <div class="clear"></div>
                            </div>
                            <div class="handle_popoup_bottom">
                            	<div class="handle_popoup_left">
                                <div class="handle_left_div d_huo_face">

                                </div>


                                	<ul class="handle_left_address">
                                    	<li>
                           					<span>起：</span><b class="d_beginunit"></b>
                                            <p class="d_get_addr"></p>
                                        </li>
                                        <li>
                           					<span>终：</span><b  class="d_endunit"></b>
                                            <p class="d_put_addr"></p>
                                        </li>
                                    </ul>
                                	<ul class="handle_popoup_h handle_left_list">
                                    	<li><span>里&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;程：</span>约<span class="d_transport_course"></span>公里</li>
                                        <li><span>货物详情：</span><leb class="d_goodstype"></leb></li>
                                        <li><span>车辆需求：</span> <leb class="d_cartype">  </leb></li>
                                        <li><span>意向价格：</span><leb class="d_carriage"></leb></li>
                                        <li><span>收货电话：</span><leb class="d_endmobile"></leb></li>
                                        <li><span>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</span><leb class="d_remark"></leb></li>
                                    </ul>
                                    <ul class="handle_left_time">
                                    	<li>发布时间：<span class="d_pubtime"></span></li>
                                        <li class="electronic_bill_id"></li>
                                        <li class="bill_dynamic"></li>



                                    </ul>
                                </div>
                                <div class="handle_popoup_right">
                                <div class="d_car">
                                 <div class="d_car_money d_car_list"></div>

                                     <div class="d_shipping_charge"></div>  
                                     </div>
                                    <div class="handle_right_div">
                                     <div class="d_arr"></div>
                                      <div class="handle_right_bottom car_tjpj" style=" display:none">
                                        	<div class="handle_evaluation">
                                            	<div class="handle_evaluation_tit">
                                                <input type="radio" id="car_assessment1" name='car_assessment' value="1" checked/>
                                                <label for="a">好评</label>
                                                <input type="radio" type="radio" id="car_assessment2" name='car_assessment' value="0" />
                                                <label for="b">差评</label>
                                                </div>
                                                <div class="car_pjbc"></div>
                                                <input name='car_billno' class='car_billno_val' value='' type='hidden' /><input name='car_roles' class='car_roles' value='car' type='hidden' />
                                            	<textarea name='car_content' class='car_content popup_pl_textarea' placeholder="请填写评价"></textarea>
                                                <a href="javascript:;" id='car_tjpj' class="handle_right_a">评价</a>
                                                </div>
                                        </div>
                                        <div class="car_assessment" style=" display:none">
                                            
                                        </div>

                                    </div>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>
                    </div>
<!--我发的货-->
     <div class="handle_popoup" id="my_send_money" style="display:none">
                    	<div class="handle_popoup_div">
                        	<div class="handle_popoup_tit">
                                运单号：<span class="d_billno"></span>
                                <a href="javascript:;" class="my_send_money"><img src="public/images_index/1_54.png" /></a>
                                <div class="clear"></div>
                            </div>
                            <div class="handle_popoup_bottom">
                            	<div class="handle_popoup_left">
                                <div class="handle_left_div d_huo_face">
                                </div>
                                	<ul class="handle_left_address">
                                    	<li>
                           					<span>起：</span><b class="d_beginunit"></b>
                                            <p class="d_get_addr"></p>
                                        </li>
                                        <li>
                           					<span>终：</span><b  class="d_endunit"></b>
                                            <p class="d_put_addr"></p>
                                        </li>
                                    </ul>
                                	<ul class="handle_popoup_h handle_left_list">
                                    	<li><span>里&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;程：</span>约<span class="d_transport_course"></span>公里</li>
                                        <li><span>货物详情：</span><leb class="d_goodstype"></leb></li>
                                        <li><span>车辆需求：</span> <leb class="d_cartype">  </leb></li>
                                        <li><span>意向价格：</span><leb class="d_carriage"></leb></li>
                                        <li><span>收货电话：</span><leb class="d_endmobile"></leb></li>
                                        <li><span>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</span><leb class="d_remark"></leb></li>
                                    </ul>
                                    <ul class="handle_left_time">
                                    	<li>发布时间：<span class="d_pubtime"></span></li>
                                        <li class="electronic_bill_id"></li>
                                        <li class="bill_dynamic"></li>
                                    </ul>
                                </div>
                                <div class="handle_popoup_right">

                                  <div class="qian_error"></div>

                                    <div class="handle_right_div" id="jd" >
                                        <div class="handle_right_bottom">
                                        	<ul class="remind_ul">
                                            	<li>提醒：如对方索要取信息费，请谨慎交易！</li>
                                                <li>须知：请检查发货人认证信息的完整性！</li>
                                            </ul>
                                            <ul class="authentication_ul">
                                            	<li><img src="public/images_index/1_55.jpg" /><span id="have_paper"></span></li>
                                                <li><img src="public/images_index/1_56.jpg" /><span id="nohave_paper"></span></li>
                                            </ul>


                                            <ul class="handle_right_input">
                                            	<li><label>报价：</label><input type="text" id="send_money" onkeyup="value=value.replace(/[^\d.]/g,'')" value="" placeholder="请输入报价" />元</li>
                                                <div style="padding-left:150px;color:#ec791e;position:relative;top:10px;"><span id='error_pic_money'></span></div>
                                                <li id="have_input"><input  type="button" value="提交" /></li>
                                            </ul>
                                        </div>
                                    </div>


                                       <div id="jdcg" >
                                       </div>

                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>
                    </div>

 
</div>    	<!--头部-->
        <div class="new_header">
            <div class="new_header_div">
            	<a href="/" class="logo_img"><img src="public/images_index/1_01.png" /></a>

                               <ul class="header_ul"  style=" position:relative">
                      <li   class=""><a href="homepage.html">首页</a></li>
                    <li class="select_head"><a href="summary.html" >公司简介</a></li>
                    <li class="select_head"><a href="apply_new.html" >招贤纳士</a></li>
                    <li ><a href="industrynew.html" onclick="collect_msg('行业新闻');">行业新闻</a></li>
                    <li class="select_head"><a href="companynew.html" onclick="collect_msg('公司新闻');">公司新闻</a></li>
                    <li class="select_head"><a  href="apply.html" onclick="collect_msg('供求信息');">供求信息</a></li>
                    <li class="new_cur select_head"><a href="/personal_center/index.html" onclick="collect_msg('会员中心');">会员中心</a>
                    <p class="header_ul_bottom" style="display:none;">
                        <a href="/personal_center/index.html?bill=3">个人信息</a>
                        <a href="/personal_center/index.html?bill=5">发布货源</a>
                        <a href="/personal_center/index.html?bill=5">货源信息</a>
                        <a href="/personal_center/index.html?bill=5">车源信息</a>
                        <a href="/personal_center/index.html?bill=4">意见反馈</a>
                        <a href="/personal_center/index.html?bill=5">积分商城</a>
                        <a href="/personal_center/index.html?bill=5">订单管理</a>
                    </p>
                    </li>

                    <p class="header_ul_bottom" style="display:none;">
                        <i></i>
                        <a href="/personal_center/index.html?bill=1">信誉认证</a>
                        <a href="/personal_center/index.html?bill=2">绑定银行卡</a>
                        <a href="/personal_center/index.html?bill=3">资金账户</a>
                        <a href="/personal_center/index.html?bill=4">个人资料</a>
                        <a href="/personal_center/index.html?bill=5">合同查询</a>
                    </p>
                    </li>


                </ul>
              <span class="mobileno">              <a class='a_login' href='/personal_center/'>用户名</a><a class='a_login' href='/logout'>退出</a>
			    </span>
                <img src="public/images_index/1_02.png" />
                <div class="clear"></div>
            </div>
        </div>

        <!--头部-->
<div class="nav">
<div class="tab_list">
<ul>
<li  id="huo1"  onclick="setTab2('huo',1,3)" class="cur"><a href="javascript:;">货源列表</a></li>
<li  id="huo2"  onclick="setTab2('huo',2,3)"><a href="javascript:;">我发的货</a></li>
<li  id="huo3"  onclick="setTab2('huo',3,3)"><a href="javascript:;">我接的单</a></li>
</ul>
</div>



            <!--1-->
            <div class="hy_list  list_huo1">
             <div class="list_tit tab_list_tit">
                <div class="list_tit_div">
                <lab class="area-wraper" style="position:relative;float:left;">
                    <input type="text" value="" id="search_begincity" readonly="readonly" onclick="onchange_input('search_begincity_x')" placeholder="选择出发地" onkeydown="return false;"/><div style="display: none;" class="area-select area-tab"></div>
                    <a href="javascript:;" class="ch" id="search_begincity_x" style="display:none" onclick="closex('search_begincity')"><img src="public/images_index/iconfont-close.png" /></a>
                    </lab>
                    <img src="images/sjt.png" onclick="left_right()"/>
                   <lab class="area-wraper" style="position:relative;float:left;"> <input type="text" readonly="readonly" value="" id="search_endcity" placeholder="选择目的地" onclick="onchange_input('search_endcity_x')" onkeydown="return false;"/><div style="display: none;" class="area-select area-tab"></div>
                   <a href="javascript:;" class="ch" onclick="closex('search_endcity')" id="search_endcity_x" style="display:none"><img src="public/images_index/iconfont-close.png" /></a>
                   </lab>

                    <input  type="hidden" id="type" name="type"   value="8" placeholder="" />
                    <a href="javascript:;" class="orange chaxun"><img src="images/ss.png" /><span>搜索</span></a>
                    <a href="javascript:;" id="huo_1" class="refresh"><img src="images/shx.png" /><span>刷新列表</span></a>

                </div>
                <div class="clear"></div>

            </div>



            <div class="home_list">
                <div class="home_list_top">
                    <ul>
                        <li  class="cyxx_list_khxx">货主信息</li>
                        <li class="cyxx_list_cfd">出发地</li>
                        <li class="cyxx_list_mdd">目的地</li>
                        <li class="cyxx_list_hwms">货物描述</li>
                        <li class="cyxx_list_fbsj">发布时间</li>
                        <li class="cyxx_list_cz">操作</li>
                    </ul>
                    <div class="clear"></div>
                </div>
                <div id="demo1"></div>
                <div class="hy_list_p" id="getmore1"><a href="javascript:;">查看更多</a></div>
                <div class="hy_list_p" id="getmore_chaxun"><a href="javascript:;">查看更多</a></div>
                </div>
            </div>
            <!--2-->
              <div class="hy_list  list_huo2"  style="display:none;">
               <div class="procedure">
            	<div class="procedure_div">
                	<p>
                    	<span>发货</span>
                        <span>确认合同/确认成交</span>
                        <span>确认收货</span>
                        <span>支付运费</span>
                        <span>评价/完成交易</span>
                    </p>
                </div>
            </div>

            <div class="home_list">


                <div class="home_list_top">
                    <ul>
                        <li class="wfdh_list_ydh">运单号</li>
                        <li class="wfdh_list_cfd">出发地</li>
                        <li class="wfdh_list_mdd">目的地</li>
                        <li  class="wfdh_list_hwms">货物描述</li>
                        <li class="wfdh_list_fbsj">发布时间</li>
                        <li  class="wfdh_list_zt">状态</li>
                        <li class="wfdh_list_cz">操作</li>
                    </ul>
                    <div class="clear"></div>
                </div>
                
                <div id="demo2"></div>
                 <div class="hy_list_p" id="getmore2"><a href="javascript:;">查看更多</a></div>

                </div>
            </div>
            <!--3-->
              <div class="hy_list  list_huo3" style="display:none;">
              <div class="procedure">
            	<div class="procedure_div">
                	<p>
                    	<span>接单</span>
                        <span>确认合同/开始运输</span>
                        <span>评价/完成交易</span>
                    </p>
                </div>
            </div>
            <div class="home_list">
                <div class="home_list_top">
                    <ul>
                        <li  class="wjdd_list_khxx">货主信息</li>
                        <li class="wjdd_list_cfd">出发地</li>
                        <li  class="wjdd_list_mdd">目的地</li>
                        <li  class="wjdd_list_hwms">货物描述</li>
                        <li class="wjdd_list_fbsj">发布时间</li>
                        <li class="wjdd_list_fbsj">状态</li>
                        <li class="wjdd_list_zt">操作</li>
                    </ul>
                    <div class="clear"></div>
                </div>
                <div id="demo3"></div>
<div class="hy_list_p" id="getmore3"><a href="javascript:;">查看更多</a></div>
                </div>
            </div>
            <!--4-->
            </div>
        </div>

    </div>
</body>
</html>
