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

#### 3、在项目中，数据库连接出现了如下问题：

```java
No operations allowed after statement closed.
```
原因是：有程序试图在已关闭的数据库连接上继续执行操作。

还有其他可能导致这个错误的原因包括：

1、你这里和数据库的连接Connection是一个Static的，程序共享这一个Connection。所以第一次对数据库操作没问题，当把Connection关闭后，第二次还想操作数据库时Connection肯定不存在了。

2、MySQL在5以后针对超长时间DB连接做了一个处理，那就是如果一个DB连接在无任何操作情况下过了8个小时后，mysql会自动把这个连接关闭。所以使用连接池的时候虽然连接对象还在但是链接数据库的时候会一直报这个异常。

解决办法：在Mysql命令行中，
```java
show global variables;
```
In MYSQL, I reset that value to 172800 seconds(48 hrs as per my requirement) using

```java
set global wait_timeout=172800;
```
