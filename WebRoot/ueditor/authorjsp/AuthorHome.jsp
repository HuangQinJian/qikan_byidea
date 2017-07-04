<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.text.SimpleDateFormat"%>
<%@include file="AuthorLoginSession.jsp"%>
<%
	Date d = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//String publish_time=sdf.format(d);
	//String path = request.getContextPath();
	//String article_content = request.getParameter("article_content");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章作者主页面</title>
</head>
<link rel="stylesheet" type="text/css" href="../../css/authorhome.css" />
<body>
	<form action="ArticleAddCheck" method="POST" id="form">
		<div id="title">
			文章题目：<input type="text" value="请输入文章题目" name="title">
		</div>
		<div id="detail">
			<div id="author">
				文章作者:
				<p><%=(String) session.getAttribute("name")%></p>
			</div>
			<div id="publish_time">
				<p><%=sdf.format(d)%></p>
			</div>
		</div>
		<script id="container" name="article_content" type="text/plain">
</script>
		<div id="submit">
			<input type="button" id="btn" value="提交" />
		</div>
		<input type="hidden"
			value=<%=(String) session.getAttribute("name")%> name="author">
		<input type="hidden" value=<%=sdf.format(d)%> name="publish_time">
	</form>
</body>
<script type="text/javascript" charset="utf-8"
	src="../lang/zh-cn/zh-cn.js"></script>
<!-- 配置文件 -->
<script type="text/javascript" src="../ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="../ueditor.all.js"></script>
<script type="text/javascript" src="../../js/jquery-2.2.3.js"></script>
<script type="text/javascript">
	/* if (jQuery) {
		alert("jquery");
	} */
	var ue = UE.getEditor('container');
	$("#btn").click(function() {
		//alert("hello");
		$("#form").submit();
	})
</script>
</html>