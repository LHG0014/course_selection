<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" deferredSyntaxAllowedAsLiteral="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>大物选课修改密码</title>
	<link rel="stylesheet" href="../css/auth.css">
	<script src="../js/auth.js"></script>
</head>

<body>
<div class="lowin lowin-blue">
	<div class="lowin-brand">
		<img src="../img/kodinger.jpg" alt="logo">
	</div>

	<div class="lowin-wrapper">
		<div class="lowin-box lowin-login">
			<div class="lowin-box-inner">


				<form class="form form-horizontal" method="post" action="changePassword">
					<p>修改密码</p>
					<div class="lowin-group">
						<label>请确认你的学号</label>
						<input type="text" name="sid" class="lowin-input" readonly="readonly" value="${showExperiment.student.sid}">
					</div>
					<div class="lowin-group">
						<label>请确认你的姓名</label>
						<input type="text" name="sname" class="lowin-input" readonly="readonly" value="${showExperiment.student.sname}">
					</div>

					<div class="lowin-group">
						<label>请输入您当前密码</label>
						<input type="password" name="password" class="lowin-input">
					</div>
					<div class="lowin-group">
						<label>请输入您修改后的密码</label>
						<input type="password" name="password_new" class="lowin-input">
					</div>
					<button class="lowin-btn" type="submit">
						确定
					</button>

					<%--<div class="text-foot">--%>
						<%--Already have an account? <a href="" class="login-link">Login</a>--%>
					<%--</div>--%>
				</form>


			</div>
		</div>
	</div>

</div>
</body>
</html>