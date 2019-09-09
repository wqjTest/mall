/*
   Copyright (c) 2018-2018, CKSource - Hus. All rights reserved.
   下面两个配置，使用其中一个即可显示“上传图片”的tab。但是两者不要同时使用！！！
   editor.customConfig.uploadImgShowBase64 = true   // 使用 base64 保存图片
   editor.customConfig.uploadImgServer = '/upload'  // 上传图片到服务器
   隐藏“网络图片”tab
   editor.customConfig.showLinkImg = false
*/

    var debug = true;
    const default_menus = [
        'head',  // 标题
        'bold',  // 粗体
        'fontSize',  // 字号
        'fontName',  // 字体
        'italic',  // 斜体
        'underline',  // 下划线
        'strikeThrough',  // 删除线
        'foreColor',  // 文字颜色
        'backColor',  // 背景颜色
        'link',  // 插入链接
        'list',  // 列表
        'justify',  // 对齐方式
        'quote',  // 引用
        'emoticon',  // 表情
        'image',  // 插入图片
        'table',  // 表格
        'video',  // 插入视频
        'code',  // 插入代码
        'undo',  // 撤销
        'redo'  // 重复
    ];

    const article_menus = [
        'head',  // 标题
        'bold',  // 粗体
        'fontSize',  // 字号
        'fontName',  // 字体
        'italic',  // 斜体
        'strikeThrough',  // 删除线
        'foreColor',  // 文字颜色
        'backColor',  // 背景颜色
        'link',  // 插入链接
        'justify',  // 对齐方式
        'image',  // 插入图片
        'table',  // 表格
        'undo',  // 撤销
        'redo'  // 重复
    ];

    function getMenus(type) {
        if (typeof(type) == "undefined") {
            return default_menus;
        } else if (type === "1") {
            return article_menus;
        } else if (type === "2") {
            return default_menus;
        } else {
            return default_menus;
        }
    }

    function getDebugStatus() {
        return debug;
    }