<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章作者登录界面</title>
</head>
<body>
<form method="post" action="AuthorLoginCheck">
用户名：<input type="text" name="name" value="">
密码：<input type="text" name="password" value="">
<input type="submit" name="submit" value="登录">
<p><a href="AuthorRegiest.jsp">什么，你还没有账号？赶紧去注册一个吧！</a></p>
</form>
</body>
</html>