<%--
  Created by IntelliJ IDEA.
  User: 11157
  Date: 2017/7/4
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>专家登录错误页面</title>
</head>
<body>
<p>专家登录错误页面</p>
<h3>专家登录错误，网页将于3秒后重新跳转到登录页面</h3>
<%
    response.setHeader("Refresh", "3;URL=../expertorjsp/ExpertorLogin.jsp");
%>
</body>
</html>
