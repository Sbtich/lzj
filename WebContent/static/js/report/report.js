$(function(){
	var myChart=echarts.init(document.getElementById('report'));
	$.ajax({
		url:$('input[name=basepath]').val()+'/report',
	}).success(function(data){
		var	option = {
				    title: {
				        text: '商品销售统计'
				    },
				    tooltip: {
				        trigger: 'axis'
				    },
				    grid: {
				        left: '3%',
				        right: '4%',
				        bottom: '3%',
				        containLabel: true
				    },
				    toolbox: {
				        feature: {
				            saveAsImage: {}
				        }
				    },
				    xAxis: {
				        type: 'category',
				        boundaryGap: false,
				    },
				    yAxis: {
				        type: 'value'
				    }
		};
		$.extend(true,option,data);
		myChart.setOption(option);
		
	});
	
})

