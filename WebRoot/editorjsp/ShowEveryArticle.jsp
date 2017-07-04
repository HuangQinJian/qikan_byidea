<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.*,java.text.SimpleDateFormat" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    String name = (String) session.getAttribute("name");
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String time = sdf.format(d);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文章详情页</title>
</head>
<body>
<div id="boby_main">
    <div id="article_detail"></div>
</div>
</body>
<script src="../js/template-web.js"></script>
<script src="../js/jquery-2.2.3.js"></script>
<script id="test" type="text/html">
    <form action="ArticleEditCheck" method="POST" id="form">
        <div id="title">
            文章题目：<input type="text" value={{list.title}} name="title">
        </div>
        <div id="detail">
            <div id="author">
                文章作者:
                <p>zhanwu</p>
            </div>
            <div id="publish_time">
                <p>{{list.publishdate}}</p>
            </div>
            <div id="content">
                <p>{{list.content}}</p>
            </div>
        </div>
        <div id="submit">
            <input type="button" id="btn" value="提交"/>
        </div>
        <input type="hidden"
               value={{name}} name="editor">
        <input type="hidden" value={{time}} name="editor_time">
    </form>
    <%--<h1>{{list.title}}</h1>
    <p>{{list.publishdate}}</p>
    <p>{{list.content}}</p>--%>
</script>
<script type="text/javascript">
    $.ajax({
        type: "post",
        url: "SearchArticleById",
        dataType: "json",
        data: {
            "id":
            <%=id%>
        },
        success: function (data) {
            console.log(data);
            var result = {
                list: data
            };
            var html = template('test', result);
            document.getElementById('article_detail').innerHTML = html;
        }
    });
</script>
</html>