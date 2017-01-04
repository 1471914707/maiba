<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cn.maiba.*,java.util.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>用户列表</title>
	<link rel="shortcut icon" href="../image/logo.png" />
   <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
   <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
   <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script type="text/javascript">
function check(){
	if (myform.index.value=="" || !myform.index.value.match(/^\d+$/))
		return false;
	return true;
}
</script>
<style type="text/css">
#reTable{
	position: relative;
	top:30px;
	width: 700px;
}
#reTable td{
	border:1px solid #99ccff;
	}
#reTable th{
	background-color:#99bcfc;
	}
#Table_header{
	background-color: #e8eef7;
}
#numInput{
	width: 40px;
	height: 20px;
}

#index{
	text-decoration: none;
	color: black;
}
#index2:VISITED{
	color:#2081d2;
}
</style>
</head>
<body>
<%@include file="/include/header.jsp" %>
<br />
&nbsp;&nbsp;&nbsp;&nbsp;<span style="font-size:20px;color:#2081d2;font-weight: bold;">用户管理</span>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/login/HandleMyArticle">我发表的帖子</a>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/login/getMyComment">我评论的帖子</a>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/login/GoModelManage">板块管理</a>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/login/HanleNotices">公告管理</a>
<br />
<div align="center">
<c:if test="${sessionScope.UserType.id==1 }">
<table id="reTable" cellspacing="0" cellpadding="5px">
<th colspan="5" id="reTable_head_footer">用户列表
<div style="float: right;padding-right: 5px;text-decoration: underline;"><a href="${pageContext.request.contextPath }/UserRegister.jsp">新增用户</a></div>
</th>
<tr id="Table_header">
<td>ID</td>
<td>账号</td>
<td>密码</td>
<td>昵称</td>
<td>操作</td>
</tr>
<c:forEach items="${userList}" var="user">
	<tr bgcolor="white">
		<td>${user.id}</td>
		<td><a href="${pageContext.request.contextPath }/user/GetUserDetail?userId=${user.id}">${user.account}</a> </td>
		<td>${user.password }</td>
		<td>${user.userName}</td>
		<td><a href="${pageContext.request.contextPath }/user/GetUserDetail?userId=${user.id}">查看</a>，<a href="${pageContext.request.contextPath }/user/GetUserModify?userId=${user.id}">修改</a>，
	<a href="${pageContext.request.contextPath}/servlet/HandleDelete?userId=${user.id}">删除</a></td>
	</tr>
</c:forEach>
</table>
<br /><br /><c:if test="${Tab.totalCount!=0 }">
<ul class="pagination">
<li><a href="${pageContext.request.contextPath}/HandleTab?index=1">首页</a></li>
<c:if test="${Tab.index != 1}">
	<li><a href="${pageContext.request.contextPath}/HandleTab?index=${Tab.index-1}">&laquo;</a></li>
</c:if>
<c:forEach var="j" begin="${Tab.begin}" end="${Tab.end}">
<c:choose>  
 <c:when test="${j == Tab.index }">
 	<li class="active"><a href="${pageContext.request.contextPath}/HandleTab?index=${Tab.index}"> ${Tab.index }</a></li>
</c:when>  
<c:otherwise>
	<li><a href="${pageContext.request.contextPath}/HandleTab?index=${j }">${j }</a></li>
</c:otherwise>  
</c:choose>  
</c:forEach>
<c:if test="${Tab.index!=Tab.pageCount }">
	<li><a href="${pageContext.request.contextPath}/HandleTab?index=${Tab.index+1}">&raquo;</a></li>
</c:if>
<li><a href="${pageContext.request.contextPath}/HandleTab?index=${Tab.pageCount}">尾页</a></li>
</ul><br>
<form action="${pageContext.request.contextPath}/HandleTab" name="myform">
第<input type="number" max="${Tab.pageCount }" min="1" id="numInput" name="index" value="${Tab.index }">页
&nbsp;&nbsp;<input type="submit" value="跳转" onclick="return check()">
</form>&nbsp;&nbsp;<br />
共<span style="color:red;"><b>${Tab.pageCount }</b></span>页，<span style="color:red;"><b>${Tab.totalCount }</b></span>条记录！</c:if>
</c:if>
<c:if test="${sessionScope.UserType.id!=1 }">
该功能只对超级管理员开放
</c:if>
</div>
<%@include file="/include/Footer.jsp" %>
</body>
