(function($){
	$.doctoreaxm.station.info = {
		station: "",
		init: function(station) {
			$.doctoreaxm.station.info.station = station;
			// 检录-候考区
			$("#wait_info_n").setTemplateElement("templete-m");
			// 检录-考区
			$("#exam_info_n").setTemplateElement("templete-m");
			// 考站考生信息
			var params = "station=" + station;
			$.ajax({
				type: "post",
				dataType: "json",
				url: "stationInfoServlet?method=info",
				data: params,
				success: function(data){
					if(!!data) {
						$("#wait_num").text(data.wait.count);
						$("#exam_num").text(data.exam.count);
						$("#wait_info_n").processTemplate(data.wait.info);
						$("#exam_info_n").processTemplate(data.exam.info);
					}
				},
				error: function() {
					toastr.error($.constant.ERROR);
				}
			});
		}
	};
})(jQuery);