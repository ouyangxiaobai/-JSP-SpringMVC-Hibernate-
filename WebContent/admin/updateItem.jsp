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
            <li><a href="#">景点管理</a></li>
            <li><a href="#">编辑景点</a></li>
        </ul>
    </div>
</div>
    
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default wk-panel ">
                <div class="panel-heading">
                    编辑景点 Create Data
                </div>
                <form action="<%=basePath%>/editItem/${item.id}.html" method="POST">
                <div class="panel-body">
                    <div class="row">
                      <div class="form-inline">  
                            <div class="form-group">
                                <label for="filePath" class="control-label wk-filed-label">景点名称: </label>
                                 <div class="input-group">
                                    <input required="required" value="${item.name}" name="name" type="text" class="form-control wk-normal-input" id="mark" placeholder="请输入景点名称"/>
                                </div>
                            </div>
                            
                             <div class="form-group">
                                <label for="filePath" class="control-label wk-filed-label">所属城市: </label>
                                 <div class="input-group">
                                    <input required="required" value="${item.city}" name="city" type="text" class="form-control wk-normal-input" id="mark" placeholder="请输入景点名称"/>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label for="filePath" class="control-label wk-filed-label">景点地址: </label>
                                <div class="input-group">
                                    <input required="required" value="${item.address}" name="address" type="address" class="form-control wk-long-2col-input"  placeholder="请输入景点地址"/>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label for="filePath" class="control-label wk-filed-label">门票价格: </label>
                                <div class="input-group">
                                    <input required="required" value="${item.price}" name="price" type="number" class="form-control wk-normal-input"  placeholder="请输入门票价格"/>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label for="filePath" class="control-label wk-filed-label">旅游天数: </label>
                                <div class="input-group">
                                    <input required="required" value="${item.days}" name="days" type="number" class="form-control wk-normal-input"  placeholder="请输入旅游天数"/>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label for="filePath" class="control-label wk-filed-label">景点特色: </label>
                                <div class="input-group">
                                    <input required="required" value="${item.feature}" name="feature" type="text" class="form-control wk-long-2col-input"  placeholder="请输入景点特色"/>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label for="filePath" class="control-label wk-filed-label">景点介绍: </label>
                                <div class="input-group">
                                    <input required="required" value="${item.intro}" name="intro" type="text" class="form-control wk-long-2col-input"  placeholder="请输入景点介绍"/>
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