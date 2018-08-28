(function($){
	$.doctoreaxm.station.monitor = {
		station: null,
		init: function(station) {
			$.doctoreaxm.station.monitor.station = station;
			// 候考区考生信息
			$("#wait_info_n").setTemplateElement("wait_info_m");
			// 考区考生信息
			$("#exam_info_n").setTemplateElement("exam_info_m");
			//显示页面数据
			$.doctoreaxm.station.monitor.displayPageData();
			// 定时刷新
			setInterval($.doctoreaxm.station.monitor.displayPageData, 10*1000);
		},
		displayPageData() {
			$.doctoreaxm.station.monitor.wait();
			$.doctoreaxm.station.monitor.exam();
		},
		//候考区考生信息
		wait: function() {
			var params = "station=" + $.doctoreaxm.station.monitor.station;
			$.ajax({ 
				type: "post",
				dataType: "json",
				url: "stationInfoServlet?method=wait",
				data: params,
				success: function(data){
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
			var params = "station=" + $.doctoreaxm.station.monitor.station;
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
		}
	};
})(jQuery);