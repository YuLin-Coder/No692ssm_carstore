<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎使用汽车销售系统</title>
<link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="css/global.css" media="all">
<link rel="stylesheet" href="plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="css/table.css" />
<script type="text/javascript" src="plugins/layui/layui.js"></script>
<script type="text/javascript" src="plugins/layui/controller.js"></script>
<script src="echart/jquery-1.11.1.min.js" charset="UTF-8"></script>
<script src="echart/echarts.min.js" charset="UTF-8"></script>
<script src="echart/chartOrders.js" charset="UTF-8"></script>
</head>
<body>
	<div class="admin-main">

		<blockquote class="layui-elem-quote">
			<div class="layui-card-body">
				<div class="layui-form layui-col-space5">
					<div class="layui-inline layui-show-xs-block">
						<input type="text" name="start" class="layui-input" id="start" onclick="layui.laydate({elem: this})" readonly="readonly"
							placeholder="请输入开始日期" />
					</div>
					<div class="layui-inline layui-show-xs-block">
						<input type="text" name="end" class="layui-input" id="end" onclick="layui.laydate({elem: this})" readonly="readonly"
							placeholder="请输入结束日期" />
					</div>
					<div class="layui-inline layui-show-xs-block">
						<button class="layui-btn" title="查询" id="sub">
							<i class="layui-icon">&#xe615;</i> 查询
						</button>
					</div>
					<div class="layui-inline layui-show-xs-block">
						<button class="layui-btn layui-btn-normal" onclick="location.reload()" title="刷新">
							<i class="layui-icon layui-icon-refresh"></i> 刷新
						</button>
					</div>
				</div>
			</div>
		</blockquote>
		<fieldset class="layui-elem-field">
			<legend>订单统计</legend>
			<div class="layui-field-box layui-form">
				<table class="layui-table">
					<tr align="center">
						<td><div class="text-center" id="chartmain" style="width: 99%; height: 600px;"></div></td>
					</tr>
				</table>
			</div>
		</fieldset>
		<input type="hidden" name="basepath" id="basepath" value="<%=basePath%>">
	</div>
</body>
</html>

