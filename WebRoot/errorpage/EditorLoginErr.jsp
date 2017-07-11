<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>编辑者登录错误页面</title>
</head>
<body>
<p>编辑者登录错误页面</p>
<h3>编辑者登录错误，网页将于3秒后重新跳转到登录页面</h3>
<%
    response.setHeader("Refresh", "3;URL=../editorjsp/EditorLogin.jsp");
%>
</body>
</html>