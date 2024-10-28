$(function() {
	$('#sub').click(
			function() {
				var loc = $("input[name='basepath']").val();
				var start = $("input[name='start']").val();
				var end = $("input[name='end']").val();
				var url = loc + "chart/chartUser.action?start=" + start
						+ "&end=" + end;
				if (start == '' || start == null) {
					alert('请选择开始日期');
					return;
				}
				if (end == '' || end == null) {
					alert('请选择结束日期');
					return;
				}
				$.ajax({
					type : "get",
					url : url,
					dataType : "json",
					success : function(json) {
						var days = json.days.replace("[", "").replace("]", "").split(",");
						var total = json.total.replace("[", "").replace("]", "").split(",");
						var option = {
							title : {
								text : '用户数据统计',
								left : 'center'
							},
							tooltip : {
								trigger : 'item',
								formatter : '{a} <br/>{b} : {c}'
							},
							legend : {
								left : 'left',
							},
							xAxis : {
								type : 'category',
								name : 'x',
								splitLine : {
									show : false
								},
								data : days
							},
							grid : {
								left : '3%',
								right : '4%',
								bottom : '3%',
								containLabel : true
							},
							yAxis : {
								type : 'value'
							},
							series : [ {
								name : '注册数量',
								type : 'line',
								smooth: false,
								data : total
							}]
						};

						// 初始化echarts实例
						var myChart = echarts.init(document
								.getElementById('chartmain'));

						// 使用制定的配置项和数据显示图表
						myChart.setOption(option);
					},
					error : function() {
						alert("ajax请求发生错误3");
					}
				});
			});
})