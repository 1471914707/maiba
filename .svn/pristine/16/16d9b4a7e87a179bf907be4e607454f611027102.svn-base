<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改帖子</title>
<script type="text/javascript">
function ready(){
	obj = document.getElementsByName("readpower");
	for(i=0;i<obj.length;i++){
	  if(obj[i].value == "${article.readpower}")
	    obj[i].checked = true;
	}
	obj1 = document.getElementsByName("articletype");
	for(i=0;i<obj1.length;i++){
	  if(obj1[i].value == "${article.type}")
	    obj1[i].checked = true;
	}
	obj2 = document.getElementsByName("commentpower");
	for(i=0;i<obj2.length;i++){
	  if(obj2[i].value == "${article.commentpower}")
	    obj2[i].checked = true;
	}
}
function toCancel(){
	window.open("article-list.jsp","_self");
}
function Check() {

	if (myform.title.value == ""){
		alert("标题不能为空.....");
		return false;
	}
	if (myform.content.value == "" || myform.content.value.length < 6){
		alert("文章内容不能为空且长度大于6位.....");
		return false;
	}
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
<body onload="ready()">
<%@include file="/include/header.jsp" %><br >
<div id="Main">
<div id="putContent">修改帖子</div>
<div id="contentMain">
<form action="${pageContext.request.contextPath}/login/HandleArticleUpdate" method="post" name="myform">
标题<br />
<input type="text" size="190" name="title" value="${article.title }">
<br  />
内容<br />
<textarea rows="4" cols="10" name="content" >${article.content }</textarea>
<script type="text/javascript">CKEDITOR.replace('content')</script>
<input type="hidden" value="${article.id }" name="id">
<br />选择板块：
<c:forEach items="${articletypes }" var="type">
	<label><input name="articletype" type="radio" value="${type.id }"/>${type.name }</label> &nbsp;&nbsp;
</c:forEach>
<br />阅读权限：
<label><input name="readpower" type="radio" value="1"  checked/>默认</label> &nbsp;&nbsp;
<label><input name="readpower" type="radio" value="2"/>存为草稿</label> &nbsp;&nbsp;
<label><input name="readpower" type="radio" value="3" />限制游客</label> &nbsp;&nbsp;
<label><input name="readpower" type="radio" value="4" />好友可见</label> &nbsp;&nbsp;
 <br />评论权限：
 <label><input name="commentpower" type="radio" value="1" />默认</label> &nbsp;&nbsp;
   <label><input name="commentpower" type="radio" value="2" />允许好友评论</label> &nbsp;&nbsp;
  <label><input name="commentpower" type="radio" value="3" />不可评论</label>&nbsp;&nbsp;<br /> 
<input value="发表" type="submit" onclick="return Check()">
<input value="取消" type="button" onclick="toCancel()">
</form>
</div>
</div>
<%@include file="/include/Footer.jsp" %>
</body>