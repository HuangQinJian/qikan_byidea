<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="EditorLoginSession.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>编辑者主页面</title>
</head>
<body>
<p>编辑者主页面</p>
<div id="boby_main">
    <div>
        <input type="button" id="btn" value="显示所有已提交文章题目">
    </div>
    <div id="article_list"></div>
</div>
</body>
<script src="../js/template-web.js"></script>
<script src="../js/jquery-2.2.3.js"></script>
<script id="test" type="text/html">
    <h1>{{tit}}</h1>
    <ul>
        {{each list as value i}}
        <li><a href="ShowEveryArticle.jsp?id={{value.id}}"> {{i + 1}} ：{{value.title}} 作者：
            {{value.autor.autoname}}</a></li>
        {{/each}}
    </ul>
</script>
<script type="text/javascript">
    $("#btn").click(function () {
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
                document.getElementById('article_list').innerHTML = html;
            }
        });
    })
</script>
</html>