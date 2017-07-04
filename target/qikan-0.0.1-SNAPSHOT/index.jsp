<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>
<link rel="stylesheet" type="text/css" href="css/index.css"/>
<body>
<div id="header"><p>欢迎来到期刊管理系统</p></div>
<div id="body_main">
    <ul>
        <li><a href="ueditor/authorjsp/AuthorLogin.jsp">文章作者登录</a></li>
        <li><a href="editorjsp/EditorLogin.jsp">编辑者登录</a></li>
        <li><a href="expertorjsp/ExpertorLogin.jsp">专家登录</a></li>
    </ul>
</div>
<div id="footer">页脚</div>
</body>
</html>
