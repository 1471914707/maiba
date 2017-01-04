<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>贴子列表</title>
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
#tr2{
	background-color: #ececf4;
}
#index{
	text-decoration: none;
	color: black;
}
#index2:VISITED{
	color:#2081d2;
}
#numInput{
	width: 25px;
}
#reTable a{
	text-decoration: underline;
}
</style>
</head>
<body>
<%@include file="/include/header.jsp" %>
<div align="center"  id="infotable">
<table id="reTable" cellspacing="0" cellpadding="5px">
<tr>
<th colspan="5" id="reTable_head_footer">麦吧文章列表
<div style="position: absolute;right: 20px;top:5px;"><a href="${pageContext.request.contextPath }/login/HandleGoArticelNew">新建帖子</a></div>
</th>
</tr>
<tr id="tr2"><td>点击数</td><td>回复数</td><td>标题</td><td>作者</td><td>最后回复时间</td></tr>
<c:forTokens items="${sbs }" delims="&" var="sb" varStatus="s">
		<tr bgcolor="white">
		<td>${articleList[s.index].pageView }</td>
		<td>${articleList[s.index].replyCount }</td>
		<td><b><a href="${pageContext.request.contextPath }/HandleArticleDetail?articleId=${articleList[s.index].id}">${articleList[s.index].title }</a></b></td>
		<td>${sb }</td>
		<td>${articleList[s.index].lastTime }</td>
	</tr>
</c:forTokens>
</table>

<br /><br />
<c:if test="${Tab.totalCount!=0 }">
<ul class="pagination">
<li><a href="${pageContext.request.contextPath}/HandleArticleList?index=1">首页</a></li>
<c:if test="${Tab.index != 1}">
	<li><a href="${pageContext.request.contextPath}/HandleArticleList?index=${Tab.index-1}">&laquo;</a></li>
</c:if>
<c:forEach var="j" begin="${Tab.begin}" end="${Tab.end}">
<c:choose>  
 <c:when test="${j == Tab.index }">
 	<li class="active"><a href="${pageContext.request.contextPath}/HandleArticleList?index=${Tab.index}"> ${Tab.index }</a></li>
</c:when>  
<c:otherwise>
	<li><a href="${pageContext.request.contextPath}/HandleArticleList?index=${j }">${j }</a></li>
</c:otherwise>  
</c:choose>  
</c:forEach>
<c:if test="${Tab.index!=Tab.pageCount }">
	<li><a href="${pageContext.request.contextPath}/HandleArticleList?index=${Tab.index+1}">&raquo;</a></li>
</c:if>
<li><a href="${pageContext.request.contextPath}/HandleArticleList?index=${Tab.pageCount}">尾页</a></li>
</ul><br>
<form action="${pageContext.request.contextPath}/HandleArticleList" name="myform">
第<input type="number" max="${Tab.pageCount }" min="1" id="numInput" name="index" value="${Tab.index }">页
&nbsp;&nbsp;<input type="submit" value="跳转" onclick="return check()">
</form>&nbsp;&nbsp;<br />
共<span style="color:red;"><b>${Tab.pageCount }</b></span>页，<span style="color:red;"><b>${Tab.totalCount }</b></span>条记录！</c:if>
</div>
<%@include file="/include/Footer.jsp" %>
</body>