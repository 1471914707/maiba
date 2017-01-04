<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提示</title>
	<link rel="shortcut icon" href="image/logo.png" />
   <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
   <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
   <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="/include/header.jsp" %>
<br><br>
<div align="center" id="div1">
<c:out value="${Result_Message }"></c:out>

<c:if test="${Result_TYPE==1 }"> <!-- 你提交的用户不存在，请注册或重新登录！ -->
	<form method="post" action="${pageContext.request.contextPath }/UserLogin.jsp"><br />
	<input type="submit" value="返回" /><br/>
	</form>
</c:if>

<c:if test="${Result_TYPE==2 }"><!-- 你填写的密码不正确，请重新输入！！ -->
	<form method="post" action="${pageContext.request.contextPath }/UserLogin.jsp"><br />
	<input type="submit" value="返回" /><br/>
	</form>
</c:if>

<c:if test="${Result_TYPE==3 }"><!-- 该账号已经被使用，请重新选择一个账号！ -->
	<form method="post" action="${pageContext.request.contextPath }/UserRegister.jsp"><br />
	<input type="submit" value="返回" /><br/>
	</form>
</c:if>

<c:if test="${Result_TYPE==4 }"><!--删除用户成功！  -->
	<form method="post" action="${pageContext.request.contextPath }/HandleTab"><br />
	<input type="submit" value="返回" /><br/>
	</form>
</c:if>

<c:if test="${Result_TYPE==5 }"><!-- 不允许删除自己！ -->
	<form method="post" action="${pageContext.request.contextPath }/HandleTab"><br />
	<input type="submit" value="返回" /><br/>
	</form>
</c:if>

<c:if test="${Result_TYPE==6 }"><!-- 注册信息不符合要求！ -->
	<form method="post" action="${pageContext.request.contextPath }/UserRegister.jsp"><br />
	<input type="submit" value="返回" /><br/>
	</form>
</c:if>

<c:if test="${Result_TYPE==7 }"><!-- 恭喜你！注册成功！！！ -->
	<form method="post" action="${pageContext.request.contextPath }/UserLogin.jsp"><br />
	<input type="submit" value="马上登录" /><br/>
	</form>
</c:if>
<c:if test="${Result_TYPE==8 }"><!-- 登录信息不符合要求！！ -->
	<form method="post" action="${pageContext.request.contextPath }/UserLogin.jsp"><br />
	<input type="submit" value="马上登录" /><br/>
	</form>
</c:if>
<c:if test="${Result_TYPE==9 }"><!-- 新贴信息不符合要求！！ -->
	<form method="post" action="${pageContext.request.contextPath }/handleExistInfo"><br />
	<input type="hidden" value="${title}" name="title1">
	<input type="hidden" value="${content }" name="content1">
	<input type="submit" value="返回" /><br/>
	</form>
</c:if>
<c:if test="${Result_TYPE==10 }"><!-- 发帖符合要求！！ -->
	<form method="post" action="${pageContext.request.contextPath }/HandleArticleList"><br />
	<input type="submit" value="返回" /><br/>
	</form>
</c:if>
<c:if test="${Result_TYPE==11 }"><!-- 更新异常！！ -->
	<form method="post" action="${pageContext.request.contextPath }/HandleArticleDetail?articleId=${id}"><br />
	<input type="submit" value="返回" /><br/>
	</form>
</c:if>
<c:if test="${Result_TYPE==12 }"><!-- 版主删除贴子了！！ -->
	<form method="post" action="${pageContext.request.contextPath }/login/GoModelManage"><br />
	<input type="submit" value="返回" /><br/>
	</form>
</c:if>
<c:if test="${Result_TYPE==13 }"><!-- 删除自己贴子了！！ -->
	<form method="post" action="${pageContext.request.contextPath }/login/HandleMyArticle"><br />
	<input type="submit" value="返回" /><br/>
	</form>
</c:if>
</div>
<%@include file="/include/Footer.jsp" %>
</body>