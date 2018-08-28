(function($){
	$.doctoreaxm.params.context = {
		validateForm:"",
		init : function() {
			$.doctoreaxm.params.context.validate();
			$.doctoreaxm.params.context.initClickListener();
			$.doctoreaxm.params.context.initCompent();
		},
		initCompent : function() {
			$.ajax({
        		type: "post",
        		dataType: "json",
        		url: "paramsServlet?method=getParams",
        		error: function(XMLHttpRequest, textStatus, errorThrown) {
        			toastr.error("服务器异常！");
        		},
        		success: function(data){
        		   debugger;
                   if (!!data) {
                	   $("#id").val(data.id);
                	   $("#topic").val(data.topic);
                	   $("#serialNumber").val(data.serialNumber);
                	   $("#station1jgx").val(data.sta1jgx.toFixed(2));
                	   $("#station2jgx").val(data.sta2jgx.toFixed(2));
                	   $("#station3jgx").val(data.sta3jgx.toFixed(2));
                	   $("#station4jgx").val(data.sta4jgx.toFixed(2));
                	   $("#station5jgx").val(data.sta5jgx.toFixed(2));
                	   $("#station6jgx").val(data.sta6jgx.toFixed(2));
                	   $("#topic1").val(data.topic1);
                	   $("#topic2").val(data.topic2);
                	   $("#topic3").val(data.topic3);
                	   $("#topic4").val(data.topic4);
                	   $("#topic5").val(data.topic5);
                	   $("#topic6").val(data.topic6);
                   }
        		}
        	});
		},
        initClickListener : function() {
        	// 刷新
        	$("#refresh").click(function() {
        		refresh();
        	});
        	$("#submitBtn").bind("click", function(){
        		$.doctoreaxm.params.context.upate();
        	});
        	$("#resetBtn").bind("click", function(){
        		$.doctoreaxm.params.context.initCompent();
        	});
        	$("#initBtn").bind("click", function(){
        		$.common.layer.open({
      			  title: "系统初始化",
      			  type: 1,
      			  content: $('#init-dialog'),
      			  btn: ['确认', '取消'],
      			  yes: function(index, layero){
      				var params = {};
      	        	params.password = $("#password").val();
      	        	if (!!params.password) {
      	        		layer.close(index);
	      				$.doctoreaxm.params.context.sysInit(params);
      	        	} else {
      	        		$.common.layer.msg('请输入密码'); 
      	        	}
      			  },
      			  btn2: function(index, layero){
      				layer.close(index);
      			  }
      			});
        	});
        },
        validate: function(){
        	$.doctoreaxm.params.context.validateForm = $("#jgx-form").validate({
                debug:true,
                rrorElement : 'span', 
    			errorClass : 'has-error',
    			onfocusout : function(element) {
    				$(element).valid();
    			},
                rules:{
                	serialNumber: {digits:true, max:1000, min:1},
                	station1jgx: {required: true, dobleTwo: true},
                	topic1:{digits:true, max:500, min:1},
                	station2jgx: {required: true, dobleTwo: true},
                	topic2: {digits:true, max:500, min:1},
                	station3jgx: {required: true, dobleTwo: true},
                	topic3: {digits:true, max:500, min:1},
                	station4jgx: {required: true, dobleTwo: true},
                	topic4: {digits:true, max:500, min:1},
                	station5jgx: {required: true, dobleTwo: true},
                	topic5: {digits:true, max:500, min:1},
                	station6jgx: {required: true, dobleTwo: true},
                	topic6: {digits:true, max:500, min:1},
                },
                errorPlacement: function(error, element) {
    				element.after(error);
    			}
            });
        },
        upate : function() {
        	if(!$.doctoreaxm.params.context.validateForm.form()) {
                return false;
            }
        	$.ajax({
        		type: "post",
        		dataType: "json",
        		url: "paramsServlet?method=update",
        		data: $("#jgx-form").serialize(),
        		error: function() {
        			toastr.error("服务器异常！");
        		},
        		success: function(data){
                   	if (data.result > 0) {
                   		toastr.success("修改成功！");
                	} else {
                		toastr.error("修改失败！");
                	}
        		}
        	});
        },
        sysInit : function(params) {
        	debugger;
        	
        	$.common.layer.confirm(
    			'确认对系统进行初始化？', 
    			{icon: 3, title:'提示'},
    			function(index){
    				$.ajax({
    					type: "post",
    			        url: "paramsServlet?method=sysInit",
    			        dataType: "json",
    			        data: params,
    			        error: function() {
    			        	toastr.error("服务器异常！");
    			        },
    			        success: function(data) {
    			           	if (data.result == 1) {
    			           		toastr.success("操作成功！");
    			        	} else {
    			        		toastr.error("密码错误！");
    			        	}
    			        }
    			    });
    				layer.close(index);
    			}
    		);
        }
	};
})(jQuery);

$(function(){
	$.doctoreaxm.params.context.init();
})