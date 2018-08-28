(function($){
	$.doctoreaxm = {
		user : {},
		doctor : {},
		patrol : {},
		params : {},
		inpect : {},
		monitor : {},
		station : {},
		log : {},
		analyze : {}
	};
	
	$.constant = {
		FAIL: "操作失败",
		SUCCESS: "操作成功",
		ERROR: "服务器异常，请稍后再试"
	}
	
	$.common = {
		contextPath: "",
		layer : "",
		init : function() {
			$.common.initLayui();
		},
		initLayui : function() {
			layui.use('layer', function(){
				$.common.layer = layui.layer;
			});  
		},
        getContextPath : function() {
            if (!$.common.contextPath) {
            	debugger;
                var jsFileRelativePath = "/resource/js/";
                var scripts = document.getElementsByTagName("script");
                if (scripts) {
                    for (var i = 0; i < scripts.length; i++) {
                        var src = scripts[i].src;
                        if (src && src.indexOf(jsFileRelativePath) != -1) {
                            var pathArray = src.split(jsFileRelativePath);
                            $.common.contextPath = pathArray[0];
                            break;
                        }
                    }
                } else {
                    alert("JavaScript初始化异常，请开启浏览器的JavaScript脚本支持！");
                }
            }
            return  $.common.contextPath;
        }
	};
})(jQuery);

$(function(){
	$.common.init();
})