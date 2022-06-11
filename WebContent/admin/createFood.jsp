<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>企业信息管理平台</title> 
	<base href="<%=basePath%>">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" >    
	<link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">
	<script type="text/javascript" src="lib/jquery-3.1.1.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/wukong-ui.css">
	<link rel="stylesheet" href="css/bootstrap-select.min.css">
    <script type="text/javascript" src="bootstrap/js/bootstrap-select.min.js"></script>
</head>

<body>
<div class="row">
    <div class="col-lg-12">
        <ul class="breadcrumb wk-breadcrumb">
            <li><a href="#">后台管理系统</a></li>
            <li><a href="#">美食管理</a></li>
            <li><a href="#">新增美食</a></li>
        </ul>
    </div>
</div>
    
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default wk-panel ">
                <div class="panel-heading">
                    新增美食 Create Data
                </div>
                <form action="<%=basePath%>/saveFood.html" method="POST">
                <div class="panel-body">
                    <div class="row">
                      <div class="form-inline">  
                      
                            <div class="form-group">
                                <label  class="control-label wk-filed-label">美食名称: </label>
                                 <div class="input-group">
                                    <input required="required" name="name" type="text" class="form-control wk-normal-input" id="mark" placeholder="请输入美食名称"/>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label  class="control-label wk-filed-label">所属景点: </label>
                                <div class="input-group">
                                    <select class="wk-select" name="item.id">
                                    	<c:forEach items="${items}" var="var">
                                    		<option value="${var.id}">${var.name}</option>
                                    	</c:forEach>
                                    </select>
                                </div>
                            </div>
                            
                        </div>

                    </div>
                 </div>

                <div class="panel-footer wk-panel-footer">
                    <button type="submit" class="btn btn-default wk-btn">提&nbsp;&nbsp;交</button>
                </div>
                </form>
            </div>
        </div>
    </div>

</body>
</html>