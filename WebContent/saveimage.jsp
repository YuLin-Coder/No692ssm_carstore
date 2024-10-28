<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta charset="UTF-8">
<title>汽车销售系统</title>
<link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="plugins/font-awesome/css/font-awesome.min.css">
<script type="text/javascript" src="plugins/layui/layui.js"></script>
<script type="text/javascript" src="plugins/layui/controller.js"></script>
<script type="text/javascript">
	function selok() {
		opener.document.getElementById("image").value = myform.p.value;
		window.close();
	}
</script>
</head>
<body>
	<div style="margin: 15px;">
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
			<legend>文件上传</legend>
		</fieldset>
		<form id="addForm" class="layui-form" action="upload/image.action" name="myform" method="post"
			enctype="multipart/form-data">
			<div class="layui-form-item">
				<div class="layui-input-inline" style="width: 45%;">
					<input type="file" name="image" class="layui-input" id="image" />
				</div>
			</div>
			<c:if test="${imageFileName ne null }">
				<div class="layui-form-item">
					<label class="layui-form-label">${imageFileName }</label>
					<div class="layui-input-inline shortInput">
						<input type="hidden" name="p" value="upfiles/${imageFileName }" id="p" />
						<button class="layui-btn" type="button" onclick="selok();">保存图片</button>
					</div>
				</div>
			</c:if>
			<c:if test="${imageFileName eq null }">
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" type="submit" id="sub">上传图片</button>
					</div>
				</div>
			</c:if>
		</form>
	</div>
</body>
</html>
