<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
  <script type="text/javascript">
  		function addOption(){
  				
  				var tr=document.getElementById("option");
  				var newTr=tr.cloneNode(true);
  				$("#tb_question").append(newTr);
  			}
  	function markComplete() {
		document.getElementById("complete").value="true"
	}
  </script>
  <style type="text/css">
  	.add{
  		cursor: pointer;
  	}
  </style>
  </head>
  <body>
  <h1 align="center">出题</h1>
  <hr>
  	<form action="question_add" method="post">
  	<div align="center">
  		<table id="tb_question">
  			<tr>
  				<td>题目:</td><td><textarea rows="6" cols="50" name="content"></textarea></td>
  			</tr>
  			<tr id="option" name="option">
  				<td>选项:</td><td><select name="optionLabel">
  									<option value="A">A</option>
  									<option value="B">B</option>
  									<option value="C">C</option>
  									<option value="D">D</option>
  								</select>&nbsp
  								<input name="optionValue"/>
  								<img alt="新增" src="image/btn_add.jpg" class="add" onclick="addOption()">新增选项
  								</td>
  			</tr>
  		</table>
  				答案:&nbsp<select name="answer">
  									<option value="A">A</option>
  									<option value="B">B</option>
  									<option value="C">C</option>
  									<option value="D">D</option>
  								</select><br><br>
  		<input type="submit" value="下一题"/>&nbsp<input type="submit" value="完成" onclick="markComplete()"/>
  		<input type="hidden" name="complete" id="complete"/>
  		</div>
  	</form>
  </body>
</html>
