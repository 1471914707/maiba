<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cn.maiba.*"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>具体信息</title>
	<link rel="shortcut icon" href="../image/logo.png" />

<script type="text/javascript">
	function handle_modify(){	
		window.location.href="${pageContext.request.contextPath}/user/GetUserModify?userId=${user1.id}";
	}

	function handle_delete(){		
		window.location.href="${pageContext.request.contextPath}/servlet/HandleDelete?userId=${user1.id}";
	}

	function handle_list_user(){		
		window.location.href="${pageContext.request.contextPath}/HandleTab";
	}
</script>


<style type="text/css">
#infotable{
	position: relative;
	top:20px;
}
#reTable td{
	border:1px solid #99ccff;
	}
#reInput{
	width: 300px;
	height: 25px;
	border:1px solid #99ccff;
}
#reTable_head_footer{
	background-color: #99ccff;
}
#reTable_left{
	background-color: #f1f1f1;
}
#articles{
	margin-left: 20px;
	margin-top: 20px;
	}
#articles a{
	text-decoration: underline;
}
</style>
</head>
<body>
<%@include file="/include/header.jsp" %>
<!-- 忘记了权限的查看 -->
<div align="center"  id="infotable">
<table id="reTable" cellspacing="0" cellpadding="5px">
<tr>
<th colspan="4" id="reTable_head_footer"><center>具体信息</center></th>
</tr>
<tr>
<td id="reTable_left">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
<td colspan="3">${user1.account }</td>
</tr>
<tr>
<td id="reTable_left">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：</td>
<td colspan="3">${user1.userName }</td>
</tr>
<tr>
<td id="reTable_left">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：</td>
<td colspan="3">${user1.age }</td>
</tr>

<tr>
<td id="reTable_left">用户等级：</td>
<td colspan="3">${userLevel.name }</td>
</tr>

<tr>
<td id="reTable_left">用户角色：</td>
<td colspan="3">${typename }</td>
</tr>
<c:if test="${sessionScope.UserType.id==1 }">
<tr>
<td id="reTable_left">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
<td colspan="3">${user1.password }</td>
</tr>
<tr>
<td id="reTable_left">电子邮件：</td>
<td colspan="3">${user1.email }</td>
</tr>
<tr>
<td colspan="4" id="reTable_head_footer"><center>
<input value="修改" type="button" onclick="handle_modify()">
<input value="删除" type="button" onclick="handle_delete()">
<input value="返回" type="button" onclick="handle_list_user()">
</center></td>
</tr>
</c:if>
</table><br /></div>
<div id="articles">
<b>已发帖子</b><br /><ol>
	<c:forEach items="${list }" var="item">
		<li><a href="${pageContext.request.contextPath}/HandleArticleDetail?articleId=${item.id}">${item.title }</a></li>
	</c:forEach></ol>
</div>
<%@include file="/include/Footer.jsp" %>
</body>