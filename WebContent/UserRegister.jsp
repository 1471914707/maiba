<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
	<link rel="shortcut icon" href="image/logo.png" />
   <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
   <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
   <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="JS/comm.js"></script>
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
	if ((!myform.age.value.match(/^\d+$/)) || myform.age.value < 0 || myform.age.value > 150){
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

#reTable{
	position: relative;
	top:10px;
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
<body>
<%@include file="/include/header.jsp" %>
<br><br>
<form action="${pageContext.request.contextPath}/servlet/HandleUserRegister" method="post" name="myform">
<p id="tip"></p>
<table id="reTable" cellspacing="0" cellpadding="5px">
<tr>
<th colspan="4" id="reTable_head_footer" style="text-align:center">用户注册</th>
</tr>
<tr>
<td id="reTable_left">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
<td colspan="3"><input name="account" type="text" id="reInput" ><span style="color: red;">*</span></td>
</tr>
<tr>
<td id="reTable_left">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
<td colspan="3"><input name="password" type="password" id="reInput" ><span style="color: red;">*</span></td>
</tr>
<tr>
<td id="reTable_left">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：</td>
<td colspan="3"><input name="userName" type="text" id="reInput"></td>
</tr>
<tr>
<td id="reTable_left">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：</td>
<td colspan="3"><input name="age" type="text" id="reInput" ></td>
</tr>
<tr>
<td id="reTable_left">电子邮件：</td>
<td colspan="3"><input name="email" type="text" id="reInput" ></td>
</tr>
<tr>
<td colspan="4" id="reTable_head_footer"><center>
<input value="注册" type="submit" onclick="return Check()">
</center></td>
</tr>
</table>
</form>
<%@include file="/include/Footer.jsp" %>
</body>
</html>