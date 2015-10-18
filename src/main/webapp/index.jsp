<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>后台管理</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta name="format-detection" content="telephone=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel ="icon" href="${pageContext.request.contextPath}/images/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css"/>
  
</head>
<body>
<div class="text-center f18 mt30">
  <div class="am-g">
    <h1>微信管理后台登录</h1>
  </div>
  <hr />
</div>
<div class="am-g">
  <div class="am-u-lg-5 am-u-md-7 am-u-sm-centered">
      <form action="${pageContext.request.contextPath}/sys/login" method="post" class="am-form">
      <label for="name">用户名:</label>
      <input type="text" name="name" id="name">
      <br>
      <label for="password">密码:</label>
      <input type="password" name="password" id="password">
      <br>
      <label for="remember-me">
        <input id="remember-me" type="checkbox">
        记住密码
      </label>
      <br />
      <div class="am-cf">
        <input type="submit" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm am-fl">
        <input type="button" name="" value="忘记密码 ? " class="am-btn am-btn-default am-btn-sm am-fr">
      </div>
    </form>
    <hr>
    <p> <small>Powered by AmazeUI <br>  © 2015 Dbyz.org </small></p>
  </div>
</div>
</body>
</html>>