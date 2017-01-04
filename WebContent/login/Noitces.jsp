<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告管理</title>
<style type="text/css">
#reTable_head_footer{
	background-color: #99ccff;
}
#left_table{
	background-color: #f1f1f1;
	border-bottom-style: solid;
}
#putTable{
	background-color: #f1f1f1;
}
#right_table{
	background-color: #02fda7;
	border-bottom-style: solid;
}
</style>
</head>
<body>
<%@include file="/include/header.jsp" %>
<br />
&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/login/HanleNotices">用户管理</a>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/login/HandleMyArticle">我发表的帖子</a>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/login/getMyComment">我评论的帖子</a>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/login/GoModelManage">板块管理</a>
&nbsp;&nbsp;&nbsp;&nbsp;<span style="font-size:20px;color:#2081d2;font-weight: bold;">公告管理</span>
<br /><br />
<div align="center">
<c:if test="${sessionScope.UserType.id!=2 and  sessionScope.UserType.id!=3 }">
${Mess }
<div id="NoticeEdit">
<form action="${pageContext.request.contextPath }/login/HanleNotices" method="post">
<table id="putTable">
	<tr><th>发布公告</th></tr>
	<tr><td>标题：</td><td><input type="text" name="title"></td></tr>
	<tr><td>内容：</td><td><textarea rows="4" cols="21" name="content"  id="textarea"></textarea></td></tr>
	<tr><td>时间：</td><td><input type="number" name="time" min="0"><b>h</b></td></tr>
	<tr><td></td><td><input type="submit" value="发布"></td></tr>
</table>
</form>
</div>
<c:if test="${Tab.totalCount!=0 }"><br />
<table id="reTable" cellspacing="0" cellpadding="5px">
<th colspan="5" id="reTable_head_footer">公告列表
</th>
<c:forEach items="${noticeList }" varStatus="s" var="notice">
<tr>
<td colspan="3" id="left_table">
${notice.id }.<b>标题</b><br />${notice.title }<br />
<b>开始时间</b><br />${notice.starttime }<br />
<b>结束时间</b><br />${notice.endtime }<br />
<a href="${pageContext.request.contextPath }/login/NoticeDelete?id=${notice.id}">删除</a>
<td colspan="3" id="right_table">
	<b>${notice.content }</b><br />
</td>
</tr>
</c:forEach>
</table>
</c:if>
<br /><br />
<c:if test="${Tab.totalCount >0 }">
<ul class="pagination">
<li><a href="${pageContext.request.contextPath}/login/HanleNotices?index=1">首页</a></li>
<c:if test="${Tab.index != 1}">
	<li><a href="${pageContext.request.contextPath}/login/HanleNotices?index=${Tab.index-1}">&laquo;</a></li>
</c:if>
<c:forEach var="j" begin="${Tab.begin}" end="${Tab.end}">
<c:choose>  
 <c:when test="${j == Tab.index }">
 	<li class="active"><a href="${pageContext.request.contextPath}/login/HanleNotices?index=${Tab.index}"> ${Tab.index }</a></li>
</c:when>  
<c:otherwise>
	<li><a href="${pageContext.request.contextPath}/login/HanleNotices?index=${j }">${j }</a></li>
</c:otherwise>  
</c:choose>  
</c:forEach>
<c:if test="${Tab.index!=Tab.pageCount }">
	<li><a href="${pageContext.request.contextPath}/login/HanleNotices?index=${Tab.index+1}">&raquo;</a></li>
</c:if>
<li><a href="${pageContext.request.contextPath}/login/HanleNotices?index=${Tab.pageCount}">尾页</a></li>
</ul><br>
<form action="${pageContext.request.contextPath}/login/HanleNotices" name="myform">
第<input type="number" max="${Tab.pageCount }" min="1" id="numInput" name="index" value="${Tab.index }">页
&nbsp;&nbsp;<input type="submit" value="跳转" onclick="return check()">
</form>&nbsp;&nbsp;<br />
共<span style="color:red;"><b>${Tab.pageCount }</b></span>页，<span style="color:red;"><b>${Tab.totalCount }</b></span>条记录！
</c:if>
</c:if>
</div>
<%@include file="/include/Footer.jsp" %>
</body>