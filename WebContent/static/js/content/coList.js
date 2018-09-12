function jump3(){
	
	var pageIndex=$('#currentPageText3').val();
	
	$("#jumpb").attr("href",$('input[name=basepath]').val()+"/getCoList?pageIndex="+pageIndex);
	
}