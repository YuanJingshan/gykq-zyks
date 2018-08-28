(function($){
	$.doctoreaxm.user.login = {
		init : function() {
			$("#password").bind('keydown', function(event) {
				$.doctoreaxm.user.login.keyboardEvent(event);
			});
			$("#loginBtn").bind('click', function(event) {
				$.doctoreaxm.user.login.login();
			});
		},
		keyboardEvent : function(event) {
			debugger;
			var keyValue = null;
			if (!!event.which) {
				keyValue = event.which;
			} else {
				keyValue = event.keyCode;
			}
			if (13 == keyValue) {
				$.doctoreaxm.user.login.login();
			}
		},
		login : function() {
			
			$.ajax({
				type: "post",
		        url: "userServlet?method=login",
		        data: $("#login-form").serialize(),
		        dataType: "json",
		        error: function() {
		        	toastr.error("服务器异常！");
		        },
		        success: function(data) {
		           	if (data.result == 1) {
		           		$.common.layer.msg("登录成功！", {icon: 1, time: 2000}, function() {
		           			openPage($.common.getContextPath() + "/bpage/page/index.jsp", "_self");
		           		});
		        	} else {
		        		$.common.layer.msg("登录失败！", {icon: 2});
		        	}
		        }
		    });
		}
	};
})(jQuery);

$(function(){
	$.doctoreaxm.user.login.init();
});