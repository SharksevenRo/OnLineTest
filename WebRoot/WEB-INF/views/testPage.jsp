<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <h1 align="center">你正在测试</h1>
  <hr>
  
  	<div align="left" id="test">
  	<form action="submitTest">
  	<br>
  		<c:forEach items="${requestScope.questions }" var="question">
  			<c:out value="${question.content }"></c:out><p>
  			<c:forTokens items="${question.options }" delims="," var="option">
  				<br>
  				<input type="radio" name="${question.questionId }" value="${option}"/>${option }<br>
  			</c:forTokens>
  			
  			</c:forEach>
  		
  	</form>
  	</div>
  </body>
</html>
