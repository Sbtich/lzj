<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
		<script type="text/javascript" src="<%=basepath%>/static/js/common/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="<%=basepath%>/static/js/report/report.js"></script>
		<script type="text/javascript" src="<%=basepath%>/static/js/report/echarts.common.min.js"></script>
		<title></title>
	
	</head>
	<body style="background: #e1e9eb;">
	<input type="hidden" name="basepath" value="${basepath}"/>
	
		<div id="report" style="height:500px;border:1px solid #ccc;padding:10px;"></div>
	</body>
</html>