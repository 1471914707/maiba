<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Header</title>
   <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
   <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
   <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<style type="text/css">
#header{
	height: 30px;
	width: 100%;
}

td {padding-left: 20px;}
#nav{
position:relative;
	width: 100%;
	height: 40px;
	top:10px;
	padding: 10px 0px 0px 5px;	
	background-color: #ebe8e8;
}
#nav_table{
	position: relative;
	top:-18px;
	padding-right:10px;
}
</style>
	<link rel="shortcut icon" href="../image/logo.png" />
</head>
<body>
<div style="position: relative;top:5px;text-align: center;">
<div style="margin: 0 auto;width: 350px;margin-bottom:-45px;"><img alt="logo" src="${pageContext.request.contextPath}/image/biglogo.png" ></div>
<div id="header" align="right">
<form action="${pageContext.request.contextPath}/HandleUserSearch" method="post">
<table>
<tr>
<td rowspan="2">
<input type="text" name="searchContent">
</td>
<td><select name="select">
<option value="content">内容</option>
<option value="user">用户</option>
<option value="title">标题</option>
</select></td>
<td><input type="submit" name="searchVal" value="搜索"></td>
</tr>
</table>
</form>
</div>

<div id="nav">
<div align="left">
<a href="#" style="text-decoration: none;">
<c:choose>  
 <c:when test="${sessionScope.user !=null }">
 	${sessionScope.user.userName }(${sessionScope.UserType.name })，你好！
</c:when>  
<c:otherwise>
	游客，你好！
</c:otherwise>  
</c:choose>  
</a>
</div>
<div id="nav_table" align="right">
<table>
<tr>

<c:choose>  
 <c:when test="${sessionScope.user !=null }">
 	<td><a href="${pageContext.request.contextPath}/index.jsp">麦吧</a></td>
	<td><a href="${pageContext.request.contextPath}/HandleTab">后台管理</a></td>
	<td><a href="${pageContext.request.contextPath}/user/GetUserModify?userId=${sessionScope.user.id}">修改基本信息</a></td>
	<td><a href="${pageContext.request.contextPath }/login/GetUnreadList">新消息<span class="badge pull-right">${sessionScope.UnreadCount>0?sessionScope.UnreadCount:'' }</span></a></td>
 	<td><a href="${pageContext.request.contextPath}/UserLogin.jsp">退出</a></td>
 </c:when>      
<c:otherwise>
	  <td><a href="${pageContext.request.contextPath}/index.jsp">麦吧</a></td>
	<td><a href="${pageContext.request.contextPath}/UserLogin.jsp">登录</a></td>
	<td><a href="${pageContext.request.contextPath}/UserRegister.jsp">注册</a></td>
</c:otherwise>  
</c:choose> 
</tr>
</table>
</div>
</div>
</div>
</body>