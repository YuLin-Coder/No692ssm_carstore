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
<script type="text/javascript" src="js/admin.js" charset="utf-8"></script>
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
<script type="text/javascript"
	src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>
<body>
	<div style="margin: 15px;">
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>新增管理员信息</legend>
		</fieldset>
		<form id="addForm" class="layui-form" action="admin/addAdmin.action"
			name="myform" method="post">
			<div class="layui-form-item">
				<label class="layui-form-label">用户名</label>
				<div class="layui-input-inline" style="width: 45%;">
					<input type="text" name="username" class="layui-input"
						id="username" placeholder="请输入用户名" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">密码</label>
				<div class="layui-input-inline" style="width: 45%;">
					<input type="password" name="password" class="layui-input"
						id="password" placeholder="请输入密码" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">姓名</label>
				<div class="layui-input-inline" style="width: 45%;">
					<input type="text" name="realname" class="layui-input"
						id="realname" placeholder="请输入姓名" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">联系方式</label>
				<div class="layui-input-inline" style="width: 45%;">
					<input type="text" name="contact" class="layui-input" id="contact"
						placeholder="请输入联系方式" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">权限</label>
				<div class="layui-input-inline" style="width: 45%;">
					<select name="role" id="role">
						<option value="">---请选择管理权限--</option>
						<option value="用户">用户</option>
						<option value="管理员">管理员</option>

					</select>
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" type="submit" id="sub">立即提交</button>
					<button type="reset" class="layui-btn" id="res">取消重置</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>

