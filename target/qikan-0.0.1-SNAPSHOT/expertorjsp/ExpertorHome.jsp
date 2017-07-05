<%--
  Created by IntelliJ IDEA.
  User: 11157
  Date: 2017/7/4
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="ExpertorLoginSession.jsp" %>
<html>
<head>
    <title>专家主页面</title>
</head>
<body>
<p>专家主页面</p>
<div id="boby_main">
    <div>
        <input type="button" id="btn" value="显示所有需要审批的文章题目">
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
