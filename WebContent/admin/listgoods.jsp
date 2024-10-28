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
				style="float: right"><a href="goods/getAllGoods.action"
				class="layui-btn layui-btn-small"> <i class="layui-icon">&#x1002;</i>&nbsp;刷新数据
			</a></span>
		</blockquote>
		<fieldset class="layui-elem-field">
			<legend>汽车商品数据列表</legend>
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
							<th style="text-align: center" width="150">操作</th>
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
							<td><a href="goods/getGoodsById.action?id=${goods.goodsid}">编辑</a>&nbsp;&nbsp;<a
								href="goods/deleteGoods.action?id=${goods.goodsid}"
								onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</fieldset>
	</div>
</body>
</html>

