/*
* jQuery UI areaselect 1.6.2
* Copyright 2011, sapphire.shand
* http://jquery.org/license
* Depends:
*	jquery.ui.core.js
*	jquery.ui.widget.js
*
* 数据结构见 areaData.js  数据改成字符串传入进来快多了 grade: 2:省市 3：省市区
*/
(function ($, undefined) {

    $.widget("ui.areaselect", {

        options: {
            showIn: "", //指定选择的内容显示在哪里
            source: '', //数据源，json字符串
            type: "", //source,dest,net
            grade: 3
        },

        setAddress: function (index, param, leng) {//设置address.设置省级，市区都清空；设置市级，区级清空
            if (index > 0) {
                this.address[index].name = (param.name || "");
                this.address[index].code = (param.code || "");
            }
            for (var i = index + 1; i < leng; i++) {
                this.address[i].name = "";
                this.address[i].code = "";
            }
        },
        close: function () {
            this.element.hide();
        },
        open: function () {
            this.element.show();
        },
        getAddress: function () {
            return this.address;
        },

        showAddress: function (address, jId) {//设置input中显示的值
            if (typeof jId == "undefined") {
                return;
            }
            $(jId).css("color", "black");
            var nlist = [],
			clist = [];
            for (var para in address) {
                if (address[para].name != "") {
                    nlist[nlist.length] = address[para].name;
                    clist[clist.length] = address[para].code;
                }
            }
            $(jId).val(nlist.join("-"))
                  .attr("code", clist.join("-"))
                  .attr("text", nlist.join("-"))
                  .trigger('setvalue');

        },

        _setSource: function (index) {//设置source
            var d = "",
			name1 = this.address[1].name,
			name2 = this.address[2].name,
			grade = this.options.grade;

            if (index == 2 && name1 != "") {//到市级tab时,通过省获取省下所有市
                d = this.options.source[name1];
            } else if (grade == 3 && index == 3 && name1 != "" && name2 != "") {
                d = this.options.source[name1][name2];
            }
            this.source = (d == "" ? this.options.source : d);
        },

        _tabChangeHandler: function (event) {//tab切换时，重新设置数据源
            var jObj = $(event.target),
			index = parseInt(jObj.attr("index"), 10);
            if (isNaN(index)) {
                this._setSource(index);
            }
        },

        _itemClickHandler: function (event, jEle) {//item点击后的处理：设置样式，更新显示的数据，控制选择空间的显示
            var self = this,
			    jObj = $(event.target),
			    item = jObj.attr("panel-item"),
			    code = jObj.attr("code"),
			    tab = jObj.parents("div.s-tab-b"),
			    nexttab = tab.next(),
			    index = parseInt(tab.attr("index"), 10),
			    allTab = jEle.find("div.s-tab-b"),
			    allTitle = jEle.find("li.s-tab-t"),
			    i, c,
			    grade = this.options.grade,
			    curIndex; //切换到的tab 的index

            if (typeof item == "undefined") {
                return;
            }

            allTab.find("a.current").removeClass("current");

            if (index == 0) {//hotArea两级连跳
                //设置address
                var parent = this.options.source[item].parent;

                this.address[1] = { "name": parent.name, "code": parent.code };
                this.address[2] = { "name": item, "code": code };
                this.address[3] = { "name": "", "code": "" };

                allTab.find("a.panel-item[code=" + parent.code + "]").addClass("current");
                this.source = this.options.source[parent.name]; //更新source
                this._createListView($(allTab[2])); //更新下级显示item 初始化	

                allTab.find("a.panel-item[code=" + code + "]").addClass("current");

                if (grade == 3) {
                    this.source = this.source[item]; //更新source
                    this._createListView($(allTab[grade])); //更新下级显示item 初始化		
                    this._setSource(grade);
                }

                //设置title
                allTitle.removeClass("current");
                $(allTitle[grade]).addClass("current");
                allTab.hide();
                $(allTab[grade]).show();

                if ((grade == 2 || this.options.type == "net") && this.options.after) {
                    this.options.after(this.element);
                }

            } else {
                this.setAddress(index, { name: item, code: code }, (this.options.grade + 1)); //设置address
                this._setSource(index);

                //常用tab中将address中包含的全部高亮 
                for (i in this.address) {
                    c = this.address[i].code;
                    if (c != "") {
                        allTab.find("a.panel-item[code=" + c + "]").addClass("current");
                    }
                }

                if (index == grade && this.options.after) {//选择完grade级区域后的处理
                    this.options.after(this.element);
                } else {
                    //                    if (index == (grade - 1) && this.options.after) {
                    //                        this.options.after(this.element);
                    //                    }
                    this.source = this.source[item]; //更新source
                    this._createListView(nexttab); //更新下级显示item 初始化
                    nexttab.next().empty();

                    allTab.hide();
                    nexttab.show();
                    allTitle.removeClass("current");
                    $(allTitle[index + 1]).addClass("current");
                }
            }

            curIndex = jEle.find('li.s-tab-t.current').attr('tabIndex');
            this._changeCloseStatus(curIndex);


            this.showAddress(this.address, this.options.showIn); //选中的item加到输入框中
        },

        _changeCloseStatus: function (index) {
            if (true || index == this.options.grade) {//切换到区县tab时才展示关闭按钮
                this.element.find('span.alp-close-area').show();
            } else {
                this.element.find('span.alp-close-area').hide();
            }
        },

        _createListView: function (jTab) {//设置显示的tab中item list
            var self = this,
			    htmlList = [],
			    index = parseInt(jTab.attr("index"), 10),
			    data = (index == 0 ? this.hotAreas : (index == 1 ? this.parentAreas : this.source)),
			    dList = {},
			    m, i, n, p,
			    scope;

            if (index == 1) {//对省的特殊处理,按拼音分组
                for (m in data) {
                    if ("scope" in data[m]) {
                        scope = data[m].scope;
                        if (!dList[scope]) { dList[scope] = []; }
                        dList[scope][dList[scope].length] = '<li><a href="javascript:;" class="panel-item" code="';
                        dList[scope][dList[scope].length] = data[m]["code"];
                        dList[scope][dList[scope].length] = '" panel-item="';
                        dList[scope][dList[scope].length] = m;
                        dList[scope][dList[scope].length] = '">';
                        dList[scope][dList[scope].length] = m;
                        dList[scope][dList[scope].length] = '</a></li>';
                    }
                }

                for (n in dList) {
                    htmlList[htmlList.length] = '<dl class="panel-category"><dt>';
                    htmlList[htmlList.length] = n.substr(0, 1);
                    htmlList[htmlList.length] = '-';
                    htmlList[htmlList.length] = n.substr(1, 1);
                    htmlList[htmlList.length] = '</dt><dd><ul>';
                    htmlList[htmlList.length] = dList[n].join('');
                    htmlList[htmlList.length] = '</ul></dd></dl>';
                }
            } else {
                htmlList[htmlList.length] = '<ul>';
                for (p in data) {
                    if (p != "code" && p != "scope" && p != "s") {
                        htmlList[htmlList.length] = '<li><a href="javascript:;" class="panel-item" code="';
                        htmlList[htmlList.length] = data[p]["code"];
                        htmlList[htmlList.length] = '" panel-item="';
                        htmlList[htmlList.length] = p;
                        htmlList[htmlList.length] = '">';
                        htmlList[htmlList.length] = p;
                        htmlList[htmlList.length] = '</a></li>';
                    }
                }
                htmlList[htmlList.length] = '</ul><div class="c"></div>';
            }
            jTab.html(htmlList.join(''));
        },

        _initAreasData: function () {//初始化热门城市和省级城市
            var hotAreas = {},
			parentAreas = {},
			source = this.options.source;
            if (typeof source === "object") {
                for (var key in source) {
                    if ("parent" in source[key]) {
							  hotAreas[key] = { "code": source[key].code };
                    } else {
                        parentAreas[key] = { "code": source[key].code, "scope": source[key].scope };
                    }
                }
            }
            this.hotAreas = hotAreas;
            this.parentAreas = parentAreas;
        },

        initAddress: function () {
            this.address = { 1: { name: "", code: "" }, 2: { name: "", code: "" }, 3: { name: "", code: ""} };
        },

        _initSource: function () {
            var self = this,
			array,
			url;
            if (typeof this.options.source === "string") {
                //			this.source = this.options.source = jQuery.parseJSON(this.options.source);
                this.source = this.options.source = eval("(" + this.options.source + ")"); //ie6用此方法转换json对象最快
                return true;
            }
            if (typeof this.options.source === "object") {
                this.source = this.options.source;
                return true;
            }
            return false;
        },

        /**
        * @param {Object} jObj   tab父节点
        * @param {Object} cb	   回调方法，回传i(当前点击的第几个，从0开始),this 对像本身
        * @param {Object} n	   初始化时哪个tab先触发
        */
        _tab: function (jObj, cb, n) {

            var tabBody = jObj.find("div.s-tab-b")
		        , tabTitle = jObj.find("ul.h .s-tab-t")
		        , m = (!n ? 0 : n)
		        , self = this;

            tabTitle
			.each(function (i) {
			    $(this).attr("tabIndex", i);
			})
			.bind("click", function () {
			    var i = $(this).attr("tabIndex");
			    jObj.find("ul.h .current").removeClass("current");
			    $(this).addClass("current");
			    tabBody.hide();
			    $(jObj.find("div.s-tab-b")[i]).show();
			    if (cb) {
			        cb(i, this);
			    }
			    self._changeCloseStatus(i);

			    return false;
			});

            //初始化
            tabBody.hide();
            tabTitle.eq(m).trigger("click");
        },

        initTab: function (address) {//根据address值设置tab
            var adds = (typeof address != "object") ? this.address : address,
			i,
			allTab = this.element.find("div.s-tab-b");
            this.element.find(".current").removeClass("current");
            this.element.find("ul.h .s-tab-t").eq(0).addClass("current");
            allTab.hide()
			.eq(0)
			.show()
			.next()
			.next()
			.empty()
			.next()
			.empty();

            for (i in adds) {
                if (adds[i].code != "") {
                    this.element.find("a.panel-item[code=" + adds[i].code + "]").click();
                }
            }
        },

        _create: function () {//创建dom框架，初始化

            var self = this,
			doc = this.element[0].ownerDocument,
			html = '',
			hotList = [],
			tabs,
			grade = parseInt(this.options.grade, 10);

            if (!grade) {
                this.options.grade = 3;
            }

            if (3 == grade) {
                html = '<ul class="h">\
				    <li class="s-tab-t"><span class="inner" index="0">热门</span></li>\
				    <li class="s-tab-t"><span class="inner" index="1">省</span></li>\
				    <li class="s-tab-t"><span class="inner" index="2">市</span></li>\
				    <li class="s-tab-t current"><span class="inner" index="3">区县</span></li>\
				    <span class="alp-close alp-close-area">&nbsp;</span>\
				    <div class="c"></div>\
			        </ul>\
			        <div index="0" class="s-tab-b"></div>\
			        <div index="1" class="s-tab-b"></div>\
			        <div index="2" class="s-tab-b"></div>\
			        <div index="3" class="s-tab-b"></div>\
			        <div class="c"></div>';
            }
            else if (2 == grade) {
                html = '<ul class="h">\
					<li class="s-tab-t"><span class="inner" index="0">热门</span></li>\
					<li class="s-tab-t"><span class="inner" index="1">省</span></li>\
					<li class="s-tab-t"><span class="inner" index="2">市</span></li>\
					<div class="c"></div>\
				    </ul>\
				    <div index="0" class="s-tab-b"></div>\
				    <div index="1" class="s-tab-b"></div>\
				    <div index="2" class="s-tab-b"></div>\
				    <div class="c"></div>';
            }

            this._initSource();
            this.initAddress();
            this._initAreasData();

            this.element
			.addClass("area-tab")
			.html(html)
			.find("ul.h").bind("click", function (event) {
			    self._tabChangeHandler(event);
			    return false;
			});

            this.element.find('span.alp-close-area').click(function () {
                self.close();
            });

            tabs = this.element.find("div.s-tab-b");
            this._createListView($(tabs[0]));
            this._createListView($(tabs[1]));


            if ($.fn.bgiframe) {//被遮挡的问题
                this.element.bgiframe();
            }

            tabs.bind("click", function (event) {
                self._itemClickHandler(event, self.element);
                return false;
            });
            this._tab(this.element);

            $(this.options.showIn).bind({
                focus: function (event) {
                    var target = $(event.target),
                        pos = target.position();

                    self.open();
                    self.element.css({
                        left: pos.left,
                        top: pos.top + target.outerHeight()
                    });
                }
            })
            .attr('autocomplete', 'off');
        }
    });
} (jQuery));