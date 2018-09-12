<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
		<title></title>
		<link rel="stylesheet" type="text/css" href="<%=basepath%>/static/css/all.css"/>
		<link rel="stylesheet" type="text/css" href="<%=basepath%>/static/css/pop.css"/>
		<link rel="stylesheet" type="text/css" href="<%=basepath%>/static/css/main.css"/>
		<link rel="stylesheet" type="text/css" href="<%=basepath%>/static/css/jquery.validate.css"/>
		<script type="text/javascript" src="<%=basepath%>/static/js/common/jquery-1.8.3.js"></script>

	</head>
	<body style="background: #e1e9eb;">
		<form id="mainForm" method="post" action="updateBs?id=${bs.id}" enctype="multipart/form-data">
			<input type="hidden" name="basepath" value="${bs.id}">
			<input type="hidden" id="message" value=""/>
			<input type="hidden" name="_method" value="PUT"/>
			<div class="right">
				<div class="current">当前位置：<a href="###">内容管理</a> &gt; 商户管理</div>
				<div class="rightCont">
					<p class="g_title fix">修改商户</p>
					<table class="tab1" width="100%">
						<tbody>
							<tr>
								<td align="right" width="15%">标题<font color="red">*</font>：</td>
								<td width="30%">
									<input name="title" value="${bs.title}" class="allInput" style="width:100%;" type="text"/>
								</td>
								<td align="right" width="15%">副标题<font color="red">*</font>：</td>
								<td width="30%">
									<input name="subtitle" value="${bs.subtitle}" class="allInput" style="width:100%;" type="text"/>
								</td>
							</tr>
							<tr>
								<td align="right" width="10%">城市<font color="red">*</font>：</td>
								<td width="30%">
									<select name="city">
										<c:forEach items="${city}" var="city">
											<option value="${city.code}">${city.name}</option>
										</c:forEach>
									</select>
								</td>
								<td align="right" width="10%">类别<font color="red">*</font>：</td>
								<td width="30%">
									<select name="category">
										<c:forEach items="${category}" var="category">
											<option value="${category.code}">${category.name}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td align="right" width="10%">上传图片：</td>
								<td width="30%">
									<a href="${bs.img_url}">查看图片</a>
								
									<input name="imgFile" class="allInput" style="width:100%;" type="file"/>
								</td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td align="right" width="10%">价格(单位：元)<font color="red">*</font>：</td>
								<td width="30%">
									<input name="price"  value="${bs.price}" class="allInput" style="width:100%;" type="text"/>
								</td>
								<td align="right" width="10%">距离(单位：米)<font color="red">*</font>：</td>
								<td width="30%">
									<input name="distance" value="${bs.distance}" class="allInput" style="width:100%;" type="text"/>
								</td>
							</tr>
							<tr>
								<td align="right">描述<font color="red">*</font>：</td>
								<td width="30%" colspan="3">
									<textarea name="description" rows="5" style="width:100%;"></textarea>
								</td>
							</tr>
						</tbody>
					</table>
					<div style="text-align: center; margin-top: 30px;">
						<input class="tabSub" value="保     存" type="submit" onclick=""/>&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="tabSub" value="返     回" type="button"/>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>