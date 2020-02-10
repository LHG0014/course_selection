<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" deferredSyntaxAllowedAsLiteral="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>大物选课修改密码</title>
	<link rel="stylesheet" href="../css/auth.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<script src="../js/auth.js"></script>
	<script src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>


	<script type="text/javascript">
		$(function(){
			//修改密码
			$("#submitBtn").click(function(){
				var data = $("#form").serialize();
				$.ajax({
					type: "post",
					url: "changePassword",
					data: data,
					dataType: "json", //返回数据类型
					success: function(data){
						if("success" == data.type){
							window.parent.location.href = "experiments";
						} else{
							$.messager.alert("消息提醒", data.msg, "warning");
							$("input[name='password_new']").val("");//清空验证码输入框
							$("input[name='password']").val("");
						}
					}
				});
			});
		})
	</script>
</head>

<body>
<div class="lowin lowin-blue">
	<div class="lowin-brand">
		<img src="/img/hljLogo.jpg" alt="logo">
	</div>

	<div class="lowin-wrapper">
		<div class="lowin-box lowin-login">
			<div class="lowin-box-inner">


				<form class="form form-horizontal" method="post"  id="form">
					<%--action="changePassword"--%>
					<p>修改密码</p>
					<div class="lowin-group">
						<label>请确认你的学号</label>
						<input type="text" name="sid" class="lowin-input" readonly="readonly" value="${student.sid}">
					</div>
					<div class="lowin-group">
						<label>请确认你的姓名</label>
						<input type="text" name="sname" class="lowin-input" readonly="readonly" value="${student.sname}">
					</div>

					<div class="lowin-group">
						<label>请输入您当前密码</label>
						<input type="password" name="password" class="lowin-input">
					</div>
					<div class="lowin-group">
						<label>请输入您修改后的密码</label>
						<input type="password" name="password_new" class="lowin-input">
					</div>
					<button class="lowin-btn" type="button" id="submitBtn">
						确定
					</button>
					<div class="text-foot">
						<a href="/homepage" class="login-link">返回主页</a>
					</div>
				</form>

			</div>
		</div>
	</div>

</div>
</body>



</html>