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
 	<p><label for="userId">学号/工号：</label>
             <input id="userId" name="userId" type="text" placeholder="学号活学工号" required="required"  pattern="[0-9]{8}"/>
     </p>
    <p><label for="password">密码：</label>
        <input id="password" name="password" type="password" placeholder="登录密码" required="required"/>
    </p>
    <input type="submit" value="登录"/>
  </form>
  </div>
  
  </body>
</html>
