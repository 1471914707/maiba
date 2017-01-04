<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请先登录</title>
	<link rel="shortcut icon" href="image/logo.png" />
   <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
   <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
   <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script type="text/javascript">
function refreshImage(){
	 document.getElementById('checkcodeimgID').src="${pageContext.request.contextPath}/servImgVal?r=1"+Math.random();
}

function toRegister(){
	window.open("UserRegister.jsp","_self");
}
function Check() {

	if (myform.account.value == ""){
		alert("账号不能为空.....");
		return false;
	}
	if (myform.password.value == "" || myform.password.value.length < 6){
		alert("密码不能为空且长度大于6位.....");
		return false;
	}
	alert("格式正确，提交页面!");
	return true;
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
	width: 150px;
	height: 25px;
	border:1px solid #99ccff;
}
#reTable_head_footer{
	background-color: #99ccff;
}
#reTable_left{
	background-color: #f1f1f1;
}

</style>
</head>
<body>
<%
	session.removeAttribute("user");
%>
<%@include file="/include/header.jsp" %>
<div align="center" id="infotable">
<h3>${Mess }</h3>
<form action="${pageContext.request.contextPath}/servlet/HandleUserLogin" method="post" name="myform">
<table id="reTable" cellspacing="0" cellpadding="5px">
<tr>
<th colspan="4" id="reTable_head_footer"><center>用户登陆</center></th>
</tr>
<tr>
<td id="reTable_left">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
<td colspan="3"><input name="account" type="text" id="reInput" ></td>
</tr>
<tr>
<td id="reTable_left">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
<td colspan="3"><input name="password" type="password" id="reInput" ></td>
</tr>
<c:if test="${sessionScope.verNum <=0 }">
<tr>
<td colspan="4"><input type="text"  name="VerificationCode" id="reInput"><img id="checkcodeimgID" src="<%=request.getContextPath()%>/servImgVal" alt="输入图中数字"><a href="JavaScript:refreshImage()">看不清</a></td>
</tr>
<tr>
</c:if><tr>
<td colspan="4" id="reTable_head_footer"><center>
<input value="登录" type="submit" onclick="return Check()">
<input value="注册" type="button" onclick="toRegister()">
</center></td>
</tr>
</table>
</form>
</div>
<%@include file="/include/Footer.jsp" %>
</body>
</html>