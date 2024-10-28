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
			<legend>汽车商品数据查询</legend>
			<div class="layui-field-box layui-form">
				<table class="layui-table">

					<thead>
						<tr>
							<th style="text-align: center">商品名称</th>
							<th style="text-align: center">汽车类型</th>
							<th style="text-align: center">品牌</th>
							<th style="text-align: center">型号</th>
							<th style="text-align: center">尺寸</th>
							<th style="text-align: center">座位数</th>
							<th style="text-align: center">颜色</th>
							<th style="text-align: center">供应商</th>
							<th style="text-align: center">货架</th>
							<th style="text-align: center">价格</th>
							<th style="text-align: center">库存</th>
							<th style="text-align: center">销售量</th>
							<th style="text-align: center">点击量</th>
							<th style="text-align: center">是否推荐</th>
							<th style="text-align: center">是否特价</th>
							<th style="text-align: center">上架时间</th>
						</tr>
					</thead>
					<c:forEach items="${goodsList}" var="goods">
						<tr align="center">
							<td>${goods.goodsname}</td>
							<td>${goods.catename}</td>
							<td>${goods.brand}</td>
							<td>${goods.type}</td>
							<td>${goods.size}</td>
							<td>${goods.seating}</td>
							<td>${goods.color}</td>
							<td>${goods.supname}</td>
							<td>${goods.racksno}</td>
							<td>${goods.price}</td>
							<td>${goods.storage}</td>
							<td>${goods.sellnum}</td>
							<td>${goods.hits}</td>
							<td>${goods.recommend}</td>
							<td>${goods.special}</td>
							<td>${goods.addtime}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</fieldset>
		<blockquote class="layui-elem-quote" style="text-align: right">
			<form action="goods/queryGoodsByCond.action" name="myform"
				method="post">
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">查询条件</label>
						<div class="layui-input-block">
							<select name="cond" class="layui-input">
								<option value="goodsname">按商品名称查询</option>
								<option value="cateid">按汽车类型查询</option>
								<option value="brand">按品牌查询</option>
								<option value="type">按型号查询</option>
								<option value="size">按尺寸查询</option>
								<option value="seating">按座位数查询</option>
								<option value="image">按图片查询</option>
								<option value="color">按颜色查询</option>
								<option value="supplierid">按供应商查询</option>
								<option value="racksid">按货架查询</option>
								<option value="price">按价格查询</option>
								<option value="storage">按库存查询</option>
								<option value="sellnum">按销售量查询</option>
								<option value="hits">按点击量查询</option>
								<option value="recommend">按是否推荐查询</option>
								<option value="special">按是否特价查询</option>
								<option value="addtime">按上架时间查询</option>
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
