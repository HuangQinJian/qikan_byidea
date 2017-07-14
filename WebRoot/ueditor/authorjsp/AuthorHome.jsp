<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.*,java.text.SimpleDateFormat" %>
<%@include file="AuthorLoginSession.jsp" %>
<%
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //String publish_time=sdf.format(d);
    //String path = request.getContextPath();
    //String article_content = request.getParameter("article_content");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>文章作者主页面</title>
    <!-- Mobile specific metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- Force IE9 to render in normal mode -->
    <!--[if IE]>
    <meta http-equiv="x-ua-compatible" content="IE=9"/><![endif]-->
    <meta name="author" content="SuggeElson"/>
    <meta name="description" content=""
    />
    <meta name="keywords" content=""
    />
    <meta name="application-name" content="sprFlat admin template"/>
    <!-- Import google fonts - Heading first/ text second -->
    <link rel='stylesheet' type='text/css'
          href='http://fonts.googleapis.com/css?family=Open+Sans:400,700|Droid+Sans:400,700'/>
    <!--[if lt IE 9]>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400" rel="stylesheet" type="text/css"/>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:700" rel="stylesheet" type="text/css"/>
    <link href="http://fonts.googleapis.com/css?family=Droid+Sans:400" rel="stylesheet" type="text/css"/>
    <link href="http://fonts.googleapis.com/css?family=Droid+Sans:700" rel="stylesheet" type="text/css"/>
    <![endif]-->
    <!-- Css files -->
    <!-- Icons -->
    <link href="../../assets/css/icons.css" rel="stylesheet"/>
    <link href="../../css/return_home.css" rel="stylesheet" type="text/css"/>
    <link href="../../css/authorhome.css" rel="stylesheet" type="text/css"/>
    <!-- jQueryUI -->
    <link href="../../assets/css/sprflat-theme/jquery.ui.all.css" rel="stylesheet"/>
    <!-- Bootstrap stylesheets (included template modifications) -->
    <link href="../../assets/css/bootstrap.css" rel="stylesheet"/>
    <!-- Plugins stylesheets (all plugin custom css) -->
    <link href="../../assets/css/plugins.css" rel="stylesheet"/>
    <!-- Main stylesheets (template main css file) -->
    <link href="../../assets/css/main.css" rel="stylesheet"/>
    <!-- Custom stylesheets ( Put your own changes here ) -->
    <link href="../../assets/css/custom.css" rel="stylesheet"/>
    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144"
          href="../../assets/img/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114"
          href="../../assets/img/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72"
          href="../../assets/img/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../../assets/img/ico/apple-touch-icon-57-precomposed.png">
    <link rel="icon" href="../../assets/img/ico/favicon.ico" type="image/png">
    <!-- Windows8 touch icon ( http://www.buildmypinnedsite.com/ )-->
    <meta name="msapplication-TileColor" content="#3399cc"/>
</head>
<body>
<%--<%
    if ((String) request.getAttribute("str") == "true") {
%>
<script>
    alert("操作成功！");
</script>
<%
    }
%>--%>
<!-- Start #header -->
<div id="header">
    <a class="navbar-brand" href="#">
        <span class="text-logo qikan"><i class="im-map"></i> 欢迎来到期刊管理系统</span>
    </a>
    <button class="btn btn-primary" id="return_home"><a href="../../index.jsp">返回主页面</a></button>
    <!-- Start .header-inner -->
</div>
<!-- End #header -->
<!-- Start #sidebar -->
<div id="sidebar">
    <!-- Start .sidebar-inner -->
    <div class="sidebar-inner">
        <!-- Start #sideNav -->
        <ul id="sideNav" class="nav nav-pills nav-stacked">
            <li><a href="AuthorLogin.jsp"><i class="en-upload"></i> <span
                    class="activeType">文章作者登录</span></a>
            </li>
            <li><a href="../../editorjsp/EditorLogin.jsp"> 编辑者登录 <i class="im-quill"></i></a>
            </li>
            <li><a href="../../expertorjsp/ExpertorLogin.jsp"><i class="st-diamond"></i> 专家登录 </a>
            </li>
        </ul>
        <!-- End #sideNav -->
    </div>
    <!-- End .sidebar-inner -->
</div>
<!-- End #sidebar -->
<!-- Start #content -->
<div id="content">
    <!-- Start .content-wrapper -->
    <div class="content-wrapper">
        <div class="row">
            <!-- Start .row -->
            <!-- Start .page-header -->
            <div class="col-lg-12 heading">
                <h1 class="page-header"><i class="im-table2"></i> 编辑文章</h1>
            </div>
            <!-- End .page-header -->
        </div>
        <!-- End .row -->

        <div class="row">
            <!-- Start .row -->
            <div class="col-lg-12">
                <!-- col-lg-12 start here -->
                <div class="panel panel-default plain toggle panelClose panelRefresh">
                    <!-- Start .panel -->
                    <div class="panel-heading white-bg">
                    </div>
                    <!-- 编辑框在此 -->
                    <div class="panel-body" id="article_main">
                        <!-- 加载编辑器的容器 -->
                        <form action="ArticleAddCheck" method="POST" id="form">
                            <div id="title">
                                文章题目：<input type="text" value="" name="title">
                            </div>
                            <div id="detail">
                                <div id="author">
                                    文章作者：<%=(String) session.getAttribute("name")%>
                                </div>
                                <div id="publish_time">
                                    发布时间：<%=sdf.format(d)%>
                                </div>
                            </div>
                            <script id="container" name="article_content" type="text/plain">
                            </script>
                            <!-- 配置文件 -->
                            <script type="text/javascript" src="../ueditor.config.js"></script>
                            <!-- 编辑器源码文件 -->
                            <script type="text/javascript" src="../ueditor.all.js"></script>
                            <!-- 实例化编辑器 -->
                            <script type="text/javascript">
                                var ue = UE.getEditor('container');
                            </script>
                            <div id="submit">
                                <button class="btn btn-primary" id="btn">提交</button>
                            </div>
                            <input type="hidden" value=<%=(String) session.getAttribute("name")%> name="author">
                            <input type="hidden" value=<%=sdf.format(d)%> name="publish_time">
                        </form>
                    </div>
                </div>
                <!-- End .panel -->
            </div>
            <!-- col-lg-12 end here -->
        </div>
        <!-- End .row -->
        <!-- Page End here -->
    </div>
    <!-- End .outlet -->
</div>
<!-- End .content-wrapper -->
<div class="clearfix"></div>
</div>
<!-- End #content -->
<!-- Javascripts -->
<!-- Load pace first -->
<script src="../../assets/plugins/core/pace/pace.min.js"></script>
<!-- Important javascript libs(put in all pages) -->
<script src="../../assets/js/jquery-1.8.3.min.js"></script>
<script>
    window.jQuery || document.write('<script src="assets/js/libs/jquery-2.1.1.min.js">\x3C/script>')
</script>
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script>
    window.jQuery || document.write('<script src="assets/js/libs/jquery-ui-1.10.4.min.js">\x3C/script>')
</script>
<!--[if lt IE 9]>
<script type="text/javascript" src="../../assets/js/libs/excanvas.min.js"></script>
<script type="text/javascript" src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<script type="text/javascript" src="../../assets/js/libs/respond.min.js"></script>
<![endif]-->
<!-- Bootstrap plugins -->
<script src="../../assets/js/bootstrap/bootstrap.js"></script>
<!-- Core plugins ( not remove ever) -->
<!-- Handle responsive view functions -->
<script src="../../assets/js/jRespond.min.js"></script>
<!-- Custom scroll for sidebars,tables and etc. -->
<script src="../../assets/plugins/core/slimscroll/jquery.slimscroll.min.js"></script>
<script src="../../assets/plugins/core/slimscroll/jquery.slimscroll.horizontal.min.js"></script>
<!-- Resize text area in most pages -->
<script src="../../assets/plugins/forms/autosize/jquery.autosize.js"></script>
<!-- Proivde quick search for many widgets -->
<script src="../../assets/plugins/core/quicksearch/jquery.quicksearch.js"></script>
<!-- Bootbox confirm dialog for reset postion on panels -->
<script src="../../assets/plugins/ui/bootbox/bootbox.js"></script>
<!-- Other plugins ( load only nessesary plugins for every page) -->
<script src="../../assets/plugins/core/moment/moment.min.js"></script>
<script src="../../assets/plugins/charts/sparklines/jquery.sparkline.js"></script>
<script src="../../assets/plugins/charts/pie-chart/jquery.easy-pie-chart.js"></script>
<script src="../../assets/plugins/forms/icheck/jquery.icheck.js"></script>
<script src="../../assets/plugins/forms/tags/jquery.tagsinput.min.js"></script>
<script src="../../assets/plugins/forms/tinymce/tinymce.min.js"></script>
<script src="../../assets/plugins/forms/checkall/jquery.checkAll.js"></script>
<script src="../../assets/plugins/misc/highlight/highlight.pack.js"></script>
<script src="../../assets/plugins/misc/countTo/jquery.countTo.js"></script>
<script src="../../assets/js/jquery.sprFlat.js"></script>
<script src="../../assets/js/app.js"></script>
<script src="../../assets/js/pages/tables.js"></script>
</body>
</html>