<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${modelName }文章</title>
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
<div align="center"><br/>
<c:forEach items="${myList }" var="notice">
	[公告]<font color="#fec501" size=3><b>${notice.content }</b></font><br/>
</c:forEach>
<table id="reTable" cellspacing="0" cellpadding="5px">
<tr>
<th colspan="5" id="reTable_head_footer">${modelName }文章列表
<div style="position: absolute;right: 20px;top:5px;"><a href="${pageContext.request.contextPath }/login/HandleGoArticelNew">新建帖子</a></div>
</th>
</tr>
<tr id="tr2"><td>点击数</td><td>回复数</td><td>标题</td><td>作者</td><td>最后回复时间</td></tr>
<c:forTokens items="${sbs }" delims="&" var="sb" varStatus="s">
		<tr bgcolor="white">
		<td>${articleList[s.index].pageView }</td>
		<td>${articleList[s.index].replyCount }</td>
		<td><c:if test="${articleList[s.index].stick==1}"><span style="color: red;font-weight: bold;">【顶】</span></c:if>
		<b><a href="${pageContext.request.contextPath }/HandleArticleDetail?articleId=${articleList[s.index].id}">
		${articleList[s.index].title }</a></b></td>
		<td>${sb }</td>
		<td>${articleList[s.index].lastTime }</td>
	</tr>
</c:forTokens>
</table>

<br /><br />
<c:if test="${Tab.totalCount>0 }">
<ul class="pagination">
<li><a href="${pageContext.request.contextPath}/GetModelDetail?index=1&typeId=${typeId}">首页</a></li>
<c:if test="${Tab.index != 1}">
	<li><a href="${pageContext.request.contextPath}/GetModelDetail?index=${Tab.index-1}&typeId=${typeId}">&laquo;</a></li>
</c:if>
<c:forEach var="j" begin="${Tab.begin}" end="${Tab.end}">
<c:choose>  
 <c:when test="${j == Tab.index }">
 	<li class="active"><a href="${pageContext.request.contextPath}/GetModelDetail?index=${Tab.index}&typeId=${typeId}"> ${Tab.index }</a></li>
</c:when>  
<c:otherwise>
	<li><a href="${pageContext.request.contextPath}/GetModelDetail?index=${j }&typeId=${typeId}">${j }</a></li>
</c:otherwise>  
</c:choose>  
</c:forEach>
<c:if test="${Tab.index!=Tab.pageCount }">
	<li><a href="${pageContext.request.contextPath}/GetModelDetail?index=${Tab.index+1}&typeId=${typeId}">&raquo;</a></li>
</c:if>
<li><a href="${pageContext.request.contextPath}/GetModelDetail?index=${Tab.pageCount}&typeId=${typeId}">尾页</a></li>
</ul><br></c:if>
<form action="${pageContext.request.contextPath}/GetModelDetail" name="myform">
<input type="hidden" name="typeId" value="${typeId }">
第<input type="number" max="${Tab.pageCount }" min="1" id="numInput" name="index" value="${Tab.index }">页
&nbsp;&nbsp;<input type="submit" value="跳转" onclick="return check()">
</form>&nbsp;&nbsp;<br />
共<span style="color:red;"><b>${Tab.pageCount }</b></span>页，<span style="color:red;"><b>${Tab.totalCount }</b></span>条记录！
</div>
<%@include file="/include/Footer.jsp" %>
</body>