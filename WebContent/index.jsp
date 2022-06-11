<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<base href="<%=basePath%>">
<link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap.min.css" >    
<link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap-theme.min.css">
<script type="text/javascript" src="<%=basePath%>lib/jquery-3.1.1.js"></script>
<script type="text/javascript" src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/wukong-ui.css">
<link rel="stylesheet" href="<%=basePath%>css/wukong-pc.css">
<link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap-select.min.css">
<script type="text/javascript" src="<%=basePath%>bootstrap/js/bootstrap-select.min.js"></script>
</head>
<body>
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8"><img alt="" src="<%=basePath%>images/wb-banner.png" width="100%"/></div>
		<div class="col-sm-2"></div>
	</div>
	

	
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<ul class="nav nav-tabs wk-nav-menu" id="wk-nav-menu">
                <li role="presentation"><a href="<%=basePath%>searchForCity.html" class="wk-main-menu-item">按城市名称搜索</a></li>
                <li role="presentation"><a href="<%=basePath%>searchForItem.html" class="wk-main-menu-item">按景点名称搜索</a></li>
                <c:choose>
	          		<c:when test="${sessionScope.user == null}">
	          			<li role="presentation"><a href="<%=basePath%>logon.html" class="wk-main-menu-item">游客登录</a></li>
	          			<li role="presentation"><a href="<%=basePath%>register.html" class="wk-main-menu-item">用户注册</a></li>
	          		</c:when>
	          		<c:otherwise>
	          			<li role="presentation"><a href="<%=basePath%>logout.html" class="wk-main-menu-item">注销登录</a></li> 
	          		</c:otherwise>
	          	</c:choose>
            </ul>
		</div>
		<div class="col-sm-2"></div>
	</div>
	
	<div class="row" style="margin-top:20px; margin-bottom:30px;">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<div class="row">
			
				<c:forEach items="${items}" var="var">
					<div class="col-sm-3" onclick="location.href='<%=basePath%>item/${var.id}.html'">
						<img alt="" src="<%=basePath%>images/${var.path}" width="100%"/>
						<p class="bm_title">${var.name}</p>
					</div>
				</c:forEach>
				
			</div>
		</div>
		<div class="col-sm-2"></div>
	</div>
	
	<div class="row">
		<div class="col-sm-12 footer">©长途旅游网毕业设计 2018</div>
	</div>
</body>
</html>