<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>期刊管理系统</title>
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
    <link href="css/article_list.css" rel="stylesheet" type="text/css"/>
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
    <link href="assets/css/icons.css" rel="stylesheet"/>
    <!-- jQueryUI -->
    <link href="assets/css/sprflat-theme/jquery.ui.all.css" rel="stylesheet"/>
    <!-- Bootstrap stylesheets (included template modifications) -->
    <link href="assets/css/bootstrap.css" rel="stylesheet"/>
    <!-- Plugins stylesheets (all plugin custom css) -->
    <link href="assets/css/plugins.css" rel="stylesheet"/>
    <!-- Main stylesheets (template main css file) -->
    <link href="assets/css/main.css" rel="stylesheet"/>
    <!-- Custom stylesheets ( Put your own changes here ) -->
    <link href="assets/css/custom.css" rel="stylesheet"/>
    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/img/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/img/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/img/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="assets/img/ico/apple-touch-icon-57-precomposed.png">
    <link rel="icon" href="assets/img/ico/favicon.ico" type="image/png">
    <!-- Windows8 touch icon ( http://www.buildmypinnedsite.com/ )-->
    <meta name="msapplication-TileColor" content="#3399cc"/>
</head>
<body>
<!-- Start #header -->
<div id="header">
    <a class="navbar-brand" href="#">
        <span class="text-logo qikan"><i class="im-map"></i> 欢迎来到期刊管理系统</span>
    </a>
    <!-- Start .header-inner -->
</div>
<!-- End #header -->
<!-- Start #sidebar -->
<div id="sidebar">
    <!-- Start .sidebar-inner -->
    <div class="sidebar-inner">
        <!-- Start #sideNav -->
        <ul id="sideNav" class="nav nav-pills nav-stacked">
            <li><a href="ueditor/authorjsp/AuthorLogin.jsp"><i class="en-upload"></i> 文章作者登录</a>
            </li>
            <li><a href="editorjsp/EditorLogin.jsp"> 编辑者登录 <i class="im-quill"></i></a>
            </li>
            <li><a href="expertorjsp/ExpertorLogin.jsp"><i class="st-diamond"></i> 专家登录 </a>
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
                <h1 class="page-header"><i class="im-table2"></i> 文章列表</h1>
                <!-- 搜索框 -->
                <div class="col-lg-4">
                    <form class="form-inline search-page-form" id="search_form" action="GetIdByArticleTitle">
                        <div class="well bn">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="请输入文章标题搜索文章 ..."
                                       name="input_value">
                                <span class="input-group-btn">
                                    <button type="submit" class="btn btn-primary" id="search_article"><i
                                            class="ec-search s16"></i></button>
                                     </span>
                            </div>
                        </div>
                    </form>
                </div>
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
                    <!-- 显示文章列表 -->
                    <div class="panel-body" id="article_main">


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
<script src="assets/plugins/core/pace/pace.min.js"></script>
<!-- Important javascript libs(put in all pages) -->
<script src="assets/js/jquery-1.8.3.min.js"></script>
<script>
    window.jQuery || document.write('<script src="assets/js/libs/jquery-2.1.1.min.js">\x3C/script>')
</script>
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script>
    window.jQuery || document.write('<script src="assets/js/libs/jquery-ui-1.10.4.min.js">\x3C/script>')
</script>
<!--[if lt IE 9]>
<script type="text/javascript" src="assets/js/libs/excanvas.min.js"></script>
<script type="text/javascript" src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<script type="text/javascript" src="assets/js/libs/respond.min.js"></script>
<![endif]-->
<!-- Bootstrap plugins -->
<script src="assets/js/bootstrap/bootstrap.js"></script>
<!-- Core plugins ( not remove ever) -->
<!-- Handle responsive view functions -->
<script src="assets/js/jRespond.min.js"></script>
<!-- Custom scroll for sidebars,tables and etc. -->
<script src="assets/plugins/core/slimscroll/jquery.slimscroll.min.js"></script>
<script src="assets/plugins/core/slimscroll/jquery.slimscroll.horizontal.min.js"></script>
<!-- Resize text area in most pages -->
<script src="assets/plugins/forms/autosize/jquery.autosize.js"></script>
<!-- Proivde quick search for many widgets -->
<script src="assets/plugins/core/quicksearch/jquery.quicksearch.js"></script>
<!-- Bootbox confirm dialog for reset postion on panels -->
<script src="assets/plugins/ui/bootbox/bootbox.js"></script>
<!-- Other plugins ( load only nessesary plugins for every page) -->
<script src="assets/plugins/core/moment/moment.min.js"></script>
<script src="assets/plugins/charts/sparklines/jquery.sparkline.js"></script>
<script src="assets/plugins/charts/pie-chart/jquery.easy-pie-chart.js"></script>
<script src="assets/plugins/forms/icheck/jquery.icheck.js"></script>
<script src="assets/plugins/forms/tags/jquery.tagsinput.min.js"></script>
<script src="assets/plugins/forms/tinymce/tinymce.min.js"></script>
<script src="assets/plugins/forms/checkall/jquery.checkAll.js"></script>
<script src="assets/plugins/misc/highlight/highlight.pack.js"></script>
<script src="assets/plugins/misc/countTo/jquery.countTo.js"></script>
<script src="assets/js/jquery.sprFlat.js"></script>
<script src="assets/js/app.js"></script>
<script src="assets/js/pages/tables.js"></script>
<script src="js/template-web.js"></script>
<script src="js/jquery-2.2.3.js"></script>
<script id="test" type="text/html">
    <h1>{{tit}}</h1>
    <ul>
        {{each list as value i}}
        <li><a href="ShowHomeArticle.jsp?id={{value.id}}"> {{i + 1}} ：{{value.title}}&nbsp&nbsp&nbsp&nbsp作者：
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

    $("#search_article").click(function () {
        $("#search_form").submit();
    })
</script>
</body>
</html>
