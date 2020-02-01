<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>大物选课登陆</title>
    <link rel="stylesheet" href="/css/auth.css">
    <script src="/js/auth.js"></script>
    <script src="/js/jquery.min.js"></script>
</head>

<body>
<div class="lowin lowin-blue">
    <div class="lowin-brand">
        <img src="/img/kodinger.jpg" alt="logo">
    </div>

    <div class="lowin-wrapper">
        <div class="lowin-box lowin-login">
            <div class="lowin-box-inner">
                <form class="form form-horizontal" method="post" action="${ctx}/login" id="form_01">

                    <p>用户登录</p>
                    <div class="lowin-group">
                        <p style="float: left">提示：请正确输入用户名和密码进行登录！</p>
                    </div>
                    <div class="lowin-group">
                        <input name="sid" type="text" placeholder="学号" class="lowin-input" value="${sid}" >
                    </div>
                    <div class="lowin-group">
                        <input name="password" type="password" placeholder="密码" class="lowin-input" >
                    </div>
                    <c:if test="${errorMeg!=null}">
                        <div class="lowin-group">
                            <input type="text" placeholder="${errorMeg}" class="lowin-input" readonly="readonly"/>
                        </div>
                    </c:if>

                    <button type="submit" class="lowin-btn" id="login_button_01" onclick="fun()">登陆</button>
                </form>
                <%--<h2 align="center" hidden id="message">${sid}${errorMeg}</h2>--%>

            </div>
        </div>
        <footer class="lowin-footer">
            Design By <a href="#">@计软科协</a>
        </footer>
    </div>
</div>
<%--<script type="text/javascript">--%>
<%--function fun() {--%>
    <%--$.ajax({--%>
        <%--url:"/to/login",--%>
        <%--type:"POST",--%>
        <%--timeout:10000,--%>
        <%--//dataType:"json",--%>
        <%--data:{},--%>
        <%--success:function (data) {--%>

                <%--alert("${errorMeg}");--%>
        <%--}--%>
    <%--});--%>
<%--}--%>
<%--</script>--%>
<script type="text/javascript">
    var timeout;
    onclick =function (){
        clearTimeout(timeout);
        timeout=setTimeout(function fun() {
            $.ajax({
                url:"/login",
                type:"POST",
                //dataType:"json",
                data:{},
                success:function () {
                    <c:if test="${errorMeg!=null}">
                        alert("${errorMeg}");
                    </c:if>
                }
            });
        },3000);
    }
</script>
</body>
</html>