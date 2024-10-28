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
<script type="text/javascript" src="js/goods.js" charset="utf-8"></script>
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
<script type="text/javascript"
	src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>
<body>
	<div style="margin: 15px;">
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>新增汽车商品信息</legend>
		</fieldset>
		<form id="addForm" class="layui-form" action="goods/addGoods.action"
			name="myform" method="post">
			<div class="layui-form-item">
				<label class="layui-form-label">商品名称</label>
				<div class="layui-input-inline" style="width: 45%;">
					<input type="text" name="goodsname" class="layui-input"
						id="goodsname" placeholder="请输入商品名称" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">汽车类型</label>
				<div class="layui-input-inline" style="width: 45%;">
					<select name="cateid" id="cateid"><option value="">---请选择汽车类型--</option>
						<c:forEach items="${cateList}" var="cate">
							<option value="${cate.cateid}">${cate.catename }</option>
						</c:forEach></select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">品牌</label>
				<div class="layui-input-inline" style="width: 45%;">
					<input type="text" name="brand" class="layui-input" id="brand"
						placeholder="请输入品牌" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">型号</label>
				<div class="layui-input-inline" style="width: 45%;">
					<input type="text" name="type" class="layui-input" id="type"
						placeholder="请输入型号" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">尺寸</label>
				<div class="layui-input-inline" style="width: 45%;">
					<input type="text" name="size" class="layui-input" id="size"
						placeholder="请输入尺寸" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">座位数</label>
				<div class="layui-input-inline" style="width: 45%;">
					<input type="text" name="seating" class="layui-input" id="seating"
						placeholder="请输入座位数" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">图片</label>
				<div class="layui-input-inline" style="width: 45%;">
					<input class="layui-input" type="text" name="image" id="image"
						onclick="selimage();" placeholder="请选择图片" readonly="readonly" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">颜色</label>
				<div class="layui-input-inline" style="width: 45%;">
					<input type="text" name="color" class="layui-input" id="color"
						placeholder="请输入颜色" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">供应商</label>
				<div class="layui-input-inline" style="width: 45%;">
					<select name="supplierid" id="supplierid"><option value="">---请选择供应商--</option>
						<c:forEach items="${supplierList}" var="supplier">
							<option value="${supplier.supplierid}">${supplier.supname }</option>
						</c:forEach></select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">货架</label>
				<div class="layui-input-inline" style="width: 45%;">
					<select name="racksid" id="racksid"><option value="">---请选择货架--</option>
						<c:forEach items="${racksList}" var="racks">
							<option value="${racks.racksid}">${racks.racksno }</option>
						</c:forEach></select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">价格</label>
				<div class="layui-input-inline" style="width: 45%;">
					<input type="text" name="price" class="layui-input" id="price"
						placeholder="请输入价格" />
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">是否推荐</label>
				<div class="layui-input-inline shortInput">
					<input type="radio" name="recommend" value="是" title="是" checked>
					<input type="radio" name="recommend" value="否" title="否">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">是否特价</label>
				<div class="layui-input-inline shortInput">
					<input type="radio" name="special" value="是" title="是" checked>
					<input type="radio" name="special" value="否" title="否">
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-input-block">
					<input type="hidden" name="storage" id="storage" value="0" />
					<button class="layui-btn" type="submit" id="sub">立即提交</button>
					<button type="reset" class="layui-btn" id="res">取消重置</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>

