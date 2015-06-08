<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		$("#hide").click(function (){
			$("#info").toggle();
		});
	});
</script>
</head>
  <body>
  <h1 align="center">用户登录</h1>
  <hr>
  <div align="center">
  <form action="${pageContext.request.contextPath }/">
 	 <table id="info">
 	 
 	 	<tr>
 	 		<td>工号/学号：</td><td><input type="text" name="userId"></td>
 	 	</tr>
 	 	<tr>
 	 		<td>用户名：</td><td><input type="text" name="userId"></td>
 	 	</tr>
 	 	<tr>
 	 		<td>密码：</td><td><input type="text" name="userId"></td>
 	 	</tr>
 	 	<tr>
 	 		<td>用户类型：</td><td><input type="text" name="userId"></td>
 	 	</tr>
 	 	<tr>
 	 		<td>提交：</td><td><input type="text" name="userId"></td>
 	 	</tr>
  	 </table>
  </form>
  <button id="hide">隐藏</button>
  </div>
  
  </body>
</html>
