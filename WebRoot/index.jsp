<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>期刊管理系统主页</title>
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
    <div id="article_main"></div>
    <ul>
        <li><a href="ueditor/authorjsp/AuthorLogin.jsp">文章作者登录</a></li>
        <li><a href="editorjsp/EditorLogin.jsp">编辑者登录</a></li>
        <li><a href="expertorjsp/ExpertorLogin.jsp">专家登录</a></li>
    </ul>
</div>
<div id="footer">页脚</div>
</body>
<script src="js/template-web.js"></script>
<script src="js/jquery-2.2.3.js"></script>
<script id="test" type="text/html">
    <h1>{{tit}}</h1>
    <ul>
        {{each list as value i}}
        <li><a href="ShowHomeArticle.jsp?id={{value.id}}"> {{i + 1}} ：{{value.title}} 作者：
            {{value.autor.autoname}}</a></li>
        {{/each}}
    </ul>
</script>
<script type="text/javascript">
    $(document).ready(function () {
        //alert("hello");
        $.ajax({
            type: "post",
            url: "ShowAllArticle",
            dataType: "json",
            data: {},
            success: function (data) {
                console.log(data);
                var result = {
                    tit: '文章列表',
                    list: data
                };
                var html = template('test', result);
                document.getElementById('article_main').innerHTML = html;
            }
        });
    })
</script>
</html>
