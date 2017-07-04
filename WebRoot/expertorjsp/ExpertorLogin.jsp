<%--
  Created by IntelliJ IDEA.
  User: 11157
  Date: 2017/7/4
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>专家登录页面</title>
</head>
<body>
<form method="post" action="ExpertorLoginCheck">
    用户名：<input type="text" name="name" value=""> 密码：<input
        type="text" name="password" value=""> <input type="submit"
                                                     name="submit" value="登录">
    <p>
        <a href="ExpertorRegiest.jsp">什么，你还没有账号？赶紧去注册一个吧！</a>
    </p>
</form>
</body>
</html>
