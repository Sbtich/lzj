function jump4(){
	
	var pageIndex=$('#currentPageText').val();
	
	$("#jumpa").attr("href",$('input[name=basepath]').val()+"/getOrList?pageIndex="+pageIndex);
	
}
