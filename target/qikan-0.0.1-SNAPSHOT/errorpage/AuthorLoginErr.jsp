<%--
  Created by IntelliJ IDEA.
  User: 11157
  Date: 2017/7/4
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录错误界面</title>
    <h3>文章作者者登录错误，网页将于3秒后重新跳转到登录页面</h3>
    <%
        response.setHeader("Refresh", "3;URL=../ueditor/authorjsp/AuthorLogin.jsp");
    %>
</head>
<body>
<p>用户登录错误界面</p>
</body>
</html>
