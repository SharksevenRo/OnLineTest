<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
 <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
	
		$("#menu").hide().slideDown("slow");
	});
</script>
<style type="text/css">
	#menu{
		width:100%;
		height:200px;
		background-color: #666699;
	}
	#userMenu{
		text-align:right;
		width:40%;
		height:200px;
		float: left;
	}
	#infoList{
		text-align:center;
		width:60%;
		height:200px;
		float: right;
	}
</style>
</head>
  <body>
 <h1 align="center"></label>${sessionScope.user.userName }的主页&nbsp&nbsp<label id="type"><font color="#11ee44">${sessionScope.user.type }</font></h1>
 <canvas id="headCanvas" width="100" height="110" style="border:1px solid #c3c3c3;">
	浏览器不支持
</canvas>
	<script type="text/javascript">
	
		var type=document.getElementById("type").innerText;
		type=type.trim();
		var src;
		var text;
		if(type=="老师"){
			src="image/teacher.jpg";
			text="我是老师";
		}if(type=="学生"){
			src="image/student.jpg";
			text="我是学生";
		}
		var c=document.getElementById("headCanvas");
		var cxt=c.getContext("2d");
		var img=new Image()
		img.src=src;
		cxt.drawImage(img,0,0);
		cxt.strokeText(text,20,105);
	</script>
 <hr>
 <div id="menu">
 	<div id="userMenu">
 		<c:if test="${sessionScope.user.type=='老师' }">
 			<br>
 				<a href="addQuestion">出题</a><br><br>
 				<a href="questions">我出的题</a><br><br>
 				<a href="#">查看答题记录</a><br><br>
 				<a href="#">查看学生留言</a><br><br>
 		</c:if>
 		<c:if test="${sessionScope.user.type=='学生' }">
 			<br>
 				<a href="#">参加测试</a><br><br>
 				<a href="#">查看测试记录</a><br><br>
 				<a href="#">查看我的留言</a><br><br>
 		
 		</c:if>
 		<a href="logout">注销登录</a>
 	</div>
 	<div id="infoList">
 		<br>
 		<c:if test="${sessionScope.user.type=='学生' }">
 		<label>出题的老师（点击老师名做老师的题目）</label><br><br>
 		<c:forEach items="${sessionScope.users}" var="user">
 			<a href="test?teacherId=${user.userId }"><c:out value="${user.userName }"></c:out></a><br><br>
 		</c:forEach>
 		</c:if>
 		<c:if test="${sessionScope.user.type=='老师' }">
 		<label>学生留言：</label>
 		</c:if>
 	</div>	
 </div>
 	
  </body>
</html>
