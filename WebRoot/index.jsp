<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
  <script type="text/javascript">
  		$(document).ready(function (){
  			$("#mainPage").hide();
  			
  			$("#mainPage").slideDown("slow");
  		});
  </script>
  </head>
  <body>
  <h1 align="center">欢迎来到在线测试系统</h1>
  <hr>
  <div align="center" id ="mainPage">
  		<a href="loginPage">登录</a><br><br>
  		<a href="register1"><font color="#ff0000">还没账号？注册</font></a><br>
  </div>
  </body>
</html>
