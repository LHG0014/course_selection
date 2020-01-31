<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>大物选课登陆</title>
    <link rel="stylesheet" href="/css/auth.css">
    <script src="/js/auth.js"></script>
</head>

<body>
<div class="lowin lowin-blue">
    <div class="lowin-brand">
        <img src="/img/kodinger.jpg" alt="logo">
    </div>

    <div class="lowin-wrapper">
        <div class="lowin-box lowin-login">
            <div class="lowin-box-inner">

                <form class="form form-horizontal" method="post" action="student/loginStudent" id="form_01">
                    <p>用户登录</p>
                    <div class="lowin-group">
                        <p style="float: left">提示：请正确输入用户名和密码进行登录！</p>
                    </div>
                    <div class="lowin-group">
                        <input name="sid" type="text" placeholder="学号" class="lowin-input">
                    </div>
                    <div class="lowin-group">
                        <input name="password" type="password" placeholder="密码" class="lowin-input">
                    </div>

                    <button type="submit" class="lowin-btn" id="button_s">登陆</button>
                </form>

            </div>
        </div>

        <footer class="lowin-footer">
            Design By <a href="#">@itskodinger</a>
        </footer>
    </div>
</div>


</body>
</html>