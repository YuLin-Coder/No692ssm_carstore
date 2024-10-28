<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%><!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<title>欢迎使用网站汽车销售系统</title>
<link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="css/global.css" media="all">
<link rel="stylesheet"
	href="plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="css/table.css" />
<script type="text/javascript" src="plugins/layui/layui.js"></script>
<script type="text/javascript" src="plugins/layui/controller.js"></script>
</head>
<body>
	<div class="admin-main">
		<fieldset class="layui-elem-field">
			<legend>货架数据查询</legend>
			<div class="layui-field-box layui-form">
				<table class="layui-table">

					<thead>
						<tr>
							<th style="text-align: center">货架号</th>
							<th style="text-align: center">详情</th>
						</tr>
					</thead>
					<c:forEach items="${racksList}" var="racks">
						<tr align="center">
							<td>${racks.racksno}</td>
							<td>${racks.contents}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</fieldset>
		<blockquote class="layui-elem-quote" style="text-align: right">
			<form action="racks/queryRacksByCond.action" name="myform"
				method="post">
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">查询条件</label>
						<div class="layui-input-block">
							<select name="cond" class="layui-input">
								<option value="racksno">按货架号查询</option>
								<option value="contents">按详情查询</option>
							</select>
						</div>
					</div>
					<div class="layui-inline">
						<div class="layui-input-block">
							<input type="text" name="name" required style="width: 200px"
								class="layui-input" />
						</div>
					</div>
					<div class="layui-inline">
						<input type="submit" value="查询" class="layui-btn" />
					</div>
				</div>
			</form>
		</blockquote>
	</div>
</body>
</html>
