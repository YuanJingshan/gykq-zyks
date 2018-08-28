(function($){
	$.doctoreaxm.station.points = {
		station: null,
		init: function(station) {
			$.doctoreaxm.station.points.station = station;
			// 考区考生
			$("#exam_info_n").setTemplateElement("exam_info_m");
			// 已考完出站的考生
			$("#exit_info_n").setTemplateElement("exit_info_m");
			//显示页面数据
			$.doctoreaxm.station.points.displayPageData();
			// 定时刷新
			setInterval($.doctoreaxm.station.points.displayPageData, 10*1000);
		},
		displayPageData: function() {
			$.doctoreaxm.station.points.exam();
			$.doctoreaxm.station.points.exit();
		},
		//考区考生
		exam: function() {
			var params = "station=" + $.doctoreaxm.station.points.station;
			$.ajax({
				type: "post",
				dataType: "json",
				url: "stationInfoServlet?method=exam",
				data: params,
				success: function(data){
					debugger;
					$("#exam_num").text(data.exam);
					$("#exam_info_n").processTemplate(data.info);
				},
				error: function() {
					toastr.error($.constant.ERROR);
				}
			});
		},
		exit: function() {
			var params = "station=" + $.doctoreaxm.station.points.station;
			$.ajax({
				type: "post",
				dataType: "json",
				url: "stationInfoServlet?method=exit",
				data: params,
				success: function(data){
					$("#exit_num").text(data.exit);
					$("#exit_info_n").processTemplate(data.info);
				},
				error: function() {
					toastr.error($.constant.ERROR);
				}
			});
		}
	};
})(jQuery);