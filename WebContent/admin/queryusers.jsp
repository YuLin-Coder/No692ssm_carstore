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
			<legend>客户数据查询</legend>
			<div class="layui-field-box layui-form">
				<table class="layui-table">

					<thead>
						<tr>
							<th style="text-align: center">用户名</th>
							<th style="text-align: center">姓名</th>
							<th style="text-align: center">性别</th>
							<th style="text-align: center">出生日期</th>
							<th style="text-align: center">联系方式</th>
							<th style="text-align: center">联系地址</th>
							<th style="text-align: center">注册日期</th>
						</tr>
					</thead>
					<c:forEach items="${usersList}" var="users">
						<tr align="center">
							<td>${users.username}</td>
							<td>${users.realname}</td>
							<td>${users.sex}</td>
							<td>${users.birthday}</td>
							<td>${users.contact}</td>
							<td>${users.address}</td>
							<td>${users.regdate}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</fieldset>
		<blockquote class="layui-elem-quote" style="text-align: right">
			<form action="users/queryUsersByCond.action" name="myform"
				method="post">
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">查询条件</label>
						<div class="layui-input-block">
							<select name="cond" class="layui-input">
								<option value="username">按用户名查询</option>
								<option value="password">按密码查询</option>
								<option value="realname">按姓名查询</option>
								<option value="sex">按性别查询</option>
								<option value="birthday">按出生日期查询</option>
								<option value="contact">按联系方式查询</option>
								<option value="address">按联系地址查询</option>
								<option value="regdate">按注册日期查询</option>
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
