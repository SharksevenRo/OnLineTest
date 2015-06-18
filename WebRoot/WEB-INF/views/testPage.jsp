<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
	
		$("#test").hide().slideDown("slow");
	});
</script>
  </head>
  <body>
  <h1 align="center">你正在测试&nbsp<a href="back">回到主页</h1>
  <hr>
 
  	<div align="center" id="test">
  	<form action="submitTest" method="post">
  	<br>
  	<table>
  		<c:forEach items="${sessionScope.questions }" var="question">
  			<tr><td align="left"><c:out value="${question.content }"></c:out><br>
  			<c:forTokens items="${question.options }" delims="," var="option">
  				<br>
  				<input type="radio" name="${question.questionId }" value="${option}"/>${option }<br>
  			</c:forTokens>
  			</td></tr><br><br>
  			</c:forEach>
  	</table>
  	<input type="submit" value="提交测试">
  	</form>
  	</div>
  </body>
</html>
