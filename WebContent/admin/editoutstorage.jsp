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
<link rel="stylesheet"
	href="plugins/font-awesome/css/font-awesome.min.css">
<script type="text/javascript" src="plugins/layui/layui.js"></script>
<script type="text/javascript" src="plugins/layui/controller.js"></script>
<script type="text/javascript" src="js/jquery-1.3.2.min.js"
	charset="utf-8"></script>
<script type="text/javascript" src="js/outstorage.js" charset="utf-8"></script>
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
<script type="text/javascript"
	src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>
<body>
	<div style="margin: 15px;">
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>修改出库信息</legend>
		</fieldset>
		<form id="addForm" class="layui-form"
			action="outstorage/updateOutstorage.action" name="myform"
			method="post">
			<div class="layui-form-item">
				<label class="layui-form-label">订单</label>
				<div class="layui-input-inline" style="width: 45%;">
					<select name="ordersid" id="ordersid"><c:forEach
							items="${ordersList}" var="orders">
							<option value="${orders.ordersid}">${orders.ordercode }</option>
						</c:forEach></select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">商品</label>
				<div class="layui-input-inline" style="width: 45%;">
					<select name="goodsid" id="goodsid"><c:forEach
							items="${goodsList}" var="goods">
							<option value="${goods.goodsid}">${goods.goodsname }</option>
						</c:forEach></select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">数量</label>
				<div class="layui-input-inline" style="width: 45%;">
					<input type="text" name="num" class="layui-input" id="num"
						value="${outstorage.num}" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">管理员</label>
				<div class="layui-input-inline" style="width: 45%;">
					<select name="adminid" id="adminid"><c:forEach
							items="${adminList}" var="admin">
							<option value="${admin.adminid}">${admin.username }</option>
						</c:forEach></select>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<input type="hidden" name="outstorageid" id="outstorageid"
						value="${outstorage.outstorageid}" /><input type="hidden"
						name="addtime" id="addtime" value="${outstorage.addtime}" />

					<button class="layui-btn" type="submit" id="sub">立即提交</button>
					<button type="reset" class="layui-btn" id="res">取消重置</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>

