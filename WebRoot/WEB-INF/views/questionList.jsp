<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
	
		$("#questions").hide().slideDown("slow");
	});
</script>
  <style type="text/css">
  	#questions{
  		text-align: center;
  		background-color: #227744;
  	}
  </style>
  </head>
  <body>
  <h1 align="center">出题记录</h1>
  <hr>
  <div id="questions">
  	<c:forEach items="${requestScope.questions }" var="question">
  		<br>
  	  	<label>题目编号：</label><c:out value="${question.questionId }"></c:out><br>
  	  	<c:out value="${question.content }"></c:out><br>
  	  	<c:out value="${question.options }"></c:out><br>
  	  	题目类型：<c:out value="${question.answer }"></c:out><br>
  	  	答案：<c:out value="${question.answer }"></c:out><br>
  	  	<hr>
  	</c:forEach>
  </div>
  </body>
</html>
