<%--
  Created by IntelliJ IDEA.
  User: Kelvin
  Date: 2017/2/10
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!DOCTYPE html>
<html lang="en" class="no-js">

<head>

    <meta charset="utf-8">
    <title>登录(Login)</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="SHORTCUT ICON" href="assets/logo.png"/>

    <!-- CSS -->
    <link rel="stylesheet" href="assets/login/css/reset.css">
    <link rel="stylesheet" href="assets/login/css/supersized.css">
    <link rel="stylesheet" href="assets/login/css/style.css">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="assets/login/js/html5.js"></script>
    <![endif]-->

</head>

<body>

<div class="page-container">
    <h1>Snowy 登录</h1>
    <form action="" method="post">
        <input type="text" name="username" class="username" placeholder="请输入您的用户名！">
        <input type="password" name="password" class="password" placeholder="请输入您的用户密码！">
        <input type="Captcha" class="Captcha" name="Captcha" placeholder="请输入验证码！">
        <button type="submit" class="submit_button">登录</button>
        <div class="error"><span>+</span></div>
    </form>
</div>

<!-- Javascript -->
<script src="assets/login/js/jquery-1.8.2.min.js"></script>
<script src="assets/login/js/supersized.3.2.7.min.js"></script>
<script src="assets/login/js/supersized-init.js"></script>
<script src="assets/login/js/scripts.js"></script>

</body>
</html>




