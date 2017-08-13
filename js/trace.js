;(function(){
	"use strict";
	window.zz_trace={
			protocol:'http://',
			analyze:document.createElement('iframe'),
			baseURL:(('https:' === document.location.protocol)?'https://ssl.':'http://')+"trace.zhiziyun.com/cm.do?siteid=" + _zzsiteid,
			fail:function(){
				zz_trace.analyze.src="";
			},
			quote:function(string){
				zz_trace.escapable.lastIndex = 0;
				return zz_trace.escapable.test(string) ? '"' + string.replace(zz_trace.escapable, function (a) {
					var c = zz_trace.meta[a];
					return typeof c === 'string'? c: '\\u' + ('0000' + a.charCodeAt(0).toString(16)).slice(-4);
				}) + '"' : '"' + string + '"';
			},
			escapable:/[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,
			meta :{'\b': '\\b','\t': '\\t','\n': '\\n','\f': '\\f','\r': '\\r','"' : '\\"','\\': '\\\\'},
			gap:"",
			str:function(key, holder){
				var i,k,v,length,mind = this.gap,partial,value = holder[key];
				if (value && typeof value === 'object' &&
						typeof value.toJSON === 'function') {
					value = value.toJSON(key);
				}
				if (typeof this.rep === 'function') {
					value = this.rep.call(holder, key, value);
				}
				switch (typeof value) {
				case 'string':
					return this.quote(value);

				case 'number':
					return isFinite(value) ? String(value) : 'null';

				case 'boolean':
				case 'null':

					return String(value);
				case 'object':
					if (!value) {
						return 'null';
					}
					this.gap += this.indent;
					partial = [];

					if (Object.prototype.toString.apply(value) === '[object Array]') {

						length = value.length;
						for (i = 0; i < length; i += 1) {
							partial[i] = this.str(i, value) || 'null';
						}
						v = partial.length === 0? '[]': this.gap? '[\n' + this.gap + partial.join(',\n' + this.gap) + '\n' + mind + ']': '[' + partial.join(',') + ']';
						this.gap = mind;
						return v;
					}

					if (this.rep && typeof this.rep === 'object') {
						length = this.rep.length;
						for (i = 0; i < length; i += 1) {
							if (typeof this.rep[i] === 'string') {
								k = this.rep.rep[i];
								v = this.str(k, value);
								if (v) {
									partial.push(this.quote(k) + (this.gap ? ': ' : ':') + v);
								}
							}
						}
					} else {
						for (k in value) {
							if (Object.prototype.hasOwnProperty.call(value, k)) {
								v = this.str(k, value);
								if (v) {
									partial.push(this.quote(k) + (this.gap ? ': ' : ':') + v);
								}
							}
						}
					}
					v = partial.length === 0? '{}': this.gap? '{\n' + this.gap + partial.join(',\n' + this.gap) + '\n' + mind + '}': '{' + partial.join(',') + '}';
					this.gap = mind;
					return v;
				}
			},
			getTrace:function(data){
				this.process(this.protocol+"trace.zhiziyun.com/contentinfo?method=update&value="+this.base64Encode(encodeURIComponent(this.JSONtoString(data))),true);
			},
			getOrderExt:function(_zzOrderExt,_zzOrderId){
				if(typeof(_zzOrderId)=="undefined") var _zzOrderId=Math.random();
				if(typeof(_zzOrderExt)=="undefined") var _zzOrderExt="1";
				if(typeof(_zzsiteid)!=="undefined"&&typeof(_zzid)!=="undefined") {
					var an_orsrc = this.protocol+'trace.zhiziyun.com/o.do?siteid=' + _zzsiteid + '&zzid=' + _zzid  + '&ordercode=' + encodeURIComponent(_zzOrderId+"_"+_zzOrderExt) + '&amt=1&orderdetail=' +encodeURIComponent(_zzOrderExt) + ':1:1&roid=' + Math.random();
					this.process(an_orsrc,true);
				}
			},
			zzorder:{
				orderId:Math.random(),
				orderTotal:1,
				orderDetail:[]
			},
			syncOrder:function(callback){
				if(this.zzorder.orderDetail.length==0) this.order.orderDetail.push('1:1:1');
				if(typeof(callback)=="function"){
					var img=new Image();
					img.onload=function(){
						if(typeof(callback)=="function"){
							callback.call();
						}
					};
					if(typeof(_zzsiteid)!=="undefined"&&typeof(_zzid)!=="undefined") {
						img.src=this.protocol+'trace.zhiziyun.com/o.do?siteid=' + _zzsiteid + '&zzid=' + _zzid  + '&ordercode=' + encodeURIComponent(this.zzorder.orderId) + '&amt='+this.zzorder.orderTotal+'&orderdetail=' +encodeURIComponent(this.zzorder.orderDetail.join('|')) + '&roid=' + Math.random();
					}
				}
				else{
					if(typeof(_zzsiteid)!=="undefined"&&typeof(_zzid)!=="undefined") {
						var an_orsrc = this.protocol+'trace.zhiziyun.com/o.do?siteid=' + _zzsiteid + '&zzid=' + _zzid  + '&ordercode=' + encodeURIComponent(this.zzorder.orderId) + '&amt='+this.zzorder.orderTotal+'&orderdetail=' +encodeURIComponent(this.zzorder.orderDetail.join('|')) + '&roid=' + Math.random();
						this.process(an_orsrc,true);
					}
				}
			},
			zztrans:{
				transId:Math.random(),
				transExt:"1"
			},
			syncTrans:function(callback){
				if(typeof(callback)=="function"){
					var img=new Image();
					img.onload=function(){
						if(typeof(callback)=="function"){
							callback.call();
						}
					};
					if(typeof(_zzsiteid)!=="undefined"&&typeof(_zzid)!=="undefined") {
						img.src=this.protocol+'trace.zhiziyun.com/o.do?siteid=' + _zzsiteid + '&zzid=' + _zzid  + '&ordercode=' + encodeURIComponent((this.zztrans.transId||Math.random())+"_"+this.zztrans.transExt) + '&amt=1&orderdetail=' +encodeURIComponent(this.zztrans.transExt) + ':1:1&roid=' + Math.random();
					}
				}
				else{
					if(typeof(_zzsiteid)!=="undefined"&&typeof(_zzid)!=="undefined") {
						var an_orsrc = this.protocol+'trace.zhiziyun.com/o.do?siteid=' + _zzsiteid + '&zzid=' + _zzid  + '&ordercode=' + encodeURIComponent((this.zztrans.transId||Math.random())+"_"+this.zztrans.transExt) + '&amt=1&orderdetail=' +encodeURIComponent(this.zztrans.transExt) + ':1:1&roid=' + Math.random();
						this.process(an_orsrc,true);
					}
				}
			},
			getOrder:function(_zzOrderId,_zzOrderDetails,_zzOrderTotal){
				if(typeof(_zzOrderId)!=="undefined"&&typeof(_zzsiteid)!=="undefined"&&typeof(_zzid)!=="undefined") {
					var an_orsrc = this.protocol+'trace.zhiziyun.com/o.do?siteid=' + _zzsiteid + '&zzid=' + _zzid  + '&ordercode=' + _zzOrderId + '&amt=' + _zzOrderTotal + '&orderdetail=' + _zzOrderDetails.join("|") + '&roid=' + Math.random();
					this.process(an_orsrc,true);
				}
			},
			escapeCharsAbove255:function(inputString){
				var outputBuffer = '';
				for(var i = 0; i <= (inputString.length - 1); i++) 
				{
					var charCode = inputString.charCodeAt(i);
					if(charCode > 255)
					{
						outputBuffer += '&#' + charCode + ';';
					} else {
						outputBuffer += inputString.charAt(i);
					}
				}
				return outputBuffer;
			},
			base64Encode:function(inputString){
				//inputString = this.escapeCharsAbove255(inputString);
				var base64Chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=';
				var outputArray = new Array();
				for(var i = 0; i <= (inputString.length - 1); i += 3) 
				{
					var byte1 = inputString.charCodeAt(i);
					var byte2 = inputString.charCodeAt(i + 1);
					var byte3 = inputString.charCodeAt(i + 2);
					var encodedCharIndex1 = byte1 >> 2;
					var encodedCharIndex2 = ((byte1 & 3) << 4) | (byte2 >> 4);
					var encodedCharIndex3 = ((byte2 & 15) << 2) | (byte3 >> 6);
					var encodedCharIndex4 = byte3 & 63;
					if(isNaN(byte2))
					{
						encodedCharIndex3 = encodedCharIndex4 = 64;
					} else if (isNaN(byte3)) {
						encodedCharIndex4 = 64;
					}
					outputArray.push(base64Chars.charAt(encodedCharIndex1));
					outputArray.push(base64Chars.charAt(encodedCharIndex2));
					outputArray.push(base64Chars.charAt(encodedCharIndex3));
					outputArray.push(base64Chars.charAt(encodedCharIndex4));
				}

				var vResult = outputArray.join('');
				vResult = vResult.replace(/\+/,'%2B');
				return vResult;
			},
			process : function (url,isImg) {
				if(isImg){
					var traceImg = document.createElement('img');
					traceImg.src = url;
					traceImg.height=1;
					traceImg.width=1;
					document.getElementsByTagName('head')[0].appendChild(traceImg);
				}
				else{
					var js = document.createElement('script');
					js.type = 'text/javascript';
					js.src = url;
					document.getElementsByTagName('head')[0].appendChild(js);
				}
			},
			url:'',
			CookieEnable:function(){
				var result = "false";
				if (navigator.cookieEnabled){
					return "true";			             
				}
				document.cookie = "testcookie=yes;";			
				var cookieSet = document.cookie;			
				if (cookieSet.indexOf("testcookie=yes") > -1){
					result = "true";
				}
				document.cookie = "";			
				return result;
			},
			SysEnable:function(){
				return	navigator.appName+" "+navigator.appVersion;
			},
			indent:'',
			rep:'',
			JSONtoString:function (value, replacer, space){
				var i;
				if (typeof space === 'number') {
					for (i = 0; i < space; i += 1) {
						this.indent += ' ';
					}

				} else if (typeof space === 'string') {
					this.indent = space;
				}
				this.rep = replacer;
				if (replacer && typeof replacer !== 'function' &&
						(typeof replacer !== 'object' ||
								typeof replacer.length !== 'number')) {
					throw new Error('JSONtoString');
				}
				return this.str('', {'': value});
			},
			init:function(){
				if('https:' === document.location.protocol){
					this.protocol='https://ssl.';
				}
				var zztrace="",dr = document.referrer,t = document.title,c = screen.width + "*" + screen.height,url = location.hash.toLowerCase();
				if (url.indexOf("zztrace") === -1) {
					url = location.search;
				}
				if (url.length > 1) {
					url = url.substring(1);
					var Url__ = url.split("&");
					for (var i = 0; i < Url__.length; i++) {
						var Url___ = Url__[i].split("=");
						if (Url___.length > 1) {
							if(Url___[0].toLowerCase()==="zztrace"){
								zztrace=Url___[1];
							}
						}
					}
				}
				this.url=this.protocol+'trace.zhiziyun.com/v.do?zzid='+_zzid+'&siteid=' + _zzsiteid  + '&r=' + encodeURIComponent(dr)  + '&t=' + encodeURIComponent(t)  + '&ck=' + this.CookieEnable() + '&brw=' + encodeURIComponent(this.SysEnable()) + '&tr=' + encodeURIComponent(zztrace)+'&rs='+ c +'&roid1=' + Math.random()+'&img=1';
			}
	};
	zz_trace.init();
	zz_trace.process(zz_trace.url,true);
	zz_trace.process(zz_trace.protocol+"trace.zhiziyun.com/zz.js?siteid="+_zzsiteid);
	zz_trace.analyze.src=zz_trace.baseURL;
	zz_trace.analyze.scrolling='no';
	zz_trace.analyze.width='1';
	zz_trace.analyze.height='1';
	zz_trace.analyze.marginheight='0';
	zz_trace.analyze.marginwidth='0';
	zz_trace.analyze.frameborder='0';
	zz_trace.analyze.style.display='none';
	
	(function zz_node()
	{
		if(document.body){
			var node=document.getElementsByTagName('body')[0];
			node.insertBefore(zz_trace.analyze,null);
		}
		else{
			setTimeout(zz_node, 50);
		}
	})();
}());