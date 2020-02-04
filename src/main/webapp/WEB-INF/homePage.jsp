<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" deferredSyntaxAllowedAsLiteral="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" type="image/png" sizes="16x16" href="plugins/images/favicon.png">
	<%--<link rel="icon" type="image/png" sizes="16x16" href="img/favicon.png">--%>
	<title>大学物理实验系统</title>
	<!-- Bootstrap Core CSS -->
	<link href="../bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- Menu CSS -->
	<link href="../bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
	<!-- toast CSS -->
	<link href="../bower_components/toast-master/css/jquery.toast.css" rel="stylesheet">
	<!-- morris CSS -->
	<link href="../bower_components/morrisjs/morris.css" rel="stylesheet">
	<!-- chartist CSS -->
	<link href="../bower_components/chartist-js/dist/chartist.min.css" rel="stylesheet">
	<link href="../bower_components/chartist-plugin-tooltip-master/dist/chartist-plugin-tooltip.css" rel="stylesheet">
	<!-- animation CSS -->
	<link href="../css/animate.css" rel="stylesheet">
	<!-- Custom CSS -->
	<link href="../css/style.css" rel="stylesheet">
	<!-- color CSS -->
	<link href="../css/colors/default.css" id="theme" rel="stylesheet">
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>

<body class="fix-header">

<div class="preloader">
	<svg class="circular" viewBox="25 25 50 50">
		<circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10"/>
	</svg>
</div>

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
					<a href="experiments" class="waves-effect"><i class="fa fa-table fa-fw"
					                                              aria-hidden="true"></i>实验预约<br/>[Experiment
						Appointment]</a>
				</li>
				<li>
					<a href="query_teacher" class="waves-effect"><i class="fa fa-info-circle fa-fw"
					                                                aria-hidden="true"></i>任课教师查询<br/>[Query
						Teacher]</a>
				</li>
				<li>
					<a href="message" class="waves-effect"><i class="fa fa-font fa-fw" aria-hidden="true"></i>留言板<br/>[Message
						Board]</a>
				</li>
				<li>
					<a href="../lostfound" class="waves-effect"><i class="fa fa-globe fa-fw" aria-hidden="true"></i>失物招领<br/>[Lost
						and Found]</a>
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

	<div id="page-wrapper">
		<div class="container-fluid">


			<div class="row">
				<div class="col-md-12 col-lg-12 col-sm-12">
					<div class="white-box">

						<h1 style="margin: 0px;padding: 0px">首页</h1>
						<h4 style="margin: 0px;padding: 0px">&nbsp;-Index-</h4>
						<p>+-------------------------------------------------------------------+</p>
						<br/>
						<br/>
						<br/>
						<h2 style="color: red">本周是第
							<%
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								Date openDay = sdf.parse("2020-01-01 12:00:00");
								GregorianCalendar g = new GregorianCalendar();
								g.setTime(openDay);
								int num1 = g.get(Calendar.WEEK_OF_YEAR);//计算开学日期的周数
								Date nowdate = new Date();
								String s = sdf.format(nowdate);
								nowdate = sdf.parse(s);
								g.setTime(nowdate);
								int num2 = g.get(Calendar.WEEK_OF_YEAR);//计算当前日期的周数
								out.print(num2 - num1 + 1);
							%>周</h2>
						<h1 style="color: red">通知</h1>
						<h4>12. 13通知:鉴于有同学要求多做实验，可以多选1个实验，选课方法见下面9.4通知。多选实验也是按
							<br>平均分计期末成绩。没选够要求数目 (实验A是12个，实验B是8个)的同学期末成绩为0分。</h4>
						<h4>9. 4通知:目前应届生和重修生都不限选课时间及类型(周-周三周四上、下午， 周二上午和周五下午
							<br>的实验都可选)，每周可选多个实验。可点击“实验预约”页面的“实验空位表”查询所有实验所有
							<br>时间的空位，表中数值不为0的就是有空位可选。选课方法:先选题目和周次，再选星期和节次。有问
							<br>题请继续在留言板留言。</h4>
						<h4>关于慕课：要求必须参加“大学物理实验”慕课学习，慕课占10%的期末成绩。要求做绪论测试;绪论
							<br>部分未掌握的，要求再次进行绪论的慕课学习;要求看所有实验的慕课(每个实验至少看90%时长的视
							<br>频)并做测试，不管是否选此实验。登陆方法: 1. 通过学校的应用门]户my. hl ju. edu. cn登录，然后
							<br>选择自主学习平台; 2. 直接登录自主学习平台网站，网址是mooc. hlju. edu. cn; 3. 安装超星学习通
							<br>APP,然后选择第三方账户登录，在单位一栏选黑龙江大学， 然后用学号，选课密码登录。</h4>
						<h4>关于重修和慕课:未在学校选课的重修同学(无法登陆本站)请务必先在学校选课，然后在首页左侧
							<br>“重修登记”，经实验室审核通过可选实验;若末在学校选课导致期末无法录入成绩，后果自
							<br>负。“ 查询预约”列表里有“保留以前成绩”的重修同学不要求学习慕课，期末成绩按实验平均成绩
							<br>计算，其他重修同学及应届生要求学习慕课。
						</h4>
						<br/>
						<h3 style="color: red">实验预约注意事项</h3>
						<ul>
							<li>-周做一个实验，每个实验题目只能选一次。</li>
							<li>需预约本学期的所有实验。</li>
							<li>实验的当天不能预约实验，也不能取消预约。</li>
							<li>如果已预约的实验不能来做，请提前一天（包括一天）取消预约</li>
							<li>已预约的实验不来做，按旷课处理。</li>
							<li>要求做满规定的题目数（大学物理实验A为12个，大学物理实验B为8个），否则期末无成绩。</li>
						</ul>
						<br/>
						<h3 style="color: red">实验室守则</h3>
						<ul>
							<li>上实验课前必须作好实验预习，写好实验报告。无预习报告或预习不合格者不允许做实验。</li>
							<li>按时上课，迟到十分钟以上（含十分钟），将取消该次实验资格。</li>
							<li>上实验课必须携带：学生证，实验教材，预习报告及钢笔，铅笔，格尺，橡皮等用具。</li>
							<li>进入实验室首先了解实验注意事项，熟悉实验装置，仪器结构，遵守仪器操作规程。如有电路连接，使用电源等，要经过教
								<br>师检查，方可接通电源。
							</li>
							<li>替做实验者、实验数据不真实、伪造数据、带别人的实验数据进实验室者等，都按考试违纪处理。</li>
							<li>期末成绩为应完成实验题目的平均成绩加慕课成绩，若未完成要求的题目数，期末成绩为0分。旷课记未完成一次实验。</li>
							<li>爱护实验仪器设备及实验设施，如有操作粗鲁、不遵守操作规范而造成仪器设备及设施损坏的，按“黑龙江大学仪器设备
								<br>损坏赔偿制度”执行。
							</li>
						</ul>
						<p>+-------------------------------------------------------------------+</p>
						<div class="table-responsive">
							<table class="table">
								<thead>
								<tr>
									<th>实验号</th>
									<th>实验题目</th>
									<th>房间号</th>
									<th>开设周次</th>
									<th>备注</th>
								</tr>
								</thead>
								<tbody>
								<c:forEach items="${experiments}" var="c" varStatus="st">
									<tr>
										<td>${c.eid}</td>
										<td>${c.ename}</td>
										<td>${c.lab}</td>
										<td><c:if test="${c.one_start!=0}">
											${c.one_start}-
										</c:if>
											<c:if test="${c.one_end!=0}">
												${c.one_end} ,
											</c:if>
											<c:if test="${c.two_start!=0}">
												${c.two_start}-
											</c:if>
											<c:if test="${c.two_end!=0}">
												${c.two_end}
											</c:if>
										</td>
										<td>
											<c:if test="${c.remark!='无'}">
												${c.remark}
											</c:if>
										</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>

		</div>
		<footer class="footer text-center">@2020 黑龙江大学 大学物理实验系统</footer>
	</div>

</div>

<script src="../bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="../bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Menu Plugin JavaScript -->
<script src="../bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
<!--slimscroll JavaScript -->
<script src="../js/jquery.slimscroll.js"></script>
<!--Wave Effects -->
<script src="../js/waves.js"></script>
<!--Counter js -->
<script src="../bower_components/waypoints/lib/jquery.waypoints.js"></script>
<script src="../bower_components/counterup/jquery.counterup.min.js"></script>
<!-- chartist chart -->
<script src="../bower_components/chartist-js/dist/chartist.min.js"></script>
<script src="../bower_components/chartist-plugin-tooltip-master/dist/chartist-plugin-tooltip.min.js"></script>
<!-- Sparkline chart JavaScript -->
<script src="../bower_components/jquery-sparkline/jquery.sparkline.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="../js/custom.min.js"></script>

<script src="../bower_components/toast-master/js/jquery.toast.js"></script>
</body>

</html>
