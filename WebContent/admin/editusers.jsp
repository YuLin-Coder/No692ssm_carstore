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
<script type="text/javascript" src="js/users.js" charset="utf-8"></script>
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
<script type="text/javascript"
	src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>
<body>
	<div style="margin: 15px;">
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>修改客户信息</legend>
		</fieldset>
		<form id="addForm" class="layui-form"
			action="users/updateUsers.action" name="myform" method="post">
			<div class="layui-form-item">
				<label class="layui-form-label">用户名</label>
				<div class="layui-input-inline" style="width: 45%;">
					<input type="text" name="username" class="layui-input"
						id="username" value="${users.username}" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">姓名</label>
				<div class="layui-input-inline" style="width: 45%;">
					<input type="text" name="realname" class="layui-input"
						id="realname" value="${users.realname}" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">性别</label>
				<div class="layui-input-inline shortInput">
					<input type="radio" name="sex" value="男" title="男"
						${users.sex == "男"?"checked":""}> <input type="radio"
						name="sex" value="女" title="女" ${users.sex == "女"?"checked":""}>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">出生日期</label>
				<div class="layui-input-inline" style="width: 45%;">
					<input type="text" name="birthday" class="layui-input"
						id="birthday" value="${users.birthday}"
						onclick="layui.laydate({elem: this})" readonly="readonly" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">联系方式</label>
				<div class="layui-input-inline" style="width: 45%;">
					<input type="text" name="contact" class="layui-input" id="contact"
						value="${users.contact}" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">联系地址</label>
				<div class="layui-input-inline" style="width: 45%;">
					<input type="text" name="address" class="layui-input" id="address"
						value="${users.address}" />
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<input type="hidden" name="usersid" id="usersid"
						value="${users.usersid}" /><input type="hidden" name="password"
						id="password" value="${users.password}" /> <input type="hidden"
						name="regdate" id="regdate" value="${users.regdate}" />

					<button class="layui-btn" type="submit" id="sub">立即提交</button>
					<button type="reset" class="layui-btn" id="res">取消重置</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>

