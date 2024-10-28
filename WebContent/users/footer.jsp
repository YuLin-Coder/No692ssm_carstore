<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<div id="footer">
	<div class="footer">
		<div class="footer_nav_box">
			<div class="footer_copyright">
				<span> &copy; 版权所有 <a href="admin/index.jsp" target="_blank">后台管理入口</a>
				</span>
			</div>
		</div>
	</div>
</div>