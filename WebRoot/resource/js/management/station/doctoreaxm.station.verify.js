(function($){
	$.doctoreaxm.station.verify = {
		station: null,
		init: function(station) {
			$.doctoreaxm.station.verify.station = station;
			// 已登分考生
			$("#score_info_n").setTemplateElement("score_info_m");
			// 已审核考生
			$("#verify_info_n").setTemplateElement("verify_info_m");
			$.doctoreaxm.station.verify.displayPageData();
			setInterval($.doctoreaxm.station.verify.displayPageData, 10*1000);
		},
		displayPageData: function() {
			$.doctoreaxm.station.verify.score();
			$.doctoreaxm.station.verify.verify();
		},
		//已登分考生
		score: function() {
			var params = "station=" + $.doctoreaxm.station.verify.station;
			$.ajax({
				type: "post",
				dataType: "json",
				url: "stationInfoServlet?method=exit",
				data: params,
				success: function(data){
					debugger;
					$("#score_num").text(data.exit);
					$("#score_info_n").processTemplate(data.info);
				},
				error: function() {
					toastr.error($.constant.ERROR);
				}
			});
		},
		//已审核考生
		verify: function() {
			var params = "station=" + $.doctoreaxm.station.verify.station;
			$.ajax({
				type: "post",
				dataType: "json",
				url: "stationInfoServlet?method=verify",
				data: params,
				success: function(data){
					$("#verify_num").text(data.verify);
					$("#verify_info_n").processTemplate(data.info);
				},
				error: function() {
					toastr.error($.constant.ERROR);
				}
			});
		}
	};
})(jQuery);