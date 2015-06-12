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
  <h1 align="center">用户注册</h1>
  <hr>
  <div align="center">
  <form action="register2" method="post">
 	 <table id="info">
 	 
 	 	<tr>
 	 		<td>工号/学号：</td><td><input type="text" name="userId" placeholder="请填写学号或学工号"></td>
 	 	</tr>
 	 	<tr>
 	 		<td>用户名：</td><td><input type="text" name="userName" placeholder="请填 写用户名"></td>
 	 	</tr>
 	 	<tr>
 	 		<td>密码：</td><td><input type="password" name="password" placeholder="设置密码"></td>
 	 	</tr>
 	 	<tr>
 	 		<td>确认密码：</td><td><input type="password" name="confirmPassword" placeholder="确认密码"></td>
 	 	</tr>
 	 	<tr>
 	 		<td>用户类型：</td><td><select name="type">
 	 							<option value="default">请选择用户类型</option>
 	 							<option value="老师">老师</option>
 	 							<option value="学生">学生</option>
 	 							</select> 
 	 		                </td>
 	 	</tr>
 	 	<tr>
 	 		<td colspan="2" align="right"><input type="submit" value="注册"><input type="reset" value="重置"></td>
 	 	</tr>
  	 </table>
  </form>
  </div>
  
  </body>
</html>
