<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>畅游网后台管理系统</title>
<script type="text/javascript" src="lib/jquery-3.1.1.js"></script>
<link rel="stylesheet" href="css/wukong-ui.css" />
</head>

<body class="logonBody">
	<form action="<%=basePath%>adminLogon.html" method="POST">
		<div class="logon">
	    	<ul>
	        	<li><input type="text" name="account" placeholder="请输入账户名"/></li>
	            <li><input type="password" name="password" placeholder="请输入登录密码"/></li>
	        </ul>	 
	        <div class="logonTip">
	        	* ${info}
	        </div>
	        <input type="submit" class="logonSubmitBtn" value="登录"/>
	    </div>
	</form>
		
</body>
</html>
