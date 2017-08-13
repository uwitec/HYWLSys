/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights
 *          reserved. For licensing, see LICENSE.md or
 *          http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function(config) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	// 界面语言，默认为 'en'

	config.language = 'zh-cn';

	// 设置宽高

	config.width = 400;

	config.height = 400;

	// 编辑器样式，有三种：'kama'（默认）、'office2003'、'v2'

	config.skin = 'v2';

	// 背景颜色

	config.uiColor = '#FFF';

	// 工具栏（基础'Basic'、全能'Full'、自定义）plugins/toolbar/plugin.js

	config.toolbar = 'Basic';

	config.toolbar = 'Full';
};
