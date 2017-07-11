# qikan_byidea

## 大三小学期大作业——期刊管理系统


## 使用技术如下：

### 1、原生JSP+Servlet技术进行开发

### 2、运用了art-template模板引擎    链接：[aui/art-template](https://github.com/aui/art-template)

### 3、使用了log4j进行日志记录

使用步骤：

![](http://op3sagu96.bkt.clouddn.com/123.PNG)

首先在src目录下建立一个resource文件夹，然后添加log4j.properties文件，具体内容可参考代码！

易错点：一定要把resource文件夹标记为资源文件夹，具体步骤如下：
![](http://op3sagu96.bkt.clouddn.com/456.gif)

如果不做这一步会报错！

其他的就不要配置了。log4j会自动读取对应的配置！

## 注意事项

#### 1、因为本项目中涉及到中文，所以必须注意在servlet中设置相应的编码格式，否则就会出现中文乱码：

```java
response.setCharacterEncoding("utf-8");
request.setCharacterEncoding("utf-8");
```

#### 具体可参考：[response和request的setCharacterEncoding区别](http://www.cnblogs.com/fan-xiaofan/p/6028233.html)

#### 2、art-template模板引擎的使用方法

（1）引入art-template
```java
<script src="../js/template-web.js"></script>
```
（2）模板渲染
```javascript
<script type="text/html" id="test">
    <h1>{{tit}}</h1>
    <ul>
        {{each list as value i}}
        <li><a href="ShowEveryArticle.jsp?id={{value.id}}">{{i+1}}:{{value.title}} 作者：{{value.autor.autoname}}</a></li>
        {{/each}}
    </ul>
</script>
```

```html
<!-- 显示文章列表 -->
<div class="panel-body" id="article_list"></div>
```
result是后台获取的json数据

```javascript
 var html = template('test', result);
 document.getElementById('article_list').innerHTML = html;
```