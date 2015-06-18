<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		$("#score").hide();
		$("#getScore").click(function(){
			$("#score").slideDown("slow");
			$("getScore").hide();
		});
	});
</script>
  <style type="text/css">
  	#score{
  		background-color: #557788;
  		text-align: center;
  	}
  </style>
  </head>
  
  <body>
  <h1 align="center">测试结果</h1>
  <hr>
  <div align="center">
  <div id="score">
  		${requestScope.score }<p>
  		
  		<label>你还可以给老师留言：</label>
  		<form action="leaveMessage?teacherId=${requestScope.teacherId }" method="post">
  			<textarea rows="5" cols="60" name="content"></textarea><br><br>
  			<input type="submit" value="留言"/>
  		</form>
  </div>
  <button id="getScore" >查看成绩</button>&nbsp<a href="back">回到主页
  </div>
  </body>
</html>
