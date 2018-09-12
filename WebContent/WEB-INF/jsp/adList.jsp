<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
		<title></title>
		<link rel="stylesheet" type="text/css" href="<%=basepath%>/static/css/all.css"/>
		<link rel="stylesheet" type="text/css" href="<%=basepath%>/static/css/pop.css"/>
		<link rel="stylesheet" type="text/css" href="<%=basepath%>/static/css/main.css"/>
		<script type="text/javascript" src="<%=basepath%>/static/js/common/jquery-1.8.3.js"></script>
	    <script type="text/javascript" src="<%=basepath%>/static/js/content/adList.js"></script>

	</head>
	<body style="background: #e1e9eb;">
	<input type="hidden" name="basepath" value="${basepath}"/>
		<form action="selectByOne" id="mainForm" method="post">

			<input type="hidden" name="page.currentPage" id="currentPage" value="1"/>
			<div class="right">
				<div class="current">当前位置：<a href="#">内容管理</a> &gt; 广告管理</div>
				<div class="rightCont">
					<p class="g_title fix">广告列表</p>
					<table class="tab1">
						<tbody>
							<tr>
								<td align="right" width="80">标题：</td>
								<td>
									<input name="title" id="title" value="" class="allInput" type="text"/>
								</td>
	                            <td style="text-align: right;" width="150">
	                            	<input class="tabSub" value="查询" onclick="" type="submit"/>&nbsp;&nbsp;&nbsp;&nbsp;
	                            	<t:auth url="/ad/addInit">
	                            		<input class="tabSub" value="添加" onclick="location.href='${basepath}/adAdd'" type="button"/>
	                            	</t:auth>
	                            </td>
	       					</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th>序号</th>
								    <th>标题</th>
								    <th>链接地址</th>
								    <th>操作</th>
								</tr>
								
								
								<c:forEach items="${adPageList.list}" var="ad">

								<tr>
									<td>${ad.id}</td>
									<td>${ad.title}</td>
									<td>${ad.link}</td>
									<td><a href="javascript:void(0);" onclick="location.href='${basepath}/modify?id=${ad.id}'">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;

										<a href="deleted?id=${ad.id}" onclick="">删除</a></td>
								</tr>

							</c:forEach>
							
						
							</tbody>
						</table>

					<div class="page fix">
							<a href="getAdList?pageIndex=1" class="first">首页</a>
						<c:if test="${adPageList.hasPreviousPage}">
							<a href="getAdList?pageIndex=${adPageList.getPageNum()-1}" class="pre">上一页</a>
						</c:if>
						当前第<span>${adPageList.pageNum}/${adPageList.pages}</span>页
						<c:if test="${adPageList.hasNextPage}">
							<a href="getAdList?pageIndex=${adPageList.getPageNum()+1}" class="next">下一页</a>
						</c:if>
							<a href="getAdList?pageIndex=${adPageList.getPages()}" class="last">末页</a>
						跳至 &nbsp;<input id="currentPageText" value="1"
							class="allInput w28" type="text">&nbsp;页 &nbsp; <a
							href="" id="jumpa" onclick="jump()" class="go">GO</a>
					</div>

				</div>
				</div>
			</div>
		</form>
	</body>
</html>