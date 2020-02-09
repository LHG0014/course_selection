<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" deferredSyntaxAllowedAsLiteral="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--教师通道目录--%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="/plugins/images/favicon.png">
    <title>大学物理实验系统</title>
    <!-- Bootstrap Core CSS -->
    <link href="/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <!-- animation CSS -->
    <link href="/css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="/css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="/css/colors/default.css" id="theme" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body class="fix-header">
<!-- ============================================================== -->
<!-- Preloader -->
<!-- ============================================================== -->
<div class="preloader">
    <svg class="circular" viewBox="25 25 50 50">
        <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10"/>
    </svg>
</div>
<!-- ============================================================== -->
<!-- Wrapper -->
<!-- ============================================================== -->
<div id="wrapper">
    <nav class="navbar navbar-default navbar-static-top m-b-0">
        <div class="navbar-header" style="height: 68px;">
            <div class="top-left-part">
                <!-- Logo -->
                <a class="logo">

                    <span class="hidden-xs">
                        <img src="../img/headlogo.png" alt="home" class="light-logo" width="100%" height="100%"/>
                        </span>
                </a>
            </div>
            <!-- /Logo -->
            <ul class="nav navbar-top-links navbar-right pull-right">
                <li>
                    <a class="nav-toggler open-close waves-effect waves-light hidden-md hidden-lg"
                       href="javascript:void(0)"><i class="fa fa-bars"></i></a>
                </li>
                <li>
                    <form role="search" class="app-search hidden-sm hidden-xs m-r-10">
                        <input type="text" placeholder="Search..." class="form-control">
                        <a href="">
                            <i class="fa fa-search"></i>
                        </a>
                    </form>
                </li>
                <c:if test="${!empty student}">
                    <li>
                        <a class="profile-pic" href="#">用户：${student.sname}</a>
                    </li>
                </c:if>

                <c:if test="${!empty student}">
                    <li>
                        <a class="profile-pic" href="../to/login"> 登出 </a>
                    </li>
                </c:if>

                <c:if test="${empty student}">
                    <li>
                        <a class="profile-pic" href="../to/login"> 登陆 </a>
                    </li>
                </c:if>
                </li>
            </ul>
        </div>

    </nav>
    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav slimscrollsidebar">
            <div class="sidebar-head">
                <h3><span class="fa-fw open-close"><i class="ti-close ti-menu"></i></span> <span
                        class="hide-menu">Navigation</span></h3>
            </div>
            <ul class="nav" id="side-menu">
                <li style="padding: 70px 0 0;">
                    <a href="homepage" class="waves-effect"><i class="fa fa-clock-o fa-fw" aria-hidden="true"></i>主页[Home]</a>
                </li>
                <li>
                    <a href="experiments" class="waves-effect"><i class="fa fa-table fa-fw" aria-hidden="true"></i>实验预约<br/>[Experiment
                        Appointment]</a>
                </li>
                <li>
                    <a href="query_teacher" class="waves-effect"><i class="fa fa-info-circle fa-fw" aria-hidden="true"></i>任课教师查询<br/>[Query
                        Teacher]</a>
                </li>
                <li>
                    <a href="message" class="waves-effect"><i class="fa fa-font fa-fw" aria-hidden="true"></i>留言板<br/>[Message
                        Board]</a>
                </li>
                <li>
                    <a href="lostfound" class="waves-effect"><i class="fa fa-globe fa-fw"
                                                                aria-hidden="true"></i>失物招领<br/>[Lost and Found]</a>
                </li>
                <li>
                    <a href="mailbox" class="waves-effect"><i class="fa fa-columns fa-fw"
                                                              aria-hidden="true"></i>投诉信箱<br/>[Complaint Mailbox]</a>
                </li>
                <li>
                    <a href="#" class="waves-effect"><i class="fa fa-info-circle fa-fw" aria-hidden="true"></i>教师通道<br/>[Teacher
                        Channel]</a>
                </li>
            </ul>
            <div class="center p-20">
                <c:if test="${empty student}">
                    <a href="../to/login" class="btn btn-danger btn-block waves-effect waves-light"
                       aria-hidden="true">登录</a>
                </c:if>
                <c:if test="${!empty student}">
                    <a href="../logout" class="btn btn-danger btn-block waves-effect waves-light"
                       aria-hidden="true">登出</a>
                </c:if>
            </div>
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- End Left Sidebar -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- Page Content -->
    <!-- ============================================================== -->
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row bg-title">
                <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                    <h1 class="page-title">教师通道</h1>
                </div>
                <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                    <ol class="breadcrumb">
                        <li><a href="homepage">主页</a></li>
                        <li class="active">教师通道</li>
                    </ol>
                </div>
                <!-- /.col-lg-12 -->
            </div>

            <!-- /row -->
            <div class="row">
                <div class="col-sm-12">
                    <div class="white-box" style="margin:2% 0 0 0;">
                        <h3 class="box-title">[操作目录]</h3>
                        <p class="text-muted"></p>
                        <div class="table-responsive">

                            <table class="table">
                                <tr><span style="font-size: 120%; ">${student.sname}</span>老师，您好！
                                    <c:if test="${student.password==student.initial_password}">
                                        请修改密码
                                    </c:if>
                                </tr>
                                <br/>
                            </table>

                            <table class="table">
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td class="txt-oflo"><a href="post_content">发布通知、注意事项、实验室守则、实验室开放信息 &nbsp; [I want to post notices, notes, lab rules]</a></td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td class="txt-oflo"><a href="#">查询实验名单 &nbsp; [I want to query the list of experiments]</a></td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td class="txt-oflo"><a href="#">查询任课教师 &nbsp; [I want to inquire about the teacher]</a></td>
                                </tr>
                                <tr>
                                    <td>4</td>
                                    <td class="txt-oflo"><a href="reply_message">回复留言板 &nbsp; [I want to reply to student messages]</a></td>
                                </tr>
                                <tr>
                                    <td>5</td>
                                    <td class="txt-oflo"><a href="reset_password">重置学生密码 &nbsp; [I want to reset the student's password]</a></td>
                                </tr>
                                <tr>
                                    <td>6</td>
                                    <td class="txt-oflo"><a href="set_startDate">设置开学日期 &nbsp; [I want to set a student's start date]</a></td>
                                </tr>

                                </tbody>
                            </table>
                            <h5>完成操作后，请注意<a href="../logout">登出</a></h5>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
        <footer class="footer text-center">@2020 黑龙江大学 大学物理实验系统</footer>
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<!-- jQuery -->
<script src="/plugins/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Menu Plugin JavaScript -->
<script src="/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
<!--slimscroll JavaScript -->
<script src="/js/jquery.slimscroll.js"></script>
<!--Wave Effects -->
<script src="/js/waves.js"></script>
<!-- Custom Theme JavaScript -->
<script src="/js/custom.min.js"></script>

<!--Counter js -->
<script src="/plugins/bower_components/waypoints/lib/jquery.waypoints.js"></script>
<script src="/plugins/bower_components/counterup/jquery.counterup.min.js"></script>
<!-- chartist chart -->
<script src="/plugins/bower_components/chartist-js/dist/chartist.min.js"></script>
<script src="/plugins/bower_components/chartist-plugin-tooltip-master/dist/chartist-plugin-tooltip.min.js"></script>
<!-- Sparkline chart JavaScript -->
<script src="/plugins/bower_components/jquery-sparkline/jquery.sparkline.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="/js/custom.min.js"></script>
<script src="/js/dashboard1.js"></script>
<script src="/plugins/bower_components/toast-master/js/jquery.toast.js"></script>
</body>

</html>