<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发表帖子</title>
<link rel="shortcut icon" href="image/logo.png" />
<script type="text/javascript">
function toCancel(){
	window.open("${pageContext.request.contextPath}/HandleArticleList","_self");
}
function Check() {
	
	if (myform.title.value == ""){
		alert("标题不能为空.....");
		return false;
	}
/* 	if (myform.content.value.length < 10){
		alert("文章内容不能为空且长度大于10位.....");
		return false;
	} */
	alert("格式正确，提交页面!");
	return true;
}	
</script>
<style type="text/css">
#putContent{
	background-color: #e6edf7;
	font-weight: bold;
	padding-left: 20px;
	padding-top:3px;
	border-top-style:ridge;
	border-bottom-style:dotted;
	border-bottom-width: 1px;
}
#contentMain{
	background-color: #f4f3f1;
		font-weight: bold;
	padding-top: 5px;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
</head>
<body>
<%@include file="/include/header.jsp" %><br >
<div id="Main">
<div id="putContent">发表帖子</div>
<div id="contentMain">
<form action="${pageContext.request.contextPath}/handleArticleNew" method="post" name="myform">
标题<br />
<input type="text" size="190" name="title" value="${title1 }">
<br  />
内容<br />
<textarea rows="4" cols="10" name="content"  id="textarea">${content1 }</textarea>
<script type="text/javascript">CKEDITOR.replace('content')</script>
<br />选择板块：
<c:forEach items="${articletypes }" var="type">
	<label><input name="articletype" type="radio" value="${type.id }"  checked/>${type.name }</label> &nbsp;&nbsp;
</c:forEach>
<br />阅读权限：
<label><input name="readpower" type="radio" value="1"  checked/>默认</label> &nbsp;&nbsp;
<label><input name="readpower" type="radio" value="2"/>存为草稿</label> &nbsp;&nbsp;
<label><input name="readpower" type="radio" value="3" />限制游客</label> &nbsp;&nbsp;
<label><input name="readpower" type="radio" value="4" />好友可见</label> &nbsp;&nbsp;
 <br />评论权限：
 <label><input name="commentpower" type="radio" value="1" checked/>默认</label>
   <label><input name="commentpower" type="radio" value="2" />允许好友评论</label>
  <label><input name="commentpower" type="radio" value="3" />不可评论</label><br />
<input value="发表" type="submit" onclick="return Check()">
<input value="取消" type="button" onclick="toCancel()">
</form>
</div>
</div>
<%@include file="/include/Footer.jsp" %>
</body>