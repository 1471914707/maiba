<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cn.maiba.*"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改信息</title>
	<link rel="shortcut icon" href="../image/logo.png" />
<script type="text/javascript">
function ready(){
	obj = document.getElementById("type");
	for(i=0;i<obj.length;i++){
	  if(obj[i].value == "${user1.type}")
	    obj[i].selected = true;
	}
}
	function handle_List(){		
		window.location.href="${pageContext.request.contextPath}/HandleTab";
	}
</script>
<script type="text/javascript">

function RunTip(tip){
	  $(
		    	function(){
		    		$("#tip").css({"color":"red","text-align":"center","font-size":"20px"}).text(tip);
					var table = $("#reTable");
					var w = $("#reTable").outerWidth(true);
					var ww = $("#reTable").width();
					table.animate({left:w/2+ww/2-10},200);
					table.animate({left:w/2+ww/2+10},200);
					table.animate({left:w/2+ww/2-10},200);
					table.animate({left:w/2+ww/2+10},200);
					table.animate({left:w/2+ww/2},200);
		    	}
		 );
}
function Check() {
	if (myform.account.value == ""){
	  	RunTip("账号不能为空.....");
		 return  false;
	}
	if (myform.password.value == "" || myform.password.value.length < 6){
		RunTip("密码不能为空且长度大于6位.....");
		return  false;
	}
	if (myform.userName.value == ""){
		RunTip("昵称不能为空.....");
		return  false;
	}
	if ((!myform.age.value.match(/^\d+$/)) || myform.age.value <= 0 || myform.age.value > 150){
		RunTip("年龄必须为数字且大于0和小于150.....");
		return  false;
	}
	if(!myform.email.value.match(/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/)){
		RunTip("请输入正确的邮箱......");	
		return  false;
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

</style>
</head>
<body onload="ready()">
<%@include file="/include/header.jsp" %><br />
<div align="center" id="infotable">
<h3><span style="color:red"><c:out value="${ModTip }"></c:out></span></h3>

<form action="${pageContext.request.contextPath}/servlet/HandleModify?userId=${user1.id}" method="post" name="myform">
<p id="tip"></p>
<table id="reTable" cellspacing="0" cellpadding="5px">
<tr>
<th colspan="4" id="reTable_head_footer"><center>修改信息</center></th>
</tr>
<tr>
<td id="reTable_left">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
<td colspan="3"><input name="account" type="text" id="reInput"  value="${user1.account }">
<input type="hidden" name="account_before" value="${user1.account }">
</td>
</tr>
<tr>
<td id="reTable_left">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
<td colspan="3"><input name="password" type="password" id="reInput"  value="${user1.password }"></td>
</tr>
<tr>
<td id="reTable_left">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：</td>
<td colspan="3"><input name="userName" type="text" id="reInput" value="${user1.userName }"></td>
</tr>
<tr>
<td id="reTable_left">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：</td>
<td colspan="3"><input name="age" type="text" id="reInput"  value="${user1.age }"></td>
</tr>
<tr>
<td id="reTable_left">电子邮件：</td>
<td colspan="3"><input name="email" type="text" id="reInput" value="${user1.email }"></td>
</tr>
<tr>
<td id="reTable_left">用户等级：</td>
<td colspan="3">${userLevel.name }</td>
</tr>

<c:if test="${sessionScope.UserType.id==1 }">
<tr>
<td id="reTable_left">用户角色：</td>
<td colspan="3">
<select name="type" id="type">
<c:forEach items="${typeList }" var="type">
	<option value="${type.id }">${type.name }</option>
</c:forEach>
</select>
</td>
</tr></c:if>
<tr>
<td colspan="4" id="reTable_head_footer"><center>
<input value="修改" type="submit" onclick="return Check()">
<input value="返回" type="button" onclick="handle_List()">
</center></td>
</tr>
</table>
</form>
</div>
<%@include file="/include/Footer.jsp" %>
</body>