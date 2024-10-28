<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎使用汽车销售系统</title>
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
		<blockquote class="layui-elem-quote">
			<span style="text-align: left">${html }</span> <span
				style="float: right"><a href="orders/getAllOrders.action"
				class="layui-btn layui-btn-small"> <i class="layui-icon">&#x1002;</i>&nbsp;刷新数据
			</a></span>
		</blockquote>
		<fieldset class="layui-elem-field">
			<legend>订单数据列表</legend>
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
							<th style="text-align: center">订单明细</th>
							<th style="text-align: center" width="150">操作</th>
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
							<td><a style="color: blue"
								href="orders/details.action?id=${orders.ordersid}"> 点击查看</a></td>
							<td><c:if test="${orders.status eq '已付款'}">
									<a href="orders/send.action?id=${orders.ordersid}">发货</a>&nbsp;&nbsp;
								</c:if> <a href="orders/deleteOrders.action?id=${orders.ordersid}"
								onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</fieldset>
	</div>
</body>
</html>

