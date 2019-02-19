(function($){
	$.doctoreaxm.station.inspect = {
		station: null,
		init: function(station) {
			debugger;
			$.doctoreaxm.station.inspect.station = station;
			//按钮监听
			$.doctoreaxm.station.inspect.initClickListener();
			// 候考区考生信息
			$("#wait_info_n").setTemplateElement("wait_info_m");
			// 考区考生信息
			$("#exam_info_n").setTemplateElement("exam_info_m");
			// 启动读卡器
			$.doctoreaxm.station.inspect.stationStart();
			// 候考区考生信息
			$.doctoreaxm.station.inspect.wait();
			// 考区考生信息
			$.doctoreaxm.station.inspect.exam();
			// 考区考生信息
			setInterval($.doctoreaxm.station.inspect.exam, 10*1000);
		},
		//按钮监听
		initClickListener: function(){
			$("#handBtn").bind("click", function(){
        		$.common.layer.open({
      			  title: "输入证件编号",
      			  type: 1,
      			  content: $('#hand-dialog'),
      			  btn: ['确认', '取消'],
      			  yes: function(index, layero){
      				debugger;
      				
      				if ($("#card-num").val() == "" || $("#card-num").val().length != 18) {
      					toastr.warning("证件号为空或不正确");
      				} else {
      					layer.close(index);
      					$.doctoreaxm.station.inspect.queryComm($("#card-num").val());
      				}
      			  },
      			  btn2: function(index, layero){
      				layer.close(index);
      			  }
      			});
        	});
		},
		//启动读卡器
		stationStart: function() {
			// 寻找读卡器
			FindReader();
			// 开始自动读卡
			setInterval($.doctoreaxm.station.inspect.readCard, 3000);
		},
		//开始读卡
		readCard: function() {
			var nRet;
			nRet = SynCardOcx1.ReadCardMsg();
			if(nRet==0) {
				var cardNum = SynCardOcx1.CardNo;
				$.doctoreaxm.station.inspect.queryComm(cardNum);
			}
		},
		//根据身份证号码查询考生信息
		queryComm: function (cardNum){
			$.ajax({
				type: "post",
				dataType: "json",
				url: "inspectServlet?method=getInspectDoctorByCard",
				data: "card=" + cardNum,
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					ajaxErrorMsg("queryStation2DoctorInfoCom('" + cardNum + "')", XMLHttpRequest, textStatus, errorThrown);
				},
				success: function(data){
					if (data.result == 0) {
						
						$.common.layer.msg("未检录，请到入口处检录！", {icon: 2});
					} else {
						$.doctoreaxm.station.inspect.displayInfo(data.info);
					}
				}
			});
		},
		//显示考生信息
		displayInfo: function(data) {
			//$("#doctor_tmplete_n").processTemplate(data);
			if (!!data) {
				$("#name").val(data.name);
				$("#sex").val(data.sex);
				$("#serialNumber").val(data.serialNumber);
				switch($.doctoreaxm.station.inspect.station){
					case 1:
						$("#topic").val(data.topic1);
						break;
					case 2:
						$("#topic").val(data.topic2);
						break;
					case 3:
						$("#topic").val(data.topic3);
						break;
					case 4:
						$("#topic").val(data.topic4);
						break;
					case 5:
						$("#topic").val(data.topic5);
						break;
					case 6:
						$("#topic").val(data.topic6);
						break;
				}
				$("#ksh").val(data.ksh);
				$("#card").val(data.card);
				if (data.examType == 120) {
					$("#examType").val("执业医师");
				} else if (data.examType == 220) {
					$("#examType").val("执业助理医师");
				}
				
				$.common.layer.open({
				  title: "考生信息",
				  type: 1,
				  area: '650px',
				  content: $('#doctor-dialog'),
				  btn: ['确认', '取消'],
				  yes: function(index, layero){
					debugger;
					layer.close(index);
					$.doctoreaxm.station.inspect.inspect(data.id);
				  },
				  btn2: function(index, layero){
					layer.close(index);
				  }
				});
			} else {
				toastr.warning("未检录，请到入口检录");
			}
		},
		//考生检录
		inspect: function(id) {
			debugger;
			$("#doctor-info").attr("style", "display:none");
			var params = "id=" + id + "&station=" + $.doctoreaxm.station.inspect.station;
			// 插入考生检录信息
			$.ajax({ 
				type: "post",
				dataType: "json",
				url: "stationInfoServlet?method=inspect",
				data: params,
				success: function(data){
					switch(data.result) {
						case 0:
							toastr.success($.constant.SUCCESS);
							$.doctoreaxm.station.inspect.wait();
							break;
						case -101:
							toastr.info('入口未检录');
							break;
						case -102:
							toastr.info('当前考站已检录');
							break;
						case -103:
							toastr.info('其他考站已检录，但是未完成考试');
							break;
						case -104:
							toastr.error('其他错误');
							break;
					}
				},
				error: function() {
					toastr.error($.constant.ERROR);
				}
			});
		},
		//候考区考生信息
		wait: function() {
			var params = "station=" + $.doctoreaxm.station.inspect.station;
			$.ajax({ 
				type: "post",
				dataType: "json",
				url: "stationInfoServlet?method=wait",
				data: params,
				success: function(data){
					debugger;
					$("#wait_num").text(data.wait);
					$("#wait_info_n").processTemplate(data.info);
				},
				error: function() {
					toastr.error($.constant.ERROR);
				}
			});
		},
		//考区考生
		exam: function() {
			var params = "station=" + $.doctoreaxm.station.inspect.station;
			$.ajax({
				type: "post",
				dataType: "json",
				url: "stationInfoServlet?method=exam",
				data: params,
				success: function(data){
					$("#exam_num").text(data.exam);
					$("#exam_info_n").processTemplate(data.info);
				},
				error: function() {
					toastr.error($.constant.ERROR);
				}
			});
		},
		//点击进入考场
		entryExam: function(id) {
			debugger;
			var params = "id=" + id + "&station=" + $.doctoreaxm.station.inspect.station;
			$.ajax({
				type: "post",
				dataType: "json",
				url: "stationInfoServlet?method=entryExam",
				data: params,
				success: function(data){
					debugger;
					if (!!data && data.result == 1) {
						playTipVoice();
						$("#" + id).remove();
						$.doctoreaxm.station.inspect.wait();
						$.doctoreaxm.station.inspect.exam();
					} else {
						toastr.error($.constant.ERROR);
					}
				},
				error: function() {
					toastr.error($.constant.ERROR);
				}
			});
		},
		//返回等待
		cancalExam: function(id) {
			debugger;
			var params = "id=" + id + "&station=" + $.doctoreaxm.station.inspect.station;
			
			$.common.layer.confirm('确认返回等候吗？', {icon: 3, title:'返回'}, function(index){
				//do something
				$.ajax({
					type: "post",
					dataType: "json",
					url: "stationInfoServlet?method=cancalExam",
					data: params,
					success: function(data){
						$.doctoreaxm.station.inspect.wait();
						$.doctoreaxm.station.inspect.exam();
					},
					error: function() {
						toastr.error($.constant.ERROR);
					}
				});
				$.common.layer.close(index);
			});
		}
	};
})(jQuery);