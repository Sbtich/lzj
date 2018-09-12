function jump2(){
	
	var pageIndex=$('#currentPageText2').val();
	
	$("#jumpa").attr("href",$('input[name=basepath]').val()+"/getBsList?pageIndex="+pageIndex);
	
}