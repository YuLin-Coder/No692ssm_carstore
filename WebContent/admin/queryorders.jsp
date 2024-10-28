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
			<legend>订单数据查询</legend>
			<div class="layui-field-box layui-form">
				<table class="layui-table">

					<thead>
						<tr>
							<th style="text-align: center">订单号</th>
							<th style="text-align: center">客户</th>
							<th style="text-align: center">总计</th>
							<th style="text-align: center">状态</th>
							<th style="text-align: center">下单时间</th>
							<th style="text-align: center">收件人</th>
							<th style="text-align: center">地址</th>
							<th style="text-align: center">联系方式</th>
						</tr>
					</thead>
					<c:forEach items="${ordersList}" var="orders">
						<tr align="center">
							<td>${orders.ordercode}</td>
							<td>${orders.username}</td>
							<td>${orders.total}</td>
							<td>${orders.status}</td>
							<td>${orders.addtime}</td>
							<td>${orders.receiver}</td>
							<td>${orders.address}</td>
							<td>${orders.contact}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</fieldset>
		<blockquote class="layui-elem-quote" style="text-align: right">
			<form action="orders/queryOrdersByCond.action" name="myform"
				method="post">
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">查询条件</label>
						<div class="layui-input-block">
							<select name="cond" class="layui-input">
								<option value="ordercode">按订单号查询</option>
								<option value="usersid">按客户查询</option>
								<option value="total">按总计查询</option>
								<option value="status">按状态查询</option>
								<option value="addtime">按下单时间查询</option>
								<option value="receiver">按收件人查询</option>
								<option value="address">按地址查询</option>
								<option value="contact">按联系方式查询</option>
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
