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
	
	<div class="row" style="margin-top:20px;"> 
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<div class="row">
				<div class="col-sm-4"><img alt="" src="<%=basePath%>images/${item.path}" width="100%"/></div> 
				<div class="col-sm-8">   
					<p class="bm2_title">${item.name}</p>
					<p class="bm2_address">景点地址: ${item.address}</p>
					<p  class="bm2_address">门票价格: <font class="bm2_price">${item.price}</font> ￥</p>
					<p  class="bm2_address">旅游天数: ${item.days} 天</p> 
					<p  class="bm2_address">景点特色: ${item.feature}</p>
				</div>
			</div>
		</div>
		<div class="col-sm-2"></div>
	</div>
	
	<div class="row" style="margin-top:60px; margin-bottom:40px;">    
		<div class="col-sm-2"></div>
		<div class="col-sm-8 bm2_br">--- 景点介绍 ---</div> 
		<div class="col-sm-2"></div>
	</div>
	
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8 bm2_content">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${item.intro} 
		</div> 
		<div class="col-sm-2"></div>
	</div>
	
	<div class="row" style="margin-top:60px; margin-bottom:40px;">    
		<div class="col-sm-2"></div>
		<div class="col-sm-8 bm2_br">--- 景点美图 ---</div> 
		<div class="col-sm-2"></div>
	</div>
	
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8"> 
			<img alt="" src="<%=basePath%>images/${item.path}" width="100%"/>
		</div> 
		<div class="col-sm-2"></div>
	</div>
	
	<div class="row" style="margin-top:60px; margin-bottom:40px;">    
		<div class="col-sm-2"></div>
		<div class="col-sm-8 bm2_br">--- 景点美食 ---</div> 
		<div class="col-sm-2"></div>
	</div>
	
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<c:forEach items="${foods}" var="var">
				<div class="col-sm-3">
					<img alt="" src="<%=basePath%>images/${var.path}" width="100%"/>
					<p class="bm_title">${var.name}</p>
				</div>
			</c:forEach>
		</div>
		<div class="col-sm-2"></div> 
	</div>
	
	
	<div class="row" style="margin-top:60px; margin-bottom:80px;">    
		<div class="col-sm-2"></div>
		<div class="col-sm-8 bm2_br">--- 景点评论 ---</div> 
		<div class="col-sm-2"></div>
	</div>
	
	<c:forEach items="${comments}" var="var">
		<div class="row" style="margin-top:50px; margin-bottom:50px;">  
			<div class="col-sm-2"></div>
			<div class="col-sm-8" style="border-bottom:solid 1px #CCC">
				<div class="col-sm-6" style="font-size:24px;">
					${var.user.account}
				</div>
				<div class="col-sm-6" style="font-size:18px;">
					${var.recordTime}
				</div>
				<div class="col-sm-12" style="margin-top:30px; margin-bottom:30px; font-size:18px;">
					${var.content}
				</div> 
			</div>
			<div class="col-sm-2"></div> 
		</div>
	</c:forEach>
	
	<form action="<%=basePath%>saveComment/${item.id}.html" method="POST">
		<div class="row">
			<div class="col-sm-2"></div> 
			<div class="col-sm-8"> 
				<input name="content" placeholder="请输入评论" type="text" style="width:99%; padding-left:10px; height:300px; font-size:22px;line-height:22px; border:none; border:solid 1px #CCC"/> 
			</div>
			<div class="col-sm-2"></div> 
		</div>
		
		<div class="row">
			<div class="col-sm-2"></div> 
			<div class="col-sm-8">
				<input type="submit" style="width:99%; height:45px; border:none; background:#1E9FD9; margin-top:30px; margin-bottom:50px; color:#FFF" value="提交"/> 
			</div>
			<div class="col-sm-2"></div> 
		</div>
	</form>
	
	<div class="row">
		<div class="col-sm-12 footer">©长途旅游网毕业设计 2018</div>
	</div>
</body>