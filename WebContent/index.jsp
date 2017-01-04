<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
	<link rel="shortcut icon" href="../image/logo.png" />
<style type="text/css">
#mian{ width:940px;padding:10px;margin: 0 auto;position: relative;top:20px;margin-bottom: 800px;} 
#left_mian{ float:left;width:600px;} 
#right_mian{ float:right;width:280px;height:50px;} 
#right_mian a{text-decoration: underline;font-color:black;}
#clear{ clear:both} 
#type_title{
	background-color: #e6ecf8;
	font-weight: bold;
}
#right_mian_head{
	margin-left: 0px;
	background-color: #f6edb2;
	font-weight: bold;
}
#right_mian_body{
	padding-left:8px;
}
</style>
</head>
<body>
<%@include file="/include/header.jsp" %>
<div id="mian">
<c:forEach items="${myList }" var="notice">
	<marquee><font color="#fec501" size=3 ><b>${notice.content }</b></font></marquee><br/>
</c:forEach>

<div id="left_mian">
<c:forEach items="${typelist }" var="type" begin="0" varStatus="s">
<div id="type_title">${type.name }<div style="float: right;margin-right: 5px;text-decoration: underline;"><a href="${pageContext.request.contextPath}/GetModelDetail?typeId=${type.id}">更多</a></div></div>
<c:forEach items="${lists[s.index] }" var="art">
	<div><c:if test="${art.stick==1}"><span style="color: red;font-weight: bold;">顶</span></c:if><a href="${pageContext.request.contextPath}/HandleArticleDetail?articleId=${art.id}" style="text-decoration: underline;">${art.title }</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;评论${art.replyCount}
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;浏览量：${art.pageView }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${art.lastTime }<br /></div>
</c:forEach>
<br />
</c:forEach>
</div>
<div id="right_mian">
<div id="right_mian1" style="background-color: #efeefe;">
<div id="right_mian_head">
今日文章</div>
<div id="right_mian_body">
<c:forEach items="${todayNewList }" var="news" varStatus="s">
	${s.index+1 }.<a href="${pageContext.request.contextPath}/HandleArticleDetail?articleId=${news.id}">${news.title }</a><br />
</c:forEach></div>
</div><br />

<div id="right_mian2" style="background-color: #efeefe;">
<div id="right_mian_head">
明星用户</div>
<div id="right_mian_body" >
<c:forEach items="${superUserList }" var="start" varStatus="s">
	${s.index+1 }.<a href="${pageContext.request.contextPath }/user/GetUserDetail?userId=${start.id}" style="text-decoration: none;color:black;"><b>${start.userName }</b></a><br />
</c:forEach>
</div>
</div><br />

<div id="right_mian3" style="background-color: #efeefe;">
<div id="right_mian_head">
统计信息</div>
<div id="right_mian_body">
文章-${ArticlesCount }<br/>
评论-${CommentCount }<br/>
用户-${UserCount }<br/>
在线-${OnlineCounters }
</div>
</div>
</div>
 <div class="clear"></div><!-- html注释：清除float产生浮动 --> 
</div>
<%@include file="/include/Footer.jsp" %>
</body>