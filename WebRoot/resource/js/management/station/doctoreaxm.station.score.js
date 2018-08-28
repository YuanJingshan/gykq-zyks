(function($){
	$.doctoreaxm.station.score = {
		station: null,
		init: function(station) {
			$.doctoreaxm.station.score.station = station;
			// 附上模版数据
			$("#tmplete-n").setTemplateElement("tmplete-m");
			// 时间控件
			$('#start-dt').datetimepicker({lang:"ch"});
			$('#end-dt').datetimepicker({lang:"ch"});
			// 分页
			setParam(10, 
					"stationScoreExtServlet?method=count", 
					"stationScoreExtServlet?method=getPageData", 
					"stationScoreExtServlet?method=delete", 
					"station=" + $.doctoreaxm.station.score.station + "&pageSize=10&pageNum=", 
					"station=" + $.doctoreaxm.station.score.station);
			getPageCount();
			getPageAndDisplay();
			
			$.doctoreaxm.station.score.initClickListener();
		},
		//按钮事件监听
		initClickListener: function() {
			// 刷新
			$("#refresh").click(function() {
				refresh();
			});

			// 删除
			$("#delete").click(function() {
				deleteTeam();
			});	
			
			// 全选
			$(".checkAll").click(function() {	
				var checkFlag = $(".checkAll").attr("checked");
				if (checkFlag == "checked") {
					selectAll();
				} else if (checkFlag == undefined){
					cacalSelAll();
				}
			});
			$("#query-condition").change(function(){
				// 条件选择
				conditionChoose();
			});
		}
	};
	
	$.doctoreaxm.station.modify = {
		station: null,
		init: function(station) {
			$.doctoreaxm.station.modify.station = station;
			//设置模板数据
			$("#station-score-n").setTemplateElement("templete-m");
			$.doctoreaxm.station.modify.detail();
			$("#submitBtn").click(function() {
				$.doctoreaxm.station.modify.update();
			});
			$("#verifyBtn").click(function() {
				$.doctoreaxm.station.modify.verify();
			});
		},
		//详细
		detail: function() {
			var params = "id=" + $("#doctor-id").val() + "&station=" + $.doctoreaxm.station.modify.station;
			$.ajax({
				type: "post",
				dataType: "json",
				url: "stationScoreExtServlet?method=score",
				data: params,
				success: function(data){
					$("#station-score-n").processTemplate(data);
				},
				error: function() {
					toastr.error($.constant.ERROR);
				}
			});
		},
		//修改分数
		update: function() {
			debugger;
			var params = "id=" + $("#doctor-id").val() + "&station=" + $.doctoreaxm.station.modify.station;
			$(".score-count").each(function(){
				params = params + "&" + this.id + "=" + $(this).text();
			});
			params = params + "&count=" + $("#count").text();
			params = params + "&" + $("#station-score-n").serialize();
			$.ajax({
				type: "post",
				dataType: "json",
				url: "stationScoreExtServlet?method=update",
				data: params,
				success: function(data){
					if (data.result == 1) {
						$.common.layer.msg("操作成功！",  {icon: 1, time: 2000}, function() {
							openPage($.common.getContextPath() + "/view/management/station/score-list.jsp?station=" + $.doctoreaxm.station.modify.station, "_self");
						});
					} else if (data.result == -101) {
						toastr.error("总分大于100，请仔细检查！");
					} else {
						toastr.error("修改分数失败！");
					}
				},
				error: function() {
					toastr.error($.constant.ERROR);
				}
			});
		},
		verify : function() {
			var params = "id=" + $("#doctor-id").val() + "&station=" + $.doctoreaxm.station.modify.station;
			
			$.ajax({
				type: "post",
				dataType: "json",
				url: "stationInfoServlet?method=exitVerify",
				data: params,
				success: function(data){
					if (!!data) {
						switch(data.result) {
							case 0:
								$.common.layer.msg("审核成功！",  {icon: 1, time: 2000}, function() {
									openPage("/doctorexam/view/management/station/verify.jsp?station=" + $.doctoreaxm.station.modify.station,"_self");
								});
								breack;
							case -101:
								toastr.error("考生信息不存在！");
								breack;
							case -102:
								toastr.error("考试未完成！");
								breack;
							case -103:
								toastr.error("已审核！");
								breack;
						}
					}
				},
				error: function() {
					toastr.error($.constant.ERROR);
				}
			});
		}
	}
})(jQuery);